// generated with ast extension for cup
// version 0.8
// 1/0/2021 12:6:58


package rs.ac.bg.etf.pp1.ast;

public class SingleCondFact extends CondFact {

    private FiniteExpr FiniteExpr;

    public SingleCondFact (FiniteExpr FiniteExpr) {
        this.FiniteExpr=FiniteExpr;
        if(FiniteExpr!=null) FiniteExpr.setParent(this);
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
        if(FiniteExpr!=null) FiniteExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FiniteExpr!=null) FiniteExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleCondFact(\n");

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
