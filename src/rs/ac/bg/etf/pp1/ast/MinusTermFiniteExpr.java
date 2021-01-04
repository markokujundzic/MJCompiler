// generated with ast extension for cup
// version 0.8
// 4/0/2021 11:37:46


package rs.ac.bg.etf.pp1.ast;

public class MinusTermFiniteExpr extends FiniteExpr {

    private Term Term;
    private OptionalTermList OptionalTermList;

    public MinusTermFiniteExpr (Term Term, OptionalTermList OptionalTermList) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.OptionalTermList=OptionalTermList;
        if(OptionalTermList!=null) OptionalTermList.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public OptionalTermList getOptionalTermList() {
        return OptionalTermList;
    }

    public void setOptionalTermList(OptionalTermList OptionalTermList) {
        this.OptionalTermList=OptionalTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(OptionalTermList!=null) OptionalTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MinusTermFiniteExpr(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalTermList!=null)
            buffer.append(OptionalTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MinusTermFiniteExpr]");
        return buffer.toString();
    }
}
