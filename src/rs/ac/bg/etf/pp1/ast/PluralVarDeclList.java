// generated with ast extension for cup
// version 0.8
// 3/0/2021 21:7:6


package rs.ac.bg.etf.pp1.ast;

public class PluralVarDeclList extends VarDeclList {

    private VarDeclList VarDeclList;
    private DeclVariable DeclVariable;

    public PluralVarDeclList (VarDeclList VarDeclList, DeclVariable DeclVariable) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.DeclVariable=DeclVariable;
        if(DeclVariable!=null) DeclVariable.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
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
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(DeclVariable!=null) DeclVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(DeclVariable!=null) DeclVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(DeclVariable!=null) DeclVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PluralVarDeclList(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclVariable!=null)
            buffer.append(DeclVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PluralVarDeclList]");
        return buffer.toString();
    }
}
