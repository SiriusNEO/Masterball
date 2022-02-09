package masterball.compiler.frontend.ast;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.share.pass.ASTVisitor;
import masterball.debug.Log;

import java.io.PrintStream;

public class ASTPrinter implements ASTVisitor {

    private static final String INDENT = "..";

    private int nowIndentNum = 0;
    private PrintStream ps;

    public ASTPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void visit(RootNode node) {
        nowIndentNum++;
        Log.info("AST Printer Start Sucess");
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- RootNode --- *\n");
        ps.println(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(ClassDefNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ClassDefNode --- *\n");
        ps.println(node.classRegistry);
        if (node.constructorDefNode != null) visit(node.constructorDefNode);
        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));
        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(FuncDefNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncDefNode --- *\n");
        ps.println(node.funcRegistry);
        if (node.suiteNode != null) visit(node.suiteNode);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefSingleNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefSingleNode --- *\n");
        ps.println(node.varRegistry);
        if (node.initExpNode != null) node.initExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefStmtNode --- *\n");
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
        nowIndentNum--;
    }

    @Override
    public void visit(SuiteNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- SuiteNode --- *\n");
        ps.println(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(SuiteStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- SuiteStmtNode --- *\n");
        visit(node.suiteNode);
        nowIndentNum--;
    }

    @Override
    public void visit(IfStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IfStmtNode --- *\n");
        ps.println("condi: ");
        node.conditionExpNode.accept(this);
        ps.println("if true: ");
        node.ifTrueStmtNode.accept(this);
        ps.println("else: ");
        if (node.elseStmtNode != null) node.elseStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(WhileStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- WhileStmtNode --- *\n");
        ps.println("condi: ");
        if (node.conditionExpNode != null) node.conditionExpNode.accept(this);
        ps.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ForStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ForStmtNode --- *\n");
        ps.println("init: ");
        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        ps.println("condi: ");
        if (node.conditionExpNode != null) node.conditionExpNode.accept(this);
        ps.println("incr: ");
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        ps.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ReturnStmtNode --- *\n");
        if (node.retExpNode != null) node.retExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ControlStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ControlStmtNode --- *\n");
        ps.println(node.controlWord);
        nowIndentNum--;
    }

    @Override
    public void visit(PureStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PureStmtNode --- *\n");
        if (node.expNode != null) node.expNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(AssignExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AssignExpNode --- *\n");
        ps.println("type: " + node.type);
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(BinaryExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- BinaryExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(FuncCallExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncCallExpNode --- *\n");
        ps.println("type: " + node.type);
        node.callExpNode.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(IndexExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IndexExpNode --- *\n");
        ps.println("type: " + node.type);
        if (node.arrayExpNode != null) node.arrayExpNode.accept(this);
        if (node.indexExpNode != null) node.indexExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(MemberExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- MemberExpNode --- *\n");
        ps.println("type: " + node.type);
        if (node.superExpNode != null) node.superExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(NewExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- NewExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("NewType: " + node.type);
        // new exp type is determined in ASTBuilder
        nowIndentNum--;
    }

    @Override
    public void visit(PostfixExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PostfixExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(PrefixExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PrefixExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(UnaryExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- UnaryExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(LambdaExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- LambdaExpNode --- *\n");
        ps.println(node.funcRegistry);
        node.suiteNode.accept(this);
        ps.println("type: " + node.type);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(AtomExpNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AtomExpNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("text: " + node.ctx.getText());
        nowIndentNum--;
    }
}
