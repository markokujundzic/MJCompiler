package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor
{
    Logger log = Logger.getLogger(getClass());

    boolean errorDetected = false;

    /* Report error */
    public void report_error(String message, SyntaxNode info)
    {
        errorDetected = true;

        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.error(msg.toString());
    }

    /* Report info */
    public void report_info(String message, SyntaxNode info)
    {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.info(msg.toString());
    }

    /* ProgramName */
    public void visit(ProgramName programName)
    {
        programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
        Tab.openScope();
    }

    /* Program */
    public void visit(Program program)
    {
        Tab.chainLocalSymbols(program.getProgramName().obj);
        Tab.closeScope();
    }

    /* Type */
    public void visit(Type type)
    {
        Obj typeNode = Tab.find(type.getName());

        if (typeNode == Tab.noObj)
        {
            report_error("Type " + type.getName() + " not found in Symbol Table!", null);
            type.struct = Tab.noType;
        }
        else if (typeNode.getKind() == Obj.Type)
        {
            type.struct = typeNode.getType();
        }
        else
        {
            report_error("Error: Identifier " + type.getName() + " does not represent a type!", null);
            type.struct = Tab.noType;
        }
    }
}
