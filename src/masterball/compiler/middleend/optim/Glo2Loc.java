package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRLoadInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Glo2Loc Pass:
 * if a GlobalVariable is used many times in a function, localize it.
 * localize can be beneficial to optimization
 *
 * works well in the following case:
 *      int N;
 *      void func() {
 *          for (int i = 1; i < N; i++)
 *              ...
 *      }
 *
 * @requirement: Call Analyzer. Run before Mem2Reg
 */

public class Glo2Loc implements IRFuncPass {

    public static final int THRESHOLD = 5;

    private Map<GlobalVariable, Integer> refTimes = new HashMap<>();

    private Set<GlobalVariable> ableSet = new HashSet<>();

    public void collectAbleSet(IRFunction function) {

        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions) {

                Value global = null;

                if (inst instanceof IRLoadInst) {
                    global = ((IRLoadInst) inst).loadPtr();
                } else if (inst instanceof IRStoreInst) {
                    global = ((IRStoreInst) inst).storePtr();
                } else {
                    continue;
                }

                if (global instanceof GlobalVariable) {
                    refTimes.putIfAbsent((GlobalVariable) global, 1);
                    refTimes.put((GlobalVariable) global, refTimes.get(global) + 1);
                }
            }

        refTimes.forEach((global, times) -> {
            if (times >= THRESHOLD) ableSet.add(global);
        });
    }

    @Override
    public void runOnFunc(IRFunction function) {

        if (function.node.cyclic) return; // can not loc

    }
}
