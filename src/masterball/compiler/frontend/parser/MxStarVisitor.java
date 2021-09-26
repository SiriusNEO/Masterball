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
	 * Visit a parse tree produced by {@link MxStarParser#funcCallExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExp(MxStarParser.FuncCallExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcCallArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallArgs(MxStarParser.FuncCallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#lambdaExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExp(MxStarParser.LambdaExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(MxStarParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxStarParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefType(MxStarParser.VarDefTypeContext ctx);
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
	 * Visit a parse tree produced by the {@code blockStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmtL(MxStarParser.BlockStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmtL(MxStarParser.IfStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmtL(MxStarParser.WhileStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmtL(MxStarParser.ForStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmtL(MxStarParser.ReturnStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code controlStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStmtL(MxStarParser.ControlStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStmtL(MxStarParser.VarDefStmtLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pureStmtL}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureStmtL(MxStarParser.PureStmtLContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#newExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExp(MxStarParser.NewExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#prefixExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExp(MxStarParser.PrefixExpContext ctx);
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
	 * Visit a parse tree produced by the {@code memberExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpL(MxStarParser.MemberExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleAtomL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAtomL(MxStarParser.SingleAtomLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpL(MxStarParser.PostfixExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpL(MxStarParser.IndexExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpL(MxStarParser.PrefixExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpL(MxStarParser.AssignExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpL(MxStarParser.ParenExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpL(MxStarParser.UnaryExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpL(MxStarParser.NewExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpL(MxStarParser.FuncCallExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpL(MxStarParser.LambdaExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpL}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpL(MxStarParser.BinaryExpLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierL(MxStarParser.IdentifierLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntL(MxStarParser.IntLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringL(MxStarParser.StringLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseL(MxStarParser.FalseLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueL(MxStarParser.TrueLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullL(MxStarParser.NullLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisL}
	 * labeled alternative in {@link MxStarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisL(MxStarParser.ThisLContext ctx);
}