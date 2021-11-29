package masterball.compiler.middleend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.info.StackManager;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.constant.BoolConst;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.AllocaInst;
import masterball.compiler.middleend.llvmir.inst.LoadInst;
import masterball.compiler.middleend.llvmir.inst.RetInst;
import masterball.compiler.middleend.llvmir.inst.StoreInst;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;
import masterball.compiler.utils.error.RuntimeError;
import masterball.debug.Log;

import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    public final Module module = new Module();

    private final StackManager stackManager = new StackManager();

    private BasicBlock curBlock = null;
    private Function curFunc = null;

    public IRBuilder(RootNode astRoot) {
        this.visit(astRoot);
    }

    // private tool methods
    private BaseValue resolvePointer(BaseValue pointer, BasicBlock block) {
        assert pointer.type instanceof PointerType;
        return new LoadInst(pointer, block);
    }

    // visit methods
    @Override
    public void visit(RootNode node) {
        stackManager.push(node.scope);

        // global init
        curFunc = new Function(LLVMTable.InitFuncName, new VoidType());
        curBlock = curFunc.entryBlock();
        new RetInst(curFunc.exitBlock());
        module.registerFunc(curFunc);

        // scan global variable
        for (BaseNode sonnode : node.sonNodes)
            if (sonnode instanceof VarDefStmtNode) {
                sonnode.accept(this);
            }

        for (BaseNode sonnode : node.sonNodes) {
            if (!(sonnode instanceof VarDefStmtNode)) {
                sonnode.accept(this);
            }
        }

        stackManager.pop();
    }

    @Override
    public void visit(ClassDefNode node) {

    }

    @Override
    public void visit(FuncDefNode node) {
        stackManager.push(node.funcRegistry.scope);

        curFunc = new Function(node.funcRegistry.name,
                IRTranslator.translateType(node.funcRegistry.type.retType));
        curBlock = curFunc.entryBlock();

        if (Objects.equals(node.funcRegistry.name, MxStarTable.mainKw)) {
            new RetInst(new IntConst(0) ,curFunc.exitBlock());
        }

        for (VarRegistry argRegistry : node.funcRegistry.funcArgs) {
            BaseValue arg = new BaseValue(argRegistry.name,
                    IRTranslator.translateType(argRegistry.type));
            curFunc.addOperand(arg);
        }

        module.registerFunc(curFunc);

        node.suiteNode.accept(this);

        stackManager.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        BaseValue allocaPtr;

        // global variable
        if (Objects.equals(curFunc.name, LLVMTable.InitFuncName)) {
           allocaPtr = new GlobalVariable(node.varRegistry.name,
                       IRTranslator.translateType(node.varRegistry.type));
           module.globalVars.add((GlobalVariable) allocaPtr);
        } else {
            allocaPtr = new AllocaInst(
                        node.varRegistry.name,
                        IRTranslator.translateType(node.varRegistry.type),
                        curBlock);
        }
        node.value = allocaPtr;
        stackManager.queryVarInStack(node.varRegistry.name).value = allocaPtr;

        if (node.initExpNode != null) {
            node.initExpNode.accept(this);
            new StoreInst(allocaPtr, node.initExpNode.value, curBlock);
        }
    }

    @Override
    public void visit(SuiteNode node) {
        stackManager.push(node.scope);
        node.stmtNodes.forEach(sonnode -> {sonnode.accept(this);});
        stackManager.pop();
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
    }

    @Override
    public void visit(SuiteStmtNode node) {
        node.suiteNode.accept(this);
    }

    @Override
    public void visit(IfStmtNode node) {

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.retExpNode.type.match(BaseType.BuiltinType.VOID)) {
            new RetInst(curBlock);
            return;
        }
        Log.track("return?");
        node.retExpNode.accept(this);
        new RetInst(node.retExpNode.value, curBlock);
    }

    @Override
    public void visit(ControlStmtNode node) {

    }

    @Override
    public void visit(PureStmtNode node) {
        node.expNode.accept(this);
    }

    @Override
    public void visit(AssignExpNode node) {
        node.lhsExpNode.accept(this);
        node.rhsExpNode.accept(this);
        new StoreInst(node.lhsExpNode.value, node.rhsExpNode.value, curBlock);
    }

    @Override
    public void visit(BinaryExpNode node) {

    }

    @Override
    public void visit(FuncCallExpNode node) {

    }

    @Override
    public void visit(IndexExpNode node) {

    }

    @Override
    public void visit(MemberExpNode node) {

    }

    @Override
    public void visit(NewExpNode node) {

    }

    @Override
    public void visit(PostfixExpNode node) {

    }

    @Override
    public void visit(PrefixExpNode node) {

    }

    @Override
    public void visit(UnaryExpNode node) {

    }

    @Override
    public void visit(LambdaExpNode node) {
        throw new RuntimeError(node.codePos, "LambdaExp not implemented");
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null)
            node.value = new IntConst(Integer.parseInt(node.ctx.IntegerConstant().toString()));
        else if (node.ctx.TrueConstant() != null)
            node.value = new BoolConst(true);
        else if (node.ctx.FalseConstant() != null)
            node.value = new BoolConst(false);
        else if (node.ctx.Identifier() != null) {
            if (node.type instanceof VarType) {
                node.value = resolvePointer(stackManager.queryVarInStack(node.ctx.Identifier().getText()).value,
                                            curBlock);
            }
        }
    }
}
