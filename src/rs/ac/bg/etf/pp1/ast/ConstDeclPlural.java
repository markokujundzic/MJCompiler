// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclPlural extends ConstDeclVariables {

    private ConstDeclVariables ConstDeclVariables;
    private ConstDeclVariable ConstDeclVariable;

    public ConstDeclPlural (ConstDeclVariables ConstDeclVariables, ConstDeclVariable ConstDeclVariable) {
        this.ConstDeclVariables=ConstDeclVariables;
        if(ConstDeclVariables!=null) ConstDeclVariables.setParent(this);
        this.ConstDeclVariable=ConstDeclVariable;
        if(ConstDeclVariable!=null) ConstDeclVariable.setParent(this);
    }

    public ConstDeclVariables getConstDeclVariables() {
        return ConstDeclVariables;
    }

    public void setConstDeclVariables(ConstDeclVariables ConstDeclVariables) {
        this.ConstDeclVariables=ConstDeclVariables;
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
        if(ConstDeclVariables!=null) ConstDeclVariables.accept(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclVariables!=null) ConstDeclVariables.traverseTopDown(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclVariables!=null) ConstDeclVariables.traverseBottomUp(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclPlural(\n");

        if(ConstDeclVariables!=null)
            buffer.append(ConstDeclVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclVariable!=null)
            buffer.append(ConstDeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclPlural]");
        return buffer.toString();
    }
}
