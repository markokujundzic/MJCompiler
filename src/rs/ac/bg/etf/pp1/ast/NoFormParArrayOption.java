// generated with ast extension for cup
// version 0.8
// 1/0/2021 12:6:58


package rs.ac.bg.etf.pp1.ast;

public class NoFormParArrayOption extends FormParArrayOption {

    public NoFormParArrayOption () {
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
        buffer.append("NoFormParArrayOption(\n");

        buffer.append(tab);
        buffer.append(") [NoFormParArrayOption]");
        return buffer.toString();
    }
}
