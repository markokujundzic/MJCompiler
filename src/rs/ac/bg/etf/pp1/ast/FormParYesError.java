// generated with ast extension for cup
// version 0.8
// 12/11/2020 12:36:35


package rs.ac.bg.etf.pp1.ast;

public class FormParYesError extends FormPar {

    public FormParYesError () {
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
        buffer.append("FormParYesError(\n");

        buffer.append(tab);
        buffer.append(") [FormParYesError]");
        return buffer.toString();
    }
}