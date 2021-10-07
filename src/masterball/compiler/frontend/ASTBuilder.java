package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.error.syntax.ClassDeclarationError;
import masterball.compiler.frontend.info.*;
import masterball.compiler.frontend.error.syntax.MainFuncError;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarBaseVisitor;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.utils.GrammarTable;
import masterball.debugger.Log;
import masterball.debugger.VarPair;

import java.util.Objects;

public class ASTBuilder extends MxStarBaseVisitor<BaseNode> {

    @Override public BaseNode visitMxStarCode(MxStarParser.MxStarCodeContext ctx) {
        Log.track("ASTBuilder started building...");

        RootNode ret = new RootNode(new CodePos(ctx));

        ret.scope.register(
                new FuncRegistry("print", BaseType.BuiltinType.VOID,
                        new VarRegistry("str", BaseType.BuiltinType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("println", BaseType.BuiltinType.VOID,
                        new VarRegistry("str", BaseType.BuiltinType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("printInt", BaseType.BuiltinType.VOID,
                        new VarRegistry("n", BaseType.BuiltinType.INT))
        );

        ret.scope.register(
                new FuncRegistry("printlnInt", BaseType.BuiltinType.VOID,
                        new VarRegistry("n", BaseType.BuiltinType.INT))
        );

        ret.scope.register(
                new FuncRegistry("getString", BaseType.BuiltinType.STRING)
        );

        ret.scope.register(
                new FuncRegistry("getInt", BaseType.BuiltinType.INT)
        );

        ret.scope.register(
                new FuncRegistry("toString", BaseType.BuiltinType.STRING,
                    new VarRegistry("i", BaseType.BuiltinType.INT))
        );

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

            if (!Objects.equals(ret.classRegistry.name, constructorDefNode.funcRegistry.name)) {
                throw new ClassDeclarationError(new CodePos(ctx), ClassDeclarationError.constructorWrongName);
            }

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
        ret.suiteNode = (SuiteNode) visit(ctx.suite());
        return ret;
    }

    @Override public BaseNode visitVarDefStmt(MxStarParser.VarDefStmtContext ctx) {
        Log.track("var def stmt");
        VarDefStmtNode ret = new VarDefStmtNode(new CodePos(ctx));

        for (int i = 0; i < ctx.varDefBody().varDefSingle().size(); i++) {
            VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(ctx.varDefBody().varDefSingle(i));
            varDefSingleNode.varRegistry.type = new VarType(ctx.varDefBody().varDefType());
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
                    varDefSingleNode.varRegistry.type = new VarType(ctx.forInit().varDefBody().varDefType());
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
        String controlWord = ctx.getText();
        controlWord = controlWord.substring(0, controlWord.length()-1); // get rid of ';'
        return new ControlStmtNode(new CodePos(ctx), controlWord);
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

        if (ctx.LogicOrOp() != null) {
            ret.op = GrammarTable.LogicOrOp;
            ret.opType = GrammarTable.logicOpType;
        }
        else if (ctx.LogicAndOp() != null) {
            ret.op = GrammarTable.LogicAndOp;
            ret.opType = GrammarTable.logicOpType;
        }
        else if (ctx.BitXorOp() != null) {
            ret.op = GrammarTable.BitXorOp;
            ret.opType = GrammarTable.arithOpType;
        }
        else if (ctx.BitOrOp() != null) {
            ret.op = GrammarTable.BitOrOp;
            ret.opType = GrammarTable.arithOpType;
        }
        else if (ctx.BitAndOp() != null) {
            ret.op = GrammarTable.BitAndOp;
            ret.opType = GrammarTable.arithOpType;
        }
        else if (ctx.equalOps() != null) {
            ret.op = ctx.equalOps().getText();
            ret.opType = GrammarTable.equalOpType;
        }
        else if (ctx.compareOps() != null) {
            ret.op = ctx.compareOps().getText();
            ret.opType = GrammarTable.compareOpType;
        }
        else if (ctx.addLevelOps() != null) {
            ret.op = ctx.addLevelOps().getText();
            ret.opType = GrammarTable.arithOpType;
        }
        else if (ctx.mulLevelOps() != null) {
            ret.op = ctx.mulLevelOps().getText();
            ret.opType = GrammarTable.arithOpType;
        }
        else if (ctx.shiftOps() != null) {
            ret.op = ctx.shiftOps().getText();
            ret.opType = GrammarTable.arithOpType;
        }

        return ret;
    }

    @Override public BaseNode visitAssignExp(MxStarParser.AssignExpContext ctx) {
        AssignExpNode ret =  new AssignExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression(0)), (ExpBaseNode) visit(ctx.expression(1)));
        return ret;
    }

    @Override public BaseNode visitFuncCallExp(MxStarParser.FuncCallExpContext ctx) {
        FuncCallExpNode ret = new FuncCallExpNode(new CodePos(ctx), (ExpBaseNode) visit(ctx.expression()));
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
        return new MemberExpNode(new CodePos(ctx), (ExpBaseNode) visit(ctx.expression()), ctx.Identifier().getText());
    }

    @Override public BaseNode visitPostfixExp(MxStarParser.PostfixExpContext ctx) {
        return new PostfixExpNode(new CodePos(ctx), ctx.postfixOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitUnaryExp(MxStarParser.UnaryExpContext ctx) {
        return new UnaryExpNode(new CodePos(ctx), ctx.unaryOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitPrefixExp(MxStarParser.PrefixExpContext ctx) {
        return new PrefixExpNode(new CodePos(ctx), ctx.prefixOps().getText(), (ExpBaseNode) visit(ctx.expression()));
    }

    @Override public BaseNode visitNewExp(MxStarParser.NewExpContext ctx) {
        NewExpNode ret =  new NewExpNode(new CodePos(ctx), new VarType(ctx));
        ctx.newExpSizeDeclaration().forEach(sonctx->{
            if (sonctx.expression() != null) {
                ret.eachDimExpNodes.add((ExpBaseNode) visit(sonctx.expression()));
            }
        });
        return ret;
    }

    @Override public BaseNode visitParenExp(MxStarParser.ParenExpContext ctx) {
        return visit(ctx.expression());
    }

    @Override public BaseNode visitAtomExp(MxStarParser.AtomExpContext ctx) {
        return new AtomExpNode(new CodePos(ctx), ctx.atom());
    }
}
