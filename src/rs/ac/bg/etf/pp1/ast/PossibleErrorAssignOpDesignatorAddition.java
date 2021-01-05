// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:36:46


package rs.ac.bg.etf.pp1.ast;

public class PossibleErrorAssignOpDesignatorAddition extends DesignatorAddition {

    private PossibleErrorDesignatorAddition PossibleErrorDesignatorAddition;

    public PossibleErrorAssignOpDesignatorAddition (PossibleErrorDesignatorAddition PossibleErrorDesignatorAddition) {
        this.PossibleErrorDesignatorAddition=PossibleErrorDesignatorAddition;
        if(PossibleErrorDesignatorAddition!=null) PossibleErrorDesignatorAddition.setParent(this);
    }

    public PossibleErrorDesignatorAddition getPossibleErrorDesignatorAddition() {
        return PossibleErrorDesignatorAddition;
    }

    public void setPossibleErrorDesignatorAddition(PossibleErrorDesignatorAddition PossibleErrorDesignatorAddition) {
        this.PossibleErrorDesignatorAddition=PossibleErrorDesignatorAddition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PossibleErrorDesignatorAddition!=null) PossibleErrorDesignatorAddition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleErrorDesignatorAddition!=null) PossibleErrorDesignatorAddition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleErrorDesignatorAddition!=null) PossibleErrorDesignatorAddition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PossibleErrorAssignOpDesignatorAddition(\n");

        if(PossibleErrorDesignatorAddition!=null)
            buffer.append(PossibleErrorDesignatorAddition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PossibleErrorAssignOpDesignatorAddition]");
        return buffer.toString();
    }
}
