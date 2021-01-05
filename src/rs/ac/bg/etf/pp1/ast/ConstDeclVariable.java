// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:36:46


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclVariable implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ConstDeclName ConstDeclName;
    private ConstDeclValue ConstDeclValue;

    public ConstDeclVariable (ConstDeclName ConstDeclName, ConstDeclValue ConstDeclValue) {
        this.ConstDeclName=ConstDeclName;
        if(ConstDeclName!=null) ConstDeclName.setParent(this);
        this.ConstDeclValue=ConstDeclValue;
        if(ConstDeclValue!=null) ConstDeclValue.setParent(this);
    }

    public ConstDeclName getConstDeclName() {
        return ConstDeclName;
    }

    public void setConstDeclName(ConstDeclName ConstDeclName) {
        this.ConstDeclName=ConstDeclName;
    }

    public ConstDeclValue getConstDeclValue() {
        return ConstDeclValue;
    }

    public void setConstDeclValue(ConstDeclValue ConstDeclValue) {
        this.ConstDeclValue=ConstDeclValue;
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
        if(ConstDeclName!=null) ConstDeclName.accept(visitor);
        if(ConstDeclValue!=null) ConstDeclValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclName!=null) ConstDeclName.traverseTopDown(visitor);
        if(ConstDeclValue!=null) ConstDeclValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclName!=null) ConstDeclName.traverseBottomUp(visitor);
        if(ConstDeclValue!=null) ConstDeclValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclVariable(\n");

        if(ConstDeclName!=null)
            buffer.append(ConstDeclName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclValue!=null)
            buffer.append(ConstDeclValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclVariable]");
        return buffer.toString();
    }
}
