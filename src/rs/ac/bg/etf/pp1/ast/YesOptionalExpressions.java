// generated with ast extension for cup
// version 0.8
// 7/0/2021 15:56:3


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalExpressions extends OptionalExpressions {

    private OptionalExpressions OptionalExpressions;
    private OptionalExpr OptionalExpr;

    public YesOptionalExpressions (OptionalExpressions OptionalExpressions, OptionalExpr OptionalExpr) {
        this.OptionalExpressions=OptionalExpressions;
        if(OptionalExpressions!=null) OptionalExpressions.setParent(this);
        this.OptionalExpr=OptionalExpr;
        if(OptionalExpr!=null) OptionalExpr.setParent(this);
    }

    public OptionalExpressions getOptionalExpressions() {
        return OptionalExpressions;
    }

    public void setOptionalExpressions(OptionalExpressions OptionalExpressions) {
        this.OptionalExpressions=OptionalExpressions;
    }

    public OptionalExpr getOptionalExpr() {
        return OptionalExpr;
    }

    public void setOptionalExpr(OptionalExpr OptionalExpr) {
        this.OptionalExpr=OptionalExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalExpressions!=null) OptionalExpressions.accept(visitor);
        if(OptionalExpr!=null) OptionalExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalExpressions!=null) OptionalExpressions.traverseTopDown(visitor);
        if(OptionalExpr!=null) OptionalExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalExpressions!=null) OptionalExpressions.traverseBottomUp(visitor);
        if(OptionalExpr!=null) OptionalExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalExpressions(\n");

        if(OptionalExpressions!=null)
            buffer.append(OptionalExpressions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalExpr!=null)
            buffer.append(OptionalExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalExpressions]");
        return buffer.toString();
    }
}
