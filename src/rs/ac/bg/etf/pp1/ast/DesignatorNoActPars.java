// generated with ast extension for cup
// version 0.8
// 24/11/2020 22:3:35


package rs.ac.bg.etf.pp1.ast;

public class DesignatorNoActPars extends DesignatorActPars {

    public DesignatorNoActPars () {
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
        buffer.append("DesignatorNoActPars(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorNoActPars]");
        return buffer.toString();
    }
}
