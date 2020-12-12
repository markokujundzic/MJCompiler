// generated with ast extension for cup
// version 0.8
// 12/11/2020 11:42:13


package rs.ac.bg.etf.pp1.ast;

public class PossibleErrorDesignatorAddition extends DesignatorAddition {

    private AssignOpExprDesignatorAddition AssignOpExprDesignatorAddition;

    public PossibleErrorDesignatorAddition (AssignOpExprDesignatorAddition AssignOpExprDesignatorAddition) {
        this.AssignOpExprDesignatorAddition=AssignOpExprDesignatorAddition;
        if(AssignOpExprDesignatorAddition!=null) AssignOpExprDesignatorAddition.setParent(this);
    }

    public AssignOpExprDesignatorAddition getAssignOpExprDesignatorAddition() {
        return AssignOpExprDesignatorAddition;
    }

    public void setAssignOpExprDesignatorAddition(AssignOpExprDesignatorAddition AssignOpExprDesignatorAddition) {
        this.AssignOpExprDesignatorAddition=AssignOpExprDesignatorAddition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignOpExprDesignatorAddition!=null) AssignOpExprDesignatorAddition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignOpExprDesignatorAddition!=null) AssignOpExprDesignatorAddition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignOpExprDesignatorAddition!=null) AssignOpExprDesignatorAddition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PossibleErrorDesignatorAddition(\n");

        if(AssignOpExprDesignatorAddition!=null)
            buffer.append(AssignOpExprDesignatorAddition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PossibleErrorDesignatorAddition]");
        return buffer.toString();
    }
}
