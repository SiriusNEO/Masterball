package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.utils.error.semantic.*;
import masterball.compiler.frontend.info.ArrayBuiltinMethods;
import masterball.compiler.frontend.info.StringBuiltinMethods;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.FuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.StackManager;
import masterball.compiler.utils.MxStarTable;

import java.util.Objects;

public class SemanticChecker implements ASTVisitor {

    private final StackManager stackManager = new StackManager();

    @Override
    public void visit(RootNode node) {
        stackManager.push(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        stackManager.pop();
    }

    @Override
    public void visit(ClassDefNode node) {
        stackManager.push(node.classRegistry); // update nowClass
        if (node.constructorDefNode != null) visit(node.constructorDefNode);
        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));
        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));
        stackManager.pop();
    }

    @Override
    public void visit(FuncDefNode node) {
        stackManager.push(node.funcRegistry.scope);

        // query class type
        for (VarRegistry registry : node.funcRegistry.funcArgs) {
            if (registry.type.builtinType == BaseType.BuiltinType.CLASS &&
                    stackManager.queryClass(registry.type.className) == null) {
                throw new NameError(node.codePos, NameError.undefined, registry.type.className);
            }
            stackManager.register(registry);
        }

        assert node.suiteNode != null;
        visit(node.suiteNode);

        if (node.funcRegistry.scope.catchedRetTypeList.isEmpty()) { //no return statement
            if (!node.isValidMainFunc() && !node.funcRegistry.type.retType.match(BaseType.BuiltinType.VOID)) {
                throw new FuncReturnError(node.codePos, FuncReturnError.noReturn);
            }
        }
        else {
            // check every return statement
            for (VarType catchedRetType : node.funcRegistry.scope.catchedRetTypeList) {
                // retType != null
                assert node.funcRegistry.type.retType != null;
                if (!node.funcRegistry.type.retType.match(catchedRetType)) {
                    throw new FuncReturnError(node.codePos, FuncReturnError.retTypeNotMatch);
                }
            }
        }

        stackManager.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        // from right to left, init first, register after
        if (node.initExpNode != null) {
            node.initExpNode.accept(this);

            if (node.varRegistry.type.builtinType == BaseType.BuiltinType.CLASS &&
               stackManager.queryClass(node.varRegistry.type.className) == null) {
                throw new NameError(node.codePos, NameError.undefined, node.varRegistry.type.className);
            }

            TypeMatcher.match(node);
        }

        stackManager.register(node.varRegistry);
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
    }

    @Override
    public void visit(SuiteNode node) {
        stackManager.push(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        stackManager.pop();
    }

    @Override
    public void visit(SuiteStmtNode node) {
        visit(node.suiteNode);
    }

    @Override
    public void visit(IfStmtNode node) {
        node.conditionExpNode.accept(this);

        TypeMatcher.match(node);

        stackManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        stackManager.pop();

        if (node.elseStmtNode != null) {
            stackManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            stackManager.pop();
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        stackManager.push(node.scope);

        node.conditionExpNode.accept(this);

        TypeMatcher.match(node);

        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);

        stackManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        stackManager.push(node.scope);

        if (node.initExpNode != null) node.initExpNode.accept(this);

        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));

        if (node.conditionExpNode != null) {
            node.conditionExpNode.accept(this);
            TypeMatcher.match(node);
        }

        if (node.incrExpNode != null) node.incrExpNode.accept(this);

        assert node.bodyStmtNode != null;
        node.bodyStmtNode.accept(this);

        stackManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (!stackManager.isInFunc()) throw new ScopeError(node.codePos, ScopeError.wrongReturn);
        if (node.retExpNode != null) {
            node.retExpNode.accept(this);
            stackManager.stackReturn((VarType) node.retExpNode.type);
        } else {
            stackManager.stackReturn(new VarType(BaseType.BuiltinType.VOID));
        }
    }

    @Override
    public void visit(ControlStmtNode node) {
        if (!stackManager.isInLoop()) {
            if (Objects.equals(node.controlWord, MxStarTable.breakKw))
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
        assert node.lhsExpNode != null;
        assert node.rhsExpNode != null;

        node.rhsExpNode.accept(this);
        node.lhsExpNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.rhsExpNode.type.copy();
    }

    @Override
    public void visit(BinaryExpNode node) {
        assert node.lhsExpNode != null;
        assert node.rhsExpNode != null;
        node.lhsExpNode.accept(this);
        node.rhsExpNode.accept(this);

        TypeMatcher.match(node);

        if (Objects.equals(node.opType, MxStarTable.compareOpType) || Objects.equals(node.opType, MxStarTable.equalOpType)) {
            node.type = new VarType(BaseType.BuiltinType.BOOL);
        } else {
            node.type = node.rhsExpNode.type.copy();
        }
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));

       if (!(node.callExpNode.type instanceof FuncType)) { // try again, func name query
           if (!(node.callExpNode instanceof AtomExpNode)) {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
           if (((AtomExpNode) node.callExpNode).ctx.Identifier() == null) {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
           FuncRegistry funcRegistry = stackManager.queryFuncInStack(((AtomExpNode) node.callExpNode).ctx.Identifier().getText());
           if (funcRegistry != null) {
                node.callExpNode.type = funcRegistry.type.copy(); // forced type conversion
           } else {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
       }

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

        TypeMatcher.match(node);

        node.type = node.arrayExpNode.type.copy();
        ((VarType) node.type).dimension--;
    }

    @Override
    public void visit(MemberExpNode node) {
        if (node.superExpNode != null) node.superExpNode.accept(this);
        assert node.superExpNode != null;

        // string & array all have builtin methods.
        if (node.superExpNode.type.match(BaseType.BuiltinType.STRING)) {
            if (StringBuiltinMethods.scope.funcTable.containsKey(node.memberName)) {
                node.type = StringBuiltinMethods.scope.queryFunc(node.memberName).type.copy();
                return;
            }
        }

        if (((VarType) node.superExpNode.type).dimension > 0) {
            if (ArrayBuiltinMethods.scope.funcTable.containsKey(node.memberName)) {
                node.type = ArrayBuiltinMethods.scope.queryFunc(node.memberName).type.copy();
            }
            return;
        }

        TypeMatcher.match(node);

        String className = ((VarType) node.superExpNode.type).className;
        ClassRegistry classRegistry = stackManager.queryClass(className);
        if (classRegistry == null) {
            throw new NameError(node.codePos, NameError.undefined, className);
        }
        if (classRegistry.scope.funcTable.containsKey(node.memberName)) {
            node.type = classRegistry.scope.queryFunc(node.memberName).type.copy();
        }
        else if (classRegistry.scope.varTable.containsKey(node.memberName)) {
            node.type = classRegistry.scope.queryVar(node.memberName).type.copy();
        }
        else {
            throw new NameError(node.codePos, NameError.undefined, node.memberName);
        }
    }

    @Override
    public void visit(NewExpNode node) {
        node.eachDimExpNodes.forEach(sonnode -> sonnode.accept(this));

        TypeMatcher.match(node);

        //new type is assigned in ASTBuilder
    }

    @Override
    public void visit(PostfixExpNode node) {
        assert node.selfExpNode != null;
        node.selfExpNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(PrefixExpNode node) {
        assert node.selfExpNode != null;
        node.selfExpNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(UnaryExpNode node) {
        assert node.selfExpNode != null;
        node.selfExpNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.selfExpNode.type.copy();
    }

    @Override
    public void visit(LambdaExpNode node) {
        stackManager.push(node.funcRegistry.scope);

        // query class type
        for (VarRegistry registry : node.funcRegistry.funcArgs) {
            if (registry.type.builtinType == BaseType.BuiltinType.CLASS &&
                    stackManager.queryClass(registry.type.className) == null) {
                throw new NameError(node.codePos, NameError.undefined, registry.type.className);
            }
            stackManager.register(registry);
        }

        assert node.suiteNode != null;
        visit(node.suiteNode);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));

        int result = node.funcRegistry.type.funcCallMatch(node.callArgExpNodes);

        if (result == -1) {
            throw new FuncCallError(node.codePos, FuncCallError.argcNotMatch);
        } else if (result == -2) {
            throw new FuncCallError(node.codePos, FuncCallError.argTypeNotMatch);
        }

        if (node.funcRegistry.scope.catchedRetTypeList.isEmpty()) { //no return statement
            node.type = new VarType(BaseType.BuiltinType.VOID);
        }
        else {
            // check every return statement
            for (VarType catchedRetType : node.funcRegistry.scope.catchedRetTypeList) {
                if (node.type == null) {
                    node.type = catchedRetType;
                    node.funcRegistry.type.retType = catchedRetType;
                }
                else if (!node.type.match(catchedRetType)) {
                    throw new FuncReturnError(node.codePos, FuncReturnError.retTypeNotMatch);
                }
            }
        }

        stackManager.pop();
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null) {
            node.type = new VarType(BaseType.BuiltinType.INT);
        }
        else if (node.ctx.StringConstant() != null) {
            node.type = new VarType(BaseType.BuiltinType.STRING);
        }
        else if (node.ctx.TrueConstant() != null || node.ctx.FalseConstant() != null) {
            node.type = new VarType(BaseType.BuiltinType.BOOL);
        }
        else if (node.ctx.NullConstant() != null) {
            node.type = new VarType(BaseType.BuiltinType.NULL);
        }
        else if (node.ctx.ThisPointer() != null) {
            ClassRegistry nowClass = stackManager.getNowClass();
            if (nowClass == null) {
                throw new ScopeError(node.codePos, ScopeError.wrongThis);
            }
            node.type = new VarType(nowClass.name);
        }
        else if (node.ctx.Identifier() != null) {

            VarRegistry varRegistry = stackManager.queryVarInStack(node.ctx.Identifier().getText());
            FuncRegistry funcRegistry = stackManager.queryFuncInStack(node.ctx.Identifier().getText());

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
