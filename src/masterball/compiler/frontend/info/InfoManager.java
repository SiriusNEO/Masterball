package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.BaseRegistry;
import masterball.compiler.frontend.info.scope.BaseScope;
import masterball.compiler.frontend.info.scope.ClassScope;
import masterball.compiler.frontend.info.scope.FuncScope;
import masterball.compiler.frontend.info.scope.LoopScope;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.share.misc.Pair;

import java.util.Stack;

public class InfoManager {

    public Stack<BaseScope> scopeStack;
    public ClassRegistry nowClass = null;

    public InfoManager() {
        this.scopeStack = new Stack<>();
    }

    public VarRegistry queryVarInStack(String name) {
        VarRegistry ret = null;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).queryVar(name);
            if (ret != null) break;
        }
        return ret;
    }

    // in IR, a variable is reachable if and only if it has value.
    public Pair<VarRegistry, Boolean> queryVarWithValue(String name) {
        VarRegistry ret = null;
        boolean isMember = false;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).queryVar(name);
            if (ret != null && ret.value != null) {
                if (scopeStack.get(i) instanceof ClassScope) isMember = true;
                break;
            }
        }
        return new Pair<>(ret, isMember);
    }

    public ClassRegistry queryClass(String name) {
        return scopeStack.get(0).queryClass(name);
    }

    public FuncRegistry queryFuncInStack(String name) {
        FuncRegistry ret = null;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).queryFunc(name);
            if (ret != null) break;
        }
        return ret;
    }

    public void stackReturn(VarType returnType) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncScope) {
                ((FuncScope) scopeStack.get(i)).catchedRetTypeList.add(returnType);
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

    public ClassRegistry getNowClass() {
        return nowClass;
    }

    public void register(BaseRegistry registry) {
        if (scopeStack.peek() instanceof ClassScope) return;
        scopeStack.peek().register(registry);
    }

    public void push(BaseScope scope) {
        assert scope != null;
        this.scopeStack.push(scope);
    }

    public void push(ClassRegistry registry) {
        assert registry.scope != null;
        this.scopeStack.push(registry.scope);
        this.nowClass = registry;
    }

    public void pop() {
        if (this.scopeStack.peek() instanceof ClassScope)
            this.nowClass = null;
        this.scopeStack.pop();
    }

}