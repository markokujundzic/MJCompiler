// generated with ast extension for cup
// version 0.8
// 3/0/2021 10:5:0


package rs.ac.bg.etf.pp1.ast;

public class OptionalYesPrintNumber extends OptionalPrintNumber {

    private PrintNumber PrintNumber;

    public OptionalYesPrintNumber (PrintNumber PrintNumber) {
        this.PrintNumber=PrintNumber;
        if(PrintNumber!=null) PrintNumber.setParent(this);
    }

    public PrintNumber getPrintNumber() {
        return PrintNumber;
    }

    public void setPrintNumber(PrintNumber PrintNumber) {
        this.PrintNumber=PrintNumber;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintNumber!=null) PrintNumber.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintNumber!=null) PrintNumber.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintNumber!=null) PrintNumber.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalYesPrintNumber(\n");

        if(PrintNumber!=null)
            buffer.append(PrintNumber.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalYesPrintNumber]");
        return buffer.toString();
    }
}
