// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:36:46


package rs.ac.bg.etf.pp1.ast;

public class SingleConstDeclList extends ConstDeclList {

    private ConstDeclVariable ConstDeclVariable;

    public SingleConstDeclList (ConstDeclVariable ConstDeclVariable) {
        this.ConstDeclVariable=ConstDeclVariable;
        if(ConstDeclVariable!=null) ConstDeclVariable.setParent(this);
    }

    public ConstDeclVariable getConstDeclVariable() {
        return ConstDeclVariable;
    }

    public void setConstDeclVariable(ConstDeclVariable ConstDeclVariable) {
        this.ConstDeclVariable=ConstDeclVariable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclVariable!=null) ConstDeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstDeclList(\n");

        if(ConstDeclVariable!=null)
            buffer.append(ConstDeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstDeclList]");
        return buffer.toString();
    }
}
