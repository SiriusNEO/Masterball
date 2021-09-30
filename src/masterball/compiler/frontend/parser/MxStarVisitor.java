// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2

    package masterball.compiler.frontend.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#mxStarCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMxStarCode(MxStarParser.MxStarCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classConstructorDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructorDef(MxStarParser.ClassConstructorDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcDefArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefArgs(MxStarParser.FuncDefArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcCallArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallArgs(MxStarParser.FuncCallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(MxStarParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefType(MxStarParser.VarDefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpSizeDeclaration(MxStarParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#newExpType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpType(MxStarParser.NewExpTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefBody(MxStarParser.VarDefBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefSingle(MxStarParser.VarDefSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStmt(MxStarParser.VarDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxStarParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxStarParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MxStarParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MxStarParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxStarParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStmt(MxStarParser.ControlStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#pureStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureStmt(MxStarParser.PureStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#suiteStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuiteStmt(MxStarParser.SuiteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxStarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#prefixOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOps(MxStarParser.PrefixOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#postfixOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOps(MxStarParser.PostfixOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#unaryOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOps(MxStarParser.UnaryOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#shiftOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOps(MxStarParser.ShiftOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#mulLevelOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulLevelOps(MxStarParser.MulLevelOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#addLevelOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddLevelOps(MxStarParser.AddLevelOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#compareOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOps(MxStarParser.CompareOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#equalOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualOps(MxStarParser.EqualOpsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(MxStarParser.AtomExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExp(MxStarParser.PrefixExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExp(MxStarParser.BinaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExp(MxStarParser.AssignExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExp(MxStarParser.MemberExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(MxStarParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExp(MxStarParser.LambdaExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExp(MxStarParser.ParenExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExp(MxStarParser.PostfixExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExp}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExp(MxStarParser.IndexExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MxStarParser.AtomContext ctx);
}