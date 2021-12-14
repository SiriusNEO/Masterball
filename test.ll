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

@make = global i32** zeroinitializer, align 8
@color = global i32* zeroinitializer, align 8
@count = global i32* zeroinitializer, align 8
@i = global i32 zeroinitializer, align 4
@j = global i32 zeroinitializer, align 4

@anon.strconst = private unnamed_addr constant [2 x i8] c" \00", align 1
@anon.strconst1 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1

define void @_glb_init() {
entry11:
  store i32** null, i32*** @make, align 8
  %mul = mul i32 10, 4
  %add = add i32 %mul, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 10, i32* %bitcast, align 4
  %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast1 = bitcast i32* %getelementptr to i32*
  store i32* %bitcast1, i32** @color, align 8
  %mul1 = mul i32 1, 4
  %add1 = add i32 %mul1, 4
  %_bot_malloc.call1 = call noalias i8* @_bot_malloc(i32 %add1)
  %bitcast2 = bitcast i8* %_bot_malloc.call1 to i32*
  store i32 1, i32* %bitcast2, align 4
  %getelementptr1 = getelementptr inbounds i32, i32* %bitcast2, i32 1
  %bitcast3 = bitcast i32* %getelementptr1 to i32*
  store i32* %bitcast3, i32** @count, align 8
  br label %exit11

exit11:                                                ; preds = %entry11 
  ret void
}

define void @origin(i32 %N) {
entry12:
  %N.addr = alloca i32, align 4
  store i32 %N, i32* %N.addr, align 4
  %make.load = load i32**, i32*** @make, align 8
  %N.load = load i32, i32* %N.addr, align 4
  %mul2 = mul i32 %N.load, 8
  %add2 = add i32 %mul2, 4
  %_bot_malloc.call2 = call noalias i8* @_bot_malloc(i32 %add2)
  %bitcast4 = bitcast i8* %_bot_malloc.call2 to i32*
  store i32 %N.load, i32* %bitcast4, align 4
  %getelementptr2 = getelementptr inbounds i32, i32* %bitcast4, i32 1
  %bitcast5 = bitcast i32* %getelementptr2 to i32**
  store i32** %bitcast5, i32*** @make, align 8
  %i.load = load i32, i32* @i, align 4
  store i32 0, i32* @i, align 4
  br label %for.cond

for.cond:                                                ; preds = %for.incr, %entry12 
  %i.load1 = load i32, i32* @i, align 4
  %N.load1 = load i32, i32* %N.addr, align 4
  %icmp = icmp slt i32 %i.load1, %N.load1
  br i1 %icmp, label %for.body, label %for.exit

for.incr:                                                ; preds = %for.exit1 
  %i.load2 = load i32, i32* @i, align 4
  %add3 = add i32 %i.load2, 1
  store i32 %add3, i32* @i, align 4
  br label %for.cond

for.body:                                                ; preds = %for.cond 
  %make.load1 = load i32**, i32*** @make, align 8
  %i.load3 = load i32, i32* @i, align 4
  %make.load1.elem.addr = getelementptr inbounds i32*, i32** %make.load1, i32 %i.load3
  %make.load1.elem.load = load i32*, i32** %make.load1.elem.addr, align 8
  %N.load2 = load i32, i32* %N.addr, align 4
  %mul3 = mul i32 %N.load2, 4
  %add4 = add i32 %mul3, 4
  %_bot_malloc.call3 = call noalias i8* @_bot_malloc(i32 %add4)
  %bitcast6 = bitcast i8* %_bot_malloc.call3 to i32*
  store i32 %N.load2, i32* %bitcast6, align 4
  %getelementptr3 = getelementptr inbounds i32, i32* %bitcast6, i32 1
  %bitcast7 = bitcast i32* %getelementptr3 to i32*
  store i32* %bitcast7, i32** %make.load1.elem.addr, align 8
  %j.load = load i32, i32* @j, align 4
  store i32 0, i32* @j, align 4
  br label %for.cond1

for.exit:                                                ; preds = %for.cond 
  br label %exit12

for.cond1:                                                ; preds = %for.body, %for.incr1 
  %j.load1 = load i32, i32* @j, align 4
  %N.load3 = load i32, i32* %N.addr, align 4
  %icmp1 = icmp slt i32 %j.load1, %N.load3
  br i1 %icmp1, label %for.body1, label %for.exit1

for.incr1:                                                ; preds = %for.body1 
  %j.load2 = load i32, i32* @j, align 4
  %add5 = add i32 %j.load2, 1
  store i32 %add5, i32* @j, align 4
  br label %for.cond1

for.body1:                                                ; preds = %for.cond1 
  %make.load2 = load i32**, i32*** @make, align 8
  %i.load4 = load i32, i32* @i, align 4
  %make.load2.elem.addr = getelementptr inbounds i32*, i32** %make.load2, i32 %i.load4
  %make.load2.elem.load = load i32*, i32** %make.load2.elem.addr, align 8
  %j.load3 = load i32, i32* @j, align 4
  %make.load2.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load2.elem.load, i32 %j.load3
  %make.load2.elem.load.elem.load = load i32, i32* %make.load2.elem.load.elem.addr, align 4
  store i32 0, i32* %make.load2.elem.load.elem.addr, align 4
  br label %for.incr1

for.exit1:                                                ; preds = %for.cond1 
  br label %for.incr

exit12:                                                ; preds = %for.exit 
  ret void
}

define void @search(i32 %x, i32 %y, i32 %z) {
entry13:
  %j.addr = alloca i32, align 4
  %i.addr = alloca i32, align 4
  %s.addr = alloca i32, align 4
  %z.addr = alloca i32, align 4
  %y.addr = alloca i32, align 4
  %x.addr = alloca i32, align 4
  store i32 %x, i32* %x.addr, align 4
  store i32 %y, i32* %y.addr, align 4
  store i32 %z, i32* %z.addr, align 4
  %y.load = load i32, i32* %y.addr, align 4
  %icmp2 = icmp sgt i32 %y.load, 0
  br i1 %icmp2, label %lg.exit, label %lg.nocut

if.true:                                                ; preds = %lg.exit2 
  %x.load4 = load i32, i32* %x.addr, align 4
  %icmp6 = icmp eq i32 %x.load4, 2
  br i1 %icmp6, label %lg.nocut3, label %lg.exit3

if.false:                                                ; preds = %lg.exit2 
  br label %if.exit

if.exit:                                                ; preds = %if.exit1, %if.false 
  br label %exit13

lg.nocut:                                                ; preds = %entry13 
  %y.load1 = load i32, i32* %y.addr, align 4
  %icmp3 = icmp slt i32 %y.load1, 0
  br label %lg.exit

lg.exit:                                                ; preds = %entry13, %lg.nocut 
  %phi = phi i1 [%icmp2, %entry13], [%icmp3, %lg.nocut]
  br i1 %phi, label %lg.exit1, label %lg.nocut1

lg.nocut1:                                                ; preds = %lg.exit 
  %x.load = load i32, i32* %x.addr, align 4
  %icmp4 = icmp eq i32 %x.load, 0
  br label %lg.exit1

lg.exit1:                                                ; preds = %lg.nocut1, %lg.exit 
  %phi1 = phi i1 [%phi, %lg.exit], [%icmp4, %lg.nocut1]
  br i1 %phi1, label %lg.exit2, label %lg.nocut2

lg.nocut2:                                                ; preds = %lg.exit1 
  %make.load3 = load i32**, i32*** @make, align 8
  %x.load1 = load i32, i32* %x.addr, align 4
  %sub = sub i32 %x.load1, 1
  %make.load3.elem.addr = getelementptr inbounds i32*, i32** %make.load3, i32 %sub
  %make.load3.elem.load = load i32*, i32** %make.load3.elem.addr, align 8
  %make.load3.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load3.elem.load, i32 0
  %make.load3.elem.load.elem.load = load i32, i32* %make.load3.elem.load.elem.addr, align 4
  %make.load4 = load i32**, i32*** @make, align 8
  %x.load2 = load i32, i32* %x.addr, align 4
  %sub1 = sub i32 %x.load2, 1
  %make.load4.elem.addr = getelementptr inbounds i32*, i32** %make.load4, i32 %sub1
  %make.load4.elem.load = load i32*, i32** %make.load4.elem.addr, align 8
  %make.load4.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load4.elem.load, i32 1
  %make.load4.elem.load.elem.load = load i32, i32* %make.load4.elem.load.elem.addr, align 4
  %add6 = add i32 %make.load3.elem.load.elem.load, %make.load4.elem.load.elem.load
  %make.load5 = load i32**, i32*** @make, align 8
  %x.load3 = load i32, i32* %x.addr, align 4
  %sub2 = sub i32 %x.load3, 1
  %make.load5.elem.addr = getelementptr inbounds i32*, i32** %make.load5, i32 %sub2
  %make.load5.elem.load = load i32*, i32** %make.load5.elem.addr, align 8
  %make.load5.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load5.elem.load, i32 2
  %make.load5.elem.load.elem.load = load i32, i32* %make.load5.elem.load.elem.addr, align 4
  %add7 = add i32 %add6, %make.load5.elem.load.elem.load
  %icmp5 = icmp eq i32 %add7, 15
  br label %lg.exit2

lg.exit2:                                                ; preds = %lg.exit1, %lg.nocut2 
  %phi2 = phi i1 [%phi1, %lg.exit1], [%icmp5, %lg.nocut2]
  br i1 %phi2, label %if.true, label %if.false

if.true1:                                                ; preds = %lg.exit3 
  %make.load18 = load i32**, i32*** @make, align 8
  %make.load18.elem.addr = getelementptr inbounds i32*, i32** %make.load18, i32 2
  %make.load18.elem.load = load i32*, i32** %make.load18.elem.addr, align 8
  %make.load18.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load18.elem.load, i32 2
  %make.load18.elem.load.elem.load = load i32, i32* %make.load18.elem.load.elem.addr, align 4
  %z.load4 = load i32, i32* %z.addr, align 4
  %sub5 = sub i32 45, %z.load4
  store i32 %sub5, i32* %make.load18.elem.load.elem.addr, align 4
  %s.load = load i32, i32* %s.addr, align 4
  %make.load19 = load i32**, i32*** @make, align 8
  %make.load19.elem.addr = getelementptr inbounds i32*, i32** %make.load19, i32 0
  %make.load19.elem.load = load i32*, i32** %make.load19.elem.addr, align 8
  %make.load19.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load19.elem.load, i32 0
  %make.load19.elem.load.elem.load = load i32, i32* %make.load19.elem.load.elem.addr, align 4
  %make.load20 = load i32**, i32*** @make, align 8
  %make.load20.elem.addr = getelementptr inbounds i32*, i32** %make.load20, i32 0
  %make.load20.elem.load = load i32*, i32** %make.load20.elem.addr, align 8
  %make.load20.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load20.elem.load, i32 1
  %make.load20.elem.load.elem.load = load i32, i32* %make.load20.elem.load.elem.addr, align 4
  %add17 = add i32 %make.load19.elem.load.elem.load, %make.load20.elem.load.elem.load
  %make.load21 = load i32**, i32*** @make, align 8
  %make.load21.elem.addr = getelementptr inbounds i32*, i32** %make.load21, i32 0
  %make.load21.elem.load = load i32*, i32** %make.load21.elem.addr, align 8
  %make.load21.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load21.elem.load, i32 2
  %make.load21.elem.load.elem.load = load i32, i32* %make.load21.elem.load.elem.addr, align 4
  %add18 = add i32 %add17, %make.load21.elem.load.elem.load
  store i32 %add18, i32* %s.addr, align 4
  %make.load22 = load i32**, i32*** @make, align 8
  %make.load22.elem.addr = getelementptr inbounds i32*, i32** %make.load22, i32 1
  %make.load22.elem.load = load i32*, i32** %make.load22.elem.addr, align 8
  %make.load22.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load22.elem.load, i32 0
  %make.load22.elem.load.elem.load = load i32, i32* %make.load22.elem.load.elem.addr, align 4
  %make.load23 = load i32**, i32*** @make, align 8
  %make.load23.elem.addr = getelementptr inbounds i32*, i32** %make.load23, i32 1
  %make.load23.elem.load = load i32*, i32** %make.load23.elem.addr, align 8
  %make.load23.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load23.elem.load, i32 1
  %make.load23.elem.load.elem.load = load i32, i32* %make.load23.elem.load.elem.addr, align 4
  %add19 = add i32 %make.load22.elem.load.elem.load, %make.load23.elem.load.elem.load
  %make.load24 = load i32**, i32*** @make, align 8
  %make.load24.elem.addr = getelementptr inbounds i32*, i32** %make.load24, i32 1
  %make.load24.elem.load = load i32*, i32** %make.load24.elem.addr, align 8
  %make.load24.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load24.elem.load, i32 2
  %make.load24.elem.load.elem.load = load i32, i32* %make.load24.elem.load.elem.addr, align 4
  %add20 = add i32 %add19, %make.load24.elem.load.elem.load
  %s.load1 = load i32, i32* %s.addr, align 4
  %icmp16 = icmp eq i32 %add20, %s.load1
  br i1 %icmp16, label %lg.nocut6, label %lg.exit6

if.false1:                                                ; preds = %lg.exit3 
  %y.load3 = load i32, i32* %y.addr, align 4
  %icmp8 = icmp eq i32 %y.load3, 2
  br i1 %icmp8, label %if.true2, label %if.false2

if.exit1:                                                ; preds = %if.exit7, %if.exit2 
  br label %if.exit

lg.nocut3:                                                ; preds = %if.true 
  %y.load2 = load i32, i32* %y.addr, align 4
  %icmp7 = icmp eq i32 %y.load2, 2
  br label %lg.exit3

lg.exit3:                                                ; preds = %if.true, %lg.nocut3 
  %phi3 = phi i1 [%icmp6, %if.true], [%icmp7, %lg.nocut3]
  br i1 %phi3, label %if.true1, label %if.false1

if.true2:                                                ; preds = %if.false1 
  %make.load8 = load i32**, i32*** @make, align 8
  %x.load9 = load i32, i32* %x.addr, align 4
  %make.load8.elem.addr = getelementptr inbounds i32*, i32** %make.load8, i32 %x.load9
  %make.load8.elem.load = load i32*, i32** %make.load8.elem.addr, align 8
  %y.load8 = load i32, i32* %y.addr, align 4
  %make.load8.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load8.elem.load, i32 %y.load8
  %make.load8.elem.load.elem.load = load i32, i32* %make.load8.elem.load.elem.addr, align 4
  %make.load9 = load i32**, i32*** @make, align 8
  %x.load10 = load i32, i32* %x.addr, align 4
  %make.load9.elem.addr = getelementptr inbounds i32*, i32** %make.load9, i32 %x.load10
  %make.load9.elem.load = load i32*, i32** %make.load9.elem.addr, align 8
  %make.load9.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load9.elem.load, i32 0
  %make.load9.elem.load.elem.load = load i32, i32* %make.load9.elem.load.elem.addr, align 4
  %sub3 = sub i32 15, %make.load9.elem.load.elem.load
  %make.load10 = load i32**, i32*** @make, align 8
  %x.load11 = load i32, i32* %x.addr, align 4
  %make.load10.elem.addr = getelementptr inbounds i32*, i32** %make.load10, i32 %x.load11
  %make.load10.elem.load = load i32*, i32** %make.load10.elem.addr, align 8
  %make.load10.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load10.elem.load, i32 1
  %make.load10.elem.load.elem.load = load i32, i32* %make.load10.elem.load.elem.addr, align 4
  %sub4 = sub i32 %sub3, %make.load10.elem.load.elem.load
  store i32 %sub4, i32* %make.load8.elem.load.elem.addr, align 4
  %make.load11 = load i32**, i32*** @make, align 8
  %x.load12 = load i32, i32* %x.addr, align 4
  %make.load11.elem.addr = getelementptr inbounds i32*, i32** %make.load11, i32 %x.load12
  %make.load11.elem.load = load i32*, i32** %make.load11.elem.addr, align 8
  %y.load9 = load i32, i32* %y.addr, align 4
  %make.load11.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load11.elem.load, i32 %y.load9
  %make.load11.elem.load.elem.load = load i32, i32* %make.load11.elem.load.elem.addr, align 4
  %icmp12 = icmp sgt i32 %make.load11.elem.load.elem.load, 0
  br i1 %icmp12, label %lg.nocut4, label %lg.exit4

if.false2:                                                ; preds = %if.false1 
  %i.load5 = load i32, i32* %i.addr, align 4
  store i32 1, i32* %i.addr, align 4
  br label %for.cond2

if.exit2:                                                ; preds = %if.exit5, %for.exit2 
  br label %if.exit1

for.cond2:                                                ; preds = %for.incr2, %if.false2 
  %i.load6 = load i32, i32* %i.addr, align 4
  %icmp9 = icmp sle i32 %i.load6, 9
  br i1 %icmp9, label %for.body2, label %for.exit2

for.incr2:                                                ; preds = %if.exit3 
  %i.load7 = load i32, i32* %i.addr, align 4
  %add8 = add i32 %i.load7, 1
  store i32 %add8, i32* %i.addr, align 4
  br label %for.cond2

for.body2:                                                ; preds = %for.cond2 
  %color.load = load i32*, i32** @color, align 8
  %i.load8 = load i32, i32* %i.addr, align 4
  %color.load.elem.addr = getelementptr inbounds i32, i32* %color.load, i32 %i.load8
  %color.load.elem.load = load i32, i32* %color.load.elem.addr, align 4
  %icmp10 = icmp eq i32 %color.load.elem.load, 0
  br i1 %icmp10, label %if.true3, label %if.false3

for.exit2:                                                ; preds = %for.cond2 
  br label %if.exit2

if.true3:                                                ; preds = %for.body2 
  %color.load1 = load i32*, i32** @color, align 8
  %i.load9 = load i32, i32* %i.addr, align 4
  %color.load1.elem.addr = getelementptr inbounds i32, i32* %color.load1, i32 %i.load9
  %color.load1.elem.load = load i32, i32* %color.load1.elem.addr, align 4
  store i32 1, i32* %color.load1.elem.addr, align 4
  %make.load6 = load i32**, i32*** @make, align 8
  %x.load5 = load i32, i32* %x.addr, align 4
  %make.load6.elem.addr = getelementptr inbounds i32*, i32** %make.load6, i32 %x.load5
  %make.load6.elem.load = load i32*, i32** %make.load6.elem.addr, align 8
  %y.load4 = load i32, i32* %y.addr, align 4
  %make.load6.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load6.elem.load, i32 %y.load4
  %make.load6.elem.load.elem.load = load i32, i32* %make.load6.elem.load.elem.addr, align 4
  %i.load10 = load i32, i32* %i.addr, align 4
  store i32 %i.load10, i32* %make.load6.elem.load.elem.addr, align 4
  %y.load5 = load i32, i32* %y.addr, align 4
  %icmp11 = icmp eq i32 %y.load5, 2
  br i1 %icmp11, label %if.true4, label %if.false4

if.false3:                                                ; preds = %for.body2 
  br label %if.exit3

if.exit3:                                                ; preds = %if.exit4, %if.false3 
  br label %for.incr2

if.true4:                                                ; preds = %if.true3 
  %x.load7 = load i32, i32* %x.addr, align 4
  %add11 = add i32 %x.load7, 1
  %z.load1 = load i32, i32* %z.addr, align 4
  %i.load12 = load i32, i32* %i.addr, align 4
  %add12 = add i32 %z.load1, %i.load12
  call void @search(i32 %add11, i32 0, i32 %add12)
  br label %if.exit4

if.false4:                                                ; preds = %if.true3 
  %x.load6 = load i32, i32* %x.addr, align 4
  %y.load6 = load i32, i32* %y.addr, align 4
  %add9 = add i32 %y.load6, 1
  %z.load = load i32, i32* %z.addr, align 4
  %i.load11 = load i32, i32* %i.addr, align 4
  %add10 = add i32 %z.load, %i.load11
  call void @search(i32 %x.load6, i32 %add9, i32 %add10)
  br label %if.exit4

if.exit4:                                                ; preds = %if.true4, %if.false4 
  %make.load7 = load i32**, i32*** @make, align 8
  %x.load8 = load i32, i32* %x.addr, align 4
  %make.load7.elem.addr = getelementptr inbounds i32*, i32** %make.load7, i32 %x.load8
  %make.load7.elem.load = load i32*, i32** %make.load7.elem.addr, align 8
  %y.load7 = load i32, i32* %y.addr, align 4
  %make.load7.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load7.elem.load, i32 %y.load7
  %make.load7.elem.load.elem.load = load i32, i32* %make.load7.elem.load.elem.addr, align 4
  store i32 0, i32* %make.load7.elem.load.elem.addr, align 4
  %color.load2 = load i32*, i32** @color, align 8
  %i.load13 = load i32, i32* %i.addr, align 4
  %color.load2.elem.addr = getelementptr inbounds i32, i32* %color.load2, i32 %i.load13
  %color.load2.elem.load = load i32, i32* %color.load2.elem.addr, align 4
  store i32 0, i32* %color.load2.elem.addr, align 4
  br label %if.exit3

if.true5:                                                ; preds = %lg.exit5 
  %color.load4 = load i32*, i32** @color, align 8
  %make.load14 = load i32**, i32*** @make, align 8
  %x.load15 = load i32, i32* %x.addr, align 4
  %make.load14.elem.addr = getelementptr inbounds i32*, i32** %make.load14, i32 %x.load15
  %make.load14.elem.load = load i32*, i32** %make.load14.elem.addr, align 8
  %y.load12 = load i32, i32* %y.addr, align 4
  %make.load14.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load14.elem.load, i32 %y.load12
  %make.load14.elem.load.elem.load = load i32, i32* %make.load14.elem.load.elem.addr, align 4
  %color.load4.elem.addr = getelementptr inbounds i32, i32* %color.load4, i32 %make.load14.elem.load.elem.load
  %color.load4.elem.load = load i32, i32* %color.load4.elem.addr, align 4
  store i32 1, i32* %color.load4.elem.addr, align 4
  %y.load13 = load i32, i32* %y.addr, align 4
  %icmp15 = icmp eq i32 %y.load13, 2
  br i1 %icmp15, label %if.true6, label %if.false6

if.false5:                                                ; preds = %lg.exit5 
  br label %if.exit5

if.exit5:                                                ; preds = %if.exit6, %if.false5 
  br label %if.exit2

lg.nocut4:                                                ; preds = %if.true2 
  %make.load12 = load i32**, i32*** @make, align 8
  %x.load13 = load i32, i32* %x.addr, align 4
  %make.load12.elem.addr = getelementptr inbounds i32*, i32** %make.load12, i32 %x.load13
  %make.load12.elem.load = load i32*, i32** %make.load12.elem.addr, align 8
  %y.load10 = load i32, i32* %y.addr, align 4
  %make.load12.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load12.elem.load, i32 %y.load10
  %make.load12.elem.load.elem.load = load i32, i32* %make.load12.elem.load.elem.addr, align 4
  %icmp13 = icmp slt i32 %make.load12.elem.load.elem.load, 10
  br label %lg.exit4

lg.exit4:                                                ; preds = %if.true2, %lg.nocut4 
  %phi4 = phi i1 [%icmp12, %if.true2], [%icmp13, %lg.nocut4]
  br i1 %phi4, label %lg.nocut5, label %lg.exit5

lg.nocut5:                                                ; preds = %lg.exit4 
  %color.load3 = load i32*, i32** @color, align 8
  %make.load13 = load i32**, i32*** @make, align 8
  %x.load14 = load i32, i32* %x.addr, align 4
  %make.load13.elem.addr = getelementptr inbounds i32*, i32** %make.load13, i32 %x.load14
  %make.load13.elem.load = load i32*, i32** %make.load13.elem.addr, align 8
  %y.load11 = load i32, i32* %y.addr, align 4
  %make.load13.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load13.elem.load, i32 %y.load11
  %make.load13.elem.load.elem.load = load i32, i32* %make.load13.elem.load.elem.addr, align 4
  %color.load3.elem.addr = getelementptr inbounds i32, i32* %color.load3, i32 %make.load13.elem.load.elem.load
  %color.load3.elem.load = load i32, i32* %color.load3.elem.addr, align 4
  %icmp14 = icmp eq i32 %color.load3.elem.load, 0
  br label %lg.exit5

lg.exit5:                                                ; preds = %lg.nocut5, %lg.exit4 
  %phi5 = phi i1 [%phi4, %lg.exit4], [%icmp14, %lg.nocut5]
  br i1 %phi5, label %if.true5, label %if.false5

if.true6:                                                ; preds = %if.true5 
  %x.load18 = load i32, i32* %x.addr, align 4
  %add15 = add i32 %x.load18, 1
  %z.load3 = load i32, i32* %z.addr, align 4
  %make.load16 = load i32**, i32*** @make, align 8
  %x.load19 = load i32, i32* %x.addr, align 4
  %make.load16.elem.addr = getelementptr inbounds i32*, i32** %make.load16, i32 %x.load19
  %make.load16.elem.load = load i32*, i32** %make.load16.elem.addr, align 8
  %y.load16 = load i32, i32* %y.addr, align 4
  %make.load16.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load16.elem.load, i32 %y.load16
  %make.load16.elem.load.elem.load = load i32, i32* %make.load16.elem.load.elem.addr, align 4
  %add16 = add i32 %z.load3, %make.load16.elem.load.elem.load
  call void @search(i32 %add15, i32 0, i32 %add16)
  br label %if.exit6

if.false6:                                                ; preds = %if.true5 
  %x.load16 = load i32, i32* %x.addr, align 4
  %y.load14 = load i32, i32* %y.addr, align 4
  %add13 = add i32 %y.load14, 1
  %z.load2 = load i32, i32* %z.addr, align 4
  %make.load15 = load i32**, i32*** @make, align 8
  %x.load17 = load i32, i32* %x.addr, align 4
  %make.load15.elem.addr = getelementptr inbounds i32*, i32** %make.load15, i32 %x.load17
  %make.load15.elem.load = load i32*, i32** %make.load15.elem.addr, align 8
  %y.load15 = load i32, i32* %y.addr, align 4
  %make.load15.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load15.elem.load, i32 %y.load15
  %make.load15.elem.load.elem.load = load i32, i32* %make.load15.elem.load.elem.addr, align 4
  %add14 = add i32 %z.load2, %make.load15.elem.load.elem.load
  call void @search(i32 %x.load16, i32 %add13, i32 %add14)
  br label %if.exit6

if.exit6:                                                ; preds = %if.true6, %if.false6 
  %color.load5 = load i32*, i32** @color, align 8
  %make.load17 = load i32**, i32*** @make, align 8
  %x.load20 = load i32, i32* %x.addr, align 4
  %make.load17.elem.addr = getelementptr inbounds i32*, i32** %make.load17, i32 %x.load20
  %make.load17.elem.load = load i32*, i32** %make.load17.elem.addr, align 8
  %y.load17 = load i32, i32* %y.addr, align 4
  %make.load17.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load17.elem.load, i32 %y.load17
  %make.load17.elem.load.elem.load = load i32, i32* %make.load17.elem.load.elem.addr, align 4
  %color.load5.elem.addr = getelementptr inbounds i32, i32* %color.load5, i32 %make.load17.elem.load.elem.load
  %color.load5.elem.load = load i32, i32* %color.load5.elem.addr, align 4
  store i32 0, i32* %color.load5.elem.addr, align 4
  br label %if.exit5

if.true7:                                                ; preds = %lg.exit11 
  %count.load = load i32*, i32** @count, align 8
  %count.load.elem.addr = getelementptr inbounds i32, i32* %count.load, i32 0
  %count.load.elem.load = load i32, i32* %count.load.elem.addr, align 4
  %count.load1 = load i32*, i32** @count, align 8
  %count.load1.elem.addr = getelementptr inbounds i32, i32* %count.load1, i32 0
  %count.load1.elem.load = load i32, i32* %count.load1.elem.addr, align 4
  %add33 = add i32 %count.load1.elem.load, 1
  store i32 %add33, i32* %count.load.elem.addr, align 4
  %i.load14 = load i32, i32* %i.addr, align 4
  store i32 0, i32* %i.addr, align 4
  br label %for.cond3

if.false7:                                                ; preds = %lg.exit11 
  br label %if.exit7

if.exit7:                                                ; preds = %if.false7, %for.exit3 
  br label %if.exit1

lg.nocut6:                                                ; preds = %if.true1 
  %make.load25 = load i32**, i32*** @make, align 8
  %make.load25.elem.addr = getelementptr inbounds i32*, i32** %make.load25, i32 2
  %make.load25.elem.load = load i32*, i32** %make.load25.elem.addr, align 8
  %make.load25.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load25.elem.load, i32 0
  %make.load25.elem.load.elem.load = load i32, i32* %make.load25.elem.load.elem.addr, align 4
  %make.load26 = load i32**, i32*** @make, align 8
  %make.load26.elem.addr = getelementptr inbounds i32*, i32** %make.load26, i32 2
  %make.load26.elem.load = load i32*, i32** %make.load26.elem.addr, align 8
  %make.load26.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load26.elem.load, i32 1
  %make.load26.elem.load.elem.load = load i32, i32* %make.load26.elem.load.elem.addr, align 4
  %add21 = add i32 %make.load25.elem.load.elem.load, %make.load26.elem.load.elem.load
  %make.load27 = load i32**, i32*** @make, align 8
  %make.load27.elem.addr = getelementptr inbounds i32*, i32** %make.load27, i32 2
  %make.load27.elem.load = load i32*, i32** %make.load27.elem.addr, align 8
  %make.load27.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load27.elem.load, i32 2
  %make.load27.elem.load.elem.load = load i32, i32* %make.load27.elem.load.elem.addr, align 4
  %add22 = add i32 %add21, %make.load27.elem.load.elem.load
  %s.load2 = load i32, i32* %s.addr, align 4
  %icmp17 = icmp eq i32 %add22, %s.load2
  br label %lg.exit6

lg.exit6:                                                ; preds = %lg.nocut6, %if.true1 
  %phi6 = phi i1 [%icmp16, %if.true1], [%icmp17, %lg.nocut6]
  br i1 %phi6, label %lg.nocut7, label %lg.exit7

lg.nocut7:                                                ; preds = %lg.exit6 
  %make.load28 = load i32**, i32*** @make, align 8
  %make.load28.elem.addr = getelementptr inbounds i32*, i32** %make.load28, i32 0
  %make.load28.elem.load = load i32*, i32** %make.load28.elem.addr, align 8
  %make.load28.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load28.elem.load, i32 0
  %make.load28.elem.load.elem.load = load i32, i32* %make.load28.elem.load.elem.addr, align 4
  %make.load29 = load i32**, i32*** @make, align 8
  %make.load29.elem.addr = getelementptr inbounds i32*, i32** %make.load29, i32 1
  %make.load29.elem.load = load i32*, i32** %make.load29.elem.addr, align 8
  %make.load29.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load29.elem.load, i32 0
  %make.load29.elem.load.elem.load = load i32, i32* %make.load29.elem.load.elem.addr, align 4
  %add23 = add i32 %make.load28.elem.load.elem.load, %make.load29.elem.load.elem.load
  %make.load30 = load i32**, i32*** @make, align 8
  %make.load30.elem.addr = getelementptr inbounds i32*, i32** %make.load30, i32 2
  %make.load30.elem.load = load i32*, i32** %make.load30.elem.addr, align 8
  %make.load30.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load30.elem.load, i32 0
  %make.load30.elem.load.elem.load = load i32, i32* %make.load30.elem.load.elem.addr, align 4
  %add24 = add i32 %add23, %make.load30.elem.load.elem.load
  %s.load3 = load i32, i32* %s.addr, align 4
  %icmp18 = icmp eq i32 %add24, %s.load3
  br label %lg.exit7

lg.exit7:                                                ; preds = %lg.nocut7, %lg.exit6 
  %phi7 = phi i1 [%phi6, %lg.exit6], [%icmp18, %lg.nocut7]
  br i1 %phi7, label %lg.nocut8, label %lg.exit8

lg.nocut8:                                                ; preds = %lg.exit7 
  %make.load31 = load i32**, i32*** @make, align 8
  %make.load31.elem.addr = getelementptr inbounds i32*, i32** %make.load31, i32 0
  %make.load31.elem.load = load i32*, i32** %make.load31.elem.addr, align 8
  %make.load31.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load31.elem.load, i32 1
  %make.load31.elem.load.elem.load = load i32, i32* %make.load31.elem.load.elem.addr, align 4
  %make.load32 = load i32**, i32*** @make, align 8
  %make.load32.elem.addr = getelementptr inbounds i32*, i32** %make.load32, i32 1
  %make.load32.elem.load = load i32*, i32** %make.load32.elem.addr, align 8
  %make.load32.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load32.elem.load, i32 1
  %make.load32.elem.load.elem.load = load i32, i32* %make.load32.elem.load.elem.addr, align 4
  %add25 = add i32 %make.load31.elem.load.elem.load, %make.load32.elem.load.elem.load
  %make.load33 = load i32**, i32*** @make, align 8
  %make.load33.elem.addr = getelementptr inbounds i32*, i32** %make.load33, i32 2
  %make.load33.elem.load = load i32*, i32** %make.load33.elem.addr, align 8
  %make.load33.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load33.elem.load, i32 1
  %make.load33.elem.load.elem.load = load i32, i32* %make.load33.elem.load.elem.addr, align 4
  %add26 = add i32 %add25, %make.load33.elem.load.elem.load
  %s.load4 = load i32, i32* %s.addr, align 4
  %icmp19 = icmp eq i32 %add26, %s.load4
  br label %lg.exit8

lg.exit8:                                                ; preds = %lg.nocut8, %lg.exit7 
  %phi8 = phi i1 [%phi7, %lg.exit7], [%icmp19, %lg.nocut8]
  br i1 %phi8, label %lg.nocut9, label %lg.exit9

lg.nocut9:                                                ; preds = %lg.exit8 
  %make.load34 = load i32**, i32*** @make, align 8
  %make.load34.elem.addr = getelementptr inbounds i32*, i32** %make.load34, i32 0
  %make.load34.elem.load = load i32*, i32** %make.load34.elem.addr, align 8
  %make.load34.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load34.elem.load, i32 2
  %make.load34.elem.load.elem.load = load i32, i32* %make.load34.elem.load.elem.addr, align 4
  %make.load35 = load i32**, i32*** @make, align 8
  %make.load35.elem.addr = getelementptr inbounds i32*, i32** %make.load35, i32 1
  %make.load35.elem.load = load i32*, i32** %make.load35.elem.addr, align 8
  %make.load35.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load35.elem.load, i32 2
  %make.load35.elem.load.elem.load = load i32, i32* %make.load35.elem.load.elem.addr, align 4
  %add27 = add i32 %make.load34.elem.load.elem.load, %make.load35.elem.load.elem.load
  %make.load36 = load i32**, i32*** @make, align 8
  %make.load36.elem.addr = getelementptr inbounds i32*, i32** %make.load36, i32 2
  %make.load36.elem.load = load i32*, i32** %make.load36.elem.addr, align 8
  %make.load36.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load36.elem.load, i32 2
  %make.load36.elem.load.elem.load = load i32, i32* %make.load36.elem.load.elem.addr, align 4
  %add28 = add i32 %add27, %make.load36.elem.load.elem.load
  %s.load5 = load i32, i32* %s.addr, align 4
  %icmp20 = icmp eq i32 %add28, %s.load5
  br label %lg.exit9

lg.exit9:                                                ; preds = %lg.nocut9, %lg.exit8 
  %phi9 = phi i1 [%phi8, %lg.exit8], [%icmp20, %lg.nocut9]
  br i1 %phi9, label %lg.nocut10, label %lg.exit10

lg.nocut10:                                                ; preds = %lg.exit9 
  %make.load37 = load i32**, i32*** @make, align 8
  %make.load37.elem.addr = getelementptr inbounds i32*, i32** %make.load37, i32 0
  %make.load37.elem.load = load i32*, i32** %make.load37.elem.addr, align 8
  %make.load37.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load37.elem.load, i32 0
  %make.load37.elem.load.elem.load = load i32, i32* %make.load37.elem.load.elem.addr, align 4
  %make.load38 = load i32**, i32*** @make, align 8
  %make.load38.elem.addr = getelementptr inbounds i32*, i32** %make.load38, i32 1
  %make.load38.elem.load = load i32*, i32** %make.load38.elem.addr, align 8
  %make.load38.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load38.elem.load, i32 1
  %make.load38.elem.load.elem.load = load i32, i32* %make.load38.elem.load.elem.addr, align 4
  %add29 = add i32 %make.load37.elem.load.elem.load, %make.load38.elem.load.elem.load
  %make.load39 = load i32**, i32*** @make, align 8
  %make.load39.elem.addr = getelementptr inbounds i32*, i32** %make.load39, i32 2
  %make.load39.elem.load = load i32*, i32** %make.load39.elem.addr, align 8
  %make.load39.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load39.elem.load, i32 2
  %make.load39.elem.load.elem.load = load i32, i32* %make.load39.elem.load.elem.addr, align 4
  %add30 = add i32 %add29, %make.load39.elem.load.elem.load
  %s.load6 = load i32, i32* %s.addr, align 4
  %icmp21 = icmp eq i32 %add30, %s.load6
  br label %lg.exit10

lg.exit10:                                                ; preds = %lg.exit9, %lg.nocut10 
  %phi10 = phi i1 [%phi9, %lg.exit9], [%icmp21, %lg.nocut10]
  br i1 %phi10, label %lg.nocut11, label %lg.exit11

lg.nocut11:                                                ; preds = %lg.exit10 
  %make.load40 = load i32**, i32*** @make, align 8
  %make.load40.elem.addr = getelementptr inbounds i32*, i32** %make.load40, i32 2
  %make.load40.elem.load = load i32*, i32** %make.load40.elem.addr, align 8
  %make.load40.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load40.elem.load, i32 0
  %make.load40.elem.load.elem.load = load i32, i32* %make.load40.elem.load.elem.addr, align 4
  %make.load41 = load i32**, i32*** @make, align 8
  %make.load41.elem.addr = getelementptr inbounds i32*, i32** %make.load41, i32 1
  %make.load41.elem.load = load i32*, i32** %make.load41.elem.addr, align 8
  %make.load41.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load41.elem.load, i32 1
  %make.load41.elem.load.elem.load = load i32, i32* %make.load41.elem.load.elem.addr, align 4
  %add31 = add i32 %make.load40.elem.load.elem.load, %make.load41.elem.load.elem.load
  %make.load42 = load i32**, i32*** @make, align 8
  %make.load42.elem.addr = getelementptr inbounds i32*, i32** %make.load42, i32 0
  %make.load42.elem.load = load i32*, i32** %make.load42.elem.addr, align 8
  %make.load42.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load42.elem.load, i32 2
  %make.load42.elem.load.elem.load = load i32, i32* %make.load42.elem.load.elem.addr, align 4
  %add32 = add i32 %add31, %make.load42.elem.load.elem.load
  %s.load7 = load i32, i32* %s.addr, align 4
  %icmp22 = icmp eq i32 %add32, %s.load7
  br label %lg.exit11

lg.exit11:                                                ; preds = %lg.exit10, %lg.nocut11 
  %phi11 = phi i1 [%phi10, %lg.exit10], [%icmp22, %lg.nocut11]
  br i1 %phi11, label %if.true7, label %if.false7

for.cond3:                                                ; preds = %for.incr3, %if.true7 
  %i.load15 = load i32, i32* %i.addr, align 4
  %icmp23 = icmp sle i32 %i.load15, 2
  br i1 %icmp23, label %for.body3, label %for.exit3

for.incr3:                                                ; preds = %for.exit4 
  %i.load16 = load i32, i32* %i.addr, align 4
  %add34 = add i32 %i.load16, 1
  store i32 %add34, i32* %i.addr, align 4
  br label %for.cond3

for.body3:                                                ; preds = %for.cond3 
  %j.load4 = load i32, i32* %j.addr, align 4
  store i32 0, i32* %j.addr, align 4
  br label %for.cond4

for.exit3:                                                ; preds = %for.cond3 
  %getelementptr6 = getelementptr inbounds [2 x i8], [2 x i8]* @anon.strconst1, i32 0, i32 0
  call void @print(i8* %getelementptr6)
  br label %if.exit7

for.cond4:                                                ; preds = %for.incr4, %for.body3 
  %j.load5 = load i32, i32* %j.addr, align 4
  %icmp24 = icmp sle i32 %j.load5, 2
  br i1 %icmp24, label %for.body4, label %for.exit4

for.incr4:                                                ; preds = %for.body4 
  %j.load6 = load i32, i32* %j.addr, align 4
  %add35 = add i32 %j.load6, 1
  store i32 %add35, i32* %j.addr, align 4
  br label %for.cond4

for.body4:                                                ; preds = %for.cond4 
  %make.load43 = load i32**, i32*** @make, align 8
  %i.load17 = load i32, i32* %i.addr, align 4
  %make.load43.elem.addr = getelementptr inbounds i32*, i32** %make.load43, i32 %i.load17
  %make.load43.elem.load = load i32*, i32** %make.load43.elem.addr, align 8
  %j.load7 = load i32, i32* %j.addr, align 4
  %make.load43.elem.load.elem.addr = getelementptr inbounds i32, i32* %make.load43.elem.load, i32 %j.load7
  %make.load43.elem.load.elem.load = load i32, i32* %make.load43.elem.load.elem.addr, align 4
  %toString.call = call i8* @toString(i32 %make.load43.elem.load.elem.load)
  call void @print(i8* %toString.call)
  %getelementptr4 = getelementptr inbounds [2 x i8], [2 x i8]* @anon.strconst, i32 0, i32 0
  call void @print(i8* %getelementptr4)
  br label %for.incr4

for.exit4:                                                ; preds = %for.cond4 
  %getelementptr5 = getelementptr inbounds [2 x i8], [2 x i8]* @anon.strconst1, i32 0, i32 0
  call void @print(i8* %getelementptr5)
  br label %for.incr3

exit13:                                                ; preds = %if.exit 
  ret void
}

define i32 @main() {
entry14:
  %retreg.addr = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr, align 4
  %count.load2 = load i32*, i32** @count, align 8
  %count.load2.elem.addr = getelementptr inbounds i32, i32* %count.load2, i32 0
  %count.load2.elem.load = load i32, i32* %count.load2.elem.addr, align 4
  store i32 0, i32* %count.load2.elem.addr, align 4
  call void @origin(i32 3)
  call void @search(i32 0, i32 0, i32 0)
  %count.load3 = load i32*, i32** @count, align 8
  %count.load3.elem.addr = getelementptr inbounds i32, i32* %count.load3, i32 0
  %count.load3.elem.load = load i32, i32* %count.load3.elem.addr, align 4
  %toString.call1 = call i8* @toString(i32 %count.load3.elem.load)
  call void @println(i8* %toString.call1)
  store i32 0, i32* %retreg.addr, align 4
  br label %exit14

exit14:                                                ; preds = %entry14 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

