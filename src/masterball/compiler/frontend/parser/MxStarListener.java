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
	 * Enter a parse tree produced by {@link MxStarParser#funcRetType}.
	 * @param ctx the parse tree
	 */
	void enterFuncRetType(MxStarParser.FuncRetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcRetType}.
	 * @param ctx the parse tree
	 */
	void exitFuncRetType(MxStarParser.FuncRetTypeContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxStarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxStarParser.ArrayTypeContext ctx);
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
	 * Enter a parse tree produced by the {@code blockStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmtL(MxStarParser.BlockStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmtL(MxStarParser.BlockStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtL(MxStarParser.IfStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtL(MxStarParser.IfStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmtL(MxStarParser.WhileStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmtL(MxStarParser.WhileStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStmtL(MxStarParser.ForStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStmtL(MxStarParser.ForStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmtL(MxStarParser.ReturnStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmtL(MxStarParser.ReturnStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code controlStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterControlStmtL(MxStarParser.ControlStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code controlStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitControlStmtL(MxStarParser.ControlStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmtL(MxStarParser.VarDefStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmtL(MxStarParser.VarDefStmtLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pureStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPureStmtL(MxStarParser.PureStmtLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pureStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPureStmtL(MxStarParser.PureStmtLContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcCallExp}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcCallExp}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newExp}.
	 * @param ctx the parse tree
	 */
	void enterNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newExp}.
	 * @param ctx the parse tree
	 */
	void exitNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#prefixExp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExp(MxStarParser.PrefixExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#prefixExp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExp(MxStarParser.PrefixExpContext ctx);
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
	 * Enter a parse tree produced by the {@code memberExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpL(MxStarParser.MemberExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpL(MxStarParser.MemberExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOrExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpL(MxStarParser.LogicOrExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOrExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpL(MxStarParser.LogicOrExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpL(MxStarParser.AssignExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpL(MxStarParser.AssignExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpL(MxStarParser.ParenExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpL(MxStarParser.ParenExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOrExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpL(MxStarParser.BitOrExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOrExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpL(MxStarParser.BitOrExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpL(MxStarParser.UnaryExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpL(MxStarParser.UnaryExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpL(MxStarParser.LogicExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpL(MxStarParser.LogicExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpL(MxStarParser.FuncCallExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpL(MxStarParser.FuncCallExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitXorExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitXorExpL(MxStarParser.BitXorExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitXorExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitXorExpL(MxStarParser.BitXorExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpL(MxStarParser.CompareExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpL(MxStarParser.CompareExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleAtomL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleAtomL(MxStarParser.SingleAtomLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleAtomL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleAtomL(MxStarParser.SingleAtomLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicAndExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExpL(MxStarParser.LogicAndExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicAndExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExpL(MxStarParser.LogicAndExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpL(MxStarParser.EqualExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpL(MxStarParser.EqualExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpL(MxStarParser.PostfixExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpL(MxStarParser.PostfixExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpL(MxStarParser.IndexExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpL(MxStarParser.IndexExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpL(MxStarParser.PrefixExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpL(MxStarParser.PrefixExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulLevelExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulLevelExpL(MxStarParser.MulLevelExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulLevelExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulLevelExpL(MxStarParser.MulLevelExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpL(MxStarParser.NewExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpL(MxStarParser.NewExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAndExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpL(MxStarParser.BitAndExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAndExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpL(MxStarParser.BitAndExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addLevelExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddLevelExpL(MxStarParser.AddLevelExpLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addLevelExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddLevelExpL(MxStarParser.AddLevelExpLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierL(MxStarParser.IdentifierLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierL(MxStarParser.IdentifierLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntL(MxStarParser.IntLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntL(MxStarParser.IntLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringL(MxStarParser.StringLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringL(MxStarParser.StringLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFalseL(MxStarParser.FalseLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFalseL(MxStarParser.FalseLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterTrueL(MxStarParser.TrueLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitTrueL(MxStarParser.TrueLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNullL(MxStarParser.NullLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNullL(MxStarParser.NullLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterThisL(MxStarParser.ThisLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitThisL(MxStarParser.ThisLContext ctx);
}