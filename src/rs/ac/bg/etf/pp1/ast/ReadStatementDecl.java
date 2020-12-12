// generated with ast extension for cup
// version 0.8
// 12/11/2020 12:36:35


package rs.ac.bg.etf.pp1.ast;

public class ReadStatementDecl extends Statement {

    private ReadStatement ReadStatement;

    public ReadStatementDecl (ReadStatement ReadStatement) {
        this.ReadStatement=ReadStatement;
        if(ReadStatement!=null) ReadStatement.setParent(this);
    }

    public ReadStatement getReadStatement() {
        return ReadStatement;
    }

    public void setReadStatement(ReadStatement ReadStatement) {
        this.ReadStatement=ReadStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReadStatement!=null) ReadStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReadStatement!=null) ReadStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReadStatement!=null) ReadStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReadStatementDecl(\n");

        if(ReadStatement!=null)
            buffer.append(ReadStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReadStatementDecl]");
        return buffer.toString();
    }
}
