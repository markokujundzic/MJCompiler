// generated with ast extension for cup
// version 0.8
// 10/0/2021 18:10:53


package rs.ac.bg.etf.pp1.ast;

public class YesTernaryExpr extends Expr {

    private CondFact CondFact;
    private TernaryQuestionMark TernaryQuestionMark;
    private Expr Expr;
    private TernaryColon TernaryColon;
    private Expr Expr1;

    public YesTernaryExpr (CondFact CondFact, TernaryQuestionMark TernaryQuestionMark, Expr Expr, TernaryColon TernaryColon, Expr Expr1) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.TernaryQuestionMark=TernaryQuestionMark;
        if(TernaryQuestionMark!=null) TernaryQuestionMark.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.TernaryColon=TernaryColon;
        if(TernaryColon!=null) TernaryColon.setParent(this);
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public TernaryQuestionMark getTernaryQuestionMark() {
        return TernaryQuestionMark;
    }

    public void setTernaryQuestionMark(TernaryQuestionMark TernaryQuestionMark) {
        this.TernaryQuestionMark=TernaryQuestionMark;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public TernaryColon getTernaryColon() {
        return TernaryColon;
    }

    public void setTernaryColon(TernaryColon TernaryColon) {
        this.TernaryColon=TernaryColon;
    }

    public Expr getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr Expr1) {
        this.Expr1=Expr1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(TernaryQuestionMark!=null) TernaryQuestionMark.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(TernaryColon!=null) TernaryColon.accept(visitor);
        if(Expr1!=null) Expr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(TernaryQuestionMark!=null) TernaryQuestionMark.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(TernaryColon!=null) TernaryColon.traverseTopDown(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(TernaryQuestionMark!=null) TernaryQuestionMark.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(TernaryColon!=null) TernaryColon.traverseBottomUp(visitor);
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesTernaryExpr(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryQuestionMark!=null)
            buffer.append(TernaryQuestionMark.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryColon!=null)
            buffer.append(TernaryColon.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesTernaryExpr]");
        return buffer.toString();
    }
}
