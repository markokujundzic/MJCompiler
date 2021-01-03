// generated with ast extension for cup
// version 0.8
// 3/0/2021 18:22:48


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodReturnType MethodReturnType;
    private MethodName MethodName;
    private MethodParameters MethodParameters;
    private MethodVariables MethodVariables;
    private MethodBody MethodBody;

    public MethodDeclaration (MethodReturnType MethodReturnType, MethodName MethodName, MethodParameters MethodParameters, MethodVariables MethodVariables, MethodBody MethodBody) {
        this.MethodReturnType=MethodReturnType;
        if(MethodReturnType!=null) MethodReturnType.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.MethodParameters=MethodParameters;
        if(MethodParameters!=null) MethodParameters.setParent(this);
        this.MethodVariables=MethodVariables;
        if(MethodVariables!=null) MethodVariables.setParent(this);
        this.MethodBody=MethodBody;
        if(MethodBody!=null) MethodBody.setParent(this);
    }

    public MethodReturnType getMethodReturnType() {
        return MethodReturnType;
    }

    public void setMethodReturnType(MethodReturnType MethodReturnType) {
        this.MethodReturnType=MethodReturnType;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public MethodParameters getMethodParameters() {
        return MethodParameters;
    }

    public void setMethodParameters(MethodParameters MethodParameters) {
        this.MethodParameters=MethodParameters;
    }

    public MethodVariables getMethodVariables() {
        return MethodVariables;
    }

    public void setMethodVariables(MethodVariables MethodVariables) {
        this.MethodVariables=MethodVariables;
    }

    public MethodBody getMethodBody() {
        return MethodBody;
    }

    public void setMethodBody(MethodBody MethodBody) {
        this.MethodBody=MethodBody;
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
        if(MethodReturnType!=null) MethodReturnType.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(MethodParameters!=null) MethodParameters.accept(visitor);
        if(MethodVariables!=null) MethodVariables.accept(visitor);
        if(MethodBody!=null) MethodBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnType!=null) MethodReturnType.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(MethodParameters!=null) MethodParameters.traverseTopDown(visitor);
        if(MethodVariables!=null) MethodVariables.traverseTopDown(visitor);
        if(MethodBody!=null) MethodBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(MethodParameters!=null) MethodParameters.traverseBottomUp(visitor);
        if(MethodVariables!=null) MethodVariables.traverseBottomUp(visitor);
        if(MethodBody!=null) MethodBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodReturnType!=null)
            buffer.append(MethodReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodParameters!=null)
            buffer.append(MethodParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVariables!=null)
            buffer.append(MethodVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodBody!=null)
            buffer.append(MethodBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
