// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class YesPrintInts extends PrintInts {

    private PrintInt PrintInt;

    public YesPrintInts (PrintInt PrintInt) {
        this.PrintInt=PrintInt;
        if(PrintInt!=null) PrintInt.setParent(this);
    }

    public PrintInt getPrintInt() {
        return PrintInt;
    }

    public void setPrintInt(PrintInt PrintInt) {
        this.PrintInt=PrintInt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintInt!=null) PrintInt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintInt!=null) PrintInt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintInt!=null) PrintInt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesPrintInts(\n");

        if(PrintInt!=null)
            buffer.append(PrintInt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesPrintInts]");
        return buffer.toString();
    }
}
