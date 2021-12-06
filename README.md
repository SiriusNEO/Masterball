# Masterball

<img src="asset/masterball.png" style="zoom:100%;" />Masterball, an elaborate Mx* Compiler.

![](https://img.shields.io/badge/implementation-Java-red)  ![](https://img.shields.io/badge/semantic-passed-success)   ![](https://img.shields.io/badge/LLVM_IR-passed-success) 



## Mx*

Mx* or MxStar is a language designed for this course.

The grammar is defined in [AssignmentRequirement](doc/README.md)

a simple syntax highlight for this language: see `hightlight/`



## Feature

- `masterball.debug.Log` 
- Registry System in Semantic
- Friendly Error(Syntax/Semantic/Runtime) Report
- AST Printer for debugging
- LLVM IR with use-def and def-use chain



## Design

Click the following links to read the project design.

- [General Design](doc/GeneralDesign.md)
- [Grammar Design](src/masterball/grammar/MxStar.g4)
- [FrontEnd Design](doc/FrontEndDesign.md)
- [IR Design](doc/IRDesign.md)



## TO DO

Now in: `ASM`



### FrontEnd (Semantic Check)

- [x] .g4
- [x] AST Design
- [x] Scope & Registry
- [x] AST Builder
- [x] Semantic Checker
- [x] Data Oriented Debug



### MiddleEnd (IR Builder)

- [x] IR Design (LLVM IR)
- [x] Type, Constant, Inst, Hierarchy
- [x] Skeleton, can generate my first IR
- [x] Type System
- [x] IR Builder (before MEM2REG)
- [x] IR debug (use clang-llvm tools)



### BackEnd (ASM)

- [ ] ASM Design (RISCV-32I)
- [ ] Inst, Operand, Hierarchy
- [ ] RegisterAlloca (GraphColoring)
- [ ] ASMBuilder



### MiddleEnd (Optimizer)

Hope I will have time.



