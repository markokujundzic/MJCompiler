// generated with ast extension for cup
// version 0.8
// 1/0/2021 12:6:58


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private OptionalPrintNumber OptionalPrintNumber;

    public PrintStatement (Expr Expr, OptionalPrintNumber OptionalPrintNumber) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.OptionalPrintNumber=OptionalPrintNumber;
        if(OptionalPrintNumber!=null) OptionalPrintNumber.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public OptionalPrintNumber getOptionalPrintNumber() {
        return OptionalPrintNumber;
    }

    public void setOptionalPrintNumber(OptionalPrintNumber OptionalPrintNumber) {
        this.OptionalPrintNumber=OptionalPrintNumber;
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
        if(OptionalPrintNumber!=null) OptionalPrintNumber.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(OptionalPrintNumber!=null) OptionalPrintNumber.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(OptionalPrintNumber!=null) OptionalPrintNumber.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalPrintNumber!=null)
            buffer.append(OptionalPrintNumber.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
