// generated with ast extension for cup
// version 0.8
// 7/0/2021 15:56:3


package rs.ac.bg.etf.pp1.ast;

public class MinusTermFiniteExpr extends FiniteExpr {

    private FiniteTerm FiniteTerm;
    private OptionalTermList OptionalTermList;

    public MinusTermFiniteExpr (FiniteTerm FiniteTerm, OptionalTermList OptionalTermList) {
        this.FiniteTerm=FiniteTerm;
        if(FiniteTerm!=null) FiniteTerm.setParent(this);
        this.OptionalTermList=OptionalTermList;
        if(OptionalTermList!=null) OptionalTermList.setParent(this);
    }

    public FiniteTerm getFiniteTerm() {
        return FiniteTerm;
    }

    public void setFiniteTerm(FiniteTerm FiniteTerm) {
        this.FiniteTerm=FiniteTerm;
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
        if(FiniteTerm!=null) FiniteTerm.accept(visitor);
        if(OptionalTermList!=null) OptionalTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FiniteTerm!=null) FiniteTerm.traverseTopDown(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FiniteTerm!=null) FiniteTerm.traverseBottomUp(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MinusTermFiniteExpr(\n");

        if(FiniteTerm!=null)
            buffer.append(FiniteTerm.toString("  "+tab));
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
