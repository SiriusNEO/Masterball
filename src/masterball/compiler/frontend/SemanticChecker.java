package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.share.error.semantic.*;
import masterball.compiler.frontend.info.ArrayBuiltinMethods;
import masterball.compiler.frontend.info.StringBuiltinMethods;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.InfoManager;
import masterball.compiler.share.MxStarTable;

import java.util.Objects;

public class SemanticChecker implements ASTVisitor {

    private final InfoManager infoManager = new InfoManager();

    @Override
    public void visit(RootNode node) {
        infoManager.push(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        infoManager.pop();
    }

    @Override
    public void visit(ClassDefNode node) {
        infoManager.push(node.classRegistry); // update nowClass

        assert node.constructorDefNode != null;
        visit(node.constructorDefNode);
        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));
        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));

        infoManager.pop();
    }

    @Override
    public void visit(FuncDefNode node) {
        infoManager.push(node.funcRegistry.scope);

        // query class type
        for (VarRegistry registry : node.funcRegistry.funcArgs) {
            if (registry.type.builtinType == MxBaseType.BuiltinType.CLASS &&
                    infoManager.queryClass(registry.type.className) == null) {
                throw new NameError(node.codePos, NameError.undefined, registry.type.className);
            }
            infoManager.register(registry);
        }

        assert node.suiteNode != null;
        visit(node.suiteNode);

        if (node.funcRegistry.scope.catchedRetTypeList.isEmpty()) { //no return statement
            if (!node.isValidMainFunc() && !node.funcRegistry.type.retType.match(MxBaseType.BuiltinType.VOID)) {
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

        infoManager.pop();
    }

    @Override
    public void visit(VarDefSingleNode node) {
        // from right to left, init first, register after
        if (node.initExpNode != null) node.initExpNode.accept(this);

        if (node.varRegistry.type.builtinType == MxBaseType.BuiltinType.CLASS &&
                infoManager.queryClass(node.varRegistry.type.className) == null) {
            throw new NameError(node.codePos, NameError.undefined, node.varRegistry.type.className);
        }

        if (node.initExpNode != null) TypeMatcher.match(node);

        infoManager.register(node.varRegistry);
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
    }

    @Override
    public void visit(SuiteNode node) {
        infoManager.push(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        infoManager.pop();
    }

    @Override
    public void visit(SuiteStmtNode node) {
        visit(node.suiteNode);
    }

    @Override
    public void visit(IfStmtNode node) {
        node.conditionExpNode.accept(this);

        TypeMatcher.match(node);

        infoManager.push(node.ifTrueScope);
        node.ifTrueStmtNode.accept(this);
        infoManager.pop();

        if (node.elseStmtNode != null) {
            infoManager.push(node.elseScope);
            node.elseStmtNode.accept(this);
            infoManager.pop();
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        infoManager.push(node.scope);

        node.conditionExpNode.accept(this);

        TypeMatcher.match(node);

        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);

        infoManager.pop();
    }

    @Override
    public void visit(ForStmtNode node) {
        infoManager.push(node.scope);

        if (node.initExpNode != null) node.initExpNode.accept(this);

        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));

        if (node.conditionExpNode != null) {
            node.conditionExpNode.accept(this);
            TypeMatcher.match(node);
        }

        if (node.incrExpNode != null) node.incrExpNode.accept(this);

        assert node.bodyStmtNode != null;
        node.bodyStmtNode.accept(this);

        infoManager.pop();
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (!infoManager.isInFunc()) throw new ScopeError(node.codePos, ScopeError.wrongReturn);
        if (node.retExpNode != null) {
            node.retExpNode.accept(this);
            infoManager.stackReturn((VarType) node.retExpNode.type);
        } else {
            infoManager.stackReturn(new VarType(MxBaseType.BuiltinType.VOID));
        }
    }

    @Override
    public void visit(ControlStmtNode node) {
        if (!infoManager.isInLoop()) {
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
            node.type = new VarType(MxBaseType.BuiltinType.BOOL);
        } else {
            node.type = node.rhsExpNode.type.copy();
        }
    }

    @Override
    public void visit(FuncCallExpNode node) {
        node.callExpNode.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));

       if (!(node.callExpNode.type instanceof MxFuncType)) { // try again, func name query
           if (!(node.callExpNode instanceof AtomExpNode)) {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
           if (((AtomExpNode) node.callExpNode).ctx.Identifier() == null) {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
           FuncRegistry funcRegistry = infoManager.queryFuncInStack(((AtomExpNode) node.callExpNode).ctx.Identifier().getText());
           if (funcRegistry != null) {
                node.callExpNode.type = funcRegistry.type.copy(); // forced type conversion
           } else {
               throw new FuncCallError(node.codePos, FuncCallError.expNotAFunc);
           }
       }

        int result = ((MxFuncType) node.callExpNode.type).funcCallMatch(node.callArgExpNodes);

        if (result == -1) {
            throw new FuncCallError(node.codePos, FuncCallError.argcNotMatch);
        } else if (result == -2) {
            throw new FuncCallError(node.codePos, FuncCallError.argTypeNotMatch);
        }

        node.type = ((MxFuncType) node.callExpNode.type).retType.copy();
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
        if (node.superExpNode.type.match(MxBaseType.BuiltinType.STRING)) {
            if (StringBuiltinMethods.scope.funcTable.containsKey(node.memberName)) {
                node.type = StringBuiltinMethods.scope.queryFunc(node.memberName).type.copy();
                return;
            }
        }

        if (node.superExpNode.type.isArray() && ArrayBuiltinMethods.scope.funcTable.containsKey(node.memberName)) {
            node.type = ArrayBuiltinMethods.scope.queryFunc(node.memberName).type.copy();
            return;
        }

        TypeMatcher.match(node);

        String className = ((VarType) node.superExpNode.type).className;
        ClassRegistry classRegistry = infoManager.queryClass(className);
        if (classRegistry == null) throw new NameError(node.codePos, NameError.undefined, className);
        if (classRegistry.scope.funcTable.containsKey(node.memberName))
            node.type = classRegistry.scope.queryFunc(node.memberName).type.copy();

        else if (classRegistry.scope.varTable.containsKey(node.memberName))
            node.type = classRegistry.scope.queryVar(node.memberName).type.copy();

        else throw new NameError(node.codePos, NameError.undefined, node.memberName);
    }

    @Override
    public void visit(NewExpNode node) {
        node.eachDimLengthExpNodes.forEach(sonnode -> sonnode.accept(this));

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
        infoManager.push(node.funcRegistry.scope);

        // query class type
        for (VarRegistry registry : node.funcRegistry.funcArgs) {
            if (registry.type.builtinType == MxBaseType.BuiltinType.CLASS &&
                    infoManager.queryClass(registry.type.className) == null) {
                throw new NameError(node.codePos, NameError.undefined, registry.type.className);
            }
            infoManager.register(registry);
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
            node.type = new VarType(MxBaseType.BuiltinType.VOID);
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

        infoManager.pop();
    }

    @Override
    public void visit(AtomExpNode node) {
        if (node.ctx.IntegerConstant() != null) {
            node.type = new VarType(MxBaseType.BuiltinType.INT);
        }
        else if (node.ctx.StringConstant() != null) {
            node.type = new VarType(MxBaseType.BuiltinType.STRING);
        }
        else if (node.ctx.TrueConstant() != null || node.ctx.FalseConstant() != null) {
            node.type = new VarType(MxBaseType.BuiltinType.BOOL);
        }
        else if (node.ctx.NullConstant() != null) {
            node.type = new VarType(MxBaseType.BuiltinType.NULL);
        }
        else if (node.ctx.ThisPointer() != null) {
            ClassRegistry nowClass = infoManager.getNowClass();
            if (nowClass == null) {
                throw new ScopeError(node.codePos, ScopeError.wrongThis);
            }
            node.type = new VarType(nowClass.name);
        }
        else if (node.ctx.Identifier() != null) {

            VarRegistry varRegistry = infoManager.queryVarInStack(node.ctx.Identifier().getText());
            FuncRegistry funcRegistry = infoManager.queryFuncInStack(node.ctx.Identifier().getText());

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
