package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.utils.error.syntax.ClassDeclarationError;
import masterball.compiler.frontend.info.*;
import masterball.compiler.utils.error.syntax.MainFuncError;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarBaseVisitor;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.utils.MxStarTable;
import masterball.debug.Log;

import java.util.Objects;

public class ASTBuilder extends MxStarBaseVisitor<BaseNode> {

    @Override public BaseNode visitMxStarCode(MxStarParser.MxStarCodeContext ctx) {
        Log.track("ASTBuilder started building...");

        RootNode ret = new RootNode(new CodePos(ctx));

        ret.scope.register(
                new FuncRegistry("print", MxBaseType.BuiltinType.VOID,
                        new VarRegistry("str", MxBaseType.BuiltinType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("println", MxBaseType.BuiltinType.VOID,
                        new VarRegistry("str", MxBaseType.BuiltinType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("printInt", MxBaseType.BuiltinType.VOID,
                        new VarRegistry("n", MxBaseType.BuiltinType.INT))
        );

        ret.scope.register(
                new FuncRegistry("printlnInt", MxBaseType.BuiltinType.VOID,
                        new VarRegistry("n", MxBaseType.BuiltinType.INT))
        );

        ret.scope.register(
                new FuncRegistry("getString", MxBaseType.BuiltinType.STRING)
        );

        ret.scope.register(
                new FuncRegistry("getInt", MxBaseType.BuiltinType.INT)
        );

        ret.scope.register(
                new FuncRegistry("toString", MxBaseType.BuiltinType.STRING,
                    new VarRegistry("i", MxBaseType.BuiltinType.INT))
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

            ret.classRegistry.memberFuncs.add(constructorDefNode.funcRegistry);
            ret.classRegistry.scope.register(constructorDefNode.funcRegistry);
            ret.constructorDefNode = constructorDefNode;
        });

        if (ctx.classConstructorDef().size() == 0) {
            FuncRegistry defaultConstructor = new FuncRegistry(ctx.Identifier().getText());
            SuiteNode suiteNode = new SuiteNode(new CodePos(ctx));
            ReturnStmtNode retNode = new ReturnStmtNode(new CodePos(ctx));
            suiteNode.stmtNodes.add(retNode);
            ret.classRegistry.memberFuncs.add(defaultConstructor);
            ret.classRegistry.scope.register(defaultConstructor);
            ret.constructorDefNode = new FuncDefNode(new CodePos(ctx), defaultConstructor, suiteNode);
        }

        ctx.varDefStmt().forEach(sonctx -> {
            VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(sonctx);
            varDefStmtNode.varDefSingleNodes.forEach(sonnode -> {
               ret.classRegistry.memberVars.add(sonnode.varRegistry);
               ret.classRegistry.scope.register(sonnode.varRegistry);
            });
            ret.varDefStmtNodes.add(varDefStmtNode);
        });

        ctx.funcDef().forEach(sonctx -> {
            FuncDefNode funcDefNode = (FuncDefNode) visit(sonctx);

            ret.classRegistry.memberFuncs.add(funcDefNode.funcRegistry);
            ret.classRegistry.scope.register(funcDefNode.funcRegistry);
            ret.funcDefNodes.add(funcDefNode);
        });

        return ret;
    }

    @Override public BaseNode visitClassConstructorDef(MxStarParser.ClassConstructorDefContext ctx) {
        return new FuncDefNode(new CodePos(ctx), new FuncRegistry(ctx), (SuiteNode) visit(ctx.suite()));
    }

    @Override public BaseNode visitFuncDef(MxStarParser.FuncDefContext ctx) {
        return new FuncDefNode(new CodePos(ctx), new FuncRegistry(ctx), (SuiteNode) visit(ctx.suite()));
    }

    @Override public BaseNode visitVarDefStmt(MxStarParser.VarDefStmtContext ctx) {
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
            ret.op = MxStarTable.LogicOrOp;
            ret.opType = MxStarTable.logicOpType;
        }
        else if (ctx.LogicAndOp() != null) {
            ret.op = MxStarTable.LogicAndOp;
            ret.opType = MxStarTable.logicOpType;
        }
        else if (ctx.BitXorOp() != null) {
            ret.op = MxStarTable.BitXorOp;
            ret.opType = MxStarTable.arithOpType;
        }
        else if (ctx.BitOrOp() != null) {
            ret.op = MxStarTable.BitOrOp;
            ret.opType = MxStarTable.arithOpType;
        }
        else if (ctx.BitAndOp() != null) {
            ret.op = MxStarTable.BitAndOp;
            ret.opType = MxStarTable.arithOpType;
        }
        else if (ctx.equalOps() != null) {
            ret.op = ctx.equalOps().getText();
            ret.opType = MxStarTable.equalOpType;
        }
        else if (ctx.compareOps() != null) {
            ret.op = ctx.compareOps().getText();
            ret.opType = MxStarTable.compareOpType;
        }
        else if (ctx.addLevelOps() != null) {
            ret.op = ctx.addLevelOps().getText();
            ret.opType = MxStarTable.arithOpType;
        }
        else if (ctx.mulLevelOps() != null) {
            ret.op = ctx.mulLevelOps().getText();
            ret.opType = MxStarTable.arithOpType;
        }
        else if (ctx.shiftOps() != null) {
            ret.op = ctx.shiftOps().getText();
            ret.opType = MxStarTable.arithOpType;
        }

        return ret;
    }

    @Override public BaseNode visitAssignExp(MxStarParser.AssignExpContext ctx) {
        return new AssignExpNode(new CodePos(ctx),
                (ExpBaseNode) visit(ctx.expression(0)), (ExpBaseNode) visit(ctx.expression(1)));
    }

    @Override public BaseNode visitFuncCallExp(MxStarParser.FuncCallExpContext ctx) {
        FuncCallExpNode ret = new FuncCallExpNode(new CodePos(ctx), (ExpBaseNode) visit(ctx.expression()));
        if (ctx.funcCallArgs().expression() != null) {
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

    @Override public BaseNode visitLambdaExp(MxStarParser.LambdaExpContext ctx) {
        LambdaExpNode ret = new LambdaExpNode(new CodePos(ctx), (SuiteNode) visit(ctx.suite()));

        ret.funcRegistry = new FuncRegistry(ctx);

        if (ctx.funcCallArgs().expression() != null) {
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExpNodes.add((ExpBaseNode) visit(sonctx));
            });
        }
        return ret;
    }

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
                ret.eachDimLengthExpNodes.add((ExpBaseNode) visit(sonctx.expression()));
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
