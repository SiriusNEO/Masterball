package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.backend.rvasm.inst.*;
import masterball.compiler.backend.rvasm.operand.*;
import masterball.compiler.backend.rvasm.operand.RawStackOffset.RawType;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.StructType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.error.runtime.InternalError;
import masterball.compiler.share.misc.Pair;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.compiler.share.pass.IRModulePass;
import masterball.compiler.share.pass.InstVisitor;
import masterball.debug.Log;

import java.util.ArrayList;

import static java.lang.Integer.max;

// implements @IRVisitor and @InstVisitor

// notice: the order of register created.
// use cur.toReg to avoid this problem

public class AsmBuilder implements IRModulePass, IRFuncPass, IRBlockPass, InstVisitor {

    public final AsmModule module = new AsmModule();

    private final AsmCurrent cur = new AsmCurrent();

    public AsmBuilder(IRModule irModule) {this.runOnModule(irModule);}

    // Builder
    @Override
    public void runOnModule(IRModule irModule) {
        globalDecl(irModule);

        for (IRFunction builtinFunc : irModule.builtinFunctions) {
            AsmFunction function = new AsmFunction(builtinFunc.name);
            builtinFunc.asmOperand = function;
            for (int i = 0; i < ((IRFuncType) builtinFunc.type).argTypes.size(); i++) {
                VirtualReg reg = new VirtualReg(builtinFunc.getArgType(i).size());
                function.arguments.add(reg);

                // spill
                if (i >= RV32I.MaxArgRegNum) {
                    reg.stackOffset = new RawStackOffset(function.calleeArgStackUse, RawType.calleeArg);
                    function.calleeArgStackUse += RV32I.I32Unit;
                }
            }
        }

        for (IRFunction irFunc : irModule.functions) {
            AsmFunction function = new AsmFunction(irFunc.name);
            irFunc.asmOperand = function;

            for (int i = 0; i < irFunc.operands.size(); i++) {
                Value arg = irFunc.operands.get(i);
                VirtualReg reg = new VirtualReg(arg.type.size());
                arg.asmOperand = reg;

                function.arguments.add(reg);

                // spill
                if (i >= RV32I.MaxArgRegNum) {
                    reg.stackOffset = new RawStackOffset(function.calleeArgStackUse, RawType.calleeArg);
                    function.calleeArgStackUse += RV32I.I32Unit;
                }
            }

            module.functions.add((AsmFunction) irFunc.asmOperand);

            for (IRBlock irBlock : irFunc.blocks) {
                AsmBlock block = new AsmBlock(irBlock.name);
                block.loopDepth = irBlock.loopDepth;
                irBlock.asmOperand = block;
                function.blocks.add(block);
            }
            for (IRBlock irBlock : irFunc.blocks) {
                irBlock.prevs.forEach(pre -> ((AsmBlock) irBlock.asmOperand).prevs.add((AsmBlock) pre.asmOperand));
                irBlock.nexts.forEach(nxt -> ((AsmBlock) irBlock.asmOperand).nexts.add((AsmBlock) nxt.asmOperand));
            }
            function.entryBlock = (AsmBlock) irFunc.entryBlock.asmOperand;
            function.exitBlock = (AsmBlock) irFunc.exitBlock.asmOperand;
        }

        irModule.functions.forEach(this::runOnFunc);
    }

    @Override
    public void runOnFunc(IRFunction function) {
        cur.func = (AsmFunction) function.asmOperand;

        // lower the stack pointer
        // sp low
        new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                new RawStackOffset(0, RawType.lowerSp), cur.func.entryBlock);

        // backup callee
        ArrayList<Register> calleeSaveTemp = new ArrayList<>();
        for (PhysicalReg phyReg : PhysicalReg.calleeSaved) {
            VirtualReg rd = new VirtualReg();
            calleeSaveTemp.add(rd);
            new AsmMvInst(rd, phyReg, cur.func.entryBlock);
        }

        // ra
        VirtualReg raTemp = new VirtualReg();
        new AsmMvInst(raTemp, PhysicalReg.reg("ra"), cur.func.entryBlock);

        // move arguments 0~7 to reg
        for (int i = 0; i < Integer.min(cur.func.arguments.size(), RV32I.MaxArgRegNum); i++) {
            new AsmMvInst(cur.func.arguments.get(i), PhysicalReg.a(i), cur.func.entryBlock);
        }

        // load arguments in mem to reg
        for (int i = RV32I.MaxArgRegNum; i < cur.func.arguments.size(); i++) {
            new AsmLoadInst(function.getOperand(i).type.size(), cur.func.arguments.get(i), PhysicalReg.reg("sp"),
                    cur.func.arguments.get(i).stackOffset, cur.func.entryBlock);
        }

        function.blocks.forEach(this::runOnBlock);

        // callee temp back
        for (int i = 0; i < PhysicalReg.calleeSaved.size(); i++) {
            new AsmMvInst(PhysicalReg.calleeSaved.get(i), calleeSaveTemp.get(i), cur.func.exitBlock);
        }

        // ra temp back
        new AsmMvInst(PhysicalReg.reg("ra"), raTemp, cur.func.exitBlock);

        // sp back
        new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                new RawStackOffset(0, RawType.raiseSp), cur.func.exitBlock);

        // return
        new AsmRetInst(cur.func.exitBlock);

        cur.func.blocks.forEach(block -> {
            block.instructions.forEach(this::allocate);
        });
        VirtualReg.regNumReset();
    }

    @Override
    public void runOnBlock(IRBlock block) {
        cur.block = (AsmBlock) block.asmOperand;
        cur.recordLi.clear();
        block.instructions.forEach(inst -> inst.accept(this));
    }

    // InstSelector
    @Override
    public void visit(IRAllocaInst inst) {
        inst.asmOperand = new RawStackOffset(cur.func.allocaStackUse, RawType.alloca);
        cur.func.allocaStackUse += RV32I.I32Unit;
    }

    @Override
    public void visit(IRBinaryInst inst) {
        Register instReg = cur.toReg(inst);
        awesomeALU(AsmTranslator.translateArithmOp(inst.op), instReg, inst.lhs(), inst.rhs());
    }

    @Override
    public void visit(IRBitCastInst inst) {
        // ignore type
        awesomeMove(cur.toReg(inst), inst.getOperand(0));
    }

    @Override
    public void visit(IRBrInst inst) {
        inst.asmOperand = null; // Br Type no inst reg

        if (inst.isJump()) {
            new AsmJmpInst((AsmBlock) inst.destBlock().asmOperand, cur.block);
            return;
        }

        if (inst.condition() instanceof IRICmpInst && ((IRICmpInst) inst.condition()).forBr()) {
            // coalesce cmp and br
            Pair<String, Boolean> result = AsmTranslator.translateCmpOp(((IRICmpInst) inst.condition()).op);
            if (result.second())
                new AsmBrInst(result.first(), cur.toReg(((IRICmpInst) inst.condition()).rhs()), cur.toReg(((IRICmpInst) inst.condition()).lhs()),
                        (AsmBlock) inst.ifTrueBlock().asmOperand, cur.block);
            else
                new AsmBrInst(result.first(), cur.toReg(((IRICmpInst) inst.condition()).lhs()), cur.toReg(((IRICmpInst) inst.condition()).rhs()),
                        (AsmBlock) inst.ifTrueBlock().asmOperand, cur.block);
        }
        else {
            new AsmBrInst(RV32I.NotEqualSuffix, cur.toReg(inst.condition()), cur.toReg(new IntConst(0)),
                    (AsmBlock) inst.ifTrueBlock().asmOperand, cur.block);
        }

        new AsmJmpInst((AsmBlock) inst.ifFalseBlock().asmOperand, cur.block);
    }

    @Override
    public void visit(IRCallInst inst) {
        AsmFunction callFunc = (AsmFunction) inst.callFunc().asmOperand;

        // 0~7
        for (int i = 0; i < Integer.min(inst.callFunc().getArgNum(), RV32I.MaxArgRegNum); i++) {
            if (inst.getArg(i) instanceof GlobalValue) {
                if (((GlobalValue) inst.getArg(i)).gpRegMark) {
                    new AsmMvInst(PhysicalReg.a(i), PhysicalReg.reg("gp"), cur.block);
                }
                else {
                    new AsmLaInst(PhysicalReg.a(i), inst.getArg(i).asmOperand.identifier, cur.block);
                }
            }
            else awesomeMove(PhysicalReg.a(i), inst.getArg(i));
        }

        // spill to mem
        for (int i = RV32I.MaxArgRegNum; i < callFunc.arguments.size(); i++) {

            new AsmStoreInst(inst.getArg(i).type.size(), PhysicalReg.reg("sp"),
                    // notice: here use the argument of CallInst, not the func
                    // and the RawStackOffset should use caller
                    cur.toReg(inst.getArg(i)),
                    new RawStackOffset(callFunc.arguments.get(i).stackOffset.value, RawType.callerArg),
                    cur.block);
        }

        // callerArg space = max calleeArg space
        cur.func.callerArgStackUse = max(cur.func.callerArgStackUse, callFunc.calleeArgStackUse);

        new AsmCallInst(callFunc, cur.block, inst.isTailCall);
        if (!inst.callFunc().isVoid()) {
            // return value
            new AsmMvInst(cur.toReg(inst), PhysicalReg.reg("a0"), cur.block);
        }
    }

    @Override
    public void visit(IRGetElementPtrInst inst) {
        // step 1. calculate address
        // only 1~2 indices presented in LLVM IR
        // 2 indices means it is a class "GetElementPtr". Then the first index must be 0
        // index * elementSize (if it is array)
        // memberOffset (if it is class)
        // do some constant folding (detail in @awesomeGEP)

        Value index = inst.isGetMember() ? inst.memberIndex() : inst.ptrMoveIndex();
        StructType classType = inst.isGetMember() ? (StructType) ((PointerType) inst.headPointer().type).pointedType : null;
        int elementSize = ((PointerType) inst.headPointer().type).pointedType.size(); // well... quite interesting

        // local & const && only for load/store

        if (index instanceof IntConst && !(inst.headPointer() instanceof GlobalValue) && specialGEPCheck(inst)) {
            int offset = 0;
            if (classType != null) {
                offset = classType.memberOffset(((IntConst) index).constData);
            }
            else {
                offset = ((IntConst) index).constData * elementSize;
            }
            inst.asmOperand = new RawMemOffset(cur.toReg(inst.headPointer()), offset);
            return;
        }

        Register instReg = cur.toReg(inst);
        Register gepReg = awesomeGEP(inst.headPointer(), index, elementSize, classType);
        new AsmMvInst(instReg, gepReg, cur.block);
    }

    @Override
    public void visit(IRICmpInst inst) {
        // only use slt, seqz, snez

        // this cmp inst will be merged into next br
        if (inst.forBr()) return;

        Register instReg = cur.toReg(inst);
        switch (inst.op) {
            case LLVM.LessArg:
                awesomeALU(RV32I.SltInst, instReg, inst.lhs(), inst.rhs());
                break;
            case LLVM.GreaterArg:
                awesomeALU(RV32I.SltInst, instReg, inst.rhs(), inst.lhs());
                break;
            case LLVM.GreaterEqualArg: // a >= b -> !(a < b)
                awesomeALU(RV32I.SltInst, instReg, inst.lhs(), inst.rhs());
                new AsmALUInst(RV32I.XorInst, instReg, instReg, cur.toImm(1), cur.block);
                break;
            case LLVM.LessEqualArg: // a <= b -> !(b < a)
                awesomeALU(RV32I.SltInst, instReg, inst.rhs(), inst.lhs());
                new AsmALUInst(RV32I.XorInst, instReg, instReg, cur.toImm(1), cur.block);
                break;
            case LLVM.EqualArg: { // a == b -> xor = a ^ b; seqz rd, xor
                VirtualReg xorReg = new VirtualReg();
                awesomeALU(RV32I.XorInst, xorReg, inst.lhs(), inst.rhs());
                new AsmALUInst(RV32I.SeqzInst, instReg, xorReg, cur.block);
                break;
            }
            case LLVM.NotEqualArg: {
                VirtualReg xorReg = new VirtualReg();
                awesomeALU(RV32I.XorInst, xorReg, inst.lhs(), inst.rhs());
                new AsmALUInst(RV32I.SnezInst, instReg, xorReg, cur.block);
                break;
            }
            default: throw new InternalError("unknown ASM compare op");
        }
    }

    @Override
    public void visit(IRLoadInst inst) {
        Register instReg = cur.toReg(inst);
        if (inst.loadPtr() instanceof GlobalValue) {
            if (((GlobalValue) inst.loadPtr()).gpRegMark) {
                new AsmMvInst(instReg, PhysicalReg.reg("gp"), cur.block);
            }
            else {
                VirtualReg luiReg = new VirtualReg();
                GlobalReg globalReg = (GlobalReg) cur.toReg(inst.loadPtr());
                new AsmLuiInst(luiReg, new GlobalAddr(globalReg, GlobalAddr.HiLo.hi), cur.block);
                new AsmLoadInst(inst.type.size(), instReg, luiReg, new GlobalAddr(globalReg, GlobalAddr.HiLo.lo), cur.block);
            }
        } else {
            // if it is not global, it must be loaded from stack, right?
            if (inst.loadPtr().asmOperand instanceof RawStackOffset) {
                new AsmLoadInst(inst.type.size(), instReg, PhysicalReg.reg("sp"), cur.toImm(inst.loadPtr()), cur.block);
            }
            else if (inst.loadPtr().asmOperand instanceof RawMemOffset) {
                // must be produced by gep
                new AsmLoadInst(inst.type.size(), instReg,
                        null,
                        (Immediate) inst.loadPtr().asmOperand,
                        cur.block);
            }
            else {
                new AsmLoadInst(inst.type.size(), instReg, cur.toReg(inst.loadPtr()), cur.toImm(0), cur.block);
            }
        }
    }

    @Override
    public void visit(IRPhiInst inst) {
        throw new InternalError("Phi Inst appears in ASM");
    }

    @Override
    public void visit(IRRetInst inst) {
        if (inst.isVoid()) return;
        awesomeMove(PhysicalReg.reg("a0"), inst.retVal());
    }

    @Override
    public void visit(IRStoreInst inst) {
        if (inst.storePtr() instanceof GlobalValue) {
            if (((GlobalValue) inst.storePtr()).gpRegMark) {
                new AsmMvInst(PhysicalReg.reg("gp"), cur.toReg(inst.storeValue()) ,cur.block);
            }
            else {
                VirtualReg luiReg = new VirtualReg();
                GlobalReg globalReg = (GlobalReg) cur.toReg(inst.storePtr());
                new AsmLuiInst(luiReg, new GlobalAddr(globalReg, GlobalAddr.HiLo.hi), cur.block);
                new AsmStoreInst(inst.storeValue().type.size(), luiReg, cur.toReg(inst.storeValue()), new GlobalAddr(globalReg, GlobalAddr.HiLo.lo), cur.block);
            }
        } else {
            if (inst.storePtr().asmOperand instanceof RawStackOffset) {
                // must be stack
                new AsmStoreInst(inst.storeValue().type.size(), PhysicalReg.reg("sp"),
                        cur.toReg(inst.storeValue()), cur.toImm(inst.storePtr()), cur.block);
            }
            else if (inst.storePtr().asmOperand instanceof RawMemOffset) {
                // must be produced by gep
                new AsmStoreInst(inst.storeValue().type.size(),
                        null,
                        cur.toReg(inst.storeValue()),
                        (Immediate) inst.storePtr().asmOperand,
                        cur.block);
            }
            else {
                new AsmStoreInst(inst.storeValue().type.size(), cur.toReg(inst.storePtr()), cur.toReg(inst.storeValue()), cur.toImm(0), cur.block);
            }
        }
    }

    @Override
    public void visit(IRTruncInst inst) {
        awesomeMove(cur.toReg(inst), inst.getOperand(0));
    }

    @Override
    public void visit(IRZextInst inst) {
        awesomeMove(cur.toReg(inst), inst.getOperand(0));
    }

    @Override
    public void visit(IRMoveInst inst) {
        awesomeMove(cur.toReg(inst.dest()), inst.source());
    }

    // private method tools

    private void globalDecl(IRModule irModule) {
        for (GlobalVariable globalVar : irModule.globalVarSeg) {
            GlobalReg globalReg = new GlobalReg(globalVar.name);
            globalVar.asmOperand = globalReg;
            module.globalVarSeg.add(globalReg);
        }

        for (StringConst strConst : irModule.stringConstSeg) {
            GlobalReg strReg = new GlobalReg(strConst.name, strConst.constData);
            strConst.asmOperand = strReg;
            module.stringConstSeg.add(strReg);
        }
    }

    // awesome asm optimize

    private static boolean validImm(Value value) {
        return (value instanceof IntConst && ((IntConst) value).constData >= -1 * RV32I.ImmBound && ((IntConst) value).constData < RV32I.ImmBound) || value instanceof BoolConst;
    }

    private static boolean validImm(int value) {
        return value >= -1 * RV32I.ImmBound && value < RV32I.ImmBound;
    }

    private static boolean equalZero(Value value) {
        return value instanceof NullptrConst || (value instanceof IntConst && ((IntConst) value).constData == 0) || (value instanceof BoolConst && !((BoolConst) value).constData);
    }

    // check an immediate: whether it is a valid two power, return imm log2
    // if not a valid 2power immediate, return null
    private static Immediate twoPowerCheck(Value value) {
        if (!(value instanceof IntConst)) return null;
        int log2 = 0, valData = ((IntConst) value).constData;
        if (valData <= 0) return null;
        while (valData > 1) {
            if (valData % 2 != 0) return null;
            valData >>= 1;
            log2++;
        }
        return new Immediate(log2);
    }

    private void allocate(AsmBaseInst inst) {
        if (!(inst.imm instanceof RawMemOffset)) return;
        inst.rs1 = ((RawMemOffset) inst.imm).pointer;
        inst.imm = new Immediate(inst.imm.value);
    }

    private boolean specialGEPCheck(IRGetElementPtrInst inst) {
        if (inst.asmOperand != null) return false;
        for (User user : inst.users)
            if (!(user instanceof IRLoadInst || user instanceof IRStoreInst)) return false;
        return true;
    }

    private void awesomeALU(String rvOp, Register dest, Value lhs, Value rhs) {
        // now support:
        // slt optimize
        // binary arithm calculate
        // remember this calculate only support two IR Value

        // div can not use this optimize because of negative num problem
        if (rvOp.equals(RV32I.MulInst)) {
            Immediate lhsLog2 = twoPowerCheck(lhs), rhsLog2 = twoPowerCheck(rhs);
            if (lhsLog2 != null) {
                new AsmALUInst(RV32I.ShiftLeftInst, dest, cur.toReg(rhs), lhsLog2, cur.block);
                return;
            }
            else if (rhsLog2 != null) {
                new AsmALUInst(RV32I.ShiftLeftInst, dest, cur.toReg(lhs), rhsLog2, cur.block);
                return;
            }
        }

        if (AsmTranslator.hasIType(rvOp)) {
            if (validImm(rhs)) {
                new AsmALUInst(rvOp, dest, cur.toReg(lhs), cur.toImm(rhs), cur.block);
                return;
            }
            else if (AsmTranslator.isCommunicative(rvOp) && validImm(lhs)) {
                new AsmALUInst(rvOp, dest, cur.toReg(rhs), cur.toImm(lhs), cur.block);
                return;
            }
        }
        else if (rvOp.equals(RV32I.SubInst)) {
            if (validImm(rhs)) {
                // not communicative
                new AsmALUInst(RV32I.AddInst, dest, cur.toReg(lhs), cur.toImm(rhs).negative(), cur.block);
                return;
            }
        }

        new AsmALUInst(rvOp, dest, cur.toReg(lhs), cur.toReg(rhs), cur.block);
    }

    public void awesomeMove(Register dest, Value source) {
        if (validImm(source)) {
            new AsmLiInst(dest, cur.toImm(source), cur.block);
        }
        else {
            new AsmMvInst(dest, cur.toReg(source), cur.block);
        }
    }

    public Register awesomeGEP(Value ptrPos, Value index, int elementSize, StructType classType) {
        VirtualReg gepReg = new VirtualReg();
        if (classType != null) {
            // class member get
            assert index instanceof IntConst;
            if (equalZero(index)) {
                Register ptrReg = cur.toReg(ptrPos);
                if (ptrPos instanceof GlobalValue) {
                    if (((GlobalValue) ptrPos).gpRegMark) {
                        new AsmMvInst(gepReg, PhysicalReg.reg("gp"), cur.block);
                    }
                    else {
                        new AsmLaInst(gepReg, ptrReg.identifier, cur.block);
                    }
                }
                else new AsmMvInst(gepReg, ptrReg, cur.block);
            } else {
                int memberOffset = classType.memberOffset(((IntConst) index).constData);
                awesomeALU(RV32I.AddInst, gepReg, ptrPos, new IntConst(memberOffset));
            }
        }
        else {
            // array
            if (index instanceof IntConst) {
                // constant folding
                if (equalZero(index)) {
                    Register ptrReg = cur.toReg(ptrPos);
                    if (ptrPos instanceof GlobalValue) {
                        if (((GlobalValue) ptrPos).gpRegMark) {
                            new AsmMvInst(gepReg, PhysicalReg.reg("gp"), cur.block);
                        }
                        else {
                            new AsmLaInst(gepReg, ptrReg.identifier, cur.block);
                        }
                    }
                    else new AsmMvInst(gepReg, ptrReg, cur.block);
                } else {
                    int totalSize = ((IntConst) index).constData * elementSize;
                    awesomeALU(RV32I.AddInst, gepReg, ptrPos, new IntConst(totalSize));
                }
            } else {
                VirtualReg mulReg = new VirtualReg();
                awesomeALU(RV32I.MulInst, mulReg, index, new IntConst(elementSize));
                // this not use awesomeALU because it can not be optimized
                new AsmALUInst(RV32I.AddInst, gepReg, cur.toReg(ptrPos), mulReg, cur.block);
            }
        }
        return gepReg;
    }
}
