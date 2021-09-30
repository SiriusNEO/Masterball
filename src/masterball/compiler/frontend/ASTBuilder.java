package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.error.syntax.AssignmentError;
import masterball.compiler.frontend.info.*;
import masterball.compiler.frontend.error.syntax.MainFuncError;
import masterball.compiler.frontend.parser.MxStarBaseVisitor;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.utils.GrammarTable;
import masterball.debugger.Log;
import masterball.debugger.VarPair;

public class ASTBuilder extends MxStarBaseVisitor<BaseNode> {

    @Override public BaseNode visitMxStarCode(MxStarParser.MxStarCodeContext ctx) {
        Log.track("ASTBuilder started building...");

        RootNode ret = new RootNode(new CodePos(ctx));

        boolean hasMainFunc = false;

        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i) instanceof MxStarParser.ClassDefContext) {
                ClassDefNode classDefNode = (ClassDefNode) visit(ctx.children.get(i));
                ret.sonNodes.add(classDefNode);
                ret.scope.register(classDefNode.classRegistry); // register class first
            }
            else if (ctx.children.get(i) instanceof MxStarParser.FuncDefContext) {
                FuncDefNode funcDefNode = (FuncDefNode) visit(ctx.children.get(i));
                ret.sonNodes.add(funcDefNode);
                ret.scope.register(funcDefNode.funcRegistry); // register global-func first
                if (funcDefNode.isValidMainFunc()) hasMainFunc = true;
            }
            else if (ctx.children.get(i) instanceof  MxStarParser.VarDefStmtContext) {
                VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(ctx.children.get(i));
                ret.sonNodes.add(varDefStmtNode);
            }
        }

        if (!hasMainFunc) {
            throw new MainFuncError(
                    new CodePos(ctx.getStop()), // report the end of code is reasonable.
                    MainFuncError.missingMain
            );
        }

        return ret;
    }

    @Override public BaseNode visitClassDef(MxStarParser.ClassDefContext ctx) {
        Log.track("class def");

        ClassDefNode ret = new ClassDefNode(new CodePos(ctx));

        ret.classRegistry = new ClassRegistry(ctx);

        ctx.classConstructorDef().forEach(sonctx -> {
            FuncDefNode constructorDefNode = (FuncDefNode) visit(sonctx);
            ret.classRegistry.scope.register(constructorDefNode.funcRegistry);
            ret.constructorDefNode = constructorDefNode;
        });

        ctx.varDefStmt().forEach(sonctx -> {
            VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(sonctx);
            varDefStmtNode.varDefSingleNodes.forEach(sonnode -> {
               ret.classRegistry.scope.register(sonnode.varRegistry);
            });
            ret.varDefStmtNodes.add(varDefStmtNode);
        });

        ctx.funcDef().forEach(sonctx -> {
            FuncDefNode constructorDefNode = (FuncDefNode) visit(sonctx);
            ret.classRegistry.scope.register(constructorDefNode.funcRegistry);
            ret.funcDefNodes.add(constructorDefNode);
        });

        return ret;
    }

    @Override public BaseNode visitClassConstructorDef(MxStarParser.ClassConstructorDefContext ctx) {
        FuncDefNode ret = new FuncDefNode(new CodePos(ctx));
        ret.funcRegistry = new FuncRegistry(ctx);
        ret.suiteNode = (SuiteNode) visit(ctx.suite());
        return ret;
    }

    @Override public BaseNode visitFuncDef(MxStarParser.FuncDefContext ctx) {
        Log.track("func def");
        FuncDefNode ret = new FuncDefNode(new CodePos(ctx));
        ret.funcRegistry = new FuncRegistry(ctx);
        Log.report(new VarPair("registry", ret.funcRegistry));
        ret.suiteNode = (SuiteNode) visit(ctx.suite());
        return ret;
    }

    @Override public BaseNode visitVarDefStmt(MxStarParser.VarDefStmtContext ctx) {
        Log.track("var def stmt");
        VarDefStmtNode ret = new VarDefStmtNode(new CodePos(ctx));

        for (int i = 0; i < ctx.varDefBody().varDefSingle().size(); i++) {
            VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(ctx.varDefBody().varDefSingle(i));
            varDefSingleNode.varRegistry.type = new Type(ctx.varDefBody().varDefType());
            ret.varDefSingleNodes.add(varDefSingleNode);
        }

        return ret;
    }

    @Override public BaseNode visitVarDefSingle(MxStarParser.VarDefSingleContext ctx) {
        VarDefSingleNode ret = new VarDefSingleNode(new CodePos(ctx));

        ret.varRegistry = new VarRegistry(ctx.Identifier().toString(), ctx);

        if (ctx.AssignOp() != null) ret.initExpNode = (ExpBaseNode) visit(ctx.expression());

        return ret;
    }

    @Override public BaseNode visitSuite(MxStarParser.SuiteContext ctx) {
        SuiteNode ret = new SuiteNode(new CodePos(ctx));
        ctx.statement().forEach(sonctx -> ret.stmtNodes.add((StmtBaseNode) visit(sonctx)));
        return ret;
    }

    @Override public BaseNode visitForStmt(MxStarParser.ForStmtContext ctx) {
        ForStmtNode ret = new ForStmtNode(new CodePos(ctx));

        if (ctx.forInit() != null) {
            if (ctx.forInit().varDefBody() != null) {
                for (int i = 0; i < ctx.forInit().varDefBody().varDefSingle().size(); i++) {
                    VarDefSingleNode varDefSingleNode = (VarDefSingleNode)
                            visit(ctx.forInit().varDefBody().varDefSingle(i));
                    varDefSingleNode.varRegistry.type = new Type(ctx.forInit().varDefBody().varDefType());
                    ret.initVarDefSingleNodes.add(varDefSingleNode);
                }
            } else if (ctx.forInit().expression() != null) {
                if (ctx.forInit().expression() != null)
                    ret.initExpNode = (ExpBaseNode) visit(ctx.forInit().expression());
            }
        }
        if (ctx.forCondition != null) {
            ret.conditionExpNode = (ExpBaseNode) visit(ctx.forCondition);
        }
        if (ctx.forIncr != null) {
            ret.incrExpNode = (ExpBaseNode) visit(ctx.forIncr);
        }

        ret.bodyStmtNode = (StmtBaseNode) visit(ctx.statement());

        return ret;
    }

    @Override public BaseNode visitWhileStmt(MxStarParser.WhileStmtContext ctx) {
        return new WhileStmtNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression()),
                (StmtBaseNode) visit(ctx.statement()));
    }

    @Override public BaseNode visitIfStmt(MxStarParser.IfStmtContext ctx) {
        IfStmtNode ret = new IfStmtNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression()),
                (StmtBaseNode) visit(ctx.statement(0)));
        if (ctx.statement().size() == 2) {
            ret.elseStmtNode = (StmtBaseNode) visit(ctx.statement(1));
        }
        return ret;
    }

    @Override public BaseNode visitSuiteStmt(MxStarParser.SuiteStmtContext ctx) {
        return new SuiteStmtNode(new CodePos(ctx), (SuiteNode) visitSuite(ctx.suite()));
    }

    @Override public BaseNode visitControlStmt(MxStarParser.ControlStmtContext ctx) {
        return new ControlStmtNode(new CodePos(ctx), ctx.getText());
    }

    @Override public BaseNode visitReturnStmt(MxStarParser.ReturnStmtContext ctx) {
        ReturnStmtNode ret = new ReturnStmtNode(new CodePos(ctx));
        if (ctx.expression() != null) ret.retExpNode = (ExpBaseNode) visit(ctx.expression());
        return ret;
    }

    @Override public BaseNode visitPureStmt(MxStarParser.PureStmtContext ctx) {
        PureStmtNode ret = new PureStmtNode(new CodePos(ctx));
        if (ctx.expression() != null) ret.expNode = (ExpBaseNode) visit(ctx.expression());
        return ret;
    }

    @Override public BaseNode visitBinaryExp(MxStarParser.BinaryExpContext ctx) {
        BinaryExpNode ret = new BinaryExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression().get(0)), (ExpBaseNode) visit(ctx.expression().get(1))
        );

        if (ctx.LogicOrOp() != null) ret.op = GrammarTable.LogicOrOp;
        else if (ctx.LogicAndOp() != null) ret.op = GrammarTable.LogicAndOp;
        else if (ctx.BitXorOp() != null) ret.op = GrammarTable.BitXorOp;
        else if (ctx.BitOrOp() != null) ret.op = GrammarTable.BitOrOp;
        else if (ctx.BitAndOp() != null) ret.op = GrammarTable.BitAndOp;
        else if (ctx.equalOps() != null) ret.op = ctx.equalOps().getText();
        else if (ctx.compareOps() != null) ret.op = ctx.compareOps().getText();
        else if (ctx.addLevelOps() != null) ret.op = ctx.addLevelOps().getText();
        else if (ctx.mulLevelOps() != null) ret.op = ctx.mulLevelOps().getText();
        else if (ctx.shiftOps() != null) ret.op = ctx.shiftOps().getText();

        return ret;
    }

    @Override public BaseNode visitAssignExp(MxStarParser.AssignExpContext ctx) {
        AssignExpNode ret =  new AssignExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression(0)), (ExpBaseNode) visit(ctx.expression(1)));
        if (!ret.lhsExpNode.isLeftValue())
            throw new AssignmentError(
                    new CodePos(ctx.expression(0)),
                    AssignmentError.expectLeftValue
            );
        return ret;
    }

    @Override public BaseNode visitFuncCallExp(MxStarParser.FuncCallExpContext ctx) {
        FuncCallExpNode ret = new FuncCallExpNode(new CodePos(ctx), ctx.Identifier().toString());
        if (ctx.funcCallArgs() != null) {
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExpNodes.add((ExpBaseNode) visit(sonctx));
            });
        }
        return ret;
    }

    @Override public BaseNode visitIndexExp(MxStarParser.IndexExpContext ctx) {
        return new IndexExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression(0)),
                (ExpBaseNode) visit(ctx.expression(1))
                );
    }

    /*@Override public BaseNode visitLambdaExp(MxStarParser.LambdaExpContext ctx) {

    }*/

    @Override public BaseNode visitMemberExp(MxStarParser.MemberExpContext ctx) {
        return new MemberExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression(0)),
                (ExpBaseNode) visit(ctx.expression(1))
        );
    }

    @Override public BaseNode visitPostfixExp(MxStarParser.PostfixExpContext ctx) {
        return new PostfixExpNode(new CodePos(ctx), ctx.postfixOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitUnaryExp(MxStarParser.UnaryExpContext ctx) {
        return new UnaryExpNode(new CodePos(ctx), ctx.unaryOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitPrefixExp(MxStarParser.PrefixExpContext ctx) {
        return new PostfixExpNode(new CodePos(ctx), ctx.prefixOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitNewExp(MxStarParser.NewExpContext ctx) {
        return new NewExpNode(new CodePos(ctx), new Type(ctx.newExpType()));
    }

    @Override public BaseNode visitAtomExp(MxStarParser.AtomExpContext ctx) {
        return new AtomExpNode(new CodePos(ctx), ctx.atom());
    }
}
