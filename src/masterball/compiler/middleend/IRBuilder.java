package masterball.compiler.middleend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.info.InfoManager;
import masterball.compiler.frontend.info.StringBuiltinMethods;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.CurrentCarrier;
import masterball.compiler.middleend.llvmir.IRTranslator;
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

import java.util.ArrayList;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    public final Module module = new Module();

    // from frontend, scope stack
    private final InfoManager infoManager = new InfoManager();
    // IR current info carrier
    private final CurrentCarrier cur = new CurrentCarrier();
    // IR Translator
    private final IRTranslator translator = new IRTranslator();

    public IRBuilder(RootNode astRoot) {
        this.visit(astRoot);
    }

    // private tool methods

    // global init func
    private void createInitFunc() {
        FuncRegistry initRegistry = new FuncRegistry(LLVMTable.InitFuncName, MxBaseType.BuiltinType.VOID);
        initRegistry.isBuiltin = false; // declare a FuncRegistry directly will be seen as builtin. close it.

        cur.func = new Function(LLVMTable.InitFuncName,
                  translator.translateFuncType(initRegistry.type, null));

        cur.block = cur.func.entryBlock();

        infoManager.register(initRegistry);

        new RetInst(cur.func.exitBlock()); // return void
        module.functions.add(cur.func);
        infoManager.queryFuncInStack(cur.func.name).value = cur.func;
    }

    private void funcDecl(FuncDefNode node) {
        Function declFunc = new Function(node.funcRegistry.name,
                translator.translateFuncType(node.funcRegistry.type, null));

        module.functions.add(declFunc);
        node.funcRegistry.value = declFunc;
    }

    private void builtinFuncDecl(RootNode node) {
        // malloc & string op
        module.setBottomFunctions();

        // global functions
        for (FuncRegistry builtinFuncRegistry : node.scope.builtinFuncList) {
            Function builtinFunc = new Function(builtinFuncRegistry.name,
                    translator.translateFuncType(builtinFuncRegistry.type, null));

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }

        // string methods
        for (FuncRegistry builtinFuncRegistry : StringBuiltinMethods.scope.builtinFuncList) {
            Function builtinFunc = new Function(LLVMTable.StrMethodPrefix + builtinFuncRegistry.name,
                    translator.translateFuncType(builtinFuncRegistry.type, IRTranslator.stringType));

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }
    }

    private void classDecl(RootNode node) {
        ArrayList<ClassRegistry> classRegistries = new ArrayList<>();

        for (BaseNode sonNode : node.sonNodes) {
            if (sonNode instanceof ClassDefNode) {
                StructType declClass = new StructType(((ClassDefNode) sonNode).classRegistry.name);
                ((ClassDefNode) sonNode).classRegistry.value = declClass.structProto;
                module.classes.add(declClass.structProto);
                classRegistries.add(((ClassDefNode) sonNode).classRegistry);
            }
        }
        for (ClassRegistry classRegistry : classRegistries) {
            StructType declClass = (StructType) classRegistry.value.type;

            for (VarRegistry memberVar : classRegistry.memberVars)
                declClass.memberVarTypes.add(translator.translateAllocaType(memberVar.type));

            for (FuncRegistry memberFunc : classRegistry.memberFuncs) {
                Function declMemberFunc = new Function(declClass.structName + LLVMTable.Spliter + memberFunc.name,
                        translator.translateFuncType(memberFunc.type, new PointerType(declClass)));
                module.methods.add(declMemberFunc);
                memberFunc.value = declMemberFunc;
            }
        }
    }

    private BaseValue memLoad(BaseValue pointer, BasicBlock parentBlock) {
        assert pointer.type instanceof PointerType;
        BaseValue ret = new LoadInst(pointer, parentBlock);
        if (((PointerType) pointer.type).pointedType instanceof MemBoolType)
            ret = new TruncInst(ret, IRTranslator.boolType, parentBlock);
        ret.resolveFrom = pointer;
        return ret;
    }

    private void memStore(BaseValue destPtr, BaseValue assignData) {
        if (assignData.type instanceof BoolType) {
            assignData = new ZextInst(assignData, IRTranslator.memBoolType, cur.block);
        }
        assert destPtr.type instanceof PointerType;
        assert ((PointerType) destPtr.type).pointedType.match(assignData.type);
        new StoreInst(destPtr, assignData, cur.block);
    }

    private BaseValue arrayMalloc(ArrayList<BaseValue> eachDimLengths, int curDim, IRBaseType elementType) {
        // int[][][] a = new int [3][4][5];
        // curDim: from 0 to 2
        // elementType: now dim element. e.g. curDim = 0, elementType = i32**

        // step 1. malloc this dim.
        // size calculation using (curDimLength+1) * elementTypeSize (metadata)
        BaseValue curDimSize = new BinaryInst(LLVMTable.MulInst,
                               eachDimLengths.get(curDim),
                               new IntConst(elementType.size()), cur.block);
        BaseValue mallocSize = new BinaryInst(LLVMTable.AddInst, curDimSize, new IntConst(IRTranslator.i32Type.size()), cur.block);
        BaseValue mallocPtr = new CallInst(module.getMalloc(), cur.block, mallocSize);

        // step 2. store length at the head of the array
        BaseValue lengthDestPtr = new BitCastInst(mallocPtr, IRTranslator.i32PointerType, cur.block);
        memStore(lengthDestPtr, eachDimLengths.get(curDim));

        // step 3. get array head pointer, malloc the internal space
        BaseValue arrHeadPointer = new BitCastInst(
                new GetElementPtrInst(lengthDestPtr, IRTranslator.i32PointerType, cur.block, new IntConst(1)),
                new PointerType(elementType), cur.block);
        if (curDim < eachDimLengths.size() - 1) {
            // int* curDimPtr = 0; while (curDimPtr != tailDimPtr) {curDimPtr++;}
            BasicBlock condBlock = new BasicBlock(LLVMTable.WhCondBlockLabel, cur.func),
                    bodyBlock = new BasicBlock(LLVMTable.WhBodyBlockLabel, cur.func),
                    exitBlock = new BasicBlock(LLVMTable.WhExitBlockLabel, cur.func);

            PhiInst curDimPtr = new PhiInst(arrHeadPointer.type, null, arrHeadPointer, cur.block);
            BaseValue tailDimPtr = new GetElementPtrInst(arrHeadPointer, arrHeadPointer.type, cur.block, eachDimLengths.get(curDim));
            BaseInst incrPtr = new GetElementPtrInst(curDimPtr, curDimPtr.type, null, new IntConst(1));
            curDimPtr.addBranch(incrPtr, bodyBlock);

            new BrInst(condBlock, cur.block);
            cur.block = condBlock;
            curDimPtr.setParentBlock(condBlock);
            BaseValue condValue = new ICmpInst(LLVMTable.NotEqualArg, curDimPtr, tailDimPtr, cur.block);
            new BrInst(condValue, bodyBlock, exitBlock, cur.block);

            cur.block = bodyBlock;
            memStore(curDimPtr, arrayMalloc(eachDimLengths, curDim+1, ((PointerType) elementType).pointedType));
            incrPtr.setParentBlock(bodyBlock);
            new BrInst(condBlock, cur.block);

            cur.block = exitBlock;
        }
        return arrHeadPointer;
    }

    private BaseValue classMalloc(StructType classType) {
        BaseValue mallocPtr = new CallInst(module.getMalloc(), cur.block, new IntConst(classType.size()));
        return new BitCastInst(mallocPtr, new PointerType(classType), cur.block);
    }

    // visit methods
    @Override
    public void visit(RootNode node) {
        infoManager.push(node.scope);
        translator.setGlobalScope(node.scope);

        builtinFuncDecl(node);
        createInitFunc();

        // forward reference support
        classDecl(node);

        for (BaseNode sonnode: node.sonNodes)
            if (sonnode instanceof FuncDefNode) funcDecl((FuncDefNode) sonnode);

        // scan global variable
        for (BaseNode sonnode : node.sonNodes)
            if (sonnode instanceof VarDefStmtNode) sonnode.accept(this);

        cur.terminateAllBlocks();

        for (BaseNode sonnode : node.sonNodes)
            if (!(sonnode instanceof VarDefStmtNode)) sonnode.accept(this);

        infoManager.pop();
    }

    @Override
    public void visit(ClassDefNode node) {
        infoManager.push(node.classRegistry.scope);

        cur.classRegistry = node.classRegistry;

        assert node.constructorDefNode != null;
        node.constructorDefNode.accept(this);

        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));

        cur.classRegistry = null;

        infoManager.pop();
    }

    @Override
    public void visit(FuncDefNode node) {
        infoManager.push(node.funcRegistry.scope);

        cur.func = (Function) node.funcRegistry.value;
        cur.block = cur.func.entryBlock();

        if (!node.funcRegistry.type.retType.match(MxBaseType.BuiltinType.VOID)) {
            cur.retValPtr = new AllocaInst(LLVMTable.RetReg, translator.translateAllocaType(node.funcRegistry.type.retType), cur.block);
            new RetInst(memLoad(cur.retValPtr, cur.func.exitBlock()), cur.func.exitBlock());
        } else {
            new RetInst(cur.func.exitBlock());
        }

        // main func
        if (Objects.equals(node.funcRegistry.name, MxStarTable.mainKw)) {
            // call init
            new CallInst((Function) infoManager.queryFuncInStack(LLVMTable.InitFuncName).value,
                    cur.block, new ArrayList<>());
            new StoreInst(cur.retValPtr, new IntConst(0), cur.block);
        }

        for (int i = 0; i < cur.func.getArgNum(); i++) {
            VarRegistry argRegistry;
            if (cur.classRegistry != null) {
                if (i == 0) {
                    // "this"
                    cur.func.addArg(new BaseValue(LLVMTable.ThisArg, new PointerType(cur.classRegistry.value.type)));
                    continue;
                }
                argRegistry = node.funcRegistry.funcArgs.get(i-1);
            }
            else argRegistry = node.funcRegistry.funcArgs.get(i);

            BaseValue arg = new BaseValue(argRegistry.name,
                    translator.translateVarType(argRegistry.type));

            BaseValue allocaPtr = new AllocaInst(argRegistry.name, translator.translateAllocaType(argRegistry.type), cur.block);
            argRegistry.value = allocaPtr;
            cur.func.addArg(arg);
            memStore(allocaPtr, arg);
        }

        node.suiteNode.accept(this);

        cur.terminateAllBlocks();

        infoManager.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        BaseValue allocaPtr;

        // global variable
        if (Objects.equals(cur.func.name, LLVMTable.InitFuncName)) {
           allocaPtr = new GlobalVariable(node.varRegistry.name,
                       translator.translateVarType(node.varRegistry.type));
           module.globalVarSeg.add((GlobalVariable) allocaPtr);
        } else {
            allocaPtr = new AllocaInst(node.varRegistry.name, translator.translateAllocaType(node.varRegistry.type), cur.block);
        }
        node.value = allocaPtr;
        node.varRegistry.value = allocaPtr;

        if (node.initExpNode != null) {
            node.initExpNode.accept(this);
            memStore(allocaPtr, node.initExpNode.value);
        }
        else if (node.varRegistry.type.match(MxBaseType.BuiltinType.CLASS) || node.varRegistry.type.isArray()) {
            // array type & class should be initialized with null
            // string no need
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
        BasicBlock trueBlock = new BasicBlock(LLVMTable.IfTrueBlockLabel, cur.func),
                   falseBlock = new BasicBlock(LLVMTable.IfFalseBlockLabel, cur.func),
                   exitBlock = new BasicBlock(LLVMTable.IfExitBlockLabel, cur.func);

        node.conditionExpNode.accept(this);
        new BrInst(node.conditionExpNode.value, trueBlock, falseBlock, cur.block);
        cur.block = falseBlock;
        if (node.elseStmtNode != null) {
            infoManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            infoManager.pop();
        }
        new BrInst(exitBlock, cur.block);

        cur.block = trueBlock;
        infoManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        new BrInst(exitBlock, cur.block);
        infoManager.pop();

        cur.block = exitBlock;
    }

    @Override
    public void visit(WhileStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.WhCondBlockLabel, cur.func),
                   bodyBlock = new BasicBlock(LLVMTable.WhBodyBlockLabel, cur.func),
                   exitBlock = new BasicBlock(LLVMTable.WhExitBlockLabel, cur.func);

        new BrInst(condBlock, cur.block);
        infoManager.push(node.scope);

        cur.block = condBlock;
        node.conditionExpNode.accept(this);
        new BrInst(node.conditionExpNode.value, bodyBlock, exitBlock, cur.block);

        cur.block = bodyBlock;

        cur.loopSetKeywordTarget(condBlock, exitBlock);

        node.bodyStmtNode.accept(this);
        new BrInst(condBlock, cur.block);

        cur.loopPopKeywordTarget();
        cur.block = exitBlock;
        infoManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        BasicBlock condBlock = new BasicBlock(LLVMTable.ForCondBlockLabel, cur.func),
                   incrBlock = new BasicBlock(LLVMTable.ForIncrBlockLabel, cur.func),
                   bodyBlock = new BasicBlock(LLVMTable.ForBodyBlockLabel, cur.func),
                   exitBlock = new BasicBlock(LLVMTable.ForExitBlockLabel, cur.func);

        infoManager.push(node.scope);

        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        new BrInst(condBlock, cur.block);

        if (node.conditionExpNode != null) {
            cur.block = condBlock;
            node.conditionExpNode.accept(this);
            new BrInst(node.conditionExpNode.value, bodyBlock, exitBlock, cur.block);
        }

        cur.block = incrBlock;
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        new BrInst(condBlock, cur.block);

        cur.block = bodyBlock;

        cur.loopSetKeywordTarget(incrBlock, exitBlock);
        node.bodyStmtNode.accept(this);
        new BrInst(incrBlock, cur.block);
        cur.loopPopKeywordTarget();

        cur.block = exitBlock;

        infoManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.retExpNode != null && !node.retExpNode.type.match(MxBaseType.BuiltinType.VOID)) {
            node.retExpNode.accept(this);
            new StoreInst(cur.retValPtr, node.retExpNode.value, cur.block);
        }
        new BrInst(cur.func.exitBlock(), cur.block);
    }

    @Override
    public void visit(ControlStmtNode node) {
        cur.setControlBr(node.controlWord);
    }

    @Override
    public void visit(PureStmtNode node) {
        if (node.expNode != null) node.expNode.accept(this);
    }

    @Override
    public void visit(AssignExpNode node) {
        node.lhsExpNode.accept(this);
        node.rhsExpNode.accept(this);
        memStore(node.lhsExpNode.value.resolveFrom, node.rhsExpNode.value);
    }

    @Override
    public void visit(BinaryExpNode node) {
        node.lhsExpNode.accept(this);
        if (Objects.equals(node.opType, MxStarTable.logicOpType)) {
            BasicBlock tempNowBlock = cur.block,
                    nocutBlock = new BasicBlock(LLVMTable.LogicNoCutBlockLabel, cur.func),
                    exitBlock = new BasicBlock(LLVMTable.LogicExitBlockLabel, cur.func);
            if (node.op.equals(MxStarTable.LogicOrOp)) {
                // ret = a || b -> if (!a) b; ret = phi a b
                new BrInst(node.lhsExpNode.value, exitBlock, nocutBlock, cur.block);
                cur.block = nocutBlock;
                node.rhsExpNode.accept(this);
                new BrInst(exitBlock, cur.block);
                cur.block = exitBlock;
                node.value = new PhiInst(IRTranslator.boolType, cur.block, node.lhsExpNode.value, tempNowBlock, node.rhsExpNode.value, nocutBlock);
            } else if (node.op.equals(MxStarTable.LogicAndOp)) {
                // ret = a && b -> if (a) b; ret = phi a b
                new BrInst(node.lhsExpNode.value, nocutBlock, exitBlock, cur.block);
                cur.block = nocutBlock;
                node.rhsExpNode.accept(this);
                new BrInst(exitBlock, cur.block);
                cur.block = exitBlock;
                node.value = new PhiInst(IRTranslator.boolType, cur.block, node.lhsExpNode.value, tempNowBlock, node.rhsExpNode.value, nocutBlock);
            } else throw new UnknownError(node.codePos, node);
        } else {
            node.rhsExpNode.accept(this);
            if (node.lhsExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
                node.value = new CallInst(
                        module.getStrMethod(IRTranslator.translateStrOp(node.op)),
                        cur.block, node.lhsExpNode.value, node.rhsExpNode.value
                );
            } else if (Objects.equals(node.opType, MxStarTable.equalOpType)
                    || Objects.equals(node.opType, MxStarTable.compareOpType)) {
                node.value = new ICmpInst(
                        IRTranslator.translateOp(node.op),
                        node.lhsExpNode.value,
                        node.rhsExpNode.value,
                        cur.block
                );
            } else if (Objects.equals(node.opType, MxStarTable.arithOpType)) {
                node.value = new BinaryInst(
                        IRTranslator.translateOp(node.op),
                        node.lhsExpNode.value,
                        node.rhsExpNode.value,
                        cur.block
                );
            } else {
                throw new UnknownError(node.codePos, node);
            }
        }
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);

        if (!(node.callExpNode.value instanceof Function)){
            // .size() function pass
            node.value = node.callExpNode.value;
            return;
        }

        ArrayList<BaseValue> argsValue = new ArrayList<>();

        if (node.callExpNode instanceof MemberExpNode)
            argsValue.add(((MemberExpNode) node.callExpNode).superExpNode.value); // this

        for (int i = 0; i < node.callArgExpNodes.size(); i++) {
            node.callArgExpNodes.get(i).accept(this);
            argsValue.add(node.callArgExpNodes.get(i).value);
        }
        node.value = new CallInst((Function) node.callExpNode.value, cur.block, argsValue);
    }

    @Override
    public void visit(IndexExpNode node) {
        node.arrayExpNode.accept(this);
        node.indexExpNode.accept(this);
        node.value = memLoad(new GetElementPtrInst(node.arrayExpNode.value.name + LLVMTable.ArrayElementSuffix,
                node.arrayExpNode.value, node.arrayExpNode.value.type, cur.block, node.indexExpNode.value), cur.block);
    }

    @Override
    public void visit(MemberExpNode node) {
        node.superExpNode.accept(this);

        if (node.superExpNode.type.isArray()) {
            // array
            BaseValue castPtr = new BitCastInst(node.superExpNode.value, IRTranslator.i32PointerType, cur.block);
            // one step back
            node.value = memLoad(new GetElementPtrInst(castPtr, IRTranslator.i32PointerType, cur.block, new IntConst(-1)), cur.block);
        } else if (node.superExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
            // string
            node.value = StringBuiltinMethods.scope.queryFunc(node.memberName).value;
        } else {
            // class
            String className = ((VarType) node.superExpNode.type).className;
            ClassRegistry classRegistry = infoManager.queryClass(className);

            if (node.type instanceof VarType) {
                VarRegistry varRegistry = classRegistry.scope.queryVar(node.memberName);
                BaseValue varAddr = new GetElementPtrInst(node.memberName, node.superExpNode.value,
                        new PointerType(translator.translateAllocaType(varRegistry.type)),
                        cur.block, new IntConst(0), new IntConst(classRegistry.getMemberVarIndex(varRegistry.name)));
                node.value = memLoad(varAddr, cur.block);
            } else if (node.type instanceof MxFuncType) {
                node.value = classRegistry.scope.queryFunc(node.memberName).value;
            }
        }
    }

    @Override
    public void visit(NewExpNode node) {
        assert node.type instanceof VarType;
        if (((VarType) node.type).dimension == 0) {
            if (node.type.match(MxBaseType.BuiltinType.CLASS)) {
                ClassRegistry classRegistry = infoManager.queryClass(((VarType) node.type).className);
                node.value = classMalloc((StructType) classRegistry.value.type);
                new CallInst((Function) classRegistry.scope.queryFunc(classRegistry.name).value, cur.block, node.value);
            }
            else throw new UnimplementedError(node.codePos, node);
        }
        else { // must be an array
            ArrayList<BaseValue> eachDimLengths = new ArrayList<>();
            for (int i = 0; i < node.eachDimLengthExpNodes.size(); i++) {
                node.eachDimLengthExpNodes.get(i).accept(this);
                eachDimLengths.add(node.eachDimLengthExpNodes.get(i).value);
            }
            if (eachDimLengths.size() > 0)
                node.value = arrayMalloc(eachDimLengths, 0, ((PointerType) translator.translateAllocaType(node.type)).pointedType);
            else node.value = new NullptrConst();
        }
    }

    @Override
    public void visit(PostfixExpNode node) {
        node.selfExpNode.accept(this);
        BaseValue calculated = null, storePtr = node.selfExpNode.value.resolveFrom;
        switch (node.op) {
            case MxStarTable.IncrementOp:
                calculated = new BinaryInst(LLVMTable.AddInst, node.selfExpNode.value, new IntConst(1), cur.block);
                break;
            case MxStarTable.DecrementOp:
                calculated = new BinaryInst(LLVMTable.SubInst, node.selfExpNode.value, new IntConst(1), cur.block);
                break;
        }
        memStore(storePtr, calculated);
        node.value = node.selfExpNode.value;
    }

    @Override
    public void visit(PrefixExpNode node) {
        node.selfExpNode.accept(this);
        BaseValue calculated = null, storePtr = node.selfExpNode.value.resolveFrom;
        switch (node.op) {
            case MxStarTable.IncrementOp:
                calculated = new BinaryInst(LLVMTable.AddInst, node.selfExpNode.value, new IntConst(1), cur.block);break;
            case MxStarTable.DecrementOp:
                calculated = new BinaryInst(LLVMTable.SubInst, node.selfExpNode.value, new IntConst(1), cur.block);break;
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
                node.value = node.selfExpNode.value;break;
            case MxStarTable.SubOp:
                node.value = new BinaryInst(LLVMTable.SubInst, new IntConst(0), node.selfExpNode.value, cur.block);break;
            case MxStarTable.LogicNotOp:
                node.value = new BinaryInst(LLVMTable.XorInst, node.selfExpNode.value, new BoolConst(true), cur.block);break;
            case MxStarTable.BitNotOp:
                node.value = new BinaryInst(LLVMTable.XorInst, node.selfExpNode.value, new IntConst(-1), cur.block);break;
            default: throw new UnknownError(node.codePos, node);
        }
    }

    @Override
    public void visit(LambdaExpNode node) {
        throw new UnimplementedError(node.codePos, node);
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null) node.value = new IntConst(Integer.parseInt(node.ctx.IntegerConstant().toString()));
        else if (node.ctx.TrueConstant() != null) node.value = new BoolConst(true);
        else if (node.ctx.FalseConstant() != null) node.value = new BoolConst(false);
        else if (node.ctx.StringConstant() != null) {
            node.value = new GetElementPtrInst(module.getStringConst(node.getStringLiteral()),
                        IRTranslator.stringType, cur.block, new IntConst(0), new IntConst(0));
        }
        else if (node.ctx.NullConstant() != null) {
            node.value = new NullptrConst();
        }
        else if (node.ctx.ThisPointer() != null) {
            node.value = cur.getThis();
        }
        else if (node.ctx.Identifier() != null) {
            if (node.type instanceof VarType) {
                BaseValue varAddr;
                VarRegistry varRegistry = infoManager.queryVarInStack(node.ctx.Identifier().getText());
                int memberIndex = -1;
                if (cur.classRegistry != null) memberIndex = cur.classRegistry.getMemberVarIndex(varRegistry.name);
                if (memberIndex >= 0) {
                    // member in class scope
                    varAddr = new GetElementPtrInst(varRegistry.name, cur.getThis(),
                            new PointerType(translator.translateAllocaType(varRegistry.type)),
                            cur.block, new IntConst(0), new IntConst(memberIndex));
                }
                else {
                    varAddr = varRegistry.value;
                }
                // variable resolve
                node.value = memLoad(varAddr, cur.block);
            }
            else if (node.type instanceof MxFuncType) {
                node.value = infoManager.queryFuncInStack(node.ctx.Identifier().getText()).value;
            }
        }
    }
}
