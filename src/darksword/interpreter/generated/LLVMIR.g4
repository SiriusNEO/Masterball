grammar LLVMIR;

llvmIR: (targetInfo | funcDecl | funcDef)* EOF;

// target info
targetInfo: sourceFn | dataLayout | targetTriple;
sourceFn: 'source_filename' '=' InfoStr;
dataLayout: 'target' 'datalayout' '=' InfoStr;
targetTriple: 'target' 'triple' '=' InfoStr;

// function
funcHeader: GlobalReg '(' (type LocalReg? (',' type LocalReg?)*)? ')';
funcDecl: 'declare' type funcHeader;
funcDef: 'define' type funcHeader '{' (basicBlock)* '}';

// block
basicBlock: Identifier ':' (instruction)*;

// inst
instDest: LocalReg '=';

phiBranch: '[' atom ',' atom ']';

instruction
    :   instDest 'alloca' type (',' align)?                          #alloca
    |   instDest (binaryOp = 'add' | 'sub' | 'mul' | 'sdiv' | 'srem' | 'shl' | 'ashr' | 'and' | 'or' | 'xor')
        type (lsrc = atom) ',' (rsrc = atom)                         #binary
    |   instDest '=' 'bitcast' type (src = atom) 'to' type           #bitcast
    |   instDest 'trunc'   type (src = atom) 'to' type               #trunc
    |   instDest 'zext'    type (src = atom) 'to' type               #zext
    |   'br' type atom                                               #br
    |   'br' type (src = atom) ',' type atom ',' type atom           #br
    |   instDest? 'call' type funcHeader                             #call
    |   instDest 'getelementptr'
        type ',' type (src = atom) (offset = ',' type atom)*         #getelementptr
    |   instDest 'icmp'
        (cmpOp = 'sgt' | 'sge' | 'slt' | 'sle' | 'eq' | 'ne')
        type (lsrc = atom) (rsrc = atom)                             #icmp
    |   instDest 'load'  type ',' type atom (',' align)?             #load
    |   'store' type atom ',' type atom (',' align)?                 #store
    |   'ret' type (atom)?                                           #ret
    |   instDest 'phi' type phiBranch (',' phiBranch)*               #phi
    ;

// atom
atom: GlobalReg | LocalReg | integerConstant | stringConstant | NullptrConstant | BoolConstant;

// align
align: 'align' IntegerLiteral;

// type
type: type '*' | basicType | arrayType;
arrayType: '[' IntegerLiteral 'x' type ']';
basicType: IntType | VoidType | LabelType | LocalReg; // struct type

IntType: 'i' IntegerLiteral;
VoidType: 'void';
LabelType: 'label';

// register
GlobalReg: '@' Identifier;
LocalReg: '%' Identifier;

// constant
integerConstant: IntegerLiteral | '-' IntegerLiteral;

// basic
IntegerLiteral: '0' | [1-9][0-9]*;
Identifier: [a-zA-Z_0-9.]+;

// eater
WhitespaceEater: [ \t]+ -> skip ;
NewlineEater: ('\r' '\n'?| '\n') -> skip ;
LineCommentEater: ';' ~[\r\n]* -> skip ;

// string (must after eater)
EscapeEnter: '\\n';
EscapeBackslash: '\\\\';
EscapeQuote: '\\"';
StringLiteral: [ -~];

stringConstant
    :   'c"' (EscapeEnter | EscapeBackslash | EscapeQuote | StringLiteral)*? '\\00"'
    ;

NullptrConstant: 'null';
BoolConstant: 'true' | 'false';

InfoStr: '"' (StringLiteral)*? '"';
