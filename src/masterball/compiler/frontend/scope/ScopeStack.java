package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.ast.node.BaseNode;
import masterball.compiler.frontend.info.Registry;
import masterball.compiler.frontend.info.VarRegistry;

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

    public GlobalScope global() {
        return (GlobalScope) scopeStack.peek();
    }

    public boolean isInLoop() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof LoopScope ) {
                return true;
            }
        }
        return false;
    }

    public boolean isInFunc() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncArgScope) {
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

    public void register(Registry registry) {
        scopeStack.peek().register(registry);
    }

    public void push(BaseScope scope) {
        this.scopeStack.push(scope);
    }

    public void pop() {
        this.scopeStack.pop();
    }

}