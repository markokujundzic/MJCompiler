package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{
	private Symbol new_symbol(int type)
	{
		return new Symbol(type, yyline + 1, yycolumn);
	}

	private Symbol new_symbol(int type, Object value)
	{
		return new Symbol(type, yyline + 1, yycolumn, value);
	}
%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" "    { }
"\b"   { }
"\t"   { }
"\r\n" { }
"\f"   { }

"continue" { return new_symbol(sym.CONTINUE, yytext()); }
"program"  { return new_symbol(sym.PROGRAM, yytext()); }
"return"   { return new_symbol(sym.RETURN, yytext()); }
"break"    { return new_symbol(sym.BREAK, yytext()); }
"print"    { return new_symbol(sym.PRINT, yytext()); }
"while"    { return new_symbol(sym.WHILE, yytext()); }
"const"    { return new_symbol(sym.CONST, yytext()); }
"enum"     { return new_symbol(sym.ENUM, yytext()); }
"else"     { return new_symbol(sym.ELSE, yytext()); }
"read"     { return new_symbol(sym.READ, yytext()); }
"void"     { return new_symbol(sym.VOID, yytext()); }
"new"      { return new_symbol(sym.NEW, yytext()); }
"if"       { return new_symbol(sym.IF, yytext()); }
"do"       { return new_symbol(sym.DO, yytext()); }

"==" { return new_symbol(sym.EQUAL, yytext()); }
"!=" { return new_symbol(sym.NOT_EQUAL, yytext()); }
">=" { return new_symbol(sym.GREATER_OR_EQUAL, yytext()); }
"<=" { return new_symbol(sym.LESS_OR_EQUAL, yytext()); }
"&&" { return new_symbol(sym.AND, yytext()); }
"||" { return new_symbol(sym.OR, yytext()); }
"++" { return new_symbol(sym.INCREMENT, yytext()); }
"--" { return new_symbol(sym.DECREMENT, yytext()); }
"="  { return new_symbol(sym.ASSIGN, yytext()); }
">"  { return new_symbol(sym.GREATER, yytext()); }
"<"  { return new_symbol(sym.LESS, yytext()); }
"+"  { return new_symbol(sym.PLUS, yytext()); }
"-"  { return new_symbol(sym.MINUS, yytext()); }
"*"  { return new_symbol(sym.MUL, yytext()); }
"/"  { return new_symbol(sym.DIV, yytext()); }
"%"  { return new_symbol(sym.MOD, yytext()); }
";"  { return new_symbol(sym.SEMICOLON, yytext()); }
","  { return new_symbol(sym.COMMA, yytext()); }
"."	 { return new_symbol(sym.PERIOD, yytext()); }
"("	 { return new_symbol(sym.LEFT_PARENTHESIS, yytext()); }
")"	 { return new_symbol(sym.RIGHT_PARENTHESIS, yytext()); }
"["	 { return new_symbol(sym.LEFT_SQUARE, yytext()); }
"]"	 { return new_symbol(sym.RIGHT_SQUARE, yytext()); }
"{"	 { return new_symbol(sym.LEFT_BRACE, yytext()); }
"}"	 { return new_symbol(sym.RIGHT_BRACE, yytext()); }
"?"	 { return new_symbol(sym.QUESTION_MARK, yytext()); }
":"	 { return new_symbol(sym.COLON, yytext()); }

"//"             { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

"\'"[x20-x7E]"\'"             { return new_symbol(sym.CHAR, new Character (yytext().charAt(1))); }
("true"|"false")	          { return new_symbol(sym.BOOL, new Boolean(yytext())); }
[0-9]+                        { return new_symbol(sym.INT, new Integer(yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* { return new_symbol(sym.IDENTIFIER, yytext()); }

. { System.err.println("Lexical error: (" + yytext() + ") on line " + (yyline + 1)); }
