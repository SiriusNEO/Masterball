# Architecture



## Work Pipe

### Semantic
```mermaid
graph LR
I(Input) -->|code string| B(Lexer&Parser)
B -->|parse tree| A(ASTBuilder)
C--> |AST| S(SemanticChecker)
A --> |AST| C(RegistryCollector)
S --> |Exception| H(ExceptionHandler)
A--> |Scope| S

```

## AST Design

```
Instead of:
	exp -> atom:(exp) -> exp
We use:
	exp:(exp) -> atom
```



### Node Pack

A Node usually contains

- `CodePos`  used in throw Exception. All Nodes.

- `Scope`  used to manage namespace. Only three types of nodes have:

  - `RootNode`		
  - `ClassDefNode` 
  - `SuiteNode`

  And the visitor will pull the scope into the scope stack when they meeting a node with Scope.

- `Registry`  Only in "Def" Type Node.

  A Registry records the information need in define a variable/func/class, recorded in Scope to do semantic check.

- `<some son Nodes>`

  vary from different Nodes.

- `<some must information>`

  enum type or integer etc.



#### Node List

- `BaseNode`

- `RootNode`

- `ClassDefNode`

- `FuncDefNode`

- `SuiteNode`

- `VarDefNode`

- `StmtNode/`

  - `StmtBaseNode`

  - `IfStmtNode`
  - `ForStmtNode`
  - `WhileStmtNode`
  - `ReturnStmtNode`
  - `ControlStmtNode`
  - `VarDefStmtNode`
  - `PureStmtNode`

- `ExpNode/`

  - `ExpBaseNode`
  - `FuncCallExpNode`
  - `IndexExpNode`
  - `MemberExpNode`
  - `NewExpNode`
  
  - `PrefixExpNode`
  
  - `PostfixExpNode`
  - `BinaryExpNode`
  - `UnaryExpNode`
  - `AssignNode`



## Exception Design

### ExceptionType

Syntax Exception

Semantic Exception



## ScopeDesign

### ClassRegister

- Register All Class First -- To avoid:

  ```
  class A {B b;};
  class B {A a;};
  ```

  

### Scope

- `Base Scope`

- `Global Scope`

  Able to register: class, var, func

- `Locality Scope`

  Able to regiser: var

  Use in: func def, if/while/for stmt, scope in scope

- `Class Scope`

  Use in: class def

  Able to regiser: func var