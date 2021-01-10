// generated with ast extension for cup
// version 0.8
// 10/0/2021 18:10:53


package rs.ac.bg.etf.pp1.ast;

public class SingleCondFact extends CondFact {

    private TernaryStart TernaryStart;
    private FiniteExpr FiniteExpr;

    public SingleCondFact (TernaryStart TernaryStart, FiniteExpr FiniteExpr) {
        this.TernaryStart=TernaryStart;
        if(TernaryStart!=null) TernaryStart.setParent(this);
        this.FiniteExpr=FiniteExpr;
        if(FiniteExpr!=null) FiniteExpr.setParent(this);
    }

    public TernaryStart getTernaryStart() {
        return TernaryStart;
    }

    public void setTernaryStart(TernaryStart TernaryStart) {
        this.TernaryStart=TernaryStart;
    }

    public FiniteExpr getFiniteExpr() {
        return FiniteExpr;
    }

    public void setFiniteExpr(FiniteExpr FiniteExpr) {
        this.FiniteExpr=FiniteExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TernaryStart!=null) TernaryStart.accept(visitor);
        if(FiniteExpr!=null) FiniteExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TernaryStart!=null) TernaryStart.traverseTopDown(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TernaryStart!=null) TernaryStart.traverseBottomUp(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleCondFact(\n");

        if(TernaryStart!=null)
            buffer.append(TernaryStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FiniteExpr!=null)
            buffer.append(FiniteExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleCondFact]");
        return buffer.toString();
    }
}
