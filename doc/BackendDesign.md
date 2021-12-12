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

### RV32 Inst

required:

- Arithm

  contains arithmetic operations and logic operations.

  notice: RType, IType.

  Different constructor and format

- Branch

- Jump

- Li

- Load

- Store

- Lui

- Move

- Ret



### Selector

- Alloca

  pass.

- Binary

  simply use arithm.

- BitCast

  Mv

- Br

  if it is a jump, use jump.

  use `beq`

- Call

  Mv fist 8 params to register.

  Other spill to stack.

  use call pseudo inst.

- ICmp

  use slt and seqz

  use xor to implement `!`

- Load

- Store

  Notice: Hi Lo

  if it is global, use LUI

- Return

  store the value in a0 (is a1 needed?)

  return is done in visit(Func) (a simple ret)

- GetElementPtr

  1. calculate the address by insert Arithm inst.
  2. use Mv to get ptr.

- Move

  Mv

- Zext / Trunc

  Mv

