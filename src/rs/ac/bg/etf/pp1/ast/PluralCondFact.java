// generated with ast extension for cup
// version 0.8
// 3/0/2021 18:22:48


package rs.ac.bg.etf.pp1.ast;

public class PluralCondFact extends CondFact {

    private FiniteExpr FiniteExpr;
    private Relop Relop;
    private FiniteExpr FiniteExpr1;

    public PluralCondFact (FiniteExpr FiniteExpr, Relop Relop, FiniteExpr FiniteExpr1) {
        this.FiniteExpr=FiniteExpr;
        if(FiniteExpr!=null) FiniteExpr.setParent(this);
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.FiniteExpr1=FiniteExpr1;
        if(FiniteExpr1!=null) FiniteExpr1.setParent(this);
    }

    public FiniteExpr getFiniteExpr() {
        return FiniteExpr;
    }

    public void setFiniteExpr(FiniteExpr FiniteExpr) {
        this.FiniteExpr=FiniteExpr;
    }

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
    }

    public FiniteExpr getFiniteExpr1() {
        return FiniteExpr1;
    }

    public void setFiniteExpr1(FiniteExpr FiniteExpr1) {
        this.FiniteExpr1=FiniteExpr1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FiniteExpr!=null) FiniteExpr.accept(visitor);
        if(Relop!=null) Relop.accept(visitor);
        if(FiniteExpr1!=null) FiniteExpr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseTopDown(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(FiniteExpr1!=null) FiniteExpr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FiniteExpr!=null) FiniteExpr.traverseBottomUp(visitor);
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(FiniteExpr1!=null) FiniteExpr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PluralCondFact(\n");

        if(FiniteExpr!=null)
            buffer.append(FiniteExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FiniteExpr1!=null)
            buffer.append(FiniteExpr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PluralCondFact]");
        return buffer.toString();
    }
}
