package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.AliasAnalyzer;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRLoadInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.HashSet;

/**
 *  Local Memory-related Optimization Pass
 *
 *  this pass intends to modify instructions so that it is faster in BackEnd
 *
 */

public class LocalMO implements IRFuncPass, IRBlockPass {

    AliasAnalyzer analyzer = new AliasAnalyzer();

    // load match load, store match store
    // load invalidate store, store invalidate load
    HashSet<IRLoadInst> loadRecord = new HashSet<>();
    HashSet<IRStoreInst> storeRecord = new HashSet<>();

    private Value recordMatch(IRBaseInst inst) {
        if (inst instanceof IRLoadInst) {
            for (IRLoadInst load : loadRecord)
                if (load.loadPtr() == ((IRLoadInst) inst).loadPtr())
                    return load;
        }
        else if (inst instanceof IRStoreInst) {
            for (IRStoreInst store : storeRecord)
                if (store.storePtr() == ((IRStoreInst) inst).storePtr() &&
                        store.storeValue().equals(((IRStoreInst) inst).storeValue()))
                    return store;
        }

        return null;
    }

    private void invalidate(IRBaseInst inst) {
        if (inst instanceof IRLoadInst) {
            HashSet<IRStoreInst> toRemove = new HashSet<>();
            for (IRStoreInst store : storeRecord)
                if (analyzer.mayAlias(inst, store)) toRemove.add(store);
            storeRecord.removeAll(toRemove);
        }
        else if (inst instanceof IRStoreInst) {
            HashSet<IRLoadInst> toRemove = new HashSet<>();
            for (IRLoadInst load : loadRecord)
                if (analyzer.mayAlias(inst, load)) toRemove.add(load);
            loadRecord.removeAll(toRemove);
        }
        else if (inst instanceof IRCallInst) {
            loadRecord.clear();
            storeRecord.clear();
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("local mem opt", function.identifier());

        analyzer.runOnFunc(function);
        function.blocks.forEach(this::runOnBlock);
    }

    @Override
    public void runOnBlock(IRBlock block) {
        var it = block.instructions.listIterator();

        while (it.hasNext()) {
            IRBaseInst inst = it.next();

            if (inst instanceof IRLoadInst) {
                var replace = recordMatch(inst);
                if (replace != null) {
                    it.remove();
                    inst.replaceAllUsesWith(replace);
                }
                else {
                    invalidate(inst);
                }
            }
            else if (inst instanceof IRStoreInst) {
                var replace = recordMatch(inst);
                if (replace != null) {
                    it.remove();
                }
                else {
                    invalidate(inst);
                }
            }
            else if (inst instanceof IRCallInst) {
                invalidate(inst);
            }
        }
    }
}
