// generated with ast extension for cup
// version 0.8
// 5/0/2021 23:17:23


package rs.ac.bg.etf.pp1.ast;

public class IfStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private PossibleErrorCondition PossibleErrorCondition;
    private Statement Statement;
    private OptionalStatement OptionalStatement;

    public IfStatement (PossibleErrorCondition PossibleErrorCondition, Statement Statement, OptionalStatement OptionalStatement) {
        this.PossibleErrorCondition=PossibleErrorCondition;
        if(PossibleErrorCondition!=null) PossibleErrorCondition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.OptionalStatement=OptionalStatement;
        if(OptionalStatement!=null) OptionalStatement.setParent(this);
    }

    public PossibleErrorCondition getPossibleErrorCondition() {
        return PossibleErrorCondition;
    }

    public void setPossibleErrorCondition(PossibleErrorCondition PossibleErrorCondition) {
        this.PossibleErrorCondition=PossibleErrorCondition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public OptionalStatement getOptionalStatement() {
        return OptionalStatement;
    }

    public void setOptionalStatement(OptionalStatement OptionalStatement) {
        this.OptionalStatement=OptionalStatement;
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
        if(PossibleErrorCondition!=null) PossibleErrorCondition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(OptionalStatement!=null) OptionalStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleErrorCondition!=null) PossibleErrorCondition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(OptionalStatement!=null) OptionalStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleErrorCondition!=null) PossibleErrorCondition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(OptionalStatement!=null) OptionalStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatement(\n");

        if(PossibleErrorCondition!=null)
            buffer.append(PossibleErrorCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalStatement!=null)
            buffer.append(OptionalStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatement]");
        return buffer.toString();
    }
}
