package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.AliasAnalyzer;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.analyzer.DomTreeBuilder;
import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.*;

/**
 *  Global Value Numbering Pass
 *
 *  numbering every value with special hashCode
 *  numbering Inst with the hashCode of the ArrayList
 *  do some simple load eliminate (if no side effect before or in this Loop)
 *
 *  WARNING:
 *      this load elimination may cross-block, and I use checkLoad() to
 *      achieve the correctness. If any wrong happened, just remove the load part (use LocalMO)
 *
 *  @requirement: DomTreeBuilder
 */

public class GVN implements IRFuncPass {

    private AliasAnalyzer analyzer = new AliasAnalyzer();

    private static boolean numberTarget(Value value) {
        return value instanceof IRBinaryInst ||
                value instanceof IRBitCastInst ||
                value instanceof IRICmpInst ||
                value instanceof IRTruncInst ||
                value instanceof IRZextInst ||
                value instanceof IRGetElementPtrInst ||
                value instanceof IRLoadInst;
    }

    private static class ValueNumber {
        Value value;
        ArrayList<ValueNumber> operandNum;

        static HashMap<Value, ValueNumber> value2NumMap = new HashMap<>();
        static HashSet<IRLoadInst> invalidatedLoads = new HashSet<>();

        static void init() {
            value2NumMap.clear();
            invalidatedLoads.clear();
        }

        static ValueNumber getNumber(Value value) {
            if (value2NumMap.containsKey(value)) return value2NumMap.get(value);
            var vn = new ValueNumber(value);
            value2NumMap.put(value, vn);
            return vn;
        }

        /*
         * used in num2Value
         * first use hashCode (only the info of operands)
         * next use equals
         */

        public ValueNumber(Value value) {
            this.value = value;
            if (GVN.numberTarget(value)) {
                this.operandNum = new ArrayList<>();
                for (Value operand : ((IRBaseInst) value).operands)
                    this.operandNum.add(getNumber(operand));
            }
        }

        @Override
        public int hashCode() {
            // instance of inst
            if (this.operandNum != null) {
                return 233; // map to the same code, use equals to judge
            }
            return this.value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ValueNumber)) return false;

            if (!numberTarget(this.value) || !numberTarget(((ValueNumber) o).value)) {
                return this.value.equals(((ValueNumber) o).value);
            }

            if (this.value.getClass() != ((ValueNumber) o).value.getClass()) return false;

            if (this.operandNum.size() != ((ValueNumber) o).operandNum.size()) return false;

            for (int i = 0; i < this.operandNum.size(); i++)
                if (!this.operandNum.get(i).equals(((ValueNumber) o).operandNum.get(i))) return false;

            IRBaseInst inst1 = (IRBaseInst) this.value;
            IRBaseInst inst2 = (IRBaseInst) ((ValueNumber) o).value;

            if (inst1.getClass() != inst2.getClass()) return false;
            if (inst1 instanceof IRBinaryInst) {
                assert inst2 instanceof IRBinaryInst;
                return (Objects.equals(((IRBinaryInst) inst1).op, ((IRBinaryInst) inst2).op));
            }
            else if (inst1 instanceof IRBitCastInst) {
                assert inst2 instanceof  IRBitCastInst;
                return inst1.type.match(inst2.type);
            }
            else if (inst1 instanceof IRICmpInst) {
                assert inst2 instanceof IRICmpInst;
                return (Objects.equals(((IRICmpInst) inst1).op, ((IRICmpInst) inst2).op));
            }
            else if (inst1 instanceof IRTruncInst) {
                return inst1.type.match(inst2.type);
            }
            else if (inst1 instanceof IRZextInst) {
                return inst1.type.match(inst2.type);
            }
            else if (inst1 instanceof IRGetElementPtrInst) {
                return true;
            }
            else if (inst1 instanceof IRLoadInst) {
                return !invalidatedLoads.contains(inst1) && !invalidatedLoads.contains(inst2);
            }

            return false;
        }
    }

    private static class NumberScope {

        HashMap<ValueNumber, Value> num2ValueMap = new HashMap<>();
        static ArrayList<ValueNumber> loadCollection = new ArrayList<>();

        void set(Value value) {
            num2ValueMap.put(ValueNumber.getNumber(value), value);

            if (value instanceof IRBinaryInst && IRTranslator.isCommunicative(((IRBinaryInst) value).op)) {
                IRBaseInst newInst = ((IRBinaryInst) value).copy();
                Collections.reverse(newInst.operands);
                // notice: this is for mapping "add a b" and "add b a" to the same value
                // so newInst is just for indexing, not used as a value
                num2ValueMap.put(ValueNumber.getNumber(newInst), value);
            }
            else if (value instanceof IRICmpInst && IRTranslator.isCommunicative(((IRICmpInst) value).op)) {
                IRBaseInst newInst = ((IRICmpInst) value).copy();
                Collections.reverse(newInst.operands);
                num2ValueMap.put(ValueNumber.getNumber(newInst), value);
            }

            if (value instanceof IRLoadInst) loadCollection.add(ValueNumber.getNumber(value));
        }

        Value getValue(ValueNumber number) {
            if (!num2ValueMap.containsKey(number)) {
                return null;
            }
            return num2ValueMap.get(number);
        }

        void removeAllLoads() {
            loadCollection.forEach(load -> {
                num2ValueMap.remove(load);
                ValueNumber.invalidatedLoads.add((IRLoadInst) load.value);
            });
        }
    }

    private Stack<NumberScope> scopeStack = new Stack<NumberScope>();

    private Value getAlias(Value value) {
        var num = ValueNumber.getNumber(value);
        Value ret = null;

        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).getValue(num);
            if (ret != null) break;
        }

        return ret;
    }

    private boolean checkLoad(IRBaseInst inst) {
        if (!(inst instanceof IRLoadInst)) return true;
        if (inst.parentBlock.belongLoop == null) return true;
        return inst.parentBlock.belongLoop.isInstInvariant(inst, analyzer);
    }

    private void invalidateLoad() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            scopeStack.get(i).removeAllLoads();
        }
        NumberScope.loadCollection.clear();
    }

    private void eliminate(IRBlock block) {
        var it = block.instructions.listIterator();

        var curScope = new NumberScope();
        scopeStack.push(curScope);

        // Log.info(block.identifier());

        while (it.hasNext()) {
            IRBaseInst inst = it.next();

            if (!inst.mayHaveSideEffects() || inst instanceof IRLoadInst) {
                if (numberTarget(inst)) {
                    var vInst = getAlias(inst);
                    if (vInst != null && checkLoad(inst)) {
                        it.remove();
                        inst.replaceAllUsesWith(vInst);
                    } else {
                        // Log.info("null", inst.format());
                        curScope.set(inst);
                    }
                }
            } else {
                invalidateLoad();
            }
        }

        block.dtNode.sons.forEach(node -> eliminate(node.fromBlock));

        scopeStack.pop();
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("GVN", function.identifier(), function.blocks.size());
        analyzer.runOnFunc(function);
        ValueNumber.init();
        new CFGBuilder().runOnFunc(function);
        new DomTreeBuilder(false).runOnFunc(function);
        new LoopAnalyzer().runOnFunc(function);
        eliminate(function.entryBlock);
    }
}