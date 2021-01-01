// generated with ast extension for cup
// version 0.8
// 1/0/2021 19:51:0


package rs.ac.bg.etf.pp1.ast;

public class SingleVarDeclList extends VarDeclList {

    private DeclVariable DeclVariable;

    public SingleVarDeclList (DeclVariable DeclVariable) {
        this.DeclVariable=DeclVariable;
        if(DeclVariable!=null) DeclVariable.setParent(this);
    }

    public DeclVariable getDeclVariable() {
        return DeclVariable;
    }

    public void setDeclVariable(DeclVariable DeclVariable) {
        this.DeclVariable=DeclVariable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclVariable!=null) DeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclVariable!=null) DeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclVariable!=null) DeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarDeclList(\n");

        if(DeclVariable!=null)
            buffer.append(DeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarDeclList]");
        return buffer.toString();
    }
}
