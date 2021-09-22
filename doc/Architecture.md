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

- RootNode

