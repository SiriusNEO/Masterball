# IR Design



According to https://llvm.org/doxygen/IRBuilder_8h.html



## Printer

### Unit Display

- Value: display their identifier `identifier`
- Type: use toString method

### Formatter

link unit in one line.

every instructions override `format` methods

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



## Type System

### Function

- **Members:** retType, argTypes
- initialized in func declare (function value initialized in func def)
- decl first (forward reference support)

### Bool

There are two types for boolean: BoolType(i1) and MemBoolType(i8)

Converted in three mem operations (alloca, load, store)

- alloca: alloca boolType -> alloca memBoolType
- load: load memBoolType -> load boolType
- store: store boolType -> store memBoolType

### String

string variable is a pointer i8* (translated)

string constant is a pointer to ArrayType ([ n x i8 ], same as i8*)

getelmentptr [4 x i8], <string constant typedIdentifier>, offset1, offset2 

### Array

PointerType, alloca a single PointerType and assign null at first.

Different from Mx grammar (`.size()`), I use `length` to represent the number of elements and `size` to represent the bytes.

### Class

Class is a Type in LLVM rather than Value. But for assigning a value to ClassRegistry, we use a `ClassProto` which is a Value

In LLVM, `Structure Type` can be used to implement it.

Declare first.

Translator will translate MxStarClass to IRStructType*



## Pass



### SSADestructor

is a Function Pass.

mainly for Resolve Phi.



##### ParaCopy

`%indvar = phi i32 [ 0, %LoopHeader ], [ %nextindvar, %Loop ]`

as its name, it is a parallel copy with %indvar <- 0 and %indar <- %nextindvar

use a CopyMap with Block -> ParaCopy



##### Step 1. Critical Edge Split

Critical edge is an edge in CFG which connects A block and B block: 

- A has multiple successors.
- B has multiple predecessors.

if we simply put the copy in this case, it will cause redundancy.



##### Step 2. Build CopyGraph

a copy is a directed edge like:

```
dest <- source
```

Then we maintain a copy list to eliminate.



### Step 3. Copy Eliminate

Notice that if we have:

```T
A <- B
B <- C
```

Then 1 must be done after 2.

if we have

```
A <- B
B <- C
C <- A
```

which is a ring, then we do

```
A <- A' <- B
```

 And we commit A1 <- B first, then it will be converted into a chain

```
A <- A'
C <- A
B <- C
```



