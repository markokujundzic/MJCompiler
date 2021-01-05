// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:36:46


package rs.ac.bg.etf.pp1.ast;

public class DoWhileStatementDecl extends Statement {

    private DoWhileStatement DoWhileStatement;

    public DoWhileStatementDecl (DoWhileStatement DoWhileStatement) {
        this.DoWhileStatement=DoWhileStatement;
        if(DoWhileStatement!=null) DoWhileStatement.setParent(this);
    }

    public DoWhileStatement getDoWhileStatement() {
        return DoWhileStatement;
    }

    public void setDoWhileStatement(DoWhileStatement DoWhileStatement) {
        this.DoWhileStatement=DoWhileStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhileStatement!=null) DoWhileStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhileStatement!=null) DoWhileStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhileStatement!=null) DoWhileStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileStatementDecl(\n");

        if(DoWhileStatement!=null)
            buffer.append(DoWhileStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileStatementDecl]");
        return buffer.toString();
    }
}
