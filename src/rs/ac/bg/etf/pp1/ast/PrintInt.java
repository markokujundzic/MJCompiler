// generated with ast extension for cup
// version 0.8
// 10/0/2021 18:10:53


package rs.ac.bg.etf.pp1.ast;

public class PrintInt extends PrintNumber {

    private Integer number;

    public PrintInt (Integer number) {
        this.number=number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number=number;
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
        buffer.append("PrintInt(\n");

        buffer.append(" "+tab+number);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintInt]");
        return buffer.toString();
    }
}
