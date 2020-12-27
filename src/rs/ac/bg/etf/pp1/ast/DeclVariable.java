// generated with ast extension for cup
// version 0.8
// 27/11/2020 9:10:42


package rs.ac.bg.etf.pp1.ast;

public class DeclVariable implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDeclName VarDeclName;
    private VarDeclArrayOption VarDeclArrayOption;

    public DeclVariable (VarDeclName VarDeclName, VarDeclArrayOption VarDeclArrayOption) {
        this.VarDeclName=VarDeclName;
        if(VarDeclName!=null) VarDeclName.setParent(this);
        this.VarDeclArrayOption=VarDeclArrayOption;
        if(VarDeclArrayOption!=null) VarDeclArrayOption.setParent(this);
    }

    public VarDeclName getVarDeclName() {
        return VarDeclName;
    }

    public void setVarDeclName(VarDeclName VarDeclName) {
        this.VarDeclName=VarDeclName;
    }

    public VarDeclArrayOption getVarDeclArrayOption() {
        return VarDeclArrayOption;
    }

    public void setVarDeclArrayOption(VarDeclArrayOption VarDeclArrayOption) {
        this.VarDeclArrayOption=VarDeclArrayOption;
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
        if(VarDeclName!=null) VarDeclName.accept(visitor);
        if(VarDeclArrayOption!=null) VarDeclArrayOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclName!=null) VarDeclName.traverseTopDown(visitor);
        if(VarDeclArrayOption!=null) VarDeclArrayOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclName!=null) VarDeclName.traverseBottomUp(visitor);
        if(VarDeclArrayOption!=null) VarDeclArrayOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclVariable(\n");

        if(VarDeclName!=null)
            buffer.append(VarDeclName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclArrayOption!=null)
            buffer.append(VarDeclArrayOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclVariable]");
        return buffer.toString();
    }
}
