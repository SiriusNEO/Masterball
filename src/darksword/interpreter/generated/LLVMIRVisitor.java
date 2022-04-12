// Generated from ../src/darksword/interpreter/generated/LLVMIR.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LLVMIRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LLVMIRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#llvmIR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlvmIR(LLVMIRParser.LlvmIRContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#targetInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetInfo(LLVMIRParser.TargetInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#sourceFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceFn(LLVMIRParser.SourceFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#dataLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataLayout(LLVMIRParser.DataLayoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#targetTriple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetTriple(LLVMIRParser.TargetTripleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#funcHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncHeader(LLVMIRParser.FuncHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(LLVMIRParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(LLVMIRParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#basicBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlock(LLVMIRParser.BasicBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#instDest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDest(LLVMIRParser.InstDestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#phiBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhiBranch(LLVMIRParser.PhiBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alloca}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlloca(LLVMIRParser.AllocaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(LLVMIRParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitcast}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitcast(LLVMIRParser.BitcastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trunc}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrunc(LLVMIRParser.TruncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zext}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZext(LLVMIRParser.ZextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code br}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBr(LLVMIRParser.BrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LLVMIRParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getelementptr}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetelementptr(LLVMIRParser.GetelementptrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code icmp}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmp(LLVMIRParser.IcmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code load}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(LLVMIRParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code store}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStore(LLVMIRParser.StoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(LLVMIRParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code phi}
	 * labeled alternative in {@link LLVMIRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhi(LLVMIRParser.PhiContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LLVMIRParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#align}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlign(LLVMIRParser.AlignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LLVMIRParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(LLVMIRParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(LLVMIRParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#integerConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConstant(LLVMIRParser.IntegerConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMIRParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(LLVMIRParser.StringConstantContext ctx);
}