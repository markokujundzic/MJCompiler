package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;

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
}
