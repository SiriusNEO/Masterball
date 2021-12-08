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
  %a.addr = alloca i32**, align 8
  %retreg.addr = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr, align 4
  %mul = mul i32 3, 8
  %add = add i32 %mul, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 3, i32* %bitcast, align 4
  %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast1 = bitcast i32* %getelementptr to i32**
  %getelementptr1 = getelementptr inbounds i32*, i32** %bitcast1, i32 3
  move %phi, %bitcast1
  br label %wh.cond

wh.cond:                                                ; preds = %entry12, %wh.body 
  %icmp = icmp ne i32** %phi, %getelementptr1
  br i1 %icmp, label %wh.body, label %wh.exit

wh.body:                                                ; preds = %wh.cond 
  %mul1 = mul i32 4, 4
  %add1 = add i32 %mul1, 4
  %_bot_malloc.call1 = call noalias i8* @_bot_malloc(i32 %add1)
  %bitcast2 = bitcast i8* %_bot_malloc.call1 to i32*
  store i32 4, i32* %bitcast2, align 4
  %getelementptr3 = getelementptr inbounds i32, i32* %bitcast2, i32 1
  %bitcast3 = bitcast i32* %getelementptr3 to i32*
  store i32* %bitcast3, i32** %phi, align 8
  %getelementptr2 = getelementptr inbounds i32*, i32** %phi, i32 1
  move %phi, %getelementptr2
  br label %wh.cond

wh.exit:                                                ; preds = %wh.cond 
  store i32** %bitcast1, i32*** %a.addr, align 8
  br label %exit12

exit12:                                                ; preds = %wh.exit 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

