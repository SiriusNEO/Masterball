package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRAllocaInst;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRLoadInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Glo2Loc Pass:
 *
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
 * @requirement: Call Analyzer. Run before Mem2Reg because it introduces alloc
 */

public class Glo2Loc implements IRFuncPass {

    public static final int THRESHOLD = 4;

    private Map<GlobalVariable, Integer> refTimes = new HashMap<>();
    private Set<GlobalVariable> ableSet = new HashSet<>();

    private void collectAbleSet(IRFunction function) {

        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions) {

                Value global;

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

        //  If a global variable is used in the callee function, it is likely it will be modified,
        //  and that causes side effects.

        for (var global : refTimes.keySet()) {
            // Log.report("ref times", global.identifier(), refTimes.get(global));
            if (refTimes.get(global) >= THRESHOLD) {
                boolean check = true;
                for (IRFunction callee : function.node.callee) {
                    if (callee.node.glbUses.contains(global)) {
                        check = false;
                        break;
                    }
                }
                if (check) ableSet.add(global);
            }
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        if (function.node.cyclic) return;
        if (function.name.equals(LLVM.InitFuncName)) return;

        collectAbleSet(function);

        // Log.mark("able set: " + function.identifier());
        // ableSet.forEach(glb -> Log.report(glb.identifier()));

        for (GlobalVariable global : ableSet) {
            IRBaseInst initLoad = new IRLoadInst(global, null),
                       initAlloc = new IRAllocaInst(LLVM.LocalPrefix + global.name, ((PointerType) global.type).pointedType, null),
                       initStore = new IRStoreInst(initAlloc, initLoad, null);

            // Notice that "tAddFirst" method is like the stack
            // Therefore the correct order of these three insts is:
            // 1. alloc space for local
            // 2. load value from global
            // 3. store value to local

            function.entryBlock.tAddFirst(initStore);
            function.entryBlock.tAddFirst(initLoad);
            function.entryBlock.tAddFirst(initAlloc);
            IRBaseInst writeBackLoad = null, writeBackStore = null;
            // if the function doesn't modify it, there is no need to store back
            if (function.node.glbDefs.contains(global)) {
                 writeBackLoad = new IRLoadInst(initAlloc, null);
                 writeBackStore = new IRStoreInst(global, writeBackLoad, null);
                function.exitBlock.tAddFirst(writeBackStore);
                function.exitBlock.tAddFirst(writeBackLoad);
            }

            for (IRBlock block : function.blocks)
                for (IRBaseInst inst : block.instructions) {
                    if (inst instanceof IRLoadInst && global == ((IRLoadInst) inst).loadPtr() &&
                            inst != initLoad && inst != writeBackLoad) {
                        ((IRLoadInst) inst).replacePtr(initAlloc);
                    }
                    else if (inst instanceof IRStoreInst && global == ((IRStoreInst) inst).storePtr() &&
                            inst != initStore && inst != writeBackStore) {
                        ((IRStoreInst) inst).replacePtr(initAlloc);
                    }
                }
        }
    }
}
