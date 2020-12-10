// generated with ast extension for cup
// version 0.8
// 10/11/2020 21:15:52


package rs.ac.bg.etf.pp1.ast;

public class ProgramName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String program_name;

    public ProgramName (String program_name) {
        this.program_name=program_name;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name=program_name;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramName(\n");

        buffer.append(" "+tab+program_name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramName]");
        return buffer.toString();
    }
}
