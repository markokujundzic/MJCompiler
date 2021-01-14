package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.*;

import java.util.Stack;

public class CodeGenerator extends VisitorAdaptor
{
    /* Utils */
    private int mainPC;
    private int currentPrintInt = -1;

    private Obj currentDesignator = null;

    private final Stack<Integer> jumpOnElseBackPatch = new Stack<>();
    private final Stack<Integer> jumpAfterElseBackPatch = new Stack<>();

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

    public void visit(NewArrayFactor newArrayFactor)
    {
        Code.put(Code.newarray);
        if (newArrayFactor.getType().getName().equals("bool") ||
            newArrayFactor.getType().getName().equals("int"))
        {
            Code.put(1);
        }
        else if (newArrayFactor.getType().getName().equals("char"))
        {
            Code.put(0);
        }
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

    public void visit(FiniteTerm finiteTerm)
    {
        if (finiteTerm.getParent().getClass() == MinusTermFiniteExpr.class)
        {
            Code.put(Code.neg);
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

            if (statement.getDesignatorAddition() instanceof PossibleErrorAssignOpDesignatorAddition ||
                statement.getDesignatorAddition() instanceof IncrementDesignatorAddition ||
                statement.getDesignatorAddition() instanceof DecrementDesignatorAddition)
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

        currentDesignator = designator.getDesignatorName().obj;
    }

    public void visit(DesignatorName designatorName)
    {
        /* If it is an array, push the array address to the expression stack */
        if (designatorName.obj.getKind() == Obj.Elem)
        {
            if (designatorName.obj.getLevel() == 0)
            {
                Code.put(Code.getstatic);
                Code.put2(designatorName.obj.getAdr());
            }
            else
            {
                if (designatorName.obj.getAdr() >= 0 &&
                    designatorName.obj.getAdr() <= 3)
                {
                    Code.put(Code.load_n + designatorName.obj.getAdr());
                }
                else
                {
                    Code.put(Code.load);
                    Code.put(designatorName.obj.getAdr());
                }
            }
        }
    }

    public void visit(DesignatorStatement designatorStatement)
    {
        if (designatorStatement.getDesignatorAddition() instanceof PossibleErrorAssignOpDesignatorAddition)
        {
            Code.store(designatorStatement.getDesignator().getDesignatorName().obj);
        }
    }

    /* Helper function */
    private void processIncrementDecrement(int code)
    {
        if (currentDesignator.getKind() == Obj.Elem)
        {
            Code.put(Code.dup2);
            Code.put(Code.aload);
            Code.put(Code.const_1);
            Code.put(code); // add or sub
            Code.put(Code.astore);
        }
        else
        {
            if (currentDesignator.getLevel() == 0)
            {
                Code.put(Code.getstatic);
                Code.put2(currentDesignator.getAdr());
            }
            else
            {
                if (currentDesignator.getAdr() >= 0 &&
                    currentDesignator.getAdr() <= 3)
                {
                    Code.put(Code.load_n + currentDesignator.getAdr());
                }
                else
                {
                    Code.put(Code.load);
                    Code.put(currentDesignator.getAdr());
                }
            }

            Code.put(Code.const_1);
            Code.put(code); // add or sub

            if (currentDesignator.getLevel() == 0)
            {
                Code.put(Code.putstatic);
                Code.put2(currentDesignator.getAdr());
            }
            else
            {
                if (currentDesignator.getAdr() >= 0 &&
                    currentDesignator.getAdr() <= 3)
                {
                    Code.put(Code.store_n + currentDesignator.getAdr());
                }
                else
                {
                    Code.put(Code.store);
                    Code.put(currentDesignator.getAdr());
                }
            }
        }
    }

    // a[3]++; -> 2 3 | (2 3) -> val | 1
    // x++: -> val | 1
    public void visit(IncrementDesignatorAddition incrementDesignatorAddition)
    {
        processIncrementDecrement(Code.add);
    }

    public void visit(DecrementDesignatorAddition decrementDesignatorAddition)
    {
       processIncrementDecrement(Code.sub);
    }

    /* Finite Expr */
    public void visit(YesOptionalTermList yesOptionalTermList)
    {
        if (yesOptionalTermList.getAddop() instanceof AddopPlus)
        {
            Code.put(Code.add);
        }
        else if (yesOptionalTermList.getAddop() instanceof AddopMinus)
        {
            Code.put(Code.sub);
        }
    }

    /* Ternary Expression */
    public void visit(SingleCondFact singleCondFact)
    {
        if (singleCondFact.getParent().getClass() == YesTernaryExpr.class)
        {
            Code.put(Code.const_1);
            Code.putFalseJump(Code.eq, 0);
            jumpOnElseBackPatch.push(Code.pc - 2);
        }
    }

    public void visit(TernaryColon ternaryColon)
    {
        Code.putJump(0);
        jumpAfterElseBackPatch.push(Code.pc - 2);
        Code.fixup(jumpOnElseBackPatch.pop());
    }

    public void visit(YesTernaryExpr yesTernaryExpr)
    {
        Code.fixup(jumpAfterElseBackPatch.pop());
    }
}
