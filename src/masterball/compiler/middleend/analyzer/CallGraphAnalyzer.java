package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.share.pass.IRModulePass;
import masterball.debug.Log;

import java.util.HashSet;
import java.util.Stack;

public class CallGraphAnalyzer implements IRModulePass {

    public static class Node {
        public IRFunction fromFunc;
        public HashSet<Value> glbUses = new HashSet<>(), glbDefs = new HashSet<>();

        public HashSet<IRCallInst> call = new HashSet<>();
        public HashSet<IRFunction> caller = new HashSet<>(), callee = new HashSet<>();

        // A call A, or A call B, B call A ...
        public boolean cyclic = false;

        public Node(IRFunction fromFunc) {
            this.fromFunc = fromFunc;
        }

        public void init() {
            glbUses = new HashSet<>();
            glbDefs = new HashSet<>();
            caller = new HashSet<>();
            callee = new HashSet<>();
            cyclic = false;
        }
    }

    private HashSet<IRFunction> visited = new HashSet<>();
    private Stack<IRFunction> callStack = new Stack<>();

    private void init(IRModule module) {
        module.functions.forEach(function -> function.node.init());
    }

    private void callGraphBuild(IRModule module) {
        for (IRFunction function : module.functions)
            for (IRBlock block : function.blocks)
                for (IRBaseInst inst : block.instructions) {
                    if (inst instanceof IRCallInst) {
                        function.node.call.add((IRCallInst) inst);

                        IRFunction callee = ((IRCallInst) inst).callFunc();
                        callee.node.caller.add(function);
                        function.node.callee.add(callee);
                    }
                    // glb use: load or store
                    inst.operands.forEach(operand -> {
                        if (operand instanceof GlobalVariable) function.node.glbUses.add(operand);
                    });
                    // glb def: store
                    if (inst instanceof IRStoreInst && ((IRStoreInst) inst).storePtr() instanceof GlobalVariable)
                        function.node.glbDefs.add(((IRStoreInst) inst).storePtr());
                }

        // my callee's use is my use
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRFunction function : module.functions)
                for (IRFunction callee : function.node.callee)
                    for (Value use : callee.node.glbUses)
                        if (!function.node.glbUses.contains(use)) {
                            function.node.glbUses.add(use);
                            changed = true;
                        }
        }

        // def is not necessary to propagation because it will be considered in callee
    }

    private void callGraphAnalysis(IRFunction function) {
        if (visited.contains(function)) return;
        visited.add(function);
        callStack.push(function);

        for (IRFunction caller : callStack)
            if (function.node.callee.contains(caller)) {
                function.node.cyclic = true; // caller -> ... -> function -> caller
                break;
            }

        function.node.callee.forEach(this::callGraphAnalysis);
        callStack.pop();
    }

    @Override
    public void runOnModule(IRModule module) {
        init(module);
        callGraphBuild(module);
        for (IRFunction function : module.functions)
            if (!visited.contains(function)) callGraphAnalysis(function);
    }
}
