package masterball.compiler.middleend.llvmir;

import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.info.InfoManager;
import masterball.compiler.frontend.info.StringBuiltinMethods;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.share.error.runtime.InternalError;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.error.runtime.UnimplementedError;
import masterball.compiler.share.misc.Pair;
import masterball.compiler.share.pass.ASTVisitor;

import java.util.ArrayList;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    public final IRModule module = new IRModule();

    // from frontend, scope stack
    private final InfoManager infoManager = new InfoManager();
    // IR current info carrier
    private final IRCurrent cur = new IRCurrent();
    // IR Translator
    private final IRTranslator translator = new IRTranslator();

    public IRBuilder(RootNode astRoot) {
        this.visit(astRoot);
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

        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));

        assert node.constructorDefNode != null;
        node.constructorDefNode.accept(this);

        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));

        cur.classRegistry = null;

        infoManager.pop();
    }

    @Override
    public void visit(FuncDefNode node) {
        infoManager.push(node.funcRegistry.scope);

        cur.func = (IRFunction) node.funcRegistry.value;
        cur.block = cur.func.entryBlock;

        if (!node.funcRegistry.type.retType.match(MxBaseType.BuiltinType.VOID)) {
            cur.func.retValPtr = memAlloca(LLVM.RetReg, translator.translateAllocaType(node.funcRegistry.type.retType));
            new IRRetInst(memLoad(cur.func.retValPtr, cur.func.exitBlock), cur.func.exitBlock);
        } else {
            new IRRetInst(cur.func.exitBlock);
        }

        // main func
        if (Objects.equals(node.funcRegistry.name, MxStar.mainKw)) {
            // call init
            new IRCallInst((IRFunction) infoManager.queryFuncInStack(LLVM.InitFuncName).value, cur.block, new ArrayList<>());
            memStore(cur.func.retValPtr, new IntConst(0));
        }

        for (int i = 0; i < cur.func.getArgNum(); i++) {
            VarRegistry argRegistry;
            if (cur.classRegistry != null) {
                if (i == 0) {
                    // "this"
                    cur.func.addArg(new Value(LLVM.ThisArg, new PointerType(cur.classRegistry.value.type)));
                    continue;
                }
                argRegistry = node.funcRegistry.funcArgs.get(i-1);
            }
            else argRegistry = node.funcRegistry.funcArgs.get(i);

            Value arg = new Value(argRegistry.name, translator.translateVarType(argRegistry.type));

            Value allocaPtr = memAlloca(argRegistry.name, translator.translateAllocaType(argRegistry.type));
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
        Value allocaPtr;

        // global variable
        if (Objects.equals(cur.func.name, LLVM.InitFuncName)) {
           allocaPtr = new GlobalVariable(node.varRegistry.name,
                       translator.translateAllocaType(node.varRegistry.type));
           module.globalVarSeg.add((GlobalVariable) allocaPtr);
        } else {
            allocaPtr = memAlloca(node.varRegistry.name, translator.translateAllocaType(node.varRegistry.type));
        }
        node.value = allocaPtr;
        node.varRegistry.value = allocaPtr;

        if (node.initExpNode != null) {
            node.initExpNode.accept(this);
            memStore(allocaPtr, node.initExpNode.value);

            if (allocaPtr instanceof GlobalVariable && (node.initExpNode.value instanceof IntConst || node.initExpNode.value instanceof BoolConst))
                ((GlobalVariable) allocaPtr).initValue = node.initExpNode.value;
        }
        else if (node.varRegistry.type.match(MxBaseType.BuiltinType.CLASS) || node.varRegistry.type.isArray()) {
            // array type & class should be initialized with null
            // string no need
            memStore(allocaPtr, new NullptrConst());
        }
        else {
            if (allocaPtr instanceof GlobalVariable) {
                if (((GlobalVariable) allocaPtr).pointedType().match(IRTranslator.i32Type))
                    ((GlobalVariable) allocaPtr).initValue = new IntConst(0);
                else if (((GlobalVariable) allocaPtr).pointedType().match(IRTranslator.boolType))
                    ((GlobalVariable) allocaPtr).initValue = new BoolConst(false);
            }
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
        IRBlock trueBlock = new IRBlock(LLVM.IfTrueBlockLabel, cur.func),
                   falseBlock = new IRBlock(LLVM.IfFalseBlockLabel, cur.func),
                   exitBlock = new IRBlock(LLVM.IfExitBlockLabel, cur.func);

        node.conditionExpNode.accept(this);
        new IRBrInst(node.conditionExpNode.value, trueBlock, falseBlock, cur.block);
        cur.block = falseBlock;
        if (node.elseStmtNode != null) {
            infoManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            infoManager.pop();
        }
        new IRBrInst(exitBlock, cur.block);

        cur.block = trueBlock;
        infoManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        new IRBrInst(exitBlock, cur.block);
        infoManager.pop();

        cur.block = exitBlock;
    }

    @Override
    public void visit(WhileStmtNode node) {
        IRBlock condBlock = new IRBlock(LLVM.WhCondBlockLabel, cur.func),
                   bodyBlock = new IRBlock(LLVM.WhBodyBlockLabel, cur.func),
                   exitBlock = new IRBlock(LLVM.WhExitBlockLabel, cur.func);

        new IRBrInst(condBlock, cur.block);
        infoManager.push(node.scope);

        cur.block = condBlock;
        node.conditionExpNode.accept(this);
        new IRBrInst(node.conditionExpNode.value, bodyBlock, exitBlock, cur.block);

        cur.block = bodyBlock;

        cur.loopSetKeywordTarget(condBlock, exitBlock);

        node.bodyStmtNode.accept(this);
        new IRBrInst(condBlock, cur.block);

        cur.loopPopKeywordTarget();
        cur.block = exitBlock;
        infoManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        IRBlock condBlock = new IRBlock(LLVM.ForCondBlockLabel, cur.func),
                   incrBlock = new IRBlock(LLVM.ForIncrBlockLabel, cur.func),
                   bodyBlock = new IRBlock(LLVM.ForBodyBlockLabel, cur.func),
                   exitBlock = new IRBlock(LLVM.ForExitBlockLabel, cur.func);

        infoManager.push(node.scope);

        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        new IRBrInst(condBlock, cur.block);

        cur.block = condBlock;
        if (node.conditionExpNode != null) {
            node.conditionExpNode.accept(this);
            new IRBrInst(node.conditionExpNode.value, bodyBlock, exitBlock, cur.block);
        } else {
            new IRBrInst(bodyBlock, cur.block);
        }

        cur.block = incrBlock;
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        new IRBrInst(condBlock, cur.block);

        cur.block = bodyBlock;

        cur.loopSetKeywordTarget(incrBlock, exitBlock);
        node.bodyStmtNode.accept(this);
        new IRBrInst(incrBlock, cur.block);
        cur.loopPopKeywordTarget();

        cur.block = exitBlock;

        infoManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.retExpNode != null && !node.retExpNode.type.match(MxBaseType.BuiltinType.VOID)) {
            node.retExpNode.accept(this);

            if (node.retExpNode.value instanceof IRCallInst)
                ((IRCallInst) node.retExpNode.value).isTailCall = true;

            memStore(cur.func.retValPtr, node.retExpNode.value);
        }
        new IRBrInst(cur.func.exitBlock, cur.block);
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
        node.value = node.rhsExpNode.value;
        node.value.resolveFrom = node.lhsExpNode.value.resolveFrom;
    }

    /**
     *  Note: for continuous logic:
     *      a && b && c
     *  reuse the block!
     *
     *  no cut: means there is no logic-cut
     *  exit:   means logic-cut happen, directly jump to exit
     */
    @Override
    public void visit(BinaryExpNode node) {
        node.lhsExpNode.accept(this);
        if (Objects.equals(node.opType, MxStar.logicOpType)) {
            IRBlock tempNowBlock = cur.block;

            if (funcDetect(node)) {
                node.rhsExpNode.accept(this);
                node.value = new IRBinaryInst(IRTranslator.logic2Bit(node.op),
                                            IRTranslator.boolType,
                                            node.lhsExpNode.value,
                                            node.rhsExpNode.value, cur.block);
            }
            else {
                if (node.op.equals(MxStar.LogicOrOp)) {
                    // ret = a || b -> if (!a) b; ret = phi a b

                    IRBlock nocutBlock = new IRBlock(LLVM.LogicNoCutBlockLabel, cur.func),
                            exitBlock = new IRBlock(LLVM.LogicExitBlockLabel, cur.func);

                    new IRBrInst(node.lhsExpNode.value, exitBlock, nocutBlock, cur.block);
                    cur.block = nocutBlock;
                    node.rhsExpNode.accept(this);
                    new IRBrInst(exitBlock, cur.block);
                    node.value = new IRPhiInst(IRTranslator.boolType, exitBlock, node.lhsExpNode.value, tempNowBlock, node.rhsExpNode.value, cur.block);
                    cur.block = exitBlock;
                } else if (node.op.equals(MxStar.LogicAndOp)) {
                    // ret = a && b -> if (a) b; ret = phi a b

                    IRBlock nocutBlock = new IRBlock(LLVM.LogicNoCutBlockLabel, cur.func),
                            exitBlock = new IRBlock(LLVM.LogicExitBlockLabel, cur.func);

                    new IRBrInst(node.lhsExpNode.value, nocutBlock, exitBlock, cur.block);
                    cur.block = nocutBlock;
                    node.rhsExpNode.accept(this);
                    new IRBrInst(exitBlock, cur.block);
                    node.value = new IRPhiInst(IRTranslator.boolType, exitBlock, node.lhsExpNode.value, tempNowBlock, node.rhsExpNode.value, cur.block);
                    cur.block = exitBlock;
                } else throw new InternalError("unknown IR logic op");
            }
        } else {
            node.rhsExpNode.accept(this);
            if (node.lhsExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
                node.value = new IRCallInst(
                        module.getStrMethod(IRTranslator.translateStrOp(node.op)),
                        cur.block, node.lhsExpNode.value, node.rhsExpNode.value
                );
            } else if (Objects.equals(node.opType, MxStar.equalOpType)
                    || Objects.equals(node.opType, MxStar.compareOpType)) {
                node.value = new IRICmpInst(
                        IRTranslator.translateOp(node.op),
                        node.lhsExpNode.value,
                        node.rhsExpNode.value,
                        cur.block
                );
            } else if (Objects.equals(node.opType, MxStar.arithOpType)) {
                node.value = new IRBinaryInst(
                        IRTranslator.translateOp(node.op),
                        IRTranslator.i32Type,
                        node.lhsExpNode.value,
                        node.rhsExpNode.value,
                        cur.block
                );
            } else {
                throw new InternalError("unknown IR arith op");
            }
        }
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);

        if (!(node.callExpNode.value instanceof IRFunction)){
            // .size() function pass
            node.value = node.callExpNode.value;
            return;
        }

        ArrayList<Value> argsValue = new ArrayList<>();

        // this
        if (((IRFuncType) node.callExpNode.value.type).methodFrom != null) {
            if (node.callExpNode instanceof MemberExpNode) {
                argsValue.add(((MemberExpNode) node.callExpNode).superExpNode.value);
            }
            else {
                assert cur.classRegistry != null;
                argsValue.add(cur.getThis());
            }
        }

        for (int i = 0; i < node.callArgExpNodes.size(); i++) {
            node.callArgExpNodes.get(i).accept(this);
            argsValue.add(node.callArgExpNodes.get(i).value);
        }
        node.value = new IRCallInst((IRFunction) node.callExpNode.value, cur.block, argsValue);
    }

    @Override
    public void visit(IndexExpNode node) {
        node.arrayExpNode.accept(this);
        node.indexExpNode.accept(this);
        node.value = memLoad(new IRGetElementPtrInst(node.arrayExpNode.value.name + LLVM.ArrayElementSuffix,
                node.arrayExpNode.value, node.arrayExpNode.value.type, cur.block, node.indexExpNode.value), cur.block);
    }

    @Override
    public void visit(MemberExpNode node) {
        node.superExpNode.accept(this);

        if (node.superExpNode.type.isArray()) {
            // array
            Value castPtr = new IRBitCastInst(node.superExpNode.value, IRTranslator.i32PointerType, cur.block);
            // one step back
            node.value = memLoad(new IRGetElementPtrInst(castPtr, IRTranslator.i32PointerType, cur.block, new IntConst(-1)), cur.block);
        } else if (node.superExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
            // string
            node.value = StringBuiltinMethods.scope.queryFunc(node.memberName).value;
        } else {
            // class
            String className = ((VarType) node.superExpNode.type).className;
            ClassRegistry classRegistry = infoManager.queryClass(className);

            if (node.type instanceof VarType) {
                VarRegistry varRegistry = classRegistry.scope.queryVar(node.memberName);
                Value varAddr = new IRGetElementPtrInst(node.memberName, node.superExpNode.value,
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
                new IRCallInst((IRFunction) classRegistry.scope.queryFunc(classRegistry.name).value, cur.block, node.value);
            }
            else throw new UnimplementedError(node.codePos, node);
        }
        else { // must be an array
            ArrayList<Value> eachDimLengths = new ArrayList<>();
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
        Value calculated = null, storePtr = node.selfExpNode.value.resolveFrom;
        switch (node.op) {
            case MxStar.IncrementOp:
                calculated = new IRBinaryInst(LLVM.AddInst, IRTranslator.i32Type,  node.selfExpNode.value, new IntConst(1), cur.block);
                break;
            case MxStar.DecrementOp:
                calculated = new IRBinaryInst(LLVM.SubInst, IRTranslator.i32Type, node.selfExpNode.value, new IntConst(1), cur.block);
                break;
            default: throw new InternalError("unknown postfix op");
        }
        memStore(storePtr, calculated);
        node.value = node.selfExpNode.value;
    }

    @Override
    public void visit(PrefixExpNode node) {
        node.selfExpNode.accept(this);
        Value calculated = null, storePtr = node.selfExpNode.value.resolveFrom;

        switch (node.op) {
            case MxStar.IncrementOp:
                calculated = new IRBinaryInst(LLVM.AddInst, IRTranslator.i32Type, node.selfExpNode.value, new IntConst(1), cur.block);break;
            case MxStar.DecrementOp:
                calculated = new IRBinaryInst(LLVM.SubInst, IRTranslator.i32Type, node.selfExpNode.value, new IntConst(1), cur.block);break;
            default: throw new InternalError("unknown prefix op");
        }
        memStore(storePtr, calculated);
        calculated.resolveFrom = storePtr; // left value
        node.value = calculated;
    }

    @Override
    public void visit(UnaryExpNode node) {
        node.selfExpNode.accept(this);
        switch (node.op) {
            case MxStar.AddOp:
                node.value = node.selfExpNode.value;break;
            case MxStar.SubOp:
                node.value = new IRBinaryInst(LLVM.SubInst, IRTranslator.i32Type ,new IntConst(0), node.selfExpNode.value, cur.block);break;
            case MxStar.LogicNotOp:
                node.value = new IRBinaryInst(LLVM.XorInst, IRTranslator.boolType, node.selfExpNode.value, new BoolConst(true), cur.block);break;
            case MxStar.BitNotOp:
                node.value = new IRBinaryInst(LLVM.XorInst, IRTranslator.i32Type, node.selfExpNode.value, new IntConst(-1), cur.block);break;
            default: throw new InternalError("unknown unary op");
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
        else if (node.ctx.StringConstant() != null)
            node.value = new IRGetElementPtrInst(module.getStringConst(node.getStringLiteral()),
                        IRTranslator.stringType, cur.block, new IntConst(0), new IntConst(0));
        else if (node.ctx.NullConstant() != null) node.value = new NullptrConst();
        else if (node.ctx.ThisPointer() != null) node.value = cur.getThis();
        else if (node.ctx.Identifier() != null) {
            if (node.type instanceof VarType) {
                Value varAddr;
                Pair<VarRegistry, Boolean> result = infoManager.queryVarWithValue(node.ctx.Identifier().getText());
                VarRegistry varRegistry = result.first();
                int memberIndex = -1;
                if (cur.classRegistry != null && result.second())
                    memberIndex = cur.classRegistry.getMemberVarIndex(varRegistry.name);
                if (memberIndex >= 0) {
                    // member in class scope
                    varAddr = new IRGetElementPtrInst(varRegistry.name, cur.getThis(),
                            new PointerType(translator.translateAllocaType(varRegistry.type)),
                            cur.block, new IntConst(0), new IntConst(memberIndex));
                }
                else varAddr = varRegistry.value;
                // variable resolve
                node.value = memLoad(varAddr, cur.block);
            }
            else if (node.type instanceof MxFuncType) node.value = infoManager.queryFuncInStack(node.ctx.Identifier().getText()).value;
        }
    }

    // private tool methods

    // global init func
    private void createInitFunc() {
        FuncRegistry initRegistry = new FuncRegistry(LLVM.InitFuncName, MxBaseType.BuiltinType.VOID);
        initRegistry.isBuiltin = false; // declare a FuncRegistry directly will be seen as builtin. close it.

        cur.func = new IRFunction(LLVM.InitFuncName,
                translator.translateFuncType(initRegistry.type, null));

        cur.block = cur.func.entryBlock;

        infoManager.register(initRegistry);

        new IRRetInst(cur.func.exitBlock); // return void
        module.functions.add(cur.func);
        infoManager.queryFuncInStack(cur.func.name).value = cur.func;
    }

    private void funcDecl(FuncDefNode node) {
        IRFunction declFunc = new IRFunction(node.funcRegistry.name,
                translator.translateFuncType(node.funcRegistry.type, null));

        module.functions.add(declFunc);
        node.funcRegistry.value = declFunc;
    }

    private void builtinFuncDecl(RootNode node) {
        // malloc & string op
        module.setBottomFunctions();

        // global functions
        for (FuncRegistry builtinFuncRegistry : node.scope.builtinFuncList) {
            IRFunction builtinFunc = new IRFunction(builtinFuncRegistry.name,
                    translator.translateFuncType(builtinFuncRegistry.type, null));

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }

        // string methods
        for (FuncRegistry builtinFuncRegistry : StringBuiltinMethods.scope.builtinFuncList) {
            IRFunction builtinFunc = new IRFunction(LLVM.StrMethodPrefix + builtinFuncRegistry.name,
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
                IRFunction declMemberFunc = new IRFunction(declClass.structName + LLVM.Splitter + memberFunc.name,
                        translator.translateFuncType(memberFunc.type, new PointerType(declClass)));
                module.functions.add(declMemberFunc);
                memberFunc.value = declMemberFunc;
            }
        }
    }

    private Value memAlloca(String allocaName, IRBaseType allocaType) {
        // allocated in entry block
        return new IRAllocaInst(allocaName, allocaType, cur.func.entryBlock);
    }

    private Value memLoad(Value pointer, IRBlock parentBlock) {
        assert pointer.type instanceof PointerType;
        Value ret = new IRLoadInst(pointer, parentBlock);
        if (((PointerType) pointer.type).pointedType instanceof MemBoolType)
            ret = new IRTruncInst(ret, IRTranslator.boolType, parentBlock);
        ret.resolveFrom = pointer;
        return ret;
    }

    private void memStore(Value destPtr, Value assignData) {
        if (assignData.type instanceof BoolType) {
            assignData = new IRZextInst(assignData, IRTranslator.memBoolType, cur.block);
        }
        assert destPtr.type instanceof PointerType;
        assert ((PointerType) destPtr.type).pointedType.match(assignData.type);
        new IRStoreInst(destPtr, assignData, cur.block);
    }

    private Value arrayMalloc(ArrayList<Value> eachDimLengths, int curDim, IRBaseType elementType) {
        // int[][][] a = new int [3][4][5];
        // curDim: from 0 to 2
        // elementType: now dim element. e.g. curDim = 0, elementType = i32**

        // step 1. malloc this dim.
        // size calculation using (curDimLength+1) * elementTypeSize (metadata)
        Value curDimSize = new IRBinaryInst(LLVM.MulInst, IRTranslator.i32Type,
                eachDimLengths.get(curDim), new IntConst(elementType.size()), cur.block);
        Value mallocSize = new IRBinaryInst(LLVM.AddInst, IRTranslator.i32Type, curDimSize, new IntConst(IRTranslator.i32Type.size()), cur.block);
        Value mallocPtr = new IRCallInst(module.getMalloc(), cur.block, mallocSize).noalias();

        // step 2. store length at the head of the array
        Value lengthDestPtr = new IRBitCastInst(mallocPtr, IRTranslator.i32PointerType, cur.block);
        memStore(lengthDestPtr, eachDimLengths.get(curDim));

        // step 3. get array head pointer, malloc the internal space
        Value arrHeadPointer = new IRBitCastInst(
                new IRGetElementPtrInst(lengthDestPtr, IRTranslator.i32PointerType, cur.block, new IntConst(1)),
                new PointerType(elementType), cur.block);
        if (curDim < eachDimLengths.size() - 1) {
            // int* curDimPtr = 0; while (curDimPtr != tailDimPtr) {curDimPtr++;}
            IRBlock condBlock = new IRBlock(LLVM.WhCondBlockLabel, cur.func),
                    bodyBlock = new IRBlock(LLVM.WhBodyBlockLabel, cur.func),
                    exitBlock = new IRBlock(LLVM.WhExitBlockLabel, cur.func);

            IRPhiInst curDimPtr = new IRPhiInst(arrHeadPointer.type, null);
            curDimPtr.addBranch(arrHeadPointer, cur.block); // initial branch

            Value tailDimPtr = new IRGetElementPtrInst(arrHeadPointer, arrHeadPointer.type, cur.block, eachDimLengths.get(curDim));
            IRBaseInst incrPtr = new IRGetElementPtrInst(curDimPtr, curDimPtr.type, null, new IntConst(1));

            new IRBrInst(condBlock, cur.block);

            cur.block = condBlock;
            curDimPtr.setParentBlock(condBlock);
            Value condValue = new IRICmpInst(LLVM.NotEqualArg, curDimPtr, tailDimPtr, cur.block);
            new IRBrInst(condValue, bodyBlock, exitBlock, cur.block);

            cur.block = bodyBlock;
            Value subMallocPtr = arrayMalloc(eachDimLengths, curDim+1, ((PointerType) elementType).pointedType);
            memStore(curDimPtr, subMallocPtr);
            incrPtr.setParentBlock(cur.block);
            curDimPtr.addBranch(incrPtr, cur.block);
            new IRBrInst(condBlock, cur.block);

            cur.block = exitBlock;
        }
        return arrHeadPointer;
    }

    private Value classMalloc(StructType classType) {
        Value mallocPtr = new IRCallInst(module.getMalloc(), cur.block, new IntConst(classType.size())).noalias();
        return new IRBitCastInst(mallocPtr, new PointerType(classType), cur.block);
    }

    private boolean funcDetect(ExpBaseNode node) {
        if (node instanceof AtomExpNode) {
            return !(node.type instanceof MxFuncType);
        }
        if (node instanceof BinaryExpNode) {
            return funcDetect(((BinaryExpNode) node).lhsExpNode) && funcDetect(((BinaryExpNode) node).rhsExpNode);
        }
        return false;
    }
}
