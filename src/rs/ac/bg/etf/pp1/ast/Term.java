// generated with ast extension for cup
// version 0.8
// 10/11/2020 21:10:44


package rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Factor Factor;
    private OptionalFactors OptionalFactors;

    public Term (Factor Factor, OptionalFactors OptionalFactors) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.OptionalFactors=OptionalFactors;
        if(OptionalFactors!=null) OptionalFactors.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public OptionalFactors getOptionalFactors() {
        return OptionalFactors;
    }

    public void setOptionalFactors(OptionalFactors OptionalFactors) {
        this.OptionalFactors=OptionalFactors;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Factor!=null) Factor.accept(visitor);
        if(OptionalFactors!=null) OptionalFactors.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(OptionalFactors!=null) OptionalFactors.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(OptionalFactors!=null) OptionalFactors.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalFactors!=null)
            buffer.append(OptionalFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Term]");
        return buffer.toString();
    }
}
