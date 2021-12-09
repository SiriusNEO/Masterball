target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

declare i8* @_bot_malloc(i32)
declare i8* @_bot_str_cat(i8*, i8*)
declare i1 @_bot_str_eq(i8*, i8*)
declare i1 @_bot_str_ne(i8*, i8*)
declare i1 @_bot_str_slt(i8*, i8*)
declare i1 @_bot_str_sle(i8*, i8*)
declare i1 @_bot_str_sgt(i8*, i8*)
declare i1 @_bot_str_sge(i8*, i8*)
declare void @print(i8*)
declare void @println(i8*)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare i8* @getString()
declare i32 @getInt()
declare i8* @toString(i32)
declare i32 @_str_length(i8*)
declare i8* @_str_substring(i8*, i32, i32)
declare i32 @_str_parseInt(i8*)
declare i32 @_str_ord(i8*, i32)

define void @_glb_init() {
entry11:
  br label %exit11

exit11:                                                ; preds = %entry11 
  ret void
}

define i32 @main() {
entry12:
  %i.addr = alloca i32, align 4
  %f2.addr = alloca i32, align 4
  %f1.addr = alloca i32, align 4
  %f0.addr = alloca i32, align 4
  %n.addr = alloca i32, align 4
  %retreg.addr = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr, align 4
  store i32 10, i32* %n.addr, align 4
  store i32 0, i32* %f0.addr, align 4
  store i32 1, i32* %f1.addr, align 4
  %i.load = load i32, i32* %i.addr, align 4
  store i32 1, i32* %i.addr, align 4
  br label %for.cond

for.cond:                                                ; preds = %entry12, %for.incr 
  %i.load1 = load i32, i32* %i.addr, align 4
  %n.load = load i32, i32* %n.addr, align 4
  %icmp = icmp slt i32 %i.load1, %n.load
  br i1 %icmp, label %for.body, label %for.exit

for.incr:                                                ; preds = %for.body 
  %i.load2 = load i32, i32* %i.addr, align 4
  %add = add i32 %i.load2, 1
  store i32 %add, i32* %i.addr, align 4
  br label %for.cond

for.body:                                                ; preds = %for.cond 
  %f2.load = load i32, i32* %f2.addr, align 4
  %f0.load = load i32, i32* %f0.addr, align 4
  %f1.load = load i32, i32* %f1.addr, align 4
  %add1 = add i32 %f0.load, %f1.load
  store i32 %add1, i32* %f2.addr, align 4
  %f0.load1 = load i32, i32* %f0.addr, align 4
  %f1.load1 = load i32, i32* %f1.addr, align 4
  store i32 %f1.load1, i32* %f0.addr, align 4
  %f1.load2 = load i32, i32* %f1.addr, align 4
  %f2.load1 = load i32, i32* %f2.addr, align 4
  store i32 %f2.load1, i32* %f1.addr, align 4
  br label %for.incr

for.exit:                                                ; preds = %for.cond 
  %f2.load2 = load i32, i32* %f2.addr, align 4
  store i32 %f2.load2, i32* %retreg.addr, align 4
  br label %exit12

exit12:                                                ; preds = %for.exit 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

