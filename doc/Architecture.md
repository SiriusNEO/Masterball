# Architecture

Now in: `semantic check`



## Design Rules

- Simple and Clear
- High Performance
- Compromise



## Structure

### File Structure

```
src/masterball/
- compiler (core)
  - antlr
  - org
  - frontend
  - backend
  - repository
  - optimizer
- debugger
- engine
- grammar
  - g4
```



### Work Structure

```mermaid
graph LR
A(Input) -->|code string| B(Lexer&Parser)
B -->|parse tree| C(FrontEnd.ASTBuilder)
B -->|parse tree| D(FrontEnd.SemanticChecker)
```


```mermaid
graph LR
A(FrontEnd.ASTBuilder) --> |AST| R(Repository)
S(FrontEnd.SemanticChecker) --> |Exception| R

R --> |AST| I(FrontEnd.IRBuilder)
I --> |IR from AST| R
R --> |AST| F(FrontEnd.ScopeBuilder)
F --> |Scope| R
R --> |IR before opm| E(Optimizer)
E --> |IR after opm| R

R --> |Exception| H(FrontEnd.ExceptionHandler)
H --> |throw| O(Output)

```


## AST Design

```
Instead of:
	exp -> atom:(exp) -> exp
	suite -> stmt:(suite) -> suite
We use:
	exp:(exp) -> atom
	suite:{suite} -> suite
```



### Type Pack



### Node Pack

- BaseNode

- RootNode

  ```
  List <ClassDefNode>
  List <FuncDefNode>
  List <VarDefStmtNode>
  ```

- ClassDefNode

  ```
  classIdentifier
  List <VarDefStmtNode> memberVar
  List <FuncDefNode> mermberFunc
  ```

- FuncDefNode

  ```
  funcIdentifier
  retType
  List funcArgs
  SuiteNode suiteNode
  ```

- SuiteNode/

  - SuiteBaseNode

  - SuiteNode

- StmtNode/

  - StmtBaseNode

  - IfStmtNode
  - ForStmtNode
  - WhileStmtNode
  - ReturnStmtNode
  - ControlStmtNode
  - VarDefStmtNode
  - PureDefStmtNode

- ExpNode/

  - ExpBaseNode
  - FuncCallExpNode
  - IndexExpNode
  - MemberExpNode
  - NewExpNode
- PrefixExpNode
  - PostfixExpNode
  - BinaryExpNode
  - UnaryExpNode
  - AssignNode

