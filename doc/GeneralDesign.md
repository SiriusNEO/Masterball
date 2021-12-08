# General



## Design Rules

- Simple and Clear
- Easy to read
- ~~High Performance~~ 
- Compromise



## Code Style

- Class Name: Upper Camel Case

- Variable Name: Lower Camel Case

- Package: All Lower Case

- Access Specifiers: 

  Most internal classes are **almost all public** for easy to access and manage. 

  The executors (classes between engine and compiler, e.g. , SemanticChecker): members are **private**, methods are public (for engine to access)

  The engine are **almost all public** for Masterball to link them. 
  
- Name Collision

  e.g. in LLVM IR and RV ASM, we all have class `BaseInst`

  if they present in the same file, Java will use the full path:

  `package masterball.compiler.middleend.llvmir.inst.BaseInst;`

  which is really ugly.

  in this case, use `IRBaseInst` and `ASMBaseInst` to discriminate them (and also it is easy for ready when you are doing some translation work)



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
