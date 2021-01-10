// generated with ast extension for cup
// version 0.8
// 10/0/2021 18:10:53


package rs.ac.bg.etf.pp1.ast;

public class CharFactor extends Factor {

    private Character value;

    public CharFactor (Character value) {
        this.value=value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value=value;
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
        buffer.append("CharFactor(\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharFactor]");
        return buffer.toString();
    }
}
