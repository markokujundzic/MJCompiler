package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor
{
    /* Utils */
    private int mainPC;
    private int currentPrintInt = -1;

    /* Getters */
    public int getMainPC()
    {
        return mainPC;
    }

    /* Methods */
    public void visit(MethodName methodName)
    {
        if (methodName.getName().equalsIgnoreCase("main"))
        {
            mainPC = Code.pc;
        }

        methodName.obj.setAdr(Code.pc);

        SyntaxNode methodNode = methodName.getParent();

        CounterVisitor.VarCounter varCounter = new CounterVisitor.VarCounter();
        methodNode.traverseTopDown(varCounter);

        CounterVisitor.FormParamCounter formParamCounter = new CounterVisitor.FormParamCounter();
        methodNode.traverseTopDown(formParamCounter);

        Code.put(Code.enter);
        Code.put(formParamCounter.getCount());
        Code.put(formParamCounter.getCount() + varCounter.getCount());
    }

    public void visit(MethodDeclaration methodDeclaration)
    {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    /* Print Statement */
    public void visit(PrintInt printInt)
    {
        currentPrintInt = printInt.getNumber();
    }

    public void visit(PrintStatement printStatement)
    {
        if (printStatement.getOptionalPrintNumber() instanceof OptionalYesPrintNumber)
        {
            Code.loadConst(currentPrintInt);
            if (printStatement.getExpr().struct == SymTab.charType)
            {
                Code.put(Code.bprint);
            }
            else
            {
                Code.put(Code.print);
            }
        }
        else
        {
            if (printStatement.getExpr().struct == SymTab.charType)
            {
                Code.loadConst(1);
                Code.put(Code.bprint);
            }
            else
            {
                Code.loadConst(5);
                Code.put(Code.print);
            }
        }
        currentPrintInt = -1;
    }

    /* Read Statement */
    public void visit(ReadStatement readStatement)
    {
        Obj o = readStatement.getDesignator().getDesignatorName().obj;
        Struct s = o.getType();
        if (s == SymTab.intType ||
            s == SymTab.boolType)
        {
            Code.put(Code.read);
        }
        else if (s == SymTab.charType)
        {
            Code.put(Code.bread);
        }
        Code.store(o);
    }

    /* Factor */
    public void visit(IntFactor intFactor)
    {
        Obj constFactor = new Obj(Obj.Con, "$", intFactor.struct);
        constFactor.setAdr(intFactor.getValue());
        Code.load(constFactor);
    }

    public void visit(CharFactor charFactor)
    {
        Obj constFactor = new Obj(Obj.Con, "$", charFactor.struct);
        constFactor.setAdr(charFactor.getValue());
        Code.load(constFactor);
    }

    public void visit(BoolFactor boolFactor)
    {
        Obj constFactor = new Obj(Obj.Con, "$", boolFactor.struct);
        constFactor.setAdr(boolFactor.getValue() ? 1 : 0);
        Code.load(constFactor);
    }

    /* Term */
    public void visit(MulopTerm mulopTerm)
    {
        if (mulopTerm.getMulop() instanceof MulopMul)
        {
            Code.put(Code.mul);
        }
        else if (mulopTerm.getMulop() instanceof MulopDiv)
        {
            Code.put(Code.div);
        }
        else if (mulopTerm.getMulop() instanceof MulopMod)
        {
            Code.put(Code.rem);
        }
    }

    /* Designator */
    public void visit(Designator designator)
    {
        SyntaxNode parent = designator.getParent();
        boolean assignOP = false;

        if (parent.getClass() == DesignatorStatement.class)
        {
            DesignatorStatement statement = (DesignatorStatement) parent;
            if (statement.getDesignatorAddition() instanceof PossibleErrorAssignOpDesignatorAddition)
            {
                assignOP = true;
            }
        }
        else if (parent.getClass() == ReadStatement.class)
        {
            assignOP = true;
        }

        if (!assignOP)
        {
            Code.load(designator.getDesignatorName().obj);
        }
    }

    public void visit(DesignatorStatement designatorStatement)
    {
        if (designatorStatement.getDesignatorAddition() instanceof PossibleErrorAssignOpDesignatorAddition)
        {
            Code.store(designatorStatement.getDesignator().getDesignatorName().obj);
        }
    }

    /* Finite Expr */
    public void visit(MinusTermFiniteExpr minusTermFiniteExpr)
    {
        Code.put(Code.neg);
    }
}
