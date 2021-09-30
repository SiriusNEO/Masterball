package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.error.semantic.NameError;
import masterball.compiler.frontend.error.semantic.ScopeError;
import masterball.compiler.frontend.error.semantic.TypeError;
import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.info.VarRegistry;
import masterball.compiler.frontend.scope.GlobalScope;
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
        if (node.conditionExpNode.type.match(Type.BasicType.BOOL)) {
            throw new TypeError(
                    node.codePos, node.conditionExpNode.type, Type.BasicType.BOOL
            );
        }
        node.ifTrueStmtNode.accept(this);
        node.elseStmtNode.accept(this);
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.conditionExpNode.accept(this);
        if (node.conditionExpNode.type.match(Type.BasicType.BOOL)) {
            throw new TypeError(
                    node.codePos, node.conditionExpNode.type, Type.BasicType.BOOL
            );
        }
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
    }

    @Override
    public void visit(ForStmtNode node) {
        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        node.conditionExpNode.accept(this);
        if (node.conditionExpNode.type.match(Type.BasicType.BOOL)) {
            throw new TypeError(
                    node.codePos, node.conditionExpNode.type, Type.BasicType.BOOL
            );
        }
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (!scopeStack.isInFunc()) throw new ScopeError(node.codePos, ScopeError.wrongReturn);
        if (node.retExpNode != null) node.retExpNode.accept(this);
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
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
    }

    @Override
    public void visit(BinaryExpNode node) {
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
    }

    @Override
    public void visit(IndexExpNode node) {
        if (node.arrayExpNode != null) node.arrayExpNode.accept(this);
        if (node.indexExpNode != null) node.indexExpNode.accept(this);
    }

    @Override
    public void visit(MemberExpNode node) {
        if (node.superExpNode != null) node.superExpNode.accept(this);
        if (node.memberExpNode != null) node.memberExpNode.accept(this);
    }

    @Override
    public void visit(NewExpNode node) {
        //todo
    }

    @Override
    public void visit(PostfixExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
    }

    @Override
    public void visit(PrefixExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
    }

    @Override
    public void visit(UnaryExpNode node) {
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
    }

    @Override
    public void visit(LambdaExpNode node) {
        //todo
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null)
            node.type = new Type(Type.BasicType.INT);
        else if (node.ctx.StringConstant() != null)
            node.type = new Type(Type.BasicType.STRING);
        else if (node.ctx.TrueConstant() != null || node.ctx.FalseConstant() != null)
            node.type = new Type(Type.BasicType.BOOL);
        else if (node.ctx.NullConstant() != null)
            node.type = new Type(Type.BasicType.NULL);
        else if (node.ctx.ThisPointer() != null)
            node.type = new Type(Type.BasicType.THIS);
        else if (node.ctx.Identifier() != null) {
            VarRegistry varRegistry = scopeStack.queryVarInStack(node.ctx.Identifier().getText());
            if (varRegistry == null)
                throw new NameError(node.codePos, NameError.undefined, node.ctx.Identifier().getText());
            node.type = varRegistry.type;
        }
    }
}
