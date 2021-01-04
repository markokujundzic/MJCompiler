// generated with ast extension for cup
// version 0.8
// 4/0/2021 11:37:46


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalTermList extends OptionalTermList {

    private OptionalTermList OptionalTermList;
    private Addop Addop;
    private Term Term;

    public YesOptionalTermList (OptionalTermList OptionalTermList, Addop Addop, Term Term) {
        this.OptionalTermList=OptionalTermList;
        if(OptionalTermList!=null) OptionalTermList.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public OptionalTermList getOptionalTermList() {
        return OptionalTermList;
    }

    public void setOptionalTermList(OptionalTermList OptionalTermList) {
        this.OptionalTermList=OptionalTermList;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalTermList!=null) OptionalTermList.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalTermList!=null) OptionalTermList.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalTermList(\n");

        if(OptionalTermList!=null)
            buffer.append(OptionalTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalTermList]");
        return buffer.toString();
    }
}
