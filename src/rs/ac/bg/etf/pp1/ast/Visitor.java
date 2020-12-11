// generated with ast extension for cup
// version 0.8
// 11/11/2020 23:31:44


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(Mulop Mulop);
    public void visit(FiniteExpr FiniteExpr);
    public void visit(MethodVariables MethodVariables);
    public void visit(FormParList FormParList);
    public void visit(Relop Relop);
    public void visit(OptionalStatement OptionalStatement);
    public void visit(DesignatorAddition DesignatorAddition);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(VarDeclArrayOption VarDeclArrayOption);
    public void visit(OptionalExpressions OptionalExpressions);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(DesignatorActPars DesignatorActPars);
    public void visit(Condition Condition);
    public void visit(OptionalFactors OptionalFactors);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(OptionalDesignator OptionalDesignator);
    public void visit(ConstDeclVariable ConstDeclVariable);
    public void visit(MethodBody MethodBody);
    public void visit(ConstDeclValue ConstDeclValue);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(PrintNumber PrintNumber);
    public void visit(OptionalTermList OptionalTermList);
    public void visit(OptionalDesignatorList OptionalDesignatorList);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(Statement Statement);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(VarDecl VarDecl);
    public void visit(FormParArrayOption FormParArrayOption);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(Declaration Declaration);
    public void visit(OptionalPrintNumber OptionalPrintNumber);
    public void visit(MethodParameters MethodParameters);
    public void visit(RelopLessOrEqual RelopLessOrEqual);
    public void visit(RelopLess RelopLess);
    public void visit(RelopGreaterOrEqual RelopGreaterOrEqual);
    public void visit(RelopGreater RelopGreater);
    public void visit(RelopNotEqual RelopNotEqual);
    public void visit(RelopEqual RelopEqual);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(Assignop Assignop);
    public void visit(ExprFactor ExprFactor);
    public void visit(NewArrayFactor NewArrayFactor);
    public void visit(NewFactor NewFactor);
    public void visit(BoolFactor BoolFactor);
    public void visit(CharFactor CharFactor);
    public void visit(IntFactor IntFactor);
    public void visit(FunctionCallFactor FunctionCallFactor);
    public void visit(DesignatorFactor DesignatorFactor);
    public void visit(OptionalFactor OptionalFactor);
    public void visit(NoOptionalFactors NoOptionalFactors);
    public void visit(YesOptionalFactors YesOptionalFactors);
    public void visit(Term Term);
    public void visit(NoOptionalTermList NoOptionalTermList);
    public void visit(YesOptionalTermList YesOptionalTermList);
    public void visit(MinusTermFiniteExpr MinusTermFiniteExpr);
    public void visit(TermFiniteExpr TermFiniteExpr);
    public void visit(NoTernaryExpr NoTernaryExpr);
    public void visit(YesTernaryExpr YesTernaryExpr);
    public void visit(PluralCondFact PluralCondFact);
    public void visit(SingleCondFact SingleCondFact);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(PluralCondTerm PluralCondTerm);
    public void visit(SingleCondition SingleCondition);
    public void visit(PluralCondition PluralCondition);
    public void visit(OptionalExpr OptionalExpr);
    public void visit(NoOptionalExpressions NoOptionalExpressions);
    public void visit(YesOptionalExpressions YesOptionalExpressions);
    public void visit(ActPars ActPars);
    public void visit(PrintInt PrintInt);
    public void visit(OptionalNoPrintNumber OptionalNoPrintNumber);
    public void visit(OptionalYesPrintNumber OptionalYesPrintNumber);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(NoReturnExpr NoReturnExpr);
    public void visit(YesReturnExpr YesReturnExpr);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(DoWhileStatement DoWhileStatement);
    public void visit(ElseStatement ElseStatement);
    public void visit(NoOptionalStatement NoOptionalStatement);
    public void visit(YesOptionalStatement YesOptionalStatement);
    public void visit(IfStatement IfStatement);
    public void visit(DesignatorNoActPars DesignatorNoActPars);
    public void visit(YesDesignatorActPars YesDesignatorActPars);
    public void visit(DecrementDesignatorAddition DecrementDesignatorAddition);
    public void visit(IncrementDesignatorAddition IncrementDesignatorAddition);
    public void visit(ActParsDesignatorAddition ActParsDesignatorAddition);
    public void visit(AssignOpExprDesignatorAddition AssignOpExprDesignatorAddition);
    public void visit(OptionalDesignatorName OptionalDesignatorName);
    public void visit(ExprOptionalDesignator ExprOptionalDesignator);
    public void visit(PeriodOptionalDesignator PeriodOptionalDesignator);
    public void visit(NoOptionalDesignatorList NoOptionalDesignatorList);
    public void visit(YesOptionalDesignatorList YesOptionalDesignatorList);
    public void visit(DesignatorName DesignatorName);
    public void visit(Designator Designator);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MultipleStatements MultipleStatements);
    public void visit(PrintStatementDecl PrintStatementDecl);
    public void visit(ReadStatementDecl ReadStatementDecl);
    public void visit(ReturnStatementDecl ReturnStatementDecl);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(DoWhileStatementDecl DoWhileStatementDecl);
    public void visit(IfStatementDecl IfStatementDecl);
    public void visit(DesignatorStatementDecl DesignatorStatementDecl);
    public void visit(Type Type);
    public void visit(NoFormParArrayOption NoFormParArrayOption);
    public void visit(YesFormParArrayOption YesFormParArrayOption);
    public void visit(FormParName FormParName);
    public void visit(FormPar FormPar);
    public void visit(SingleFormParList SingleFormParList);
    public void visit(PluralFormParList PluralFormParList);
    public void visit(FormPars FormPars);
    public void visit(NoMethodBody NoMethodBody);
    public void visit(YesMethodBody YesMethodBody);
    public void visit(NoMethodVariables NoMethodVariables);
    public void visit(YesMethodVariables YesMethodVariables);
    public void visit(NoMethodParameters NoMethodParameters);
    public void visit(YesMethodParameters YesMethodParameters);
    public void visit(MethodName MethodName);
    public void visit(VoidMethodReturnType VoidMethodReturnType);
    public void visit(TypeMethodReturnType TypeMethodReturnType);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoMethodDeclarationList NoMethodDeclarationList);
    public void visit(YesMethodDeclarationList YesMethodDeclarationList);
    public void visit(NoVarDeclArrayOption NoVarDeclArrayOption);
    public void visit(YesVarDeclArrayOption YesVarDeclArrayOption);
    public void visit(VarDeclName VarDeclName);
    public void visit(DeclVariable DeclVariable);
    public void visit(SingleVarDeclList SingleVarDeclList);
    public void visit(PluralVarDeclList PluralVarDeclList);
    public void visit(VarDeclYesError VarDeclYesError);
    public void visit(VarDeclNoError VarDeclNoError);
    public void visit(ConstDeclValueBool ConstDeclValueBool);
    public void visit(ConstDeclValueChar ConstDeclValueChar);
    public void visit(ConstDeclValueInt ConstDeclValueInt);
    public void visit(ConstDeclName ConstDeclName);
    public void visit(ConstDeclVariableNoError ConstDeclVariableNoError);
    public void visit(SingleConstDeclList SingleConstDeclList);
    public void visit(PluralConstDeclList PluralConstDeclList);
    public void visit(ConstDeclYesError ConstDeclYesError);
    public void visit(ConstDeclNoError ConstDeclNoError);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(ConstantDeclaration ConstantDeclaration);
    public void visit(NoDeclarationList NoDeclarationList);
    public void visit(YesDeclarationList YesDeclarationList);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
