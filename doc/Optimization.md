The optimization mainly consists of two parts

- MiddleEnd (performing in IR/MIR)
- BackEnd (performing in Assembly/LIR)



### Middle End

- Mem2Reg
- Global Variable Localization (Glo2Loc)
- Aggressive Dead Code Elimination (ADCE)

- Sparse Conditional Constant Propagation (SCCP)
- Inline
  - including force inlining
- CFG Simplifier
  - remove unreachable blocks
  - merge blocks
- Global Value Numbering (GVN)
- Local Memory Optimization
  - Remove redundant load/store in a block
  - And use the dominator's information to remove the dominated blocks load/store.
- Tail Recursion Optimization (TRO)
- Loop Invariant Code Motion
- Induction Variable Transform
  - Strength Reduction
- Instruction Adapter
  - print(toString) -> printInt
- Logic And/Or Optimization
  -  `a && b` can be transformed to `a & b` if there is no side effect.



### Back End

- Coalesce Moves

  - delete `move  a  a`

- Reorder Blocks

  - because jump also costs 1 cycle.

- Tail Call Optimization (TCO) 

  - use `tail` to replace `call`

- Block Merge

- ZeroInst Peephole

  - delete `addi a, 0` 

- LoadStore Peephole

  - ```
    sw t0, addr
    ...
    lw t0, addr
    ```

    If t0 do not change, there is no need to load again. So delete the lw.

- Redundant Instruction Optimization

  - folding addi, move
  - remove instructions which are defined but not used.