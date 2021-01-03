// generated with ast extension for cup
// version 0.8
// 3/0/2021 21:7:6


package rs.ac.bg.etf.pp1.ast;

public class NoVarDeclArrayOption extends VarDeclArrayOption {

    public NoVarDeclArrayOption () {
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
        buffer.append("NoVarDeclArrayOption(\n");

        buffer.append(tab);
        buffer.append(") [NoVarDeclArrayOption]");
        return buffer.toString();
    }
}
