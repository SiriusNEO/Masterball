package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.VarDefSingleNode;
import masterball.compiler.frontend.ast.node.expnode.*;
import masterball.compiler.frontend.ast.node.stmtnode.ForStmtNode;
import masterball.compiler.frontend.ast.node.stmtnode.IfStmtNode;
import masterball.compiler.frontend.ast.node.stmtnode.WhileStmtNode;
import masterball.compiler.frontend.error.semantic.TypeError;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.utils.GrammarTable;

import java.util.Objects;

public class TypeMatcher {

    // unary:
    // LogicNot (!) -> bool
    // others (+ - ~) -> int
    public static void match(UnaryExpNode node) {
        if (Objects.equals(node.op, GrammarTable.LogicNotOp)) {
            if (!node.selfExpNode.type.match(BaseType.BuiltinType.BOOL)) {
                throw new TypeError(node.codePos, BaseType.BuiltinType.BOOL, node.selfExpNode.type);
            }
        } else {
            if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
                throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
            }
        }
    }

    // prefix: --a, ++a -> int, leftValue
    public static void match(PrefixExpNode node) {
        if (!node.selfExpNode.isLeftValue()) {
            throw new TypeError(node.codePos, TypeError.prefixAndPostfix);
        }
        if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
        }
    }

    // postfix: a++, a-- -> int, leftValue
    public static void match(PostfixExpNode node) {
        if (!node.selfExpNode.isLeftValue()) {
            throw new TypeError(node.codePos, TypeError.prefixAndPostfix);
        }
        if (!node.selfExpNode.type.match(BaseType.BuiltinType.INT)) {
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.selfExpNode.type);
        }
    }

    // member: a.b, a -> class (str and array is checked in semantic checker)
    public static void match(MemberExpNode node) {
        if (!node.superExpNode.type.match(BaseType.BuiltinType.CLASS)) {
            throw new TypeError(node.codePos, TypeError.typeNotCallable, node.superExpNode.type);
        }
    }

    //index: a[b], a -> subscribable, b -> int
    public static void match(IndexExpNode node) {
        if (!(node.arrayExpNode.type instanceof VarType)) {
            throw new TypeError(node.codePos, TypeError.typeNotSubscribable, node.arrayExpNode.type);
        }
        if (((VarType) node.arrayExpNode.type).dimension == 0) {
            throw new TypeError(node.codePos, TypeError.typeNotSubscribable, node.arrayExpNode.type);
        }
        assert node.indexExpNode != null;
        if (!node.indexExpNode.type.match(BaseType.BuiltinType.INT)) {
            throw new TypeError(node.codePos, BaseType.BuiltinType.INT, node.indexExpNode.type);
        }
    }

    // binary: a op b


    // str & str: == != >= <= > < +

    // logicOps: bool && bool
    // arithOps: int + int
    // compare: int > int
    // == !=: all

    public static void match(BinaryExpNode node) {
        if (!node.lhsExpNode.type.match(node.rhsExpNode.type)) {
            throw new TypeError(node.codePos, node.lhsExpNode.type, node.rhsExpNode.type);
        }

        if (node.lhsExpNode.type.match(BaseType.BuiltinType.STRING)) {
            if (!Objects.equals(node.op, GrammarTable.AddOp) &&
                !Objects.equals(node.opType, GrammarTable.compareOpType) &&
                !Objects.equals(node.opType, GrammarTable.equalOpType)
            ) {
                throw new TypeError(node.codePos, TypeError.invalidOpForType, node.lhsExpNode.type);
            }
            return;
        }

        if (Objects.equals(node.opType, GrammarTable.logicOpType)) {
            if (!node.lhsExpNode.type.match(BaseType.BuiltinType.BOOL))
                throw new TypeError(node.codePos, TypeError.invalidOpForType, node.lhsExpNode.type);
        }

        else if (Objects.equals(node.opType, GrammarTable.arithOpType)) {
            if (!node.lhsExpNode.type.match(BaseType.BuiltinType.INT))
                throw new TypeError(node.codePos, TypeError.invalidOpForType, node.lhsExpNode.type);
        }

        else if (Objects.equals(node.opType, GrammarTable.compareOpType)) {
            if (!node.lhsExpNode.type.match(BaseType.BuiltinType.INT))
                throw new TypeError(node.codePos, TypeError.invalidOpForType, node.lhsExpNode.type);
        }
    }

    //assignment: a = b -> a.type == b.type, a is left-value
    public static void match(AssignExpNode node) {
        if (!node.lhsExpNode.isLeftValue()) {
            throw new TypeError(node.codePos, TypeError.assignment);
        }
        if (!node.lhsExpNode.type.match(node.rhsExpNode.type)) {
            throw new TypeError(node.codePos, node.lhsExpNode.type, node.rhsExpNode.type);
        }
    }

    //vardeclaration: int a = 1, c = 2;
    public static void match(VarDefSingleNode node) {
        if (!node.varRegistry.type.match(node.initExpNode.type)) {
            throw new TypeError(
                    node.codePos, node.varRegistry.type, node.initExpNode.type
            );
        }
    }

    // forstmt: condi is bool
    public static void match(ForStmtNode node) {
        if (!node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
    }

    // while stmt: condi is bool
    public static void match(WhileStmtNode node) {
        if (!node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
    }

    // if stmt: condi is bool
    public static void match(IfStmtNode node) {
        if (!node.conditionExpNode.type.match(BaseType.BuiltinType.BOOL)) {
            throw new TypeError(
                    node.codePos, BaseType.BuiltinType.BOOL, node.conditionExpNode.type
            );
        }
    }

    // new: int[][] a = new int[][];
    // index -> int
    public static void match(NewExpNode node) {
        for (ExpBaseNode eachDimExpNode : node.eachDimExpNodes) {
            if (!eachDimExpNode.type.match(BaseType.BuiltinType.INT)) {
                throw new TypeError(node.codePos, BaseType.BuiltinType.INT, eachDimExpNode.type);
            }
        }
    }
}
