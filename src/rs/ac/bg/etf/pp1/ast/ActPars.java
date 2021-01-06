// generated with ast extension for cup
// version 0.8
// 6/0/2021 16:13:58


package rs.ac.bg.etf.pp1.ast;

public class ActPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private OptionalExpressions OptionalExpressions;

    public ActPars (Expr Expr, OptionalExpressions OptionalExpressions) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.OptionalExpressions=OptionalExpressions;
        if(OptionalExpressions!=null) OptionalExpressions.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public OptionalExpressions getOptionalExpressions() {
        return OptionalExpressions;
    }

    public void setOptionalExpressions(OptionalExpressions OptionalExpressions) {
        this.OptionalExpressions=OptionalExpressions;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(OptionalExpressions!=null) OptionalExpressions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(OptionalExpressions!=null) OptionalExpressions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(OptionalExpressions!=null) OptionalExpressions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalExpressions!=null)
            buffer.append(OptionalExpressions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars]");
        return buffer.toString();
    }
}
