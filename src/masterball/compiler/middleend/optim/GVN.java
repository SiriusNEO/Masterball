package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.DomTreeBuilder;
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
 *  @requirement: DomTreeBuilder
 */

public class GVN implements IRFuncPass {

    private boolean numberTarget(IRBaseInst inst) {
        return inst instanceof IRBinaryInst ||
               inst instanceof IRBitCastInst ||
               inst instanceof IRICmpInst ||
               inst instanceof IRTruncInst ||
               inst instanceof IRZextInst ||
               inst instanceof IRLoadInst;
    }

    private static class ValueNumber {
        Value value;
        ArrayList<ValueNumber> operandNum;

        static HashMap<Value, ValueNumber> value2NumMap = new HashMap<>();

        static void init() {
            value2NumMap.clear();
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
            if (value instanceof IRBaseInst && !(value instanceof IRPhiInst)) {
                this.operandNum = new ArrayList<>();
                for (Value operand : ((IRBaseInst) value).operands)
                    this.operandNum.add(getNumber(operand));
            }
        }

        @Override
        public int hashCode() {
            // instance of inst
            if (this.operandNum != null) {
                return this.operandNum.hashCode();
            }
            return this.value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ValueNumber)) return false;

            if (!(this.value instanceof IRBaseInst && ((ValueNumber) o).value instanceof IRBaseInst)) return false;

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
            else if (inst1 instanceof IRLoadInst) {
                return true;
            }

            return false;
        }
    }

    private static class NumberScope {

        HashMap<ValueNumber, Value> num2ValueMap = new HashMap<>();

        void set(Value value) {
            num2ValueMap.put(ValueNumber.getNumber(value), value);

            if (value instanceof IRBinaryInst && IRTranslator.isCommunicative(((IRBinaryInst) value).op)) {
                IRBaseInst newInst = ((IRBinaryInst) value).copy();
                Collections.reverse(newInst.operands);
                num2ValueMap.put(ValueNumber.getNumber(newInst), newInst);
            }
            else if (value instanceof IRICmpInst && IRTranslator.isCommunicative(((IRICmpInst) value).op)) {
                IRBaseInst newInst = ((IRICmpInst) value).copy();
                Collections.reverse(newInst.operands);
                num2ValueMap.put(ValueNumber.getNumber(newInst), newInst);
            }
        }

        Value getValue(ValueNumber number) {
            if (!num2ValueMap.containsKey(number)) return null;
            return num2ValueMap.get(number);
        }

        void removeAll() {
            num2ValueMap.clear();
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

    private void eliminate(IRBlock block) {
        var it = block.instructions.listIterator();

        var curScope = new NumberScope();
        scopeStack.push(curScope);

        while (it.hasNext()) {
            IRBaseInst inst = it.next();

            if (!inst.mayHaveSideEffects() || inst instanceof IRLoadInst) {
                if (numberTarget(inst)) {
                    var vInst = getAlias(inst);
                    if (vInst != null) {
                        it.remove();
                        inst.replaceAllUsesWith(vInst);
                    } else {
                        curScope.set(inst);
                    }
                }
            } else {
                curScope.removeAll();
            }
        }

        block.dtNode.sons.forEach(node -> eliminate(node.fromBlock));

        scopeStack.pop();
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("GVN", function.identifier());
        ValueNumber.init();
        new DomTreeBuilder(false).runOnFunc(function);
        eliminate(function.entryBlock);
    }
}
