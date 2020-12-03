// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ReturnType ReturnType;
    private MethodName MethodName;
    private MethodParameters MethodParameters;
    private MethodVariables MethodVariables;
    private MethodStatements MethodStatements;

    public MethodDeclaration (ReturnType ReturnType, MethodName MethodName, MethodParameters MethodParameters, MethodVariables MethodVariables, MethodStatements MethodStatements) {
        this.ReturnType=ReturnType;
        if(ReturnType!=null) ReturnType.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.MethodParameters=MethodParameters;
        if(MethodParameters!=null) MethodParameters.setParent(this);
        this.MethodVariables=MethodVariables;
        if(MethodVariables!=null) MethodVariables.setParent(this);
        this.MethodStatements=MethodStatements;
        if(MethodStatements!=null) MethodStatements.setParent(this);
    }

    public ReturnType getReturnType() {
        return ReturnType;
    }

    public void setReturnType(ReturnType ReturnType) {
        this.ReturnType=ReturnType;
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

    public MethodStatements getMethodStatements() {
        return MethodStatements;
    }

    public void setMethodStatements(MethodStatements MethodStatements) {
        this.MethodStatements=MethodStatements;
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
        if(ReturnType!=null) ReturnType.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(MethodParameters!=null) MethodParameters.accept(visitor);
        if(MethodVariables!=null) MethodVariables.accept(visitor);
        if(MethodStatements!=null) MethodStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnType!=null) ReturnType.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(MethodParameters!=null) MethodParameters.traverseTopDown(visitor);
        if(MethodVariables!=null) MethodVariables.traverseTopDown(visitor);
        if(MethodStatements!=null) MethodStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnType!=null) ReturnType.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(MethodParameters!=null) MethodParameters.traverseBottomUp(visitor);
        if(MethodVariables!=null) MethodVariables.traverseBottomUp(visitor);
        if(MethodStatements!=null) MethodStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(ReturnType!=null)
            buffer.append(ReturnType.toString("  "+tab));
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

        if(MethodStatements!=null)
            buffer.append(MethodStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
