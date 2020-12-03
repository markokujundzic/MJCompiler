// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPlural extends DeclVariables {

    private DeclVariables DeclVariables;
    private DeclVariable DeclVariable;

    public VarDeclPlural (DeclVariables DeclVariables, DeclVariable DeclVariable) {
        this.DeclVariables=DeclVariables;
        if(DeclVariables!=null) DeclVariables.setParent(this);
        this.DeclVariable=DeclVariable;
        if(DeclVariable!=null) DeclVariable.setParent(this);
    }

    public DeclVariables getDeclVariables() {
        return DeclVariables;
    }

    public void setDeclVariables(DeclVariables DeclVariables) {
        this.DeclVariables=DeclVariables;
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
        if(DeclVariables!=null) DeclVariables.accept(visitor);
        if(DeclVariable!=null) DeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclVariables!=null) DeclVariables.traverseTopDown(visitor);
        if(DeclVariable!=null) DeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclVariables!=null) DeclVariables.traverseBottomUp(visitor);
        if(DeclVariable!=null) DeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPlural(\n");

        if(DeclVariables!=null)
            buffer.append(DeclVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclVariable!=null)
            buffer.append(DeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPlural]");
        return buffer.toString();
    }
}
