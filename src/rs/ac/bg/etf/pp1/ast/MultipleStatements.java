// generated with ast extension for cup
// version 0.8
// 2/0/2021 16:0:33


package rs.ac.bg.etf.pp1.ast;

public class MultipleStatements extends Statement {

    private MethodBody MethodBody;

    public MultipleStatements (MethodBody MethodBody) {
        this.MethodBody=MethodBody;
        if(MethodBody!=null) MethodBody.setParent(this);
    }

    public MethodBody getMethodBody() {
        return MethodBody;
    }

    public void setMethodBody(MethodBody MethodBody) {
        this.MethodBody=MethodBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodBody!=null) MethodBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodBody!=null) MethodBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodBody!=null) MethodBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleStatements(\n");

        if(MethodBody!=null)
            buffer.append(MethodBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleStatements]");
        return buffer.toString();
    }
}
