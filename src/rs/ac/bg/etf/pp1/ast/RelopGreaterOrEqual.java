// generated with ast extension for cup
// version 0.8
// 12/11/2020 11:42:13


package rs.ac.bg.etf.pp1.ast;

public class RelopGreaterOrEqual extends Relop {

    public RelopGreaterOrEqual () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelopGreaterOrEqual(\n");

        buffer.append(tab);
        buffer.append(") [RelopGreaterOrEqual]");
        return buffer.toString();
    }
}
