// generated with ast extension for cup
// version 0.8
// 2/0/2021 16:0:33


package rs.ac.bg.etf.pp1.ast;

public class YesMethodBody extends MethodBody {

    private MethodBody MethodBody;
    private Statement Statement;

    public YesMethodBody (MethodBody MethodBody, Statement Statement) {
        this.MethodBody=MethodBody;
        if(MethodBody!=null) MethodBody.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public MethodBody getMethodBody() {
        return MethodBody;
    }

    public void setMethodBody(MethodBody MethodBody) {
        this.MethodBody=MethodBody;
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
        if(MethodBody!=null) MethodBody.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodBody!=null) MethodBody.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodBody!=null) MethodBody.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesMethodBody(\n");

        if(MethodBody!=null)
            buffer.append(MethodBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesMethodBody]");
        return buffer.toString();
    }
}
