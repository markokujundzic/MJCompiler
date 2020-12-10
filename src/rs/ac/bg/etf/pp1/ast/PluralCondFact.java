// generated with ast extension for cup
// version 0.8
// 10/11/2020 21:10:44


package rs.ac.bg.etf.pp1.ast;

public class PluralCondFact extends CondFact {

    private CondFact CondFact;
    private Relop Relop;
    private FiniteExpr FiniteExpr;

    public PluralCondFact (CondFact CondFact, Relop Relop, FiniteExpr FiniteExpr) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.FiniteExpr=FiniteExpr;
        if(FiniteExpr!=null) FiniteExpr.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
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
        if(CondFact!=null) CondFact.accept(visitor);
        if(Relop!=null) Relop.accept(visitor);
        if(FiniteExpr!=null) FiniteExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(FiniteExpr!=null) FiniteExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PluralCondFact(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FiniteExpr!=null)
            buffer.append(FiniteExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PluralCondFact]");
        return buffer.toString();
    }
}
