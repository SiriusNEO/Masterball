# IR Design



According to https://llvm.org/doxygen/IRBuilder_8h.html



## Printer

### Unit Display

- Value: display their identifier
- Type: use toString method

### Formatter

link unit in one line

### IRPrinter

link lines together, wrapper BasicBlocks, Functions and so on.

display the whole IR, finish IR generating.



## Hierarchy

### Module

- LLVM top module.

### Type

- LLVM IR type system.
- every type should override method **toString** to better display it.

### BaseValue

- value of everything. Records the user of this value.
- **Members:** name, type, users.
  - every value has its **identifier**. Default it is `%name` (local reg), for global value it is `@name`, for constant it is ...

### BaseUser

- The basic class of classes which can "use" a value.

- **Superclass:** Value 
- **Members:** operands (this user "uses" them)

### BaseInst

- Instructions. The value of Instruction means the return value. And it use some values.
- **Superclass: **BaseUser
- **Members:** parentBlock

### BasicBlock

- A block is a set of instructions which begins with a label. It is a value with LabelType.
- **Members: ** parentFunction

### Constant

- Constant. Functions are constants because their address is immutable.

- **Superclass: ** BaseUser

### GlobalValue

### Function

- Function. The arguments are seen as the operands of this User.

  The value of Function is its return value for convenience.

- **Superclass:** GlobalValue

### GlobalVariable

- **Superclass:** GlobalValue