package masterball.compiler.middleend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.info.InfoManager;
import masterball.compiler.frontend.info.StringBuiltinMethods;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;
import masterball.compiler.utils.error.runtime.UnimplementedError;
import masterball.compiler.utils.error.runtime.UnknownError;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class IRBuilder implements ASTVisitor {
    public final Module module = new Module();

    // from frontend, scope stack
    private final InfoManager infoManager = new InfoManager();

    // current pointer
    private BasicBlock curBlock = null;
    private Function curFunc = null;
    // break/continue support
    private final Stack<BasicBlock> continueTargetBlocks = new Stack<>(),
                                    breakTargetBlocks = new Stack<>();

    public IRBuilder(RootNode astRoot) {
        this.visit(astRoot);
    }

    // private tool methods

    // global init func
    private void createInitFunc() {
        FuncRegistry initRegistry = new FuncRegistry(LLVMTable.InitFuncName, MxBaseType.BuiltinType.VOID);
        initRegistry.isBuiltin = false; // declare a FuncRegistry directly will be seen as builtin. close it.

        curFunc = new Function(LLVMTable.InitFuncName,
                  IRTranslator.translateFuncType(initRegistry.type, null));

        curBlock = curFunc.entryBlock();

        infoManager.register(initRegistry);

        new RetInst(curFunc); // return void
        module.functions.add(curFunc);
        infoManager.queryFuncInStack(curFunc.name).value = curFunc;
    }

    // func decl
    // Mx.FuncType -> IR.FuncType
    private void funcDecl(FuncDefNode node) {
        Function declFunc = new Function(node.funcRegistry.name,
                IRTranslator.translateFuncType(node.funcRegistry.type, null));

        module.functions.add(declFunc);
        node.funcRegistry.value = declFunc;
    }

    private void builtinFuncDecl(RootNode node) {
        // malloc & string op
        module.setBottomFunctions();

        // global functions
        for (FuncRegistry builtinFuncRegistry : node.scope.builtinFuncList) {
            Function builtinFunc = new Function(builtinFuncRegistry.name,
                    IRTranslator.translateFuncType(builtinFuncRegistry.type, null));

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }

        // string methods
        for (FuncRegistry builtinFuncRegistry : StringBuiltinMethods.scope.builtinFuncList) {
            Function builtinFunc = new Function(LLVMTable.StrFuncPrefix + builtinFuncRegistry.name,
                    IRTranslator.translateFuncType(builtinFuncRegistry.type, IRTranslator.stringType));

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }
    }

    private BaseValue memAlloca(VarRegistry varRegistry) {
        IRBaseType allocaType = IRTranslator.translateVarType(varRegistry.type);

        if (allocaType instanceof BoolType) allocaType = IRTranslator.memBoolType;

        return new AllocaInst(varRegistry.name,
                allocaType,
                curBlock);
    }

    private BaseValue memLoad(BaseValue pointer) {
        assert pointer.type instanceof PointerType;
        BaseValue ret = new LoadInst(pointer, curBlock);
        if (((PointerType) pointer.type).pointedType instanceof MemBoolType) {
            ret = new TruncInst(ret, IRTranslator.boolType, curBlock);
        }
        return ret;
    }

    private void memStore(BaseValue destPtr, BaseValue assignData) {
        if (assignData.type instanceof BoolType) {
            assignData = new ZextInst(assignData, IRTranslator.memBoolType, curBlock);
        }
        assert destPtr.type instanceof PointerType;
        // null no need to match
        Log.mark();
        Log.report(((PointerType) destPtr.type).pointedType);
        Log.report(assignData.type);
        assert ((PointerType) destPtr.type).pointedType.match(assignData.type);
        new StoreInst(destPtr, assignData, curBlock);
    }

    private BaseValue getLeftValuePtr(ExpBaseNode node) {
        assert node.isLeftValue();
        if (node instanceof PrefixExpNode) return getLeftValuePtr(((PrefixExpNode) node).selfExpNode);
        assert node instanceof AtomExpNode;
        return infoManager.queryVarInStack(((AtomExpNode) node).ctx.Identifier().getText()).value;
    }

    private BaseValue arrayMalloc(ArrayList<BaseValue> eachDimLengths, int curDim, IRBaseType elementType) {
        // int[][][] a = new int [3][4][5];
        // curDim: from 0 to 2
        // elementType: now dim element. e.g. curDim = 0, elementType = i32**

        // step 1. malloc this dim.
        // size calculation using (curDimLength+1) * elementTypeSize (metadata)
        BaseValue curDimSize = new BinaryInst(LLVMTable.MulInst,
                               eachDimLengths.get(curDim),
                               new IntConst(elementType.size()), curBlock);
        BaseValue mallocSize = new BinaryInst(LLVMTable.AddInst, curDimSize, new IntConst(1), curBlock);
        BaseValue mallocPtr = new CallInst(module.getMalloc(), curBlock, mallocSize);

        // step 2. store length at the head of the array
        BaseValue lengthDestPtr = new BitCastInst(mallocPtr, new PointerType(IRTranslator.i32Type), curBlock);
        memStore(lengthDestPtr, eachDimLengths.get(curDim));

        // step 3. get array head pointer, malloc the internal space
        BaseValue arrHeadPointer = new BitCastInst(
                // step 4 byte because length-metadata
                new GetElementPtrInst(lengthDestPtr, new PointerType(IRTranslator.i32Type), curBlock, new IntConst(1)),
                new PointerType(elementType), curBlock);
        if (curDim < eachDimLengths.size() - 1) {
            // int* curDimPtr = 0; while (curDimPtr != tailDimPtr) {curDimPtr++;}
            BaseValue curDimPtr = new AllocaInst(LLVMTable.TempAnon, arrHeadPointer.type, curBlock);
            memStore(curDimPtr, arrHeadPointer);
            BaseValue tailDimPtr = new GetElementPtrInst(arrHeadPointer, new PointerType(elementType), curBlock, eachDimLengths.get(curDim));

            BasicBlock condBlock = new BasicBlock(LLVMTable.WhCondBlockLabel, curFunc),
                    bodyBlock = new BasicBlock(LLVMTable.WhBodyBlockLabel, curFunc),
                    exitBlock = new BasicBlock(LLVMTable.WhExitBlockLabel, curFunc);

            new BrInst(condBlock, curBlock);
            curBlock = condBlock;
            BaseValue condValue = new BinaryInst(LLVMTable.NotEqualArg, curDimPtr, tailDimPtr, curBlock);
            new BrInst(condValue, bodyBlock, exitBlock, curBlock);

            curBlock = bodyBlock;
            memStore(curDimPtr, arrayMalloc(eachDimLengths, curDim+1, ((PointerType) elementType).pointedType));
            new BrInst(condBlock, curBlock);

            curBlock = exitBlock;
        }
        return arrHeadPointer;
    }

    // visit methods
    @Override
    public void visit(RootNode node) {
        infoManager.push(node.scope);

        builtinFuncDecl(node);
        createInitFunc();

        // forward reference support
        for (BaseNode sonnode: node.sonNodes) {
            if (sonnode instanceof FuncDefNode) {
                funcDecl((FuncDefNode) sonnode);
            }
        }

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

        infoManager.pop();
    }

    @Override
    public void visit(ClassDefNode node) {

    }

    @Override
    public void visit(FuncDefNode node) {
        infoManager.push(node.funcRegistry.scope);

        curFunc = (Function) node.funcRegistry.value;
        curBlock = curFunc.entryBlock();

        // main func
        if (Objects.equals(node.funcRegistry.name, MxStarTable.mainKw)) {
            // call init
            new CallInst((Function) infoManager.queryFuncInStack(LLVMTable.InitFuncName).value,
                    curBlock, new ArrayList<>());
            // main without return
            new RetInst(new IntConst(0), curFunc);
        }

        for (int i = 0; i < curFunc.getArgNum(); i++) {
            VarRegistry argRegistry = node.funcRegistry.funcArgs.get(i);

            BaseValue arg = new BaseValue(argRegistry.name,
                    IRTranslator.translateVarType(argRegistry.type));

            BaseValue allocaPtr = memAlloca(argRegistry);
            argRegistry.value = allocaPtr;
            curFunc.addArg(arg);
            memStore(allocaPtr, arg);
        }

        node.suiteNode.accept(this);

        for (BasicBlock block : curFunc.blocks) {
            if (!block.isTerminated) new BrInst(curFunc.exitBlock(), block);
        }

        infoManager.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        BaseValue allocaPtr;

        // global variable
        if (Objects.equals(curFunc.name, LLVMTable.InitFuncName)) {
           allocaPtr = new GlobalVariable(node.varRegistry.name,
                       IRTranslator.translateVarType(node.varRegistry.type));
           module.globalVarSeg.add((GlobalVariable) allocaPtr);
        } else {
            allocaPtr = memAlloca(node.varRegistry);
        }
        node.value = allocaPtr;
        node.varRegistry.value = allocaPtr;

        if (node.initExpNode != null) {
            node.initExpNode.accept(this);
            memStore(allocaPtr, node.initExpNode.value);
        }
        else if (node.varRegistry.type.dimension > 0) {
            // array type should be initialized with null
            // string & class: no need
            memStore(allocaPtr, new NullptrConst());
        }
    }

    @Override
    public void visit(SuiteNode node) {
        infoManager.push(node.scope);
        node.stmtNodes.forEach(sonnode -> {sonnode.accept(this);});
        infoManager.pop();
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
        new BrInst(node.conditionExpNode.value, trueBlock, falseBlock, curBlock);
        curBlock = falseBlock;
        if (node.elseStmtNode != null) {
            infoManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            infoManager.pop();
        }
        new BrInst(exitBlock, curBlock);

        curBlock = trueBlock;
        infoManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        new BrInst(exitBlock, curBlock);
        infoManager.pop();

        curBlock = exitBlock;
    }

    @Override
    public void visit(WhileStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.WhCondBlockLabel, curFunc),
                   bodyBlock = new BasicBlock(LLVMTable.WhBodyBlockLabel, curFunc),
                   exitBlock = new BasicBlock(LLVMTable.WhExitBlockLabel, curFunc);

        new BrInst(condBlock, curBlock);
        infoManager.push(node.scope);

        curBlock = condBlock;
        node.conditionExpNode.accept(this);
        new BrInst(node.conditionExpNode.value, bodyBlock, exitBlock, curBlock);

        curBlock = bodyBlock;

        continueTargetBlocks.push(condBlock);
        breakTargetBlocks.push(exitBlock);

        node.bodyStmtNode.accept(this);
        new BrInst(condBlock, curBlock);

        continueTargetBlocks.pop();
        breakTargetBlocks.pop();
        curBlock = exitBlock;
        infoManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.ForCondBlockLabel, curFunc),
                   incrBlock = new BasicBlock(LLVMTable.ForIncrBlockLabel, curFunc),
                   bodyBlock = new BasicBlock(LLVMTable.ForBodyBlockLabel, curFunc),
                   exitBlock = new BasicBlock(LLVMTable.ForExitBlockLabel, curFunc);

        infoManager.push(node.scope);

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

        continueTargetBlocks.push(incrBlock);
        breakTargetBlocks.push(exitBlock);

        node.bodyStmtNode.accept(this);
        new BrInst(incrBlock, curBlock);

        continueTargetBlocks.pop();
        breakTargetBlocks.pop();

        curBlock = exitBlock;

        infoManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.retExpNode.type.match(MxBaseType.BuiltinType.VOID)) {
            new RetInst(curFunc);
            return;
        }
        node.retExpNode.accept(this);
        new RetInst(node.retExpNode.value, curFunc);
    }

    @Override
    public void visit(ControlStmtNode node) {
        assert !(continueTargetBlocks.empty() && breakTargetBlocks.empty());
        switch (node.controlWord) {
            case MxStarTable.continueKw:
                new BrInst(continueTargetBlocks.peek(), curBlock);
                break;
            case MxStarTable.breakKw:
                new BrInst(breakTargetBlocks.peek(), curBlock);
                break;
            default: throw new UnknownError(node.codePos, node);
        }
    }

    @Override
    public void visit(PureStmtNode node) {
        if (node.expNode != null) node.expNode.accept(this);
    }

    @Override
    public void visit(AssignExpNode node) {
        BaseValue lhsPtr = getLeftValuePtr(node.lhsExpNode);
        node.rhsExpNode.accept(this);
        memStore(lhsPtr, node.rhsExpNode.value);
    }

    @Override
    public void visit(BinaryExpNode node) {
        //TODO: string and && methods
        node.lhsExpNode.accept(this);
        node.rhsExpNode.accept(this);
        if (node.lhsExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
            node.value = new CallInst(
                module.getStrMethod(IRTranslator.translateStrOp(node.op)),
                curBlock, node.lhsExpNode.value, node.rhsExpNode.value
            );
        }
        else if (Objects.equals(node.opType, MxStarTable.logicOpType)) {
            Log.track("logic");
        }
        else if (Objects.equals(node.opType, MxStarTable.equalOpType)
                 || Objects.equals(node.opType, MxStarTable.compareOpType)) {
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
            throw new UnknownError(node.codePos, node);
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
                curBlock,
                argsValue
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
        assert node.type instanceof VarType;
        if (((VarType) node.type).dimension == 0) {
            if (node.type.match(MxBaseType.BuiltinType.CLASS)) {
                throw new UnimplementedError(node.codePos, node);
            }
            else {
                throw new UnimplementedError(node.codePos, node);
            }
        }
        else {
            // must be an array
            ArrayList<BaseValue> eachDimLengths = new ArrayList<>();
            for (int i = 0; i < node.eachDimLengthExpNodes.size(); i++) {
                node.eachDimLengthExpNodes.get(i).accept(this);
                eachDimLengths.add(node.eachDimLengthExpNodes.get(i).value);
            }
            node.value = arrayMalloc(eachDimLengths, 0,
                    ((PointerType) IRTranslator.translateVarType(node.type)).pointedType);
        }
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
        memStore(storePtr, calculated);
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
            default: throw new UnknownError(node.codePos, node);
        }
        memStore(storePtr, calculated);
        node.value = calculated;
    }

    @Override
    public void visit(UnaryExpNode node) {
        node.selfExpNode.accept(this);
        switch (node.op) {
            case MxStarTable.AddOp:
                node.value = node.selfExpNode.value;
                break;
            case MxStarTable.SubOp:
                node.value = new BinaryInst(LLVMTable.SubInst, new IntConst(0), node.selfExpNode.value, curBlock);
                break;
            case MxStarTable.LogicNotOp:
                node.value = new BinaryInst(LLVMTable.XorInst, node.selfExpNode.value, new BoolConst(true), curBlock);
                break;
            case MxStarTable.BitNotOp:
                node.value = new BinaryInst(LLVMTable.XorInst, node.selfExpNode.value, new IntConst(-1), curBlock);
                break;
            default: throw new UnknownError(node.codePos, node);
        }
    }

    @Override
    public void visit(LambdaExpNode node) {
        throw new UnimplementedError(node.codePos, node);
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null) {
            node.value = new IntConst(Integer.parseInt(node.ctx.IntegerConstant().toString()));
        }
        else if (node.ctx.TrueConstant() != null) {
            node.value = new BoolConst(true);
        }
        else if (node.ctx.FalseConstant() != null) {
            node.value = new BoolConst(false);
        }
        else if (node.ctx.StringConstant() != null) {
            String literalString = node.ctx.StringConstant().toString();
            StringConst stringConst = module.getStringConst(literalString.substring(1, literalString.length()-1));
            node.value = new GetElementPtrInst(stringConst,
                        IRTranslator.stringType, curBlock, new IntConst(0), new IntConst(0));
        }
        else if (node.ctx.NullConstant() != null) {
            node.value = new NullptrConst();
        }
        else if (node.ctx.ThisPointer() != null) {
            throw new UnimplementedError(node.codePos, node);
        }
        else if (node.ctx.Identifier() != null) {
            if (node.type instanceof VarType) {
                // variable resolve
                node.value = memLoad(infoManager.queryVarInStack(node.ctx.Identifier().getText()).value);
            }
            else if (node.type instanceof MxFuncType) {
                node.value = infoManager.queryFuncInStack(node.ctx.Identifier().getText()).value;
            }
        }
    }
}
