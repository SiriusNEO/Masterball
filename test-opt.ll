; ModuleID = 'test'
source_filename = "test"
target datalayout = "e-m:e-p:32:32-i64:64-n32-S128"
target triple = "riscv32"

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

@anon.strconst = private unnamed_addr constant [6 x i8] c"Hello\00", align 1

define void @_glb_init() {
entry11:
  br label %exit11

exit11:                                                ; preds = %entry11 
  ret void
}

define i32 @main() {
entry12:
  %retreg.addr = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr, align 4
  %getelementptr = getelementptr inbounds [6 x i8], [6 x i8]* @anon.strconst, i32 0, i32 0
  call void @println(i8* %getelementptr)
  br label %exit12

exit12:                                                ; preds = %entry12 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

