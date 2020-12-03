// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class PrintInt implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Integer number_to_print;

    public PrintInt (Integer number_to_print) {
        this.number_to_print=number_to_print;
    }

    public Integer getNumber_to_print() {
        return number_to_print;
    }

    public void setNumber_to_print(Integer number_to_print) {
        this.number_to_print=number_to_print;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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

        buffer.append(" "+tab+number_to_print);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintInt]");
        return buffer.toString();
    }
}
