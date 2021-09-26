package masterball.debugger;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.*;
import masterball.compiler.frontend.ast.node.stmtnode.PureStmtNode;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;

public class ASTPrinter implements ASTVisitor {

    @Override
    public void visit(RootNode node) {
        System.out.println("* --- RootNode --- *");

        System.out.println("GlobalScope VarTable: " + node.scope.varTable.toString());
        System.out.println("GlobalScope FuncTable: " + node.scope.funcTable.toString());
        System.out.println("GlobalScope ClassTable: " + node.scope.classTable.toString());

        for (ClassDefNode classDefNode : node.classDefNodes) visit(classDefNode);
        for (FuncDefNode funcDefNode : node.globalFuncDefNodes) visit(funcDefNode);
        for (VarDefStmtNode varDefStmtNode : node.globalVarDefStmtNodes) visit(varDefStmtNode);
    }

    @Override
    public void visit(ClassDefNode node) {
        System.out.println("* --- ClassDefNode --- *");
    }

    @Override
    public void visit(FuncDefNode node) {

    }

    @Override
    public void visit(VarDefSingleNode node) {

    }

    @Override
    public void visit(VarDefStmtNode node) {

    }

    @Override
    public void visit(SuiteNode node) {

    }

    @Override
    public void visit(SuiteStmtNode node) {

    }

    @Override
    public void visit(IfStmtNode node) {

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(ReturnStmtNode node) {

    }

    @Override
    public void visit(ControlStmtNode node) {

    }

    @Override
    public void visit(PureStmtNode node) {

    }

    @Override
    public void visit(AssignExpNode node) {

    }

    @Override
    public void visit(BinaryExpNode node) {

    }

    @Override
    public void visit(FuncCallExpNode node) {

    }

    @Override
    public void visit(IndexExpNode node) {

    }

    @Override
    public void visit(MemberExpNode node) {

    }

    @Override
    public void visit(NewExpNode node) {

    }

    @Override
    public void visit(PostfixExpNode node) {

    }

    @Override
    public void visit(PrefixExpNode node) {

    }

    @Override
    public void visit(UnaryExpNode node) {

    }

    @Override
    public void visit(LambdaExpNode node) {

    }
}
