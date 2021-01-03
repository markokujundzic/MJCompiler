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
            report_error("Type " + type.getName() +
            " not found in Symbol Table on line " + type.getLine(), null);
            type.struct = currentType = SymTab.noType;
        }
        else if (typeNode.getKind() == Obj.Type)
        {
            type.struct = currentType = typeNode.getType();
        }
        else
        {
            report_error("Semantic Error: Identifier " + type.getName() +
            " does not represent a type on line " + type.getLine(), null);

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
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(),
                new Struct(Struct.Array, currentType));

                if (!localVariables)
                {
                    report_info("Global array " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);
                }
                else
                {
                    report_info("Local array " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);
                }
            }
            else if (declVariable.getVarDeclArrayOption() instanceof NoVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), currentType);
                if (!localVariables)
                {
                    report_info("Global variable " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);
                }
                else
                {
                    report_info("Local variable " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);
                }
            }
        }
        else
        {
            report_error("Semantic Error: Global variable " +
            declVariable.getVarDeclName().getName() + " has already been declared on line " +
            declVariable.getVarDeclName().getLine(), null);
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
                Obj constant = SymTab.insert(Obj.Con, constDeclVariable.getConstDeclName().getName(),
                constDeclVariable.getConstDeclValue().struct);

                constant.setAdr(currentConstValue);

                report_info("Const variable " + constDeclVariable.getConstDeclName().getName() +
                " declared", constDeclVariable);
            }
            else
            {
                report_error("Semantic Error: Const variable " +
                constDeclVariable.getConstDeclName().getName() + " is not compatible with assigning value on line " +
                constDeclVariable.getConstDeclName().getLine(), null);
            }
        }
        else
        {
            report_error("Semantic Error: Const variable " +
            constDeclVariable.getConstDeclName().getName() + " has already been declared on line " +
            constDeclVariable.getConstDeclName().getLine(), null);
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
                report_error("Semantic Error: Method " + methodName.getName() +
                " must return void on line " + methodName.getLine(), null);
            }
        }
        else
        {
            report_error("Semantic Error: Method " + methodName.getName() +
            " has already been declared on line " + methodName.getLine(), null);
        }
    }

    public void visit(MethodDeclaration methodDeclaration)
    {
        if (!methodDeclaration.getMethodName().getName().equals("main") && !returnFound && curerntMethodReturnType != SymTab.noType)
        {
            report_error("Semantic Error: Method " + currentMethod.getName() +
            " does not have a return statement on line " + methodDeclaration.getLine(), null);
        }
        else if (returnFound && curerntMethodReturnType == SymTab.noType)
        {
            report_error("Semantic Error: Method " + currentMethod.getName() +
            " of type void has a return statement on line " + methodDeclaration.getLine(), null);
        }

        SymTab.chainLocalSymbols(currentMethod);
        SymTab.closeScope();

        currentMethod = null;
        curerntMethodReturnType = null;
        returnFound = false;
    }

    /* Designator */

    /*
     * Ako je polje niza,   KIND objektnog cvora je ELEM
     * Ako nije polje niza, KIND objektnog cvora je VAR
     */
    public void visit(Designator designator)
    {
        Obj obj = SymTab.find(designator.getDesignatorName().getName());

        if (obj == SymTab.noObj)
        {
            report_error("Semantic Error: Variable " + designator.getDesignatorName().getName() +
            " used on line " + designator.getDesignatorName().getLine() + " has not been declared", null);
        }
        else if (obj.getType().getKind() != Struct.Array)
        {
            report_info("Variable " + designator.getDesignatorName().getName() +
            " used", designator.getDesignatorName());
        }

        designator.getDesignatorName().obj = obj;

        if (designator.getOptionalDesignator() instanceof YesOptionalDesignator)
        {
            if (obj.getType().getKind() == Struct.Array)
            {
                //if (((YesOptionalDesignator) designator.getOptionalDesignator()).getExpr().struct != SymTab.intType)
                //{
                //report_error("Semantic Error: Expression for array indexing used on line " + designator.getDesignatorName().getLine() + " must be of int type", null);
                //}
                //else
                //{
                    // dodati obradu za koriscenje konstante u indeksiranju niza
                    designator.getDesignatorName().obj = new Obj(Obj.Elem, designator.getDesignatorName().getName(),
                    designator.getDesignatorName().obj.getType().getElemType());

                    report_info("Element of array " + designator.getDesignatorName().getName() +
                    " used", designator.getDesignatorName());
                //}
            }
            else
            {
                report_error("Semantic Error: Attempted indexing of non-array variable " +
                designator.getDesignatorName().getName() + " used on line " +
                designator.getDesignatorName().getLine(), null);
            }
        }
    }

    public void visit(DesignatorStatement d)
    {
        if (d.getDesignatorAddition() instanceof IncrementDesignatorAddition ||
            d.getDesignatorAddition() instanceof DecrementDesignatorAddition)
        {
            if (d.getDesignator().getDesignatorName().obj.getType() != SymTab.intType)
            {
                report_error("Semantic Error: post-increment and post-decrement " +
                "operators can only be used with int types on line " +
                d.getDesignator().getDesignatorName().getLine(), null);
            }
        }
    }

    /* Factor */
    public void visit(DesignatorFactor designatorFactor)
    {
        designatorFactor.struct = designatorFactor.getDesignator().getDesignatorName().obj.getType();
    }

    public void visit(IntFactor intFactor)
    {
        intFactor.struct = SymTab.intType;
    }

    public void visit(BoolFactor boolFactor)
    {
        boolFactor.struct = SymTab.boolType;
    }

    public void visit(CharFactor charFactor)
    {
        charFactor.struct = SymTab.charType;
    }

    public void visit(ExprFactor exprFactor)
    {
        exprFactor.struct = exprFactor.getExpr().struct;
    }

    public void visit(NewFactor newFactor)
    {
        newFactor.struct = currentType;
    }

    public void visit(NewArrayFactor newArrayFactor)
    {
        if (newArrayFactor.getExpr().struct != SymTab.intType)
        {
            report_error("Semantic Error: Expression for array indexing used on line " +
            newArrayFactor.getLine() + " must be of int type", null);
        }

        newArrayFactor.struct = new Struct(Struct.Array, currentType);
    }

    /* Term */
    public void visit(FactorTerm factorTerm)
    {
        factorTerm.struct = factorTerm.getFactor().struct;
    }

    public void visit(MulopTerm mulopTerm)
    {
        if (mulopTerm.getTerm().struct == SymTab.intType &&
            mulopTerm.getFactor().struct == SymTab.intType)
        {
            mulopTerm.struct = SymTab.intType;
        }
        else
        {
            mulopTerm.struct = SymTab.noType;
            report_error("Semantic Error: Operands of *, /, % operations on line " +
            mulopTerm.getLine() + " must be of int type", null);
        }
    }

    /* Read statement */
    public void visit(ReadStatement readStatement)
    {
        Obj designator = readStatement.getDesignator().getDesignatorName().obj;
        if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Elem)
        {
            report_error("Semantic Error: Operand of read method on line " +
            readStatement.getLine() + " must be a variable or an array element", null);
        }
        else
        {
            if (designator.getType() != SymTab.intType &&
                designator.getType() != SymTab.boolType &&
                designator.getType() != SymTab.charType)
            {
                report_error("Semantic Error: Operand of read method on line " +
                readStatement.getLine() + " must be of int, bool or char type", null);
            }
        }
    }

    /* Print statement */
    public void visit(PrintStatement printStatement)
    {
        Struct expr = printStatement.getExpr().struct;
        if (expr != SymTab.intType &&
            expr != SymTab.boolType &&
            expr != SymTab.charType)
        {
            report_error("Semantic Error: Operand of print method on line " +
            printStatement.getLine() + " must be of int, bool or char type", null);
        }
    }

    /* CondFact */
    public void visit(SingleCondFact singleCondFact)
    {
        singleCondFact.struct = singleCondFact.getFiniteExpr().struct;
    }

    public void visit(PluralCondFact pluralCondFact)
    {
        Struct expr1 = pluralCondFact.getFiniteExpr().struct;
        Struct expr2 = pluralCondFact.getFiniteExpr1().struct;
        if (!expr1.compatibleWith(expr2))
        {
            report_error("Semantic Error: CondFact operand types on line " +
            pluralCondFact.getLine() + " are not compatible", null);

            pluralCondFact.struct = SymTab.noType;
        }
        else
        {
            if (expr1.getKind() == Struct.Array &&
                expr2.getKind() == Struct.Array)
            {
                if (pluralCondFact.getRelop() instanceof RelopEqual ||
                    pluralCondFact.getRelop() instanceof RelopNotEqual)
                {
                    pluralCondFact.struct = expr1;
                }
                else
                {
                    report_error("Semantic Error: CondFact operands of array type on line " +
                    pluralCondFact.getLine() + " can only be compared for equality or non-equality", null);

                    pluralCondFact.struct = SymTab.noType;
                }
            }
            else
            {
                pluralCondFact.struct = expr1;
            }
        }
    }

    /* Finite expression */
    public void visit()
    {

    }
}
