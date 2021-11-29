# General



## Design Rules

- Simple and Clear
- Easy to read
- ~~High Performance~~ 
- Compromise



## Java Code Style

- Class Name: Upper Camel Case
- Variable Name: Lower Camel Case
- Package: All Lower Case

- Access Specifiers: 

  Most internal classes are **all public** for easy to access and manage. 

  The executors (classes between engine and compiler, e.g. , SemanticChecker): members are private, methods are public (for engine to access)

  The engine are **all public** for Masterball to link them. 



## File Structure

```
src
- org (from antlr)
- masterball
    - compiler (core)
      - frontend
      - backend
      - optimizer
    - debugger
    - engine
    - grammar
      - g4  
```
