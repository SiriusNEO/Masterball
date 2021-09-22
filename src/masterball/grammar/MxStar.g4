grammar MxStar;

// Parser

// 0 Code

mxStarCode
    :   (classDef | funcDef | varDefStmt)*
    ;

// 8 Class

classDef
    :   ClassKw Identifier classDefSuite SemiColon
    ;

classDefSuite
    :   LeftBrace (classConstructorDef | varDefStmt | funcDef)* RightBrace
    ;

classConstructorDef
    :   Identifier LeftParen RightParen suite
    ;

// 9 Function

funcDef
    :   funcRetType Identifier LeftParen funcDefArgs* RightParen suite
    ;

funcDefArgs
    :   varDefType Identifier (Comma varDefType Identifier)*
    ;

funcRetType
    :   VoidType
    |   varDefType
    ;

// 7 Variable

// 7.1 BuiltinType

builtinType: IntType | StringType | BoolType; // not include void because void can only use in func declaration

arrayType: LeftBracket RightBracket;

varDefType
    :   builtinType
    |   Identifier
    |   varDefType arrayType+
    ;

// 11 Statement

suite
    : LeftBrace statement* RightBrace
    ;

varDefStmt
    : varDefType Identifier (AssignOp expression)?
      (Comma Identifier (AssignOp expression)?)* SemiColon;
ifStmt: IfKw LeftParen expression RightParen suite;
whileStmt: WhileKw LeftParen expression RightParen suite;
forStmt: ForKw LeftParen expression? SemiColon expression? SemiColon RightParen suite;
returnStmt: ReturnKw expression? SemiColon;

statement
    :   ifStmt                                                                         #ifStmtL
    |   whileStmt                                                                      #whileStmtL
    |   forStmt                                                                        #forStmtL
    |   returnStmt                                                                     #returnStmtL
    |   BreakKw                                                                        #breakStmtL
    |   ContinueKw                                                                     #continueStmtL
    |   varDefStmt                                                                     #varDefStmtL
    |   expression SemiColon                                                           #singleExpStmtL
    |   SemiColon                                                                      #emptyStmtL
    ;

// 10 Expression
// Warning: Avoid Mutual Left Recursion!!!

// 10.1 Some Exp

funcCallExp: Identifier LeftParen expression (Comma expression)* RightParen;
newExp: NewKw varDefType (LeftParen RightParen)?;

// 10.2 Op Set

suffixOps: (IncrementOp | DecrementOp);
prefixOps: (IncrementOp | DecrementOp | BitNotOp | LogicNotOp | AddOp | SubOp);
shiftOps: (ArithShiftLeftOp | ArithShiftRightOp);
mulLevelOps: (MulOp | DivOp | ModOp);
addLevelOps: (AddOp | SubOp);
compareOps: (GreaterOp | GreaterEqualOp | LessOp | LessEqualOp);
equalOps: (EqualOp | NotEqualOp);

expression
    :   atom                                                                            #singleAtomL   // 0
    |   LeftParen expression RightParen                                                 #parenExpL     // 1

    |   expression LeftBracket expression RightBracket                                  #indexExpL     // 1
    |   expression MemberOp Identifier                                                  #memberExpL    // 1
    |   funcCallExp                                                                     #funcCallExpL  // 1

    |   expression suffixOps                                                            #suffixExpL    // 2

    |   prefixOps expression                                                            #prefixExpL    // 3
    |   newExp                                                                          #newExpL       // 3

    |   expression shiftOps expression                                                  #logicExpL     // 4

    |   expression mulLevelOps expression                                               #mulLevelExpL       // 5
    |   expression addLevelOps expression                                               #addLevelExpL       // 6

    |   expression compareOps expression                                                #compareExpL   // 8
    |   expression equalOps expression                                                  #equalExpL     // 9
    |   expression BitAndOp expression                                                  #bitAndExpL    // 10
    |   expression BitXorOp expression                                                  #bitXorExpL    // 11
    |   expression BitOrOp expression                                                   #bitOrExpL     // 12
    |   expression LogicAndOp expression                                                #logicAndExpL  // 13
    |   expression LogicOrOp expression                                                 #logicOrExpL   // 14
    |   <asso=right> expression AssignOp expression                                     #assignExpL    // 16
    //|   expression Comma expression                                                     #commaExpL     // 18
    ;

atom
    :   Identifier                            #identifierL
    |   IntegerConstant                       #intL
    |   StringConstant                        #stringL
    |   FalseConstant                         #falseL
    |   TrueConstant                          #trueL
    |   NullConstant                          #nullL
    |   ThisPointer                           #thisL
    ;

// Lexer

// 1 Operator

// 1.1 Std Op
AddOp: '+' ;
SubOp: '-' ;
MulOp: '*' ;
DivOp: '/' ;
ModOp: '%' ;

// 1.2 Relation Op
GreaterOp: '>' ;
LessOp: '<' ;
GreaterEqualOp: '>=' ;
LessEqualOp: '<=' ;
NotEqualOp: '!=' ;
EqualOp: '==' ;

// 1.3 Logic Op
LogicAndOp: '&&' ;
LogicOrOp: '||' ;
LogicNotOp: '!' ;

// 1.4 Bit Op
ArithShiftLeftOp: '<<' ;
ArithShiftRightOp: '>>' ;
BitAndOp: '&' ;
BitOrOp: '|' ;
BitXorOp: '^' ;
BitNotOp: '~' ;

// 1.5 Assign Op
AssignOp: '=' ;

// 1.6 Increment & Decrement Op
IncrementOp: '++' ;
DecrementOp: '--' ;

// 1.7 Member Op
MemberOp: '.' ;

// 1.8 Index Op
LeftBracket: '[';
RightBracket: ']';

// 1.9 Priority Op
LeftParen: '(';
RightParen: ')';

// 1.10 Seperator Op
SemiColon: ';';
Comma: ',';
LeftBrace: '{';
RightBrace: '}';

// 1.11 String Op
QuoteOp: '"';

// 2.Keyword

// 2.1 Basic Type Keyword
IntType: 'int' ;
BoolType: 'bool' ;
StringType: 'string' ;
VoidType: 'void' ;

// 2.2 Constant Keyword
NullConstant: 'null' ;
TrueConstant: 'true' ;
FalseConstant: 'false' ;

// 2.3 Control Keyword
IfKw: 'if' ;
ElseKw: 'else' ;
ForKw: 'for' ;
WhileKw: 'while' ;
BreakKw: 'break' ;
ContinueKw: 'continue' ;
ReturnKw: 'return' ;

// 2.4 Class Related Keyword
NewKw: 'new' ;
ClassKw: 'class' ;
ThisPointer: 'this' ;

// 3 Blank
WhitespaceEater: [ \t]+ -> skip ;
NewlineEater: ('\r' '\n'?| '\n') -> skip ;

// 4 Comment
LineCommentEater: '//' ~[\r\n]* -> skip ;
BlockCommentEater: '/*' .*? '*/' -> skip ;

// 5 Identifier
Identifier: [a-zA-Z] [a-zA-Z_0-9]* ;

// 6 Constant

// 6.1 Integer Constant
IntegerConstant
    :   '0'
    |   [1-9][0-9]*
    ;

// 6.2 String Constant

EscapeEnter: '\\n';
EscapeBackslash: '\\\\';
EscapeQuote: '\\"';
StringContent: [ -~] ; // is this all printable character?

StringConstant
    :   QuoteOp (EscapeEnter | EscapeBackslash | EscapeQuote | StringContent)* QuoteOp
    ;

// 6.3 Bool Constant -> Keyword
// 6.4 Null Constant -> Keyword