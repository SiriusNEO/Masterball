# BackEnd Design



## Operand

similar to "Value" in IR.

in ASM we directly use `toString` method to print the identifier of a Operand because 

there are no type in ASM and instructions and operands are seperated. (see the reason in IR)

Without these confusions, we override `toString` method so that we can directly write:

```
String.format("%s %s %s", RVTable.LiInst, rd, imm);
```



### Register

- PhysicalReg

  representing the true physical register of RV32 architecture.

  - caller-saved register: `ra, t0-6, a0-7`

    caller-saved 意思为 caller is responsible for these registers, 因此 caller 有责任在调用前将这些寄存器压入堆栈（或其他位置）

  - callee-saved register: `s0-11`

    callee 在执行完之后，返回前，有责任恢复这部分寄存器

  - special: `zero, sp, gp, tp`

- VirualReg

- GlobalReg



### Stack

假设该函数栈空间使用了 totalStackUsed

开辟栈空间（函数头）：

```
addi sp, sp, -totalStackUsed
```

回收栈空间（函数尾）：

```
addi sp, sp, totalStackUsed
```



### Alloca 的处理

```
%a.addr = alloca i32, align 4
```

实际上是在栈上分配 4 byte 空间



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



## Register Allocator

see [this doc](RegisterAllocation.md)