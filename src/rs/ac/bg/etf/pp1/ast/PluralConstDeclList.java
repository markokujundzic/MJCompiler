// generated with ast extension for cup
// version 0.8
// 27/11/2020 12:43:21


package rs.ac.bg.etf.pp1.ast;

public class PluralConstDeclList extends ConstDeclList {

    private ConstDeclList ConstDeclList;
    private ConstDeclVariable ConstDeclVariable;

    public PluralConstDeclList (ConstDeclList ConstDeclList, ConstDeclVariable ConstDeclVariable) {
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
        this.ConstDeclVariable=ConstDeclVariable;
        if(ConstDeclVariable!=null) ConstDeclVariable.setParent(this);
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
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
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        if(ConstDeclVariable!=null) ConstDeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PluralConstDeclList(\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclVariable!=null)
            buffer.append(ConstDeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PluralConstDeclList]");
        return buffer.toString();
    }
}
