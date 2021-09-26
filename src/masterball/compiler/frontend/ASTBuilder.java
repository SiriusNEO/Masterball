package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.stmtnode.ForStmtNode;
import masterball.compiler.frontend.ast.node.stmtnode.VarDefStmtNode;
import masterball.compiler.frontend.error.semantic.NameReDefined;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.syntax.MainFuncError;
import masterball.compiler.frontend.info.FuncRegistry;
import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.info.VarRegistry;
import masterball.compiler.frontend.parser.MxStarBaseVisitor;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.scope.BaseScope;
import masterball.debugger.Log;

import java.util.List;
import java.util.Stack;

import static masterball.engine.IOEngine.redirectOutput;

public class ASTBuilder extends MxStarBaseVisitor<BaseNode> {

    public Stack<BaseScope> scopeStack = new Stack<>();

    @Override public BaseNode visitMxStarCode(MxStarParser.MxStarCodeContext ctx) {
        Log.track("ASTBuilder started building...");

        RootNode ret = new RootNode(new CodePos(ctx));

        scopeStack.push(ret.scope);

        boolean hasMainFunc = false;

        List<MxStarParser.ClassDefContext> classDefContextList = ctx.classDef();
        List<MxStarParser.FuncDefContext> funcDefContextList = ctx.funcDef();
        List<MxStarParser.VarDefStmtContext> varDefStmtContextList = ctx.varDefStmt();

        for (int i = 0; i < classDefContextList.size(); ++i) {
            ClassDefNode classDefNode = (ClassDefNode) visit(classDefContextList.get(i));
            ret.classDefNodes.add(classDefNode);
            ret.scope.register(classDefNode.classRegistry);
        }

        for (int i = 0; i < funcDefContextList.size(); ++i) {
            FuncDefNode funcDefNode = (FuncDefNode) visit(funcDefContextList.get(i));
            ret.globalFuncDefNodes.add(funcDefNode);
            if (funcDefNode.isValidMainFunc()) {
                if (hasMainFunc) throw new MainFuncError(
                        new CodePos(funcDefContextList.get(i)),
                        "\"main\" function redefined"
                );
                hasMainFunc = true;
            }
            ret.scope.register(funcDefNode.funcRegistry);
        }

        if (!hasMainFunc) {
            throw new MainFuncError(
                    new CodePos(ctx.getStop()), // report the end of code is reasonable.
                    "missing valid \"main\" function"
            );
        }

        for (int i = 0; i < varDefStmtContextList.size(); ++i) {
            VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(varDefStmtContextList.get(i));
            ret.globalVarDefStmtNodes.add(varDefStmtNode);
        }

        scopeStack.pop();

        return ret;
    }

    @Override public BaseNode visitClassDef(MxStarParser.ClassDefContext ctx) {
        Log.track("class def");

        ClassDefNode ret = new ClassDefNode(new CodePos(ctx));

        scopeStack.push(ret.scope);

        List<MxStarParser.ClassConstructorDefContext> classConstructorDefContextList = ctx.classConstructorDef();

        if (classConstructorDefContextList.size() > 0) {
            FuncDefNode constructorDefNode = (FuncDefNode) visit(classConstructorDefContextList.get(0));
            if (classConstructorDefContextList.size() > 0)
                throw new NameReDefined(
                        new CodePos(classConstructorDefContextList.get(1)),
                        constructorDefNode.funcRegistry.name
                );
        }

        scopeStack.pop();

        return ret;
    }

    @Override public BaseNode visitFuncDef(MxStarParser.FuncDefContext ctx) {
        Log.track("func def");

        FuncDefNode ret = new FuncDefNode(new CodePos(ctx));

        scopeStack.push(ret.scope);

        ret.funcRegistry = new FuncRegistry(ctx);

        ret.suiteNode = (SuiteNode) visit(ctx.suite());

        scopeStack.pop();

        return ret;
    }

    @Override public BaseNode visitVarDefStmt(MxStarParser.VarDefStmtContext ctx) {
        Log.track("var def stmt");
        VarDefStmtNode ret = new VarDefStmtNode(new CodePos(ctx));

        List<MxStarParser.VarDefSingleContext> varDefSingleContextList = ctx.varDefBody().varDefSingle();
        for (int i = 0; i < varDefSingleContextList.size(); i++) {
            VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(varDefSingleContextList.get(i));
            varDefSingleNode.varRegistry.type = new Type(ctx.varDefBody().varDefType());
        }

        return ret;
    }

    @Override public BaseNode visitVarDefSingle(MxStarParser.VarDefSingleContext ctx) {
        VarDefSingleNode ret = new VarDefSingleNode(new CodePos(ctx));

        ret.varRegistry = new VarRegistry(ctx.Identifier().toString(), null);
        if (ctx.AssignOp() != null) ret.initExpNode = (ExpBaseNode) visit(ctx.expression());

        return ret;
    }

    @Override public BaseNode visitSuite(MxStarParser.SuiteContext ctx) {
        SuiteNode ret = new SuiteNode(new CodePos(ctx));

        scopeStack.push(ret.scope);

        List<MxStarParser.StatementContext> statementContextList = ctx.statement();

        for (int i = 0; i < statementContextList.size(); i++) {
            ret.stmtNodes.add((StmtBaseNode) visit(statementContextList.get(i)));
        }

        scopeStack.pop();

        return ret;
    }

    @Override public BaseNode visitForStmt(MxStarParser.ForStmtContext ctx) {
        ForStmtNode ret = new ForStmtNode(new CodePos(ctx));

        scopeStack.push(ret.scope);

        if (ctx.forInit() != null) {
            if (ctx.forInit().varDefBody() != null) {
                List<MxStarParser.VarDefSingleContext> varDefSingleContextList = ctx.forInit().varDefBody().varDefSingle();
                for (int i = 0; i < varDefSingleContextList.size(); i++) {
                    VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(varDefSingleContextList.get(i));
                    varDefSingleNode.varRegistry.type = new Type(ctx.forInit().varDefBody().varDefType());
                }
            } else if (ctx.forInit().expression() != null) {
                ret.initExpNode = (ExpBaseNode) visit(ctx.forInit().expression());
            }
        }

        ret.bodyStmtNode = (StmtBaseNode) visit(ctx.statement());

        scopeStack.pop();

        return ret;
    }
}
