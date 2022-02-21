package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBitCastInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.misc.UnionSet;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.HashMap;
import java.util.HashSet;

/**
 * simple alias analyzer implemented
 *
 * when will two pointers alias?
 *  - store
 *  - getelementptr
 *  - move (no appearance now)
 *
 * so start to think:
 *  edge: p* store in p**
 *
 *  start from call malloc / global, a new pointer, mark p* -> p**
 *  if there is a store: q* -> p**, mark p** uncertain.
 *
 *  alias between two pointers:
 *      if one is getelementptr, use headPointer to compare
 *          if headPointer is matched,
 *           check index (if index is constant)
 *           if index unsure, return mayAlias
 *
 *      if anyone is uncertain: return if type match (basic judge)
 *      if all certain, return equals
 *
 *  alloc: no appearance
 *
 */

public class AliasAnalyzer implements IRFuncPass {

    private HashSet<Value> certain = new HashSet<>();
    private UnionSet<Value> bitcastUnion = new UnionSet<>();

    @Override
    public void runOnFunc(IRFunction function) {

        certain.addAll(function.parentModule.globalVarSeg);

        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions) {
                if (inst instanceof IRCallInst && ((IRCallInst) inst).callFunc() == function.parentModule.getMalloc())
                    certain.add(inst);
                if (inst instanceof IRBitCastInst && ((IRBitCastInst) inst).fromValue().type instanceof PointerType)
                    bitcastUnion.setAlias(((IRBitCastInst) inst).fromValue(), inst);
            }
    }

    public boolean mayAlias(Value addr1, Value addr2) {
        addr1 = bitcastUnion.getAlias(addr1);
        addr2 = bitcastUnion.getAlias(addr2);

        if (certain.contains(addr1) && certain.contains(addr2)) return addr1.equals(addr2);

        // if (addr1)
        return false;
    }
}
