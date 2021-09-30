// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2

    package masterball.compiler.frontend.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#mxStarCode}.
	 * @param ctx the parse tree
	 */
	void enterMxStarCode(MxStarParser.MxStarCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#mxStarCode}.
	 * @param ctx the parse tree
	 */
	void exitMxStarCode(MxStarParser.MxStarCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classConstructorDef}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructorDef(MxStarParser.ClassConstructorDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classConstructorDef}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructorDef(MxStarParser.ClassConstructorDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcDefArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefArgs(MxStarParser.FuncDefArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcDefArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefArgs(MxStarParser.FuncDefArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallArgs(MxStarParser.FuncCallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallArgs(MxStarParser.FuncCallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(MxStarParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(MxStarParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefType}.
	 * @param ctx the parse tree
	 */
	void enterVarDefType(MxStarParser.VarDefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefType}.
	 * @param ctx the parse tree
	 */
	void exitVarDefType(MxStarParser.VarDefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNewExpSizeDeclaration(MxStarParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNewExpSizeDeclaration(MxStarParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newExpType}.
	 * @param ctx the parse tree
	 */
	void enterNewExpType(MxStarParser.NewExpTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newExpType}.
	 * @param ctx the parse tree
	 */
	void exitNewExpType(MxStarParser.NewExpTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefBody}.
	 * @param ctx the parse tree
	 */
	void enterVarDefBody(MxStarParser.VarDefBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefBody}.
	 * @param ctx the parse tree
	 */
	void exitVarDefBody(MxStarParser.VarDefBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefSingle}.
	 * @param ctx the parse tree
	 */
	void enterVarDefSingle(MxStarParser.VarDefSingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefSingle}.
	 * @param ctx the parse tree
	 */
	void exitVarDefSingle(MxStarParser.VarDefSingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmt(MxStarParser.VarDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmt(MxStarParser.VarDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxStarParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxStarParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxStarParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxStarParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MxStarParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MxStarParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxStarParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxStarParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxStarParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxStarParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterControlStmt(MxStarParser.ControlStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitControlStmt(MxStarParser.ControlStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#pureStmt}.
	 * @param ctx the parse tree
	 */
	void enterPureStmt(MxStarParser.PureStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#pureStmt}.
	 * @param ctx the parse tree
	 */
	void exitPureStmt(MxStarParser.PureStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#suiteStmt}.
	 * @param ctx the parse tree
	 */
	void enterSuiteStmt(MxStarParser.SuiteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#suiteStmt}.
	 * @param ctx the parse tree
	 */
	void exitSuiteStmt(MxStarParser.SuiteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxStarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxStarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOps(MxStarParser.PrefixOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOps(MxStarParser.PrefixOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#postfixOps}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOps(MxStarParser.PostfixOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#postfixOps}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOps(MxStarParser.PostfixOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#unaryOps}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOps(MxStarParser.UnaryOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#unaryOps}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOps(MxStarParser.UnaryOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#shiftOps}.
	 * @param ctx the parse tree
	 */
	void enterShiftOps(MxStarParser.ShiftOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#shiftOps}.
	 * @param ctx the parse tree
	 */
	void exitShiftOps(MxStarParser.ShiftOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#mulLevelOps}.
	 * @param ctx the parse tree
	 */
	void enterMulLevelOps(MxStarParser.MulLevelOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#mulLevelOps}.
	 * @param ctx the parse tree
	 */
	void exitMulLevelOps(MxStarParser.MulLevelOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#addLevelOps}.
	 * @param ctx the parse tree
	 */
	void enterAddLevelOps(MxStarParser.AddLevelOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#addLevelOps}.
	 * @param ctx the parse tree
	 */
	void exitAddLevelOps(MxStarParser.AddLevelOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void enterCompareOps(MxStarParser.CompareOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void exitCompareOps(MxStarParser.CompareOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#equalOps}.
	 * @param ctx the parse tree
	 */
	void enterEqualOps(MxStarParser.EqualOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#equalOps}.
	 * @param ctx the parse tree
	 */
	void exitEqualOps(MxStarParser.EqualOpsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(MxStarParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(MxStarParser.AtomExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExp(MxStarParser.PrefixExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExp(MxStarParser.PrefixExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExp(MxStarParser.MemberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExp(MxStarParser.MemberExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExp(MxStarParser.BinaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExp(MxStarParser.BinaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExp(MxStarParser.AssignExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExp(MxStarParser.AssignExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(MxStarParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(MxStarParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExp(MxStarParser.LambdaExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExp(MxStarParser.LambdaExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExp(MxStarParser.ParenExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExp(MxStarParser.ParenExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExp(MxStarParser.PostfixExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExp(MxStarParser.PostfixExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExp(MxStarParser.IndexExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExp(MxStarParser.IndexExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MxStarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MxStarParser.AtomContext ctx);
}