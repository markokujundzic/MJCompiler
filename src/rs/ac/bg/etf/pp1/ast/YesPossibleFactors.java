// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class YesPossibleFactors extends PossibleFactors {

    private PossibleFactors PossibleFactors;
    private PossibleFactor PossibleFactor;

    public YesPossibleFactors (PossibleFactors PossibleFactors, PossibleFactor PossibleFactor) {
        this.PossibleFactors=PossibleFactors;
        if(PossibleFactors!=null) PossibleFactors.setParent(this);
        this.PossibleFactor=PossibleFactor;
        if(PossibleFactor!=null) PossibleFactor.setParent(this);
    }

    public PossibleFactors getPossibleFactors() {
        return PossibleFactors;
    }

    public void setPossibleFactors(PossibleFactors PossibleFactors) {
        this.PossibleFactors=PossibleFactors;
    }

    public PossibleFactor getPossibleFactor() {
        return PossibleFactor;
    }

    public void setPossibleFactor(PossibleFactor PossibleFactor) {
        this.PossibleFactor=PossibleFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PossibleFactors!=null) PossibleFactors.accept(visitor);
        if(PossibleFactor!=null) PossibleFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleFactors!=null) PossibleFactors.traverseTopDown(visitor);
        if(PossibleFactor!=null) PossibleFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleFactors!=null) PossibleFactors.traverseBottomUp(visitor);
        if(PossibleFactor!=null) PossibleFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesPossibleFactors(\n");

        if(PossibleFactors!=null)
            buffer.append(PossibleFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleFactor!=null)
            buffer.append(PossibleFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesPossibleFactors]");
        return buffer.toString();
    }
}
