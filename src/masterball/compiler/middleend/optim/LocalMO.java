package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.AliasAnalyzer;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.analyzer.DomTreeBuilder;
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
    // invaildate:
    // if there is a store, invalidate store and load.
    // load: write after read, store: write after write
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
        if (inst instanceof IRStoreInst) {
            HashSet<IRLoadInst> toRemoveL = new HashSet<>();
            HashSet<IRStoreInst> toRemoveS = new HashSet<>();
            for (IRLoadInst load : loadRecord)
                if (analyzer.mayAlias(((IRStoreInst) inst).storePtr(), load.loadPtr())) toRemoveL.add(load);
            for (IRStoreInst store : storeRecord)
                if (analyzer.mayAlias(store.storePtr(), ((IRStoreInst) inst).storePtr())) toRemoveS.add(store);
            loadRecord.removeAll(toRemoveL);
            storeRecord.removeAll(toRemoveS);
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
        new CFGBuilder().runOnFunc(function);
        new DomTreeBuilder(false).runOnFunc(function);

        function.blocks.forEach(this::runOnBlock);
    }

    @Override
    public void runOnBlock(IRBlock block) {
        loadRecord.clear();
        storeRecord.clear();

        if (block.prevs.size() == 1 && block.prevs.get(0).dtNode.doms.contains(block.dtNode)) {
            for (IRBaseInst inst : block.instructions) {
                invalidate(inst);
                if (inst instanceof IRLoadInst) loadRecord.add((IRLoadInst) inst);
                else if (inst instanceof IRStoreInst) storeRecord.add((IRStoreInst) inst);
            }
        }

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
                    loadRecord.add((IRLoadInst) inst);
                }
            }
            else if (inst instanceof IRStoreInst) {
                var replace = recordMatch(inst);
                if (replace != null) {
                    it.remove();
                }
                else {
                    invalidate(inst);
                    storeRecord.add((IRStoreInst) inst);
                }
            }
            else if (inst instanceof IRCallInst) {
                invalidate(inst);
            }
        }
    }
}
