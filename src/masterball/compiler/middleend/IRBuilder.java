package masterball.compiler.middleend;

import masterball.compiler.frontend.TypeMatcher;
import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.info.StackManager;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.FuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.constant.BoolConst;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;
import masterball.compiler.utils.error.RuntimeError;
import masterball.debug.Log;

import java.util.ArrayList;
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
    private void funcDef(Function func) {
        module.functions.add(func);
        stackManager.queryFuncInStack(func.name).value = func;
    }

    private BaseValue resolvePointer(BaseValue pointer, BasicBlock block) {
        assert pointer.type instanceof PointerType;
        return new LoadInst(pointer, block);
    }

    private BaseValue getLeftValuePtr(ExpBaseNode node) {
        assert node.isLeftValue();
        if (node instanceof PrefixExpNode) return getLeftValuePtr(((PrefixExpNode) node).selfExpNode);
        assert node instanceof AtomExpNode;
        return stackManager.queryVarInStack(((AtomExpNode) node).ctx.Identifier().getText()).value;
    }

    // visit methods
    @Override
    public void visit(RootNode node) {
        stackManager.push(node.scope);

        // global init func
        curFunc = new Function(LLVMTable.InitFuncName, new VoidType());
        curBlock = curFunc.entryBlock();
        stackManager.register(
                new FuncRegistry(LLVMTable.InitFuncName, BaseType.BuiltinType.VOID)
        );

        new RetInst(curFunc);
        funcDef(curFunc);

        // scan global variable
        for (BaseNode sonnode : node.sonNodes)
            if (sonnode instanceof VarDefStmtNode) {
                sonnode.accept(this);
            }

        for (BasicBlock block : curFunc.blocks) {
            if (!block.isTerminated) {
                new BrInst(curFunc.exitBlock(), block);
            }
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

        // main func
        if (Objects.equals(node.funcRegistry.name, MxStarTable.mainKw)) {
            // call init
            new CallInst((Function) stackManager.queryFuncInStack(LLVMTable.InitFuncName).value,
                        new ArrayList<>(), curBlock);
            // main without return
            new RetInst(new IntConst(0), curFunc);
        }

        for (VarRegistry argRegistry : node.funcRegistry.funcArgs) {
            BaseValue arg = new BaseValue(argRegistry.name,
                    IRTranslator.translateType(argRegistry.type));
            curFunc.addOperand(arg);
            BaseValue allocaPtr = new AllocaInst(argRegistry.name,
                    IRTranslator.translateType(argRegistry.type),
                    curBlock);
            argRegistry.value = allocaPtr;
            new StoreInst(allocaPtr, arg, curBlock);
        }

        funcDef(curFunc);
        Function curFuncBackup = curFunc;
        node.suiteNode.accept(this);

        for (BasicBlock block : curFuncBackup.blocks) {
            if (!block.isTerminated) new BrInst(curFuncBackup.exitBlock(), block);
        }

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
        node.varRegistry.value = allocaPtr;

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
        BasicBlock trueBlock = new BasicBlock(LLVMTable.IfTrueBlockLabel, curFunc),
                   falseBlock = new BasicBlock(LLVMTable.IfFalseBlockLabel, curFunc),
                   exitBlock = new BasicBlock(LLVMTable.IfExitBlockLabel, curFunc);

        node.conditionExpNode.accept(this);
        if (node.elseStmtNode != null) {
            new BrInst(node.conditionExpNode.value, trueBlock, falseBlock, curBlock);
            curBlock = falseBlock;
            stackManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            new BrInst(exitBlock, curBlock);
            stackManager.pop();
        }

        curBlock = trueBlock;
        stackManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        new BrInst(exitBlock, curBlock);
        stackManager.pop();

        curBlock = exitBlock;
    }

    @Override
    public void visit(WhileStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.WhCondBlockLabel, curFunc),
                   bodyBlock = new BasicBlock(LLVMTable.WhBodyBlockLabel, curFunc),
                   exitBlock = new BasicBlock(LLVMTable.WhExitBlockLabel, curFunc);

        new BrInst(condBlock, curBlock);
        stackManager.push(node.scope);

        curBlock = condBlock;
        node.conditionExpNode.accept(this);
        new BrInst(node.conditionExpNode.value, bodyBlock, exitBlock, curBlock);

        curBlock = bodyBlock;
        node.bodyStmtNode.accept(this);
        new BrInst(condBlock, curBlock);

        curBlock = exitBlock;
        stackManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.ForCondBlockLabel, curFunc),
                   incrBlock = new BasicBlock(LLVMTable.ForIncrBlockLabel, curFunc),
                   bodyBlock = new BasicBlock(LLVMTable.ForBodyBlockLabel, curFunc),
                   exitBlock = new BasicBlock(LLVMTable.ForExitBlockLabel, curFunc);

        stackManager.push(node.scope);

        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        new BrInst(condBlock, curBlock);

        if (node.conditionExpNode != null) {
            curBlock = condBlock;
            node.conditionExpNode.accept(this);
            new BrInst(node.conditionExpNode.value, bodyBlock, exitBlock, curBlock);
        }

        curBlock = incrBlock;
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        new BrInst(condBlock, curBlock);

        curBlock = bodyBlock;
        node.bodyStmtNode.accept(this);
        new BrInst(incrBlock, curBlock);

        curBlock = exitBlock;

        stackManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.retExpNode.type.match(BaseType.BuiltinType.VOID)) {
            new RetInst(curFunc);
            return;
        }
        node.retExpNode.accept(this);
        new RetInst(node.retExpNode.value, curFunc);
    }

    @Override
    public void visit(ControlStmtNode node) {
        //TODO
    }

    @Override
    public void visit(PureStmtNode node) {
        node.expNode.accept(this);
    }

    @Override
    public void visit(AssignExpNode node) {
        BaseValue lhsPtr = getLeftValuePtr(node.lhsExpNode);
        node.rhsExpNode.accept(this);
        new StoreInst(lhsPtr, node.rhsExpNode.value, curBlock);
    }

    @Override
    public void visit(BinaryExpNode node) {
        //TODO: string and && methods
        node.lhsExpNode.accept(this);
        node.rhsExpNode.accept(this);
        if (node.lhsExpNode.type.match(BaseType.BuiltinType.STRING)) {
            Log.track("string op");
        }
        else if (Objects.equals(node.opType, MxStarTable.logicOpType)) {
            Log.track("logic");
        }
        else if (Objects.equals(node.opType, MxStarTable.equalOpType)) {

        }
        else if (Objects.equals(node.opType, MxStarTable.compareOpType)) {
            node.value = new ICmpInst(
                    IRTranslator.translateOp(node.op),
                    node.lhsExpNode.value,
                    node.rhsExpNode.value,
                    curBlock
            );
        }
        else if (Objects.equals(node.opType, MxStarTable.arithOpType)) {
            node.value = new BinaryInst(
                    IRTranslator.translateOp(node.op),
                    node.lhsExpNode.value,
                    node.rhsExpNode.value,
                    curBlock
            );
        }
        else {
            throw new RuntimeError(node.codePos, "unexpected opType");
        }
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);
        ArrayList<BaseValue> argsValue = new ArrayList<>();
        for (int i = 0; i < node.callArgExpNodes.size(); i++) {
            node.callArgExpNodes.get(i).accept(this);
            argsValue.add(node.callArgExpNodes.get(i).value);
        }
        node.value = new CallInst(
                (Function) node.callExpNode.value,
                argsValue,
                curBlock
        );
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
        node.selfExpNode.accept(this);
        BaseValue calculated = null, storePtr = getLeftValuePtr(node.selfExpNode);
        switch (node.op) {
            case MxStarTable.IncrementOp:
                calculated = new BinaryInst(LLVMTable.AddInst, node.selfExpNode.value, new IntConst(1), curBlock);
                break;
            case MxStarTable.DecrementOp:
                calculated = new BinaryInst(LLVMTable.SubInst, node.selfExpNode.value, new IntConst(1), curBlock);
                break;
        }
        new StoreInst(storePtr, calculated, curBlock);
        node.value = node.selfExpNode.value;
    }

    @Override
    public void visit(PrefixExpNode node) {
        node.selfExpNode.accept(this);
        BaseValue calculated = null, storePtr =  getLeftValuePtr(node.selfExpNode);
        switch (node.op) {
            case MxStarTable.IncrementOp:
                calculated = new BinaryInst(LLVMTable.AddInst, node.selfExpNode.value, new IntConst(1), curBlock);
                break;
            case MxStarTable.DecrementOp:
                calculated = new BinaryInst(LLVMTable.SubInst, node.selfExpNode.value, new IntConst(1), curBlock);
                break;
        }
        new StoreInst(storePtr, calculated, curBlock);
        node.value = calculated;
    }

    @Override
    public void visit(UnaryExpNode node) {
        //TODO
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
            else if (node.type instanceof FuncType) {
                node.value = stackManager.queryFuncInStack(node.ctx.Identifier().getText()).value;
            }
        }
    }
}
