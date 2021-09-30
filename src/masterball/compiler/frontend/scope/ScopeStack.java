package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.BaseRegistry;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.info.registry.VarRegistry;

import java.util.Stack;

public class ScopeStack {

    public Stack<BaseScope> scopeStack;

    public ScopeStack() {
        this.scopeStack = new Stack<BaseScope>();
    }

    public VarRegistry queryVarInStack(String name) {
        VarRegistry ret = null;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).queryVar(name);
            if (ret != null) break;
        }
        return ret;
    }

    public ClassRegistry queryClass(String name) {
        ClassRegistry ret = scopeStack.get(0).queryClass(name);
        return ret;
    }

    public FuncRegistry queryGlobalFunc(String name) {
        FuncRegistry ret = scopeStack.get(0).queryFunc(name);
        return ret;
    }

    public void stackReturn(VarType returnType) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncScope) {
                ((FuncScope) scopeStack.get(i)).catchedRet = returnType;
                return;
            }
        }
    }

    public boolean isInLoop() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof LoopScope) {
                return true;
            }
        }
        return false;
    }

    public boolean isInFunc() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncScope) {
                return true;
            }
        }
        return false;
    }

    public boolean isInClass() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof ClassScope) {
                return true;
            }
        }
        return false;
    }

    public void register(BaseRegistry registry) {
        if (scopeStack.peek() instanceof ClassScope) return;
        scopeStack.peek().register(registry);
    }

    public void push(BaseScope scope) {
        this.scopeStack.push(scope);
    }

    public void pop() {
        this.scopeStack.pop();
    }

}