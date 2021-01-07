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

    private int currentConstValue = -1;
    private int nVars = 0;

    private Struct currentType = null;
    private Struct curerntMethodReturnType = null;

    private int constVariableDeclared = 0;
    private int localArraysDeclared = 0;
    private int globalArraysDeclared = 0;
    private int globalVariablesDeclared = 0;
    private int localVariablesDeclared = 0;
    private int statementsInMain = 0;

    private String print(Obj o)
    {
        StringBuilder s = new StringBuilder();

        switch (o.getKind())
        {
            case Obj.Con:  s.append("Con "); break;
            case Obj.Elem: s.append("Elem "); break;
            case Obj.Var:  s.append("Var "); break;
            case Obj.Type: s.append("Type "); break;
            case Obj.Meth: s.append("Meth "); break;
            case Obj.Fld:  s.append("Fld "); break;
            case Obj.Prog: s.append("Prog "); break;
        }

        s.append(o.getName());
        s.append(": ");

        switch (o.getType().getKind())
        {
            case Struct.None:
                s.append("notype");
                break;
            case Struct.Int:
                s.append("int");
                break;
            case Struct.Char:
                s.append("char");
                break;
            case Struct.Array:
                s.append("Array of ");

                switch (o.getType().getElemType().getKind())
                {
                    case Struct.None:
                        s.append("notype");
                        break;
                    case Struct.Int:
                        s.append("int");
                        break;
                    case Struct.Char:
                        s.append("char");
                        break;
                    case Struct.Bool:
                        s.append("bool");
                        break;
                }
                break;
            case Struct.Bool:
                s.append("bool");
                break;
        }

        s.append(", ");
        s.append(o.getAdr());
        s.append(", ");
        s.append(o.getLevel());

        return s.toString();
    }

    /* Getters */
    public int getnVars()
    {
        return nVars;
    }

    public boolean isMainFound()
    {
        return mainFound;
    }

    public int getConstVariableDeclared()
    {
        return constVariableDeclared;
    }

    public int getLocalArraysDeclared()
    {
        return localArraysDeclared;
    }

    public int getGlobalArraysDeclared()
    {
        return globalArraysDeclared;
    }

    public int getGlobalVariablesDeclared()
    {
        return globalVariablesDeclared;
    }

    public int getLocalVariablesDeclared()
    {
        return localVariablesDeclared;
    }

    public int getStatementsInMain()
    {
        return statementsInMain;
    }

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

        nVars = SymTab.currentScope().getnVars();

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
        if (SymTab.currentScope().findSymbol(declVariable.getVarDeclName().getName()) == null)
        {
            if (declVariable.getVarDeclArrayOption() instanceof YesVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(),
                new Struct(Struct.Array, currentType));

                if (!localVariables)
                {
                    report_info("Global array " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);

                    globalArraysDeclared++;
                }
                else
                {
                    report_info("Local array " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);

                    localArraysDeclared++;
                }
            }
            else if (declVariable.getVarDeclArrayOption() instanceof NoVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), currentType);
                if (!localVariables)
                {
                    report_info("Global variable " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);

                    globalVariablesDeclared++;
                }
                else
                {
                    report_info("Local variable " + declVariable.getVarDeclName().getName() +
                    " declared", declVariable);

                    localVariablesDeclared++;
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

                currentConstValue = -1;

                report_info("Const variable " + constDeclVariable.getConstDeclName().getName() +
                " declared", constDeclVariable);

                constVariableDeclared++;
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
        if (!methodDeclaration.getMethodName().getName().equals("main") &&
            !returnFound && curerntMethodReturnType != SymTab.noType)
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

    /*
     * Ako je polje niza,   KIND objektnog cvora je ELEM
     * Ako nije polje niza, KIND objektnog cvora je VAR
     */

    /* Designator */
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
            " used: " + print(obj), designator.getDesignatorName());
        }
        else if (obj.getType().getKind() == Struct.Array &&
                 !(designator.getOptionalDesignator() instanceof YesOptionalDesignator))
        {
            report_info("Array " + designator.getDesignatorName().getName() +
            " used: " + print(obj), designator.getDesignatorName());
        }

        designator.getDesignatorName().obj = obj;

        if (designator.getOptionalDesignator() instanceof YesOptionalDesignator)
        {
            if (obj.getType().getKind() == Struct.Array)
            {
                if (((YesOptionalDesignator) designator.getOptionalDesignator()).getExpr().struct != SymTab.intType)
                {
                    report_error("Semantic Error: Expression for array indexing used on line " +
                    designator.getDesignatorName().getLine() + " must be of int type", null);

                    designator.getDesignatorName().obj = SymTab.noObj;
                }
                else
                {
                    designator.getDesignatorName().obj = new Obj(
                            Obj.Elem,
                            designator.getDesignatorName().getName(),
                            designator.getDesignatorName().obj.getType().getElemType(),
                            designator.getDesignatorName().obj.getAdr(),
                            designator.getDesignatorName().obj.getLevel());

                    report_info("Element of array " + designator.getDesignatorName().getName() +
                    " used: " + print(designator.getDesignatorName().obj), designator.getDesignatorName());
                }
            }
            else
            {
                report_error("Semantic Error: Attempted indexing of non-array variable " +
                designator.getDesignatorName().getName() + " used on line " +
                designator.getDesignatorName().getLine(), null);

                designator.getDesignatorName().obj = SymTab.noObj;
            }
        }
    }

    public void visit(AssignOpExprDesignatorAdditionNoError op)
    {
        op.struct = op.getExpr().struct;
    }

    public void visit(PossibleErrorAssignOpDesignatorAddition error)
    {
        error.struct = error.getPossibleErrorDesignatorAddition().struct;
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
        else if (d.getDesignatorAddition() instanceof PossibleErrorAssignOpDesignatorAddition)
        {
            Struct expr = d.getDesignatorAddition().struct;
            Obj designator = d.getDesignator().getDesignatorName().obj;
            if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Elem)
            {
                report_error("Semantic Error: Designator in expression " +
                "assignment must be a variable or an element type on line " +
                d.getDesignator().getDesignatorName().getLine(), null);
            }
            else
            {
                if (!expr.compatibleWith(designator.getType()))
                {
                    report_error("Semantic Error: Incompatible types where " +
                    "Expr is assigned to Designator on line " +
                    d.getDesignator().getDesignatorName().getLine(), null);
                }
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

    /*public void visit(NewFactor newFactor)
    {
        newFactor.struct = currentType;
    }*/

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

    /* Read Statement */
    public void visit(ReadStatement readStatement)
    {
        statementsInMain++;

        Obj designator = readStatement.getDesignator().getDesignatorName().obj;
        if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Elem)
        {
            report_error("Semantic Error: Operand of read method on line " +
            readStatement.getLine() + " must be a variable or an array element", null);
        }
        else
        {
            if (designator.getType() != SymTab.charType &&
                designator.getType() != SymTab.boolType &&
                designator.getType() != SymTab.intType)
            {
                report_error("Semantic Error: Operand of read method on line " +
                readStatement.getLine() + " must be of int, bool or char type", null);
            }
        }
    }

    /* Print Statement */
    public void visit(PrintStatement printStatement)
    {
        statementsInMain++;

        Struct expr = printStatement.getExpr().struct;
        if (expr != SymTab.charType &&
            expr != SymTab.boolType &&
            expr != SymTab.intType)
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
                    pluralCondFact.struct = SymTab.boolType;
                }
                else
                {
                    report_error("Semantic Error: CondFact operands of array type on line " +
                    pluralCondFact.getLine() + " can only be compared for equality or non-equality", null);

                    pluralCondFact.struct = SymTab.noType;
                }
            }
            else if (expr1.getKind() == Struct.Bool &&
                     expr2.getKind() == Struct.Bool)
            {
                if (pluralCondFact.getRelop() instanceof RelopEqual ||
                    pluralCondFact.getRelop() instanceof RelopNotEqual)
                {
                    pluralCondFact.struct = SymTab.boolType;
                }
                else
                {
                    report_error("Semantic Error: CondFact operands of bool type on line " +
                    pluralCondFact.getLine() + " can only be compared for equality or non-equality", null);

                    pluralCondFact.struct = SymTab.noType;
                }
            }
            else
            {
                pluralCondFact.struct = SymTab.boolType;
            }
        }
    }

    /* Finite expression */
    public void visit(TermFiniteExpr termFiniteExpr)
    {
        Struct term = termFiniteExpr.getFiniteTerm().getTerm().struct;
        Struct list = termFiniteExpr.getOptionalTermList().struct;

        if (list == null)
        {
            termFiniteExpr.struct = term;
        }
        else
        {
            if (term.compatibleWith(list))
            {
                if (term == SymTab.intType &&
                    list == SymTab.intType)
                {
                    termFiniteExpr.struct = term;
                }
                else
                {
                    report_error("Semantic Error: Types used in FinalExpr on line " +
                    termFiniteExpr.getLine() + " must be of int type", null);

                    termFiniteExpr.struct = SymTab.noType;
                }
            }
            else
            {
                report_error("Semantic Error: Types used in FinalExpr on line " +
                termFiniteExpr.getLine() + " must be compatible", null);

                termFiniteExpr.struct = SymTab.noType;
            }
        }
    }

    public void visit(MinusTermFiniteExpr minusTermFiniteExpr)
    {
        Struct term = minusTermFiniteExpr.getFiniteTerm().getTerm().struct;

        if (term != SymTab.intType)
        {
            report_error("Semantic Error: Term used behind - sign on line " +
            minusTermFiniteExpr.getLine() + " inside of FinalExpr must be of int type", null);

            minusTermFiniteExpr.struct = SymTab.noType;
        }

        Struct list = minusTermFiniteExpr.getOptionalTermList().struct;

        if (list == null)
        {
            minusTermFiniteExpr.struct = term;
        }
        else
        {
            if (term.compatibleWith(list))
            {
                if (term == SymTab.intType &&
                    list == SymTab.intType)
                {
                    minusTermFiniteExpr.struct = term;
                }
                else
                {
                    report_error("Semantic Error: Types used in FinalExpr on line " +
                    minusTermFiniteExpr.getLine() + " must be of int type", null);

                    minusTermFiniteExpr.struct = SymTab.noType;
                }
            }
            else
            {
                report_error("Semantic Error: Types used in FinalExpr on line " +
                minusTermFiniteExpr.getLine() + " must be compatible", null);

                minusTermFiniteExpr.struct = SymTab.noType;
            }
        }
    }

    public void visit(NoOptionalTermList noOptionalTermList)
    {
        noOptionalTermList.struct = null;
    }

    public void visit(YesOptionalTermList yesOptionalTermList)
    {
        Struct term = yesOptionalTermList.getFiniteTerm().getTerm().struct;
        Struct list = yesOptionalTermList.getOptionalTermList().struct;

        if (list == null)
        {
            yesOptionalTermList.struct = term;
        }
        else
        {
            if (term.compatibleWith(list))
            {
                if (term == SymTab.intType &&
                    list == SymTab.intType)
                {
                    yesOptionalTermList.struct = term;
                }
                else
                {
                    report_error("Semantic Error: Types used in FinalExpr on line " +
                    yesOptionalTermList.getLine() + " must be of int type", null);

                    yesOptionalTermList.struct = SymTab.noType;
                }
            }
            else
            {
                report_error("Semantic Error: Types used in FinalExpr on line " +
                yesOptionalTermList.getLine() + " must be compatible", null);

                yesOptionalTermList.struct = SymTab.noType;
            }
        }
    }

    /* Expr */
    public void visit(NoTernaryExpr noTernaryExpr)
    {
        noTernaryExpr.struct = noTernaryExpr.getCondFact().struct;
    }

    public void visit(YesTernaryExpr yesTernaryExpr)
    {
        Struct condFact = yesTernaryExpr.getCondFact().struct;
        Struct expr1 = yesTernaryExpr.getExpr().struct;
        Struct expr2 = yesTernaryExpr.getExpr1().struct;

        if (condFact != SymTab.boolType)
        {
            report_error("Semantic Error: CondFact used in Ternary Expression on line " +
            yesTernaryExpr.getLine() + " must be of type bool", null);

            yesTernaryExpr.struct = SymTab.noType;
        }
        else
        {
            if (expr1 == SymTab.charType && expr2 == SymTab.charType ||
                expr1 == SymTab.boolType && expr2 == SymTab.boolType ||
                expr1 == SymTab.intType && expr2 == SymTab.intType)
            {
                yesTernaryExpr.struct = expr1;
            }
            else
            {
                report_error("Semantic Error: Operands used in Ternary Expression on line " +
                yesTernaryExpr.getLine() + " must be of the same type", null);

                yesTernaryExpr.struct = SymTab.noType;
            }
        }
    }

    public void visit(DesignatorStatementDecl designatorStatementDecl)
    {
        statementsInMain++;
    }
}