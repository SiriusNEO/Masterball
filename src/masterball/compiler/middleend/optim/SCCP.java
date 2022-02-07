package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.share.error.runtime.ZeroDivisionWarning;
import masterball.compiler.share.error.runtime.UnknownError;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.compiler.share.pass.InstVisitor;
import masterball.debug.Log;

import java.util.*;

/**
 * Sparse Condition Constant Propagation
 * use constant folding some dead block will be eliminated
 * (actually duplicate with part of CFGSimplifier)
 * @reference: Tiger Book chapter 19.3.3
 */

public class SCCP implements IRFuncPass, IRBlockPass, InstVisitor {

    private final BaseConst uncertain = new BaseConst(LLVM.UncertainConst, null);
    /**
     * Three status for LatticeCell:
     *  undef: null or not in Map
     *  def: map to a constant
     *  uncertain: map to uncertain
     */
    private final Map<Value, BaseConst> lattice = new HashMap<>();
    private final Set<IRBlock> executable = new HashSet<>();
    private final Set<IRBlock> removed = new HashSet<>();

    private final Queue<Value> valueWorklist = new LinkedList<>();
    private final Queue<IRBlock> blockWorklist = new LinkedList<>();

    private BaseConst getConst(Value value) {
        if (value instanceof BaseConst) {
            if (value instanceof GlobalValue) return uncertain;
            return (BaseConst) value;
        }
        if (!lattice.containsKey(value)) lattice.put(value, null);
        return lattice.get(value);
    }

    private boolean removeUnexecutableBlock(IRFunction function) {
        HashSet<IRBlock> toRemoveSet = new HashSet<>();

        for (IRBlock toRemove : function.blocks) {
            if (executable.contains(toRemove) || removed.contains(toRemove)) continue;

            Log.report("remove", function.identifier(), toRemove.identifier());

            // remove toRemove
            toRemoveSet.add(toRemove);

            for (IRBlock pre : toRemove.prevs) {
                var terminator = pre.terminator();
                if (terminator instanceof IRBrInst && !((IRBrInst) terminator).isJump()) {
                    pre.nexts.remove(toRemove);
                    IRBlock anotherDest = (((IRBrInst) terminator).ifTrueBlock() == toRemove) ?
                            ((IRBrInst) terminator).ifFalseBlock() :
                            ((IRBrInst) terminator).ifTrueBlock();
                    IRBrInst newTerminator = new IRBrInst(anotherDest, pre); //terminated
                    pre.instructions.removeLast();
                    pre.instructions.addLast(newTerminator); // terminated, add manually
                }
            }

            for (IRBlock suc : toRemove.nexts) {
                suc.prevs.remove(toRemove);
                var it = suc.phiInsts.iterator();
                while (it.hasNext()) {
                    var phi = it.next();
                    for (int i = 1; i < phi.operandSize(); i += 2) {
                        if (phi.getOperand(i) == toRemove) {
                            // remove the branch
                            phi.operands.remove(i-1);
                            phi.operands.remove(toRemove);
                            break;
                        }
                    }
                    if (phi.operandSize() == 2) {
                        it.remove();
                        IRMoveInst move = new IRMoveInst(phi, phi.getOperand(0), suc); // terminated
                        suc.instructions.addFirst(move);
                    }
                }
            }

            toRemove.prevs.clear();
            toRemove.nexts.clear();
            // Log.report("removed", toRemove.identifier());
        }

        function.blocks.removeAll(toRemoveSet);
        removed.addAll(toRemoveSet);
        return toRemoveSet.size() > 0;
    }

    private boolean removeRedundantInst(IRFunction function) {
        boolean ret = false;
        for (IRBlock block : function.blocks) {
            var it = block.instructions.iterator();
            while (it.hasNext()) {
                var inst = it.next();
                BaseConst instConst = getConst(inst);
                if (instConst != null && instConst != uncertain) {
                    ret = true;
                    it.remove();
                }

                if (inst instanceof IRMoveInst) {
                    BaseConst destConst = getConst(((IRMoveInst) inst).dest());
                    if (destConst != null && destConst != uncertain) {
                        ret = true;
                        it.remove();
                    }
                }
            }

            var phiIt = block.phiInsts.iterator();
            while (phiIt.hasNext()) {
                var phi = phiIt.next();
                BaseConst instConst = getConst(phi);
                if (instConst != null && instConst != uncertain) {
                    ret = true;
                    phiIt.remove();
                }
            }
        }
        return ret;
    }

    private boolean rewriteBranch(IRFunction function) {
        boolean ret = false;
        for (IRBlock block : function.blocks) {
            var terminator = block.terminator();
            if (!(terminator instanceof IRBrInst && !((IRBrInst) terminator).isJump())) continue;
            BaseConst condConst = getConst(((IRBrInst) terminator).condition());
            if (condConst == null || condConst == uncertain) continue;
            assert condConst instanceof BoolConst;

            IRBlock realDest = (((BoolConst) condConst).constData) ? ((IRBrInst) terminator).ifTrueBlock() : ((IRBrInst) terminator).ifFalseBlock();
            IRBrInst newTerminator = new IRBrInst(realDest, block); // terminated
            block.instructions.removeLast();
            block.instructions.addLast(newTerminator);
            ret = true;
        }
        return ret;
    }

    private void replaceUses() {
        lattice.forEach((val, con) -> {
            if (con != null && con != uncertain) {
                val.replaced(con);
            }
        });
    }

    @Override
    public void runOnFunc(IRFunction function) {
        boolean changed = true;

        while (changed) {
            lattice.clear();
            executable.clear();
            executable.add(function.entryBlock);
            blockWorklist.offer(function.entryBlock);
            function.operands.forEach(arg -> lattice.put(arg, uncertain));

            while (!valueWorklist.isEmpty() || !blockWorklist.isEmpty()) {
                if (!blockWorklist.isEmpty()) {
                    IRBlock block = blockWorklist.poll();
                    runOnBlock(block);
                    Log.report("check block: ", block.identifier());
                }

                if (!valueWorklist.isEmpty()) {
                    Value value = valueWorklist.poll();
                    value.users.forEach(user -> {
                        if (user instanceof IRBaseInst) ((IRBaseInst) user).accept(this);
                    });
                }
            }

            replaceUses();
            changed = removeUnexecutableBlock(function) || removeRedundantInst(function) || rewriteBranch(function);
        }
    }

    @Override
    public void runOnBlock(IRBlock block) {
        block.phiInsts.forEach(this::visit);
        block.instructions.forEach(inst -> inst.accept(this));
    }

    private void assign(Value dest, Value src) {
        BaseConst srcConst = getConst(src);
        if (srcConst == uncertain && getConst(dest) != uncertain) {
            lattice.put(dest, uncertain);
            valueWorklist.offer(dest);
        }
        else if (srcConst != null) {
            if (getConst(dest) == null) {
                int result;
                BaseConst replace = null;
                if (srcConst instanceof IntConst) result = ((IntConst) srcConst).constData;
                else if (srcConst instanceof BoolConst) result = ((BoolConst) srcConst).constData ? 1 : 0;
                else return;
                if (dest.type instanceof IntType) replace = new IntConst(result);
                else replace = new BoolConst(result != 0);
                lattice.put(dest, replace);
                dest.replaced(replace);
                valueWorklist.offer(dest);
            }
            else if (!getConst(dest).equals(getConst(srcConst))) {
                setUncertain(dest);
            }
        }
    }

    private void setUncertain(Value value) {
        if (getConst(value) != uncertain) {
            lattice.put(value, uncertain);
            valueWorklist.offer(value);
        }
    }

    private void setBlockExecutable(IRBlock block) {
        if (!executable.contains(block)) {
            Log.report("set exe", block.identifier());
            executable.add(block);
            blockWorklist.add(block);
        }
    }

    @Override
    public void visit(IRAllocaInst inst) {throw new UnknownError(inst);}

    @Override
    public void visit(IRBinaryInst inst) {
        if (getConst(inst.lhs()) == uncertain || getConst(inst.rhs()) == uncertain) {
            setUncertain(inst);
            return;
        }
        BaseConst lhsConst = getConst(inst.lhs()), rhsConst = getConst(inst.rhs());
        if (lhsConst != null && rhsConst != null && getConst(inst) == null) {
            BaseConst replace = null;
            if (lhsConst instanceof IntConst) {
                assert rhsConst instanceof IntConst;
                int lhsNum = ((IntConst) lhsConst).constData, rhsNum = ((IntConst) rhsConst).constData;
                int result = 0;
                switch (inst.op) {
                    case LLVM.AddInst: result = lhsNum + rhsNum; break;
                    case LLVM.SubInst: result = lhsNum - rhsNum; break;
                    case LLVM.MulInst: result = lhsNum * rhsNum; break;
                    case LLVM.DivInst:
                        // just a warning, because it may not be truly executed
                        if (rhsNum == 0) new ZeroDivisionWarning().tell();
                        else result = lhsNum / rhsNum;
                        break;
                    case LLVM.ModInst:
                        if (rhsNum == 0) new ZeroDivisionWarning().tell();
                        else result = lhsNum % rhsNum;
                        break;
                    case LLVM.AndInst: result = lhsNum & rhsNum; break;
                    case LLVM.OrInst: result = lhsNum | rhsNum; break;
                    case LLVM.XorInst: result = lhsNum ^ rhsNum; break;
                    case LLVM.ShiftLeftInst: result = lhsNum << rhsNum; break;
                    case LLVM.ShiftRightInst: result = lhsNum >> rhsNum; break;
                }
                replace = new IntConst(result);
            } else {
                assert lhsConst instanceof BoolConst;
                assert rhsConst instanceof BoolConst;
                boolean lhsNum = ((BoolConst) lhsConst).constData, rhsNum = ((BoolConst) rhsConst).constData;
                boolean result = false;
                switch (inst.op) {
                    case LLVM.AndInst: result = lhsNum & rhsNum; break;
                    case LLVM.OrInst: result = lhsNum | rhsNum; break;
                    case LLVM.XorInst: result = lhsNum ^ rhsNum; break;
                }
                replace = new BoolConst(result);
            }
            lattice.put(inst, replace);
            valueWorklist.offer(inst);
        }
    }

    @Override
    public void visit(IRBitCastInst inst) {
        assign(inst, inst.fromValue());
    }

    @Override
    public void visit(IRBrInst inst) {
        if (inst.isJump()) {
            Log.report("direct jump", inst.format());
            setBlockExecutable(inst.destBlock());
            return;
        }

        BaseConst condConst = getConst(inst.condition());
        if (condConst == uncertain) {
            setBlockExecutable(inst.ifTrueBlock());
            setBlockExecutable(inst.ifFalseBlock());
        }
        else if (condConst != null) {
            assert condConst instanceof BoolConst;
            boolean cond = ((BoolConst) condConst).constData;
            if (cond) setBlockExecutable(inst.ifTrueBlock());
            else setBlockExecutable(inst.ifFalseBlock());
        }
    }

    @Override
    public void visit(IRCallInst inst) {
        setUncertain(inst);
    }

    @Override
    public void visit(IRGetElementPtrInst inst) {
        setUncertain(inst);
    }

    @Override
    public void visit(IRICmpInst inst) {
        if (getConst(inst.lhs()) == uncertain || getConst(inst.rhs()) == uncertain) {
            setUncertain(inst);
            return;
        }
        BaseConst lhsConst = getConst(inst.lhs()), rhsConst = getConst(inst.rhs());
        if (lhsConst != null && rhsConst != null && getConst(inst) == null) {
            boolean result = false;
            if (lhsConst instanceof IntConst) {
                assert rhsConst instanceof IntConst;
                int lhsNum = ((IntConst) lhsConst).constData, rhsNum = ((IntConst) rhsConst).constData;
                switch (inst.op) {
                    case LLVM.LessArg: result = lhsNum < rhsNum; break;
                    case LLVM.LessEqualArg: result = lhsNum <= rhsNum; break;
                    case LLVM.GreaterArg: result = lhsNum > rhsNum; break;
                    case LLVM.GreaterEqualArg: result = lhsNum >= rhsNum; break;
                    case LLVM.EqualArg: result = lhsNum == rhsNum; break;
                    case LLVM.NotEqualArg: result = lhsNum != rhsNum; break;
                }
            }
            else if (lhsConst instanceof BoolConst) {
                assert rhsConst instanceof BoolConst;
                boolean lhsNum = ((BoolConst) lhsConst).constData, rhsNum = ((BoolConst) rhsConst).constData;
                switch (inst.op) {
                    case LLVM.EqualArg: result = lhsNum == rhsNum; break;
                    case LLVM.NotEqualArg: result = lhsNum != rhsNum; break;
                }
            }
            else {
                assert lhsConst instanceof NullptrConst;
                switch (inst.op) {
                    case LLVM.EqualArg: result = lhsConst.equals(rhsConst); break;
                    case LLVM.NotEqualArg: result = !lhsConst.equals(rhsConst); break;
                }
            }
            var replace = new BoolConst(result);
            lattice.put(inst, replace);
            valueWorklist.offer(inst);
        }
    }

    @Override
    public void visit(IRLoadInst inst) {
        setUncertain(inst);
    }

    @Override
    public void visit(IRPhiInst inst) {
        BaseConst first = getConst(inst.getOperand(0));
        for (int i = 2; i < inst.operandSize(); i += 2) {
            BaseConst now = getConst(inst.getOperand(i));
            if (now == null || now == uncertain || !executable.contains(inst.getOperand(i+1)) ||
                !now.equals(first)) {
                setUncertain(inst);
                return;
            }
        }
        lattice.put(inst, first);
        valueWorklist.offer(inst);
    }

    @Override
    public void visit(IRRetInst inst) {
        // no need
    }

    @Override
    public void visit(IRStoreInst inst) {
        // void inst
    }

    @Override
    public void visit(IRTruncInst inst) {
        assign(inst, inst.fromValue());
    }

    @Override
    public void visit(IRZextInst inst) {
        assign(inst, inst.fromValue());
    }

    @Override
    public void visit(IRMoveInst inst) {
        assign(inst.dest(), inst.source());
    }
}