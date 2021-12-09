# BackEnd Design



## Operand

similar to "Value" in IR.

in ASM we directly use `toString` method to print the identifier of a Operand because 

there are no type in ASM and instructions and operands are seperated. (see the reason in IR)

Without these confusions, we override `toString` method so that we can directly write:

```
String.format("%s %s %s", RVTable.LiInst, rd, imm);
```



## ASMBuilder



