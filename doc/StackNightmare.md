# StackNightmare

2021年12月13日，Sirius 得知 18 周的 DDL 不需要图染色，大惊，于是有如下暴力方案。

大体思路：全部放栈里

只用如下寄存器：

sp、ra、s0、t0、t1、t2、ai



## Stack Hierachy

第一层：func call。

第二层：alloca

第三层：virtual reg。

区分不同层的栈帧存于 Function 中。

func call 部分取 max。



## Alloca

alloca 一定在基本块头部。

对于每个 alloca，压栈。

alloca 的返回值是“地址”，在 Asm 中被解释为一个 StackOffset

怎样分配好 Alloca 和 Virtual Reg？



## Virtual Reg

虚拟寄存器（无限大），对标 IR 里的每个寄存器

之后会通过 StackNightmare 全部放入栈中。具体方式为：

```
add v0, v1, v2
```

to

```
lw t0, offset_t0(sp)
lw t1, offset_t1(sp)
lw t2, offset_t2(sp)
add t0, t1, t2
store t0, offset_t0(sp)
```

由于三地址码的特性，均使用 temporary 寄存器就够了。

因此就对 use load，对 def store。



## Func Call

~~Call 之前把所有参数都 spill 到内存里去。~~

还是要用 a0~a7，不然内建函数调用不了

多余的 spill 到内存

因为内建函数参数 <= 2，基本没有 spill 问题，保存好对应寄存器即可

因为第一层全部给 Func，所以就从 0 开始 +4 +4

然后 call。

在下一个函数头，会有一堆 load 指令。（在 sp 下调之前），把那些东西都 load 出来。

一个 Register 的  `stackPos` 到底是什么意思？

所有 Virtual Register 都应该有一个 stackPos！

（因为所有虚拟寄存器都要压栈）



## 理一理

```
define i32 @func(i32 %fa, i32 %fb) {
entry12:
  %fb.addr = alloca i32, align 4
  %fa.addr = alloca i32, align 4
  %retreg.addr = alloca i32, align 4
  store i32 %fa, i32* %fa.addr, align 4
  store i32 %fb, i32* %fb.addr, align 4
  %fa.load = load i32, i32* %fa.addr, align 4
  %fb.load = load i32, i32* %fb.addr, align 4
  %add = add i32 %fa.load, %fb.load
  store i32 %add, i32* %retreg.addr, align 4
  br label %exit12

exit12:                                                ; preds = %entry12 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

define i32 @main() {
entry13:
  %b.addr = alloca i32, align 4
  %a.addr = alloca i32, align 4
  %retreg.addr1 = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr1, align 4
  store i32 1, i32* %a.addr, align 4
  store i32 2, i32* %b.addr, align 4
  %a.load = load i32, i32* %a.addr, align 4
  %b.load = load i32, i32* %b.addr, align 4
  %func.call = call i32 @func(i32 %a.load, i32 %b.load)
  store i32 0, i32* %retreg.addr1, align 4
  br label %exit13

exit13:                                                ; preds = %entry13 
  %retreg.load1 = load i32, i32* %retreg.addr1, align 4
  ret i32 %retreg.load1
}
```



在 main 的时候，sp 下降 main 的**总空间大小**

前面三个 alloca，将  `%a.addr`  和 `%b.addr` 和 `%retreg.addr1`（这是 alloca inst，也是一个 IRValue）**赋形** 为一个 StackOffset（这是合理的吗？）

call，空函数不谈。

store 0 到 retreg.addr1 里，解释为直接 store 到那个 **StackOffset**

LLVM 架构本来就是 load 读，store 写，所以主要的是那些中间虚拟寄存器，它们也要在**栈分配空间**

它们都是虚拟寄存器！ 

Call 的参数寄存器在 Call 的时候分配 stackOffset

~~LLVM 的 “函数参数” 到底是什么啊？~~ Calling Convention

反正就 0~7 压栈，剩下 spill 呗



malloc 返回一个指针，这个指针可能被 store，怎么办？

store 加判断



```
entry12:
	addi sp, sp, -48
	addi s0, sp, 48
	mv v0, ra
	call _glb_init
	sw zero, 12(sp)
	lw v1, 0(sp)
	lw v2, 8(sp)
	lw v3, 4(sp)
	add v4, v2, v3
	sw v4, 0(sp)
	j exit12
exit12:
	lw v5, 12(sp)
	mv ra, v5
	mv ra, v0
	addi sp, sp, 48
	ret
```

