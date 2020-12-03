// generated with ast extension for cup
// version 0.8
// 3/11/2020 21:21:52


package rs.ac.bg.etf.pp1.ast;

public class YesPossibleExpressions extends PossibleExpressions {

    private PossibleExpressions PossibleExpressions;
    private PossibleExpr PossibleExpr;

    public YesPossibleExpressions (PossibleExpressions PossibleExpressions, PossibleExpr PossibleExpr) {
        this.PossibleExpressions=PossibleExpressions;
        if(PossibleExpressions!=null) PossibleExpressions.setParent(this);
        this.PossibleExpr=PossibleExpr;
        if(PossibleExpr!=null) PossibleExpr.setParent(this);
    }

    public PossibleExpressions getPossibleExpressions() {
        return PossibleExpressions;
    }

    public void setPossibleExpressions(PossibleExpressions PossibleExpressions) {
        this.PossibleExpressions=PossibleExpressions;
    }

    public PossibleExpr getPossibleExpr() {
        return PossibleExpr;
    }

    public void setPossibleExpr(PossibleExpr PossibleExpr) {
        this.PossibleExpr=PossibleExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PossibleExpressions!=null) PossibleExpressions.accept(visitor);
        if(PossibleExpr!=null) PossibleExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleExpressions!=null) PossibleExpressions.traverseTopDown(visitor);
        if(PossibleExpr!=null) PossibleExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleExpressions!=null) PossibleExpressions.traverseBottomUp(visitor);
        if(PossibleExpr!=null) PossibleExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesPossibleExpressions(\n");

        if(PossibleExpressions!=null)
            buffer.append(PossibleExpressions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleExpr!=null)
            buffer.append(PossibleExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesPossibleExpressions]");
        return buffer.toString();
    }
}
