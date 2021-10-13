package masterball.debugger;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.stmtnode.PureStmtNode;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;

public class ASTPrinter implements ASTVisitor {

    public int nowIndentNum = 0;
    public final String INDENT = "..";

    @Override
    public void visit(RootNode node) {
        nowIndentNum++;
        System.out.println("\nAST Printer Start Printing!!!!!!!!");
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- RootNode --- *\n");
        System.out.println(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(ClassDefNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ClassDefNode --- *\n");
        System.out.println(node.classRegistry);
        if (node.constructorDefNode != null) visit(node.constructorDefNode);
        node.varDefStmtNodes.forEach(sonnode -> sonnode.accept(this));
        node.funcDefNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(FuncDefNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncDefNode --- *\n");
        System.out.println(node.funcRegistry);
        if (node.suiteNode != null) visit(node.suiteNode);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefSingleNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefSingleNode --- *\n");
        System.out.println(node.varRegistry);
        if (node.initExpNode != null) node.initExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefStmtNode --- *\n");
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
        nowIndentNum--;
    }

    @Override
    public void visit(SuiteNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- SuiteNode --- *\n");
        System.out.println(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(SuiteStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- SuiteStmtNode --- *\n");
        visit(node.suiteNode);
        nowIndentNum--;
    }

    @Override
    public void visit(IfStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IfStmtNode --- *\n");
        System.out.println("condi: ");
        node.conditionExpNode.accept(this);
        System.out.println("if true: ");
        node.ifTrueStmtNode.accept(this);
        System.out.println("else: ");
        if (node.elseStmtNode != null) node.elseStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(WhileStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- WhileStmtNode --- *\n");
        System.out.println("condi: ");
        if (node.conditionExpNode != null) node.conditionExpNode.accept(this);
        System.out.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ForStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ForStmtNode --- *\n");
        System.out.println("init: ");
        if (node.initExpNode != null) node.initExpNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        System.out.println("condi: ");
        if (node.conditionExpNode != null) node.conditionExpNode.accept(this);
        System.out.println("incr: ");
        if (node.incrExpNode != null) node.incrExpNode.accept(this);
        System.out.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ReturnStmtNode --- *\n");
        if (node.retExpNode != null) node.retExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ControlStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ControlStmtNode --- *\n");
        System.out.println(node.controlWord);
        nowIndentNum--;
    }

    @Override
    public void visit(PureStmtNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PureStmtNode --- *\n");
        if (node.expNode != null) node.expNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(AssignExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AssignExpNode --- *\n");
        System.out.println("type: " + node.type);
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(BinaryExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- BinaryExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("op: " + node.op);
        if (node.lhsExpNode != null) node.lhsExpNode.accept(this);
        if (node.rhsExpNode != null) node.rhsExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(FuncCallExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncCallExpNode --- *\n");
        System.out.println("type: " + node.type);
        node.callExpNode.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(IndexExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IndexExpNode --- *\n");
        System.out.println("type: " + node.type);
        if (node.arrayExpNode != null) node.arrayExpNode.accept(this);
        if (node.indexExpNode != null) node.indexExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(MemberExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- MemberExpNode --- *\n");
        System.out.println("type: " + node.type);
        if (node.superExpNode != null) node.superExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(NewExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- NewExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("NewType: " + node.type);
        // new exp type is determined in ASTBuilder
        nowIndentNum--;
    }

    @Override
    public void visit(PostfixExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PostfixExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(PrefixExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PrefixExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(UnaryExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- UnaryExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("op: " + node.op);
        if (node.selfExpNode != null) node.selfExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(LambdaExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- LambdaExpNode --- *\n");
        System.out.println(node.funcRegistry);
        node.suiteNode.accept(this);
        System.out.println("type: " + node.type);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(AtomExpNode node) {
        nowIndentNum++;
        System.out.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AtomExpNode --- *\n");
        System.out.println("type: " + node.type);
        System.out.println("text: " + node.ctx.getText());
        nowIndentNum--;
    }
}
