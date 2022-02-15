package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.share.misc.Pair;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  Common Subexpression Elimination Pass
 *
 *  just in a Block now
 */

public class CSE implements IRFuncPass {

    private static boolean effectMatch(IRBaseInst inst1, IRBaseInst inst2) {
        if (inst1.getClass() != inst2.getClass()) return false;
        if (inst1 instanceof IRBinaryInst) {
            assert inst2 instanceof IRBinaryInst;
            if (Objects.equals(((IRBinaryInst) inst1).op, ((IRBinaryInst) inst2).op)) {
                return (((IRBinaryInst) inst1).lhs().equals(((IRBinaryInst) inst2).lhs()) &&
                        ((IRBinaryInst) inst1).rhs().equals(((IRBinaryInst) inst2).rhs()));
            }
        }
        else if (inst1 instanceof IRBitCastInst) {
            assert inst2 instanceof  IRBitCastInst;
            return ((IRBitCastInst) inst1).fromValue().equals(((IRBitCastInst) inst2).fromValue()) &&
                    inst1.type.match(inst2.type);
        }
        else if (inst1 instanceof IRICmpInst) {
            assert inst2 instanceof IRICmpInst;
            if (Objects.equals(((IRICmpInst) inst1).op, ((IRICmpInst) inst2).op)) {
                return ((IRICmpInst) inst1).lhs().equals(((IRICmpInst) inst2).lhs()) &&
                        ((IRICmpInst) inst1).rhs().equals(((IRICmpInst) inst2).rhs());
            }
        }
        else if (inst1 instanceof IRTruncInst) {
            return ((IRTruncInst) inst1).fromValue().equals(((IRTruncInst) inst2).fromValue()) &&
                    inst1.type.match(inst2.type);
        }
        else if (inst1 instanceof IRZextInst) {
            return ((IRZextInst) inst1).fromValue().equals(((IRZextInst) inst2).fromValue()) &&
                    inst1.type.match(inst2.type);
        }

        return false;
    }

    private void eliminate(IRBlock block) {
        ArrayList<IRBaseInst> exprList = new ArrayList<>();
        Map<IRBaseInst, IRBaseInst> replaceMap = new HashMap<>();

        for (IRBaseInst inst : block.instructions) {
            boolean hit = false;
            for (IRBaseInst expr : exprList) {
                if (effectMatch(inst, expr)) {
                    hit = true;
                    replaceMap.put(inst, expr);
                    break;
                }
            }
            if (!hit && !inst.mayHaveSideEffects()) exprList.add(inst);
        }

        var it = block.instructions.iterator();

        while (it.hasNext()) {
            IRBaseInst inst = it.next();
            if (replaceMap.containsKey(inst)) {
                it.remove();
                inst.replaceAllUsesWith(replaceMap.get(inst));
            }
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("CSE", function.identifier());
        function.blocks.forEach(this::eliminate);
    }
}
