// generated with ast extension for cup
// version 0.8
// 11/11/2020 23:31:44


package rs.ac.bg.etf.pp1.ast;

public class PeriodOptionalDesignator extends OptionalDesignator {

    private OptionalDesignatorName OptionalDesignatorName;

    public PeriodOptionalDesignator (OptionalDesignatorName OptionalDesignatorName) {
        this.OptionalDesignatorName=OptionalDesignatorName;
        if(OptionalDesignatorName!=null) OptionalDesignatorName.setParent(this);
    }

    public OptionalDesignatorName getOptionalDesignatorName() {
        return OptionalDesignatorName;
    }

    public void setOptionalDesignatorName(OptionalDesignatorName OptionalDesignatorName) {
        this.OptionalDesignatorName=OptionalDesignatorName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalDesignatorName!=null) OptionalDesignatorName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalDesignatorName!=null) OptionalDesignatorName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalDesignatorName!=null) OptionalDesignatorName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PeriodOptionalDesignator(\n");

        if(OptionalDesignatorName!=null)
            buffer.append(OptionalDesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PeriodOptionalDesignator]");
        return buffer.toString();
    }
}
