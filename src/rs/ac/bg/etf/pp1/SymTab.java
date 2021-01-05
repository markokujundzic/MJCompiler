package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class SymTab extends Tab
{
    public static final Struct boolType = new Struct(Struct.Bool);

    public static void init()
    {
        Tab.init();
        currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
    }

    public static void dump(SymbolTableVisitor stv) {
        System.out.println("=================================SYMBOL TABLE=====================================");
        if (stv == null)
            stv = new MyDumpSymbolTableVisitor();
        for (Scope s = currentScope; s != null; s = s.getOuter()) {
            s.accept(stv);
        }
        System.out.println(stv.getOutput());
    }

    public static void dump() {
        dump(null);
    }
}
