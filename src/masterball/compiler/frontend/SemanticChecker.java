package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.error.semantic.*;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.FuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.scope.ScopeStack;
import masterball.compiler.utils.GrammarTable;
import masterball.debugger.Log;

import java.util.Objects;

public class SemanticChecker implements ASTVisitor {

    ScopeStack scopeStack = new ScopeStack();

    @Override
    public void visit(RootNode node) {
        scopeStack.push(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        scopeStack.pop();
    }

    @Override
    public void visit(ClassDefNode node) {
        scopeStack.push(node.classRegistry.scope);
        if (node.constructorDefNode != null) visit(node.constructorDefNode);
        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));
        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));
        scopeStack.pop();
    }

    @Override
    public void visit(FuncDefNode node) {
        scopeStack.push(node.funcRegistry.scope);
        node.funcRegistry.funcArgs.forEach(registry -> scopeStack.register(registry));
        if (node.suiteNode != null) visit(node.suiteNode);
        scopeStack.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        Log.report(node.varRegistry);
        scopeStack.register(node.varRegistry);
        if (node.initExpNode != null) {
            node.initExpNode.accept(this);
            Log.report(node.varRegistry.type);
            if (!node.varRegistry.type.match(node.initExpNode.type)) {
                throw new TypeError(
                        node.codePos, node.varRegistry.type, node.initExpNode.type
                );
            }
        }
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
    }

    @Override
    public void visit(SuiteNode node) {
        scopeStack.push(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        scopeStack.pop();
    }

    @Override
    public void visit(SuiteStmtNode node) {
        visit(node.suiteNode);
    }

    @Override
    public void visit(IfStmtNode node) {
        node.conditionExpNode.accept(this);
        if (!node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
        node.ifTrueStmtNode.accept(this);
        if (node.elseStmtNode != null) node.elseStmtNode.accept(this);
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.conditionExpNode.accept(this);
        if (node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
    }

    @Override
    public void visit(ForStmtNode node) {
        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        node.conditionExpNode.accept(this);
        if (node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (!scopeStack.isInFunc()) throw new ScopeError(node.codePos, ScopeError.wrongReturn);
        if (node.retExpNode != null) {
            node.retExpNode.accept(this);
            scopeStack.stackReturn((VarType) node.retExpNode.type);
        }
    }

    @Override
    public void visit(ControlStmtNode node) {
        if (!scopeStack.isInLoop()) {
            if (Objects.equals(node.controlWord, GrammarTable.breakKw))
                throw new ScopeError(node.codePos, ScopeError.wrongBreak);
            else
                throw new ScopeError(node.codePos, ScopeError.wrongContinue);
        }
    }

    @Override
    public void visit(PureStmtNode node) {
        if (node.expNode != null) node.expNode.accept(this);
    }

    @Override
    public void visit(AssignExpNode node) {
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (!node.lhsExpNode.isLeftValue()) {
            throw new AssignmentError(node.codePos, AssignmentError.expectLeftValue);
        }
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
    }

    @Override
    public void visit(BinaryExpNode node) {
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        int result = ((FuncType) node.callExpNode.type).funcCallMatch(node.callArgExpNodes);

        if (result == -1) {
            throw new FuncCallError(node.codePos, FuncCallError.argcNotMatch);
        } else if (result == -2) {
            throw new FuncCallError(node.codePos, FuncCallError.argTypeNotMatch);
        }
        node.type = ((FuncType) node.callExpNode.type).retType.copy();
    }

    @Override
    public void visit(IndexExpNode node) {
        if (node.arrayExpNode != null) node.arrayExpNode.accept(this);
        if (node.indexExpNode != null) node.indexExpNode.accept(this);
        assert node.arrayExpNode != null;
        VarType arrayType = (VarType) node.arrayExpNode.type;
        if (arrayType.dimension == 0)
            throw new TypeError(node.codePos, TypeError.typeNotSubscribable, node.arrayExpNode.type);
        assert node.indexExpNode != null;
        if (!node.indexExpNode.type.match(BaseType.BuiltinType.INT))
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.indexExpNode.type);

        node.type = arrayType.copy();
        ((VarType) node.type).dimension--;
    }

    @Override
    public void visit(MemberExpNode node) {
        if (node.superExpNode != null) node.superExpNode.accept(this);
        assert node.superExpNode != null;
        if (!node.superExpNode.type.match(BaseType.BuiltinType.CLASS)) {
            throw new TypeError(node.codePos, TypeError.typeNotCallable, node.superExpNode.type);
        }
        String className = ((VarType) node.superExpNode.type).className;
        ClassRegistry classRegistry = scopeStack.queryClass(className);
        if (classRegistry == null) {
            throw new NameError(node.codePos, NameError.undefined, className);
        }
        if (classRegistry.scope.funcTable.containsKey(node.memberName)) {
            node.type = classRegistry.scope.funcTable.get(node.memberName).type.copy();
        }
        else if (classRegistry.scope.varTable.containsKey(node.memberName)) {
            node.type = classRegistry.scope.varTable.get(node.memberName).type.copy();
        }
        else {
            throw new NameError(node.codePos, NameError.undefined, node.memberName);
        }
    }

    @Override
    public void visit(NewExpNode node) {
        //todo
    }

    @Override
    public void visit(PostfixExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        assert node.selfExpNode != null;
        if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
        }
        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(PrefixExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        assert node.selfExpNode != null;
        if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
        }
        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(UnaryExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        if (Objects.equals(node.op, GrammarTable.LogicNotOp)) {
            assert node.selfExpNode != null;
            if (!node.selfExpNode.type.match(BaseType.BuiltinType.BOOL)) {
                throw new TypeError(node.codePos, BaseType.BuiltinType.BOOL, node.selfExpNode.type);
            }
        } else {
            assert node.selfExpNode != null;
            if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
                throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
            }
        }
        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(LambdaExpNode node) {
        //todo
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null)
            node.type = new VarType(BaseType.BuiltinType.INT);
        else if (node.ctx.StringConstant() != null)
            node.type = new VarType(BaseType.BuiltinType.STRING);
        else if (node.ctx.TrueConstant() != null || node.ctx.FalseConstant() != null)
            node.type = new VarType(BaseType.BuiltinType.BOOL);
        else if (node.ctx.NullConstant() != null)
            node.type = new VarType(BaseType.BuiltinType.NULL);
        else if (node.ctx.ThisPointer() != null)
            node.type = new VarType(BaseType.BuiltinType.THIS);
        else if (node.ctx.Identifier() != null) {

            VarRegistry varRegistry = scopeStack.queryVarInStack(node.ctx.Identifier().getText());
            FuncRegistry funcRegistry = scopeStack.queryGlobalFunc(node.ctx.Identifier().getText());

            if (varRegistry != null) {
                node.type = varRegistry.type.copy();
            }
            else if (funcRegistry != null) {
                node.type = funcRegistry.type.copy();
            }
            else {
                throw new NameError(node.codePos, NameError.undefined, node.ctx.Identifier().getText());
            }
        }
    }
}
