package masterball.compiler.frontend.ast;

import masterball.compiler.frontend.ast.node.ClassDefNode;
import masterball.compiler.frontend.ast.node.FuncDefNode;
import masterball.compiler.frontend.ast.node.stmtnode.PureStmtNode;
import masterball.compiler.frontend.ast.node.RootNode;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.*;
import masterball.compiler.frontend.ast.node.SuiteNode;

public interface ASTVisitor {
    // Entry Node
    void visit(RootNode node);
    void visit(ClassDefNode node);
    void visit(FuncDefNode node);

    // Suite
    void visit(SuiteNode node);

    //Stmt
    void visit(SuiteStmtNode node);
    void visit(IfStmtNode node);
    void visit(WhileStmtNode node);
    void visit(ForStmtNode node);
    void visit(ReturnStmtNode node);
    void visit(ControlStmtNode node);
    void visit(VarDefStmtNode node);
    void visit(PureStmtNode node);

    //Exp
    void visit(AssignExpNode node);
    void visit(BinaryExpNode node);
    void visit(FuncCallExpNode node);
    void visit(IndexExpNode node);
    void visit(MemberExpNode node);
    void visit(NewExpNode node);
    void visit(PostfixExpNode node);
    void visit(PrefixExpNode node);
    void visit(UnaryExpNode node);
}
