// generated with ast extension for cup
// version 0.8
// 24/11/2020 22:3:35


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalStatement extends OptionalStatement {

    private ElseStatement ElseStatement;
    private Statement Statement;

    public YesOptionalStatement (ElseStatement ElseStatement, Statement Statement) {
        this.ElseStatement=ElseStatement;
        if(ElseStatement!=null) ElseStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ElseStatement getElseStatement() {
        return ElseStatement;
    }

    public void setElseStatement(ElseStatement ElseStatement) {
        this.ElseStatement=ElseStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ElseStatement!=null) ElseStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElseStatement!=null) ElseStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElseStatement!=null) ElseStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalStatement(\n");

        if(ElseStatement!=null)
            buffer.append(ElseStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalStatement]");
        return buffer.toString();
    }
}
