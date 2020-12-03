// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class DesignatorOptionalPeriod extends DesignatorOptional {

    private DesignatorOptionalName DesignatorOptionalName;

    public DesignatorOptionalPeriod (DesignatorOptionalName DesignatorOptionalName) {
        this.DesignatorOptionalName=DesignatorOptionalName;
        if(DesignatorOptionalName!=null) DesignatorOptionalName.setParent(this);
    }

    public DesignatorOptionalName getDesignatorOptionalName() {
        return DesignatorOptionalName;
    }

    public void setDesignatorOptionalName(DesignatorOptionalName DesignatorOptionalName) {
        this.DesignatorOptionalName=DesignatorOptionalName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOptionalName!=null) DesignatorOptionalName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOptionalName!=null) DesignatorOptionalName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOptionalName!=null) DesignatorOptionalName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorOptionalPeriod(\n");

        if(DesignatorOptionalName!=null)
            buffer.append(DesignatorOptionalName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorOptionalPeriod]");
        return buffer.toString();
    }
}
