package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor
{
    /* Utils */
    private Logger log = Logger.getLogger(getClass());

    private boolean errorDetected = false;
    private boolean returnFound = false;
    private boolean mainFound = false;
    private boolean localVariables = false;

    private Obj currentMethod = null;

    private int varDeclCount = 0;
    private int currentConstValue = -1;

    private Struct currentType = null;
    private Struct curerntMethodReturnType = null;

    /* Error */
    public boolean passed()
    {
        return !errorDetected;
    }

    /* Report error */
    public void report_error(String message, SyntaxNode info)
    {
        errorDetected = true;

        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.error(msg.toString());
    }

    /* Report info */
    public void report_info(String message, SyntaxNode info)
    {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.info(msg.toString());
    }

    /* Program */
    public void visit(ProgramName programName)
    {
        programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
        SymTab.openScope();
    }

    public void visit(Program program)
    {
        if (!mainFound)
        {
            report_error("Semantic error: Method main has not been declared!", null);
        }
        SymTab.chainLocalSymbols(program.getProgramName().obj);
        SymTab.closeScope();
    }

    /* Type */
    public void visit(Type type)
    {
        Obj typeNode = SymTab.find(type.getName());

        if (typeNode == SymTab.noObj)
        {
            report_error("Type " + type.getName() + " not found in Symbol Table on line " + type.getLine(), null);
            type.struct = currentType = SymTab.noType;
        }
        else if (typeNode.getKind() == Obj.Type)
        {
            type.struct = currentType = typeNode.getType();
        }
        else
        {
            report_error("Semantic Error: Identifier " + type.getName() + " does not represent a type on line " + type.getLine(), null);
            type.struct = currentType = SymTab.noType;
        }
    }

    /* Global variables */
    public void visit(DeclVariable declVariable)
    {
        varDeclCount++;
        Obj varNode = SymTab.find(declVariable.getVarDeclName().getName());

        if (varNode == SymTab.noObj)
        {
            if (declVariable.getVarDeclArrayOption() instanceof YesVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), new Struct(Struct.Array, currentType));
                if (!localVariables)
                {
                    report_info("Global array " + declVariable.getVarDeclName().getName() + " declared", declVariable);
                }
                else
                {
                    report_info("Local array " + declVariable.getVarDeclName().getName() + " declared", declVariable);
                }
            }
            else if (declVariable.getVarDeclArrayOption() instanceof NoVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), currentType);
                if (!localVariables)
                {
                    report_info("Global variable " + declVariable.getVarDeclName().getName() + " declared", declVariable);
                }
                else
                {
                    report_info("Local variable " + declVariable.getVarDeclName().getName() + " declared", declVariable);
                }
            }
        }
        else
        {
            report_error("Semantic Error: Global variable " + declVariable.getVarDeclName().getName() + " has already been declared on line " + declVariable.getVarDeclName().getLine(), null);
        }
    }

    /* Constants */
    public void visit(ConstDeclValueInt constDeclValueInt)
    {
        currentConstValue = constDeclValueInt.getValue();
        constDeclValueInt.struct = SymTab.intType;
    }

    public void visit(ConstDeclValueChar constDeclValueChar)
    {
        currentConstValue = constDeclValueChar.getValue();
        constDeclValueChar.struct = SymTab.charType;
    }

    public void visit(ConstDeclValueBool constDeclValueBool)
    {
        currentConstValue = constDeclValueBool.getValue() ? 1 : 0;
        constDeclValueBool.struct = SymTab.boolType;
    }

    public void visit(ConstDeclVariable constDeclVariable)
    {
        Obj constNode = SymTab.find(constDeclVariable.getConstDeclName().getName());

        if (constNode == SymTab.noObj)
        {
            if (currentType.assignableTo(constDeclVariable.getConstDeclValue().struct))
            {
                Obj constant = SymTab.insert(Obj.Con, constDeclVariable.getConstDeclName().getName(), constDeclVariable.getConstDeclValue().struct);
                constant.setAdr(currentConstValue);
                report_info("Const variable " + constDeclVariable.getConstDeclName().getName() + " declared", constDeclVariable);
            }
            else
            {
                report_error("Semantic Error: Const variable " + constDeclVariable.getConstDeclName().getName() + " is not compatible with assigning value on line " + constDeclVariable.getConstDeclName().getLine(), null);
            }
        }
        else
        {
            report_error("Semantic Error: Const variable " + constDeclVariable.getConstDeclName().getName() + " has already been declared on line " + constDeclVariable.getConstDeclName().getLine(), null);
        }
    }

    /* Methods */
    public void visit(TypeMethodReturnType typeMethodReturnType)
    {
        curerntMethodReturnType = typeMethodReturnType.getType().struct;
    }

    public void visit(VoidMethodReturnType voidMethodReturnType)
    {
        curerntMethodReturnType = SymTab.noType;
    }

    public void visit(MethodName methodName)
    {
        Obj method = SymTab.find(methodName.getName());

        if (method == SymTab.noObj)
        {
            methodName.obj = currentMethod = SymTab.insert(Obj.Meth, methodName.getName(), curerntMethodReturnType);

            SymTab.openScope();
            report_info("Method " + currentMethod.getName() + " declared", methodName);

            if (methodName.getName().equals("main"))
            {
                localVariables = true;
                mainFound = true;
            }

            if (methodName.getName().equals("main") && curerntMethodReturnType != SymTab.noType)
            {
                report_error("Semantic Error: Method " + methodName.getName() + " must return void on line " + methodName.getLine(), null);
            }
        }
        else
        {
            report_error("Semantic Error: Method " + methodName.getName() + " has already been declared on line " + methodName.getLine(), null);
        }
    }

    public void visit(MethodDeclaration methodDeclaration)
    {
        if (!methodDeclaration.getMethodName().getName().equals("main") && !returnFound && curerntMethodReturnType != SymTab.noType)
        {
            report_error("Semantic Error: Method " + currentMethod.getName() + " does not have a return statement on line " + methodDeclaration.getLine(), null);
        }
        else if (returnFound && curerntMethodReturnType == SymTab.noType)
        {
            report_error("Semantic Error: Method " + currentMethod.getName() + " of type void has a return statement on line " + methodDeclaration.getLine(), null);
        }

        SymTab.chainLocalSymbols(currentMethod);
        SymTab.closeScope();

        currentMethod = null;
        curerntMethodReturnType = null;
        returnFound = false;
    }

    /* Designator */
    public void visit(DesignatorName designatorName)
    {
        Obj obj = SymTab.find(designatorName.getName());

        if (obj == SymTab.noObj)
        {
            report_error("Semantic Error: Variable " + designatorName.getName() + " used on line " + designatorName.getLine() + " has not been declared", null);
        }

        designatorName.obj = obj;
    }

    public void visit(OptionalDesignator optionalDesignator)
    {
        if (optionalDesignator instanceof YesOptionalDesignator)
        {

        }
    }
}
