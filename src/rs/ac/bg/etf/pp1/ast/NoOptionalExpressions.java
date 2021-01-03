// generated with ast extension for cup
// version 0.8
// 3/0/2021 18:22:48


package rs.ac.bg.etf.pp1.ast;

public class NoOptionalExpressions extends OptionalExpressions {

    public NoOptionalExpressions () {
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
        buffer.append("NoOptionalExpressions(\n");

        buffer.append(tab);
        buffer.append(") [NoOptionalExpressions]");
        return buffer.toString();
    }
}
