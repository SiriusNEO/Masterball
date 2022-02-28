### Translation in Operand

AST -> IR -> Assembly. 

For each stage, there is a "basic element": BaseNode (in AST), Value (in IR), BaseOperand (in Asm). 

My design is 

```
class BaseNode {
	...
	Value value;
}

class Value {
	...
	BaseOperand asmOperand;
}
```

This structure shows the mapping clearly. 



### Translation in Type & Symbol

The type system of AST and LLVM IR are different. (And in RISCV assembly, the concept of type is simply like "lb", "lw")

So I designed `Translator` to deal with these. More precisely, `IRTranslator`  from AST to IR and `AsmTranslator` from IR to ASM.



### Type Matcher

Type match is the most important part of semantic check. 

Using a Type Matcher in FrontEnd makes it clear and simple.



### Registry

Registry (Type + Name). 

"Register a variable" in ASTBuilder.

And the registry will be translated in IR.  

This design is good because a registry is mapped to a value in IR. It is very convenient use a "registry system" to manage this.



### Formatter

Now you are going to print the code. IR and Assembly have their own grammars. 

But consider a instruction like `add  var1 var2` , what we do is just like `"add %a %b".format(a=var1, b=var2)`

Use a formatter to do these. There is no problem if these are implemented in Printer, but I like this way.



### Pass

in Masterball, Pass is a very basic concept. Almost everything is a pass——like LLVM.

Visitor are also seen as a type of pass.

Masterball defined passes in different levels (Module, Function, Block) so if you write a pass which passes each functions and each blocks, 

you can write as:

```
class MyPass implements IRFuncPass, IRBlockPass
```

even a AsmBuilder is a pass in Masterball! (It can be seen as a IRModule Pass)



### Value, User

This part refers to LLVM Project.



### Error and Warn

Masterball has two types of errors:

- Compiler Error, which happens in compiling.
- Console Error, which is mainly because wrong arguments.

There are three subtypes of Compiler Error:

- Syntax Error, failed in parsing.
- Semantic Error, failed in semantic check.
- Runtime Error, failed in codegen.

And there are also some warnings (like if you use a undefined variable) which helps programmer to check their code.

Each Error and Warning has detailed information.