// generated with ast extension for cup
// version 0.8
// 10/11/2020 21:15:52


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalDesignatorList extends OptionalDesignatorList {

    private OptionalDesignatorList OptionalDesignatorList;
    private OptionalDesignator OptionalDesignator;

    public YesOptionalDesignatorList (OptionalDesignatorList OptionalDesignatorList, OptionalDesignator OptionalDesignator) {
        this.OptionalDesignatorList=OptionalDesignatorList;
        if(OptionalDesignatorList!=null) OptionalDesignatorList.setParent(this);
        this.OptionalDesignator=OptionalDesignator;
        if(OptionalDesignator!=null) OptionalDesignator.setParent(this);
    }

    public OptionalDesignatorList getOptionalDesignatorList() {
        return OptionalDesignatorList;
    }

    public void setOptionalDesignatorList(OptionalDesignatorList OptionalDesignatorList) {
        this.OptionalDesignatorList=OptionalDesignatorList;
    }

    public OptionalDesignator getOptionalDesignator() {
        return OptionalDesignator;
    }

    public void setOptionalDesignator(OptionalDesignator OptionalDesignator) {
        this.OptionalDesignator=OptionalDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalDesignatorList!=null) OptionalDesignatorList.accept(visitor);
        if(OptionalDesignator!=null) OptionalDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalDesignatorList!=null) OptionalDesignatorList.traverseTopDown(visitor);
        if(OptionalDesignator!=null) OptionalDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalDesignatorList!=null) OptionalDesignatorList.traverseBottomUp(visitor);
        if(OptionalDesignator!=null) OptionalDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalDesignatorList(\n");

        if(OptionalDesignatorList!=null)
            buffer.append(OptionalDesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignator!=null)
            buffer.append(OptionalDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalDesignatorList]");
        return buffer.toString();
    }
}