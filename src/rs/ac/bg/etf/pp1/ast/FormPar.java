// generated with ast extension for cup
// version 0.8
// 12/11/2020 11:42:13


package rs.ac.bg.etf.pp1.ast;

public class FormPar implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private FormParName FormParName;
    private FormParArrayOption FormParArrayOption;

    public FormPar (Type Type, FormParName FormParName, FormParArrayOption FormParArrayOption) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParName=FormParName;
        if(FormParName!=null) FormParName.setParent(this);
        this.FormParArrayOption=FormParArrayOption;
        if(FormParArrayOption!=null) FormParArrayOption.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParName getFormParName() {
        return FormParName;
    }

    public void setFormParName(FormParName FormParName) {
        this.FormParName=FormParName;
    }

    public FormParArrayOption getFormParArrayOption() {
        return FormParArrayOption;
    }

    public void setFormParArrayOption(FormParArrayOption FormParArrayOption) {
        this.FormParArrayOption=FormParArrayOption;
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
        if(Type!=null) Type.accept(visitor);
        if(FormParName!=null) FormParName.accept(visitor);
        if(FormParArrayOption!=null) FormParArrayOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParName!=null) FormParName.traverseTopDown(visitor);
        if(FormParArrayOption!=null) FormParArrayOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParName!=null) FormParName.traverseBottomUp(visitor);
        if(FormParArrayOption!=null) FormParArrayOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPar(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParName!=null)
            buffer.append(FormParName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParArrayOption!=null)
            buffer.append(FormParArrayOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPar]");
        return buffer.toString();
    }
}
