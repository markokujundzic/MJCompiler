// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:36:46


package rs.ac.bg.etf.pp1.ast;

public class NoMethodBody extends MethodBody {

    public NoMethodBody () {
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
        buffer.append("NoMethodBody(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodBody]");
        return buffer.toString();
    }
}
