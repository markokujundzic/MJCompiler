// generated with ast extension for cup
// version 0.8
// 6/0/2021 10:43:48


package rs.ac.bg.etf.pp1.ast;

public class NoMethodVariables extends MethodVariables {

    public NoMethodVariables () {
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
        buffer.append("NoMethodVariables(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodVariables]");
        return buffer.toString();
    }
}
