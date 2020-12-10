// generated with ast extension for cup
// version 0.8
// 10/11/2020 21:10:44


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalFactors extends OptionalFactors {

    private OptionalFactors OptionalFactors;
    private OptionalFactor OptionalFactor;

    public YesOptionalFactors (OptionalFactors OptionalFactors, OptionalFactor OptionalFactor) {
        this.OptionalFactors=OptionalFactors;
        if(OptionalFactors!=null) OptionalFactors.setParent(this);
        this.OptionalFactor=OptionalFactor;
        if(OptionalFactor!=null) OptionalFactor.setParent(this);
    }

    public OptionalFactors getOptionalFactors() {
        return OptionalFactors;
    }

    public void setOptionalFactors(OptionalFactors OptionalFactors) {
        this.OptionalFactors=OptionalFactors;
    }

    public OptionalFactor getOptionalFactor() {
        return OptionalFactor;
    }

    public void setOptionalFactor(OptionalFactor OptionalFactor) {
        this.OptionalFactor=OptionalFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalFactors!=null) OptionalFactors.accept(visitor);
        if(OptionalFactor!=null) OptionalFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalFactors!=null) OptionalFactors.traverseTopDown(visitor);
        if(OptionalFactor!=null) OptionalFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalFactors!=null) OptionalFactors.traverseBottomUp(visitor);
        if(OptionalFactor!=null) OptionalFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalFactors(\n");

        if(OptionalFactors!=null)
            buffer.append(OptionalFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalFactor!=null)
            buffer.append(OptionalFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalFactors]");
        return buffer.toString();
    }
}
