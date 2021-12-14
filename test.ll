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

@N = global i32 zeroinitializer, align 4
@row = global i32* zeroinitializer, align 8
@col = global i32* zeroinitializer, align 8
@d = global i32** zeroinitializer, align 8

@anon.strconst = private unnamed_addr constant [3 x i8] c" .\00", align 1
@anon.strconst1 = private unnamed_addr constant [3 x i8] c" O\00", align 1
@anon.strconst2 = private unnamed_addr constant [1 x i8] c"\00", align 1

define void @_glb_init() {
entry11:
  store i32 8, i32* @N, align 4
  %mul = mul i32 8, 4
  %add = add i32 %mul, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 8, i32* %bitcast, align 4
  %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast1 = bitcast i32* %getelementptr to i32*
  store i32* %bitcast1, i32** @row, align 8
  %mul1 = mul i32 8, 4
  %add1 = add i32 %mul1, 4
  %_bot_malloc.call1 = call noalias i8* @_bot_malloc(i32 %add1)
  %bitcast2 = bitcast i8* %_bot_malloc.call1 to i32*
  store i32 8, i32* %bitcast2, align 4
  %getelementptr1 = getelementptr inbounds i32, i32* %bitcast2, i32 1
  %bitcast3 = bitcast i32* %getelementptr1 to i32*
  store i32* %bitcast3, i32** @col, align 8
  %mul2 = mul i32 2, 8
  %add2 = add i32 %mul2, 4
  %_bot_malloc.call2 = call noalias i8* @_bot_malloc(i32 %add2)
  %bitcast4 = bitcast i8* %_bot_malloc.call2 to i32*
  store i32 2, i32* %bitcast4, align 4
  %getelementptr2 = getelementptr inbounds i32, i32* %bitcast4, i32 1
  %bitcast5 = bitcast i32* %getelementptr2 to i32**
  store i32** %bitcast5, i32*** @d, align 8
  br label %exit11

exit11:                                                ; preds = %entry11 
  ret void
}

define void @printBoard() {
entry12:
  %j.addr = alloca i32, align 4
  %i.addr = alloca i32, align 4
  %i.load = load i32, i32* %i.addr, align 4
  store i32 0, i32* %i.addr, align 4
  br label %for.cond

for.cond:                                                ; preds = %for.incr, %entry12 
  %i.load1 = load i32, i32* %i.addr, align 4
  %N.load = load i32, i32* @N, align 4
  %icmp = icmp slt i32 %i.load1, %N.load
  br i1 %icmp, label %for.body, label %for.exit

for.incr:                                                ; preds = %for.exit1 
  %i.load2 = load i32, i32* %i.addr, align 4
  %add3 = add i32 %i.load2, 1
  store i32 %add3, i32* %i.addr, align 4
  br label %for.cond

for.body:                                                ; preds = %for.cond 
  %j.load = load i32, i32* %j.addr, align 4
  store i32 0, i32* %j.addr, align 4
  br label %for.cond1

for.exit:                                                ; preds = %for.cond 
  %getelementptr6 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst2, i32 0, i32 0
  call void @println(i8* %getelementptr6)
  br label %exit12

for.cond1:                                                ; preds = %for.incr1, %for.body 
  %j.load1 = load i32, i32* %j.addr, align 4
  %N.load1 = load i32, i32* @N, align 4
  %icmp1 = icmp slt i32 %j.load1, %N.load1
  br i1 %icmp1, label %for.body1, label %for.exit1

for.incr1:                                                ; preds = %if.exit 
  %j.load2 = load i32, i32* %j.addr, align 4
  %add4 = add i32 %j.load2, 1
  store i32 %add4, i32* %j.addr, align 4
  br label %for.cond1

for.body1:                                                ; preds = %for.cond1 
  %col.load = load i32*, i32** @col, align 8
  %i.load3 = load i32, i32* %i.addr, align 4
  %col.load.elem.addr = getelementptr inbounds i32, i32* %col.load, i32 %i.load3
  %col.load.elem.load = load i32, i32* %col.load.elem.addr, align 4
  %j.load3 = load i32, i32* %j.addr, align 4
  %icmp2 = icmp eq i32 %col.load.elem.load, %j.load3
  br i1 %icmp2, label %if.true, label %if.false

for.exit1:                                                ; preds = %for.cond1 
  %getelementptr5 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst2, i32 0, i32 0
  call void @println(i8* %getelementptr5)
  br label %for.incr

if.true:                                                ; preds = %for.body1 
  %getelementptr4 = getelementptr inbounds [3 x i8], [3 x i8]* @anon.strconst1, i32 0, i32 0
  call void @print(i8* %getelementptr4)
  br label %if.exit

if.false:                                                ; preds = %for.body1 
  %getelementptr3 = getelementptr inbounds [3 x i8], [3 x i8]* @anon.strconst, i32 0, i32 0
  call void @print(i8* %getelementptr3)
  br label %if.exit

if.exit:                                                ; preds = %if.true, %if.false 
  br label %for.incr1

exit12:                                                ; preds = %for.exit 
  ret void
}

define void @search(i32 %c) {
entry13:
  %r.addr = alloca i32, align 4
  %c.addr = alloca i32, align 4
  store i32 %c, i32* %c.addr, align 4
  %c.load = load i32, i32* %c.addr, align 4
  %N.load2 = load i32, i32* @N, align 4
  %icmp3 = icmp eq i32 %c.load, %N.load2
  br i1 %icmp3, label %if.true1, label %if.false1

if.true1:                                                ; preds = %entry13 
  call void @printBoard()
  br label %if.exit1

if.false1:                                                ; preds = %entry13 
  %r.load = load i32, i32* %r.addr, align 4
  store i32 0, i32* %r.addr, align 4
  br label %for.cond2

if.exit1:                                                ; preds = %if.true1, %for.exit2 
  br label %exit13

for.cond2:                                                ; preds = %if.false1, %for.incr2 
  %r.load1 = load i32, i32* %r.addr, align 4
  %N.load3 = load i32, i32* @N, align 4
  %icmp4 = icmp slt i32 %r.load1, %N.load3
  br i1 %icmp4, label %for.body2, label %for.exit2

for.incr2:                                                ; preds = %if.exit2 
  %r.load2 = load i32, i32* %r.addr, align 4
  %add5 = add i32 %r.load2, 1
  store i32 %add5, i32* %r.addr, align 4
  br label %for.cond2

for.body2:                                                ; preds = %for.cond2 
  %row.load = load i32*, i32** @row, align 8
  %r.load3 = load i32, i32* %r.addr, align 4
  %row.load.elem.addr = getelementptr inbounds i32, i32* %row.load, i32 %r.load3
  %row.load.elem.load = load i32, i32* %row.load.elem.addr, align 4
  %icmp5 = icmp eq i32 %row.load.elem.load, 0
  br i1 %icmp5, label %lg.nocut, label %lg.exit

for.exit2:                                                ; preds = %for.cond2 
  br label %if.exit1

if.true2:                                                ; preds = %lg.exit1 
  %d.load2 = load i32**, i32*** @d, align 8
  %d.load2.elem.addr = getelementptr inbounds i32*, i32** %d.load2, i32 1
  %d.load2.elem.load = load i32*, i32** %d.load2.elem.addr, align 8
  %r.load6 = load i32, i32* %r.addr, align 4
  %N.load5 = load i32, i32* @N, align 4
  %add8 = add i32 %r.load6, %N.load5
  %sub2 = sub i32 %add8, 1
  %c.load3 = load i32, i32* %c.addr, align 4
  %sub3 = sub i32 %sub2, %c.load3
  %d.load2.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load2.elem.load, i32 %sub3
  %d.load2.elem.load.elem.load = load i32, i32* %d.load2.elem.load.elem.addr, align 4
  store i32 1, i32* %d.load2.elem.load.elem.addr, align 4
  %d.load3 = load i32**, i32*** @d, align 8
  %d.load3.elem.addr = getelementptr inbounds i32*, i32** %d.load3, i32 0
  %d.load3.elem.load = load i32*, i32** %d.load3.elem.addr, align 8
  %r.load7 = load i32, i32* %r.addr, align 4
  %c.load4 = load i32, i32* %c.addr, align 4
  %add9 = add i32 %r.load7, %c.load4
  %d.load3.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load3.elem.load, i32 %add9
  %d.load3.elem.load.elem.load = load i32, i32* %d.load3.elem.load.elem.addr, align 4
  store i32 1, i32* %d.load3.elem.load.elem.addr, align 4
  %row.load1 = load i32*, i32** @row, align 8
  %r.load8 = load i32, i32* %r.addr, align 4
  %row.load1.elem.addr = getelementptr inbounds i32, i32* %row.load1, i32 %r.load8
  %row.load1.elem.load = load i32, i32* %row.load1.elem.addr, align 4
  store i32 1, i32* %row.load1.elem.addr, align 4
  %col.load1 = load i32*, i32** @col, align 8
  %c.load5 = load i32, i32* %c.addr, align 4
  %col.load1.elem.addr = getelementptr inbounds i32, i32* %col.load1, i32 %c.load5
  %col.load1.elem.load = load i32, i32* %col.load1.elem.addr, align 4
  %r.load9 = load i32, i32* %r.addr, align 4
  store i32 %r.load9, i32* %col.load1.elem.addr, align 4
  %c.load6 = load i32, i32* %c.addr, align 4
  %add10 = add i32 %c.load6, 1
  call void @search(i32 %add10)
  %row.load2 = load i32*, i32** @row, align 8
  %r.load10 = load i32, i32* %r.addr, align 4
  %row.load2.elem.addr = getelementptr inbounds i32, i32* %row.load2, i32 %r.load10
  %row.load2.elem.load = load i32, i32* %row.load2.elem.addr, align 4
  store i32 0, i32* %row.load2.elem.addr, align 4
  %d.load4 = load i32**, i32*** @d, align 8
  %d.load4.elem.addr = getelementptr inbounds i32*, i32** %d.load4, i32 0
  %d.load4.elem.load = load i32*, i32** %d.load4.elem.addr, align 8
  %r.load11 = load i32, i32* %r.addr, align 4
  %c.load7 = load i32, i32* %c.addr, align 4
  %add11 = add i32 %r.load11, %c.load7
  %d.load4.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load4.elem.load, i32 %add11
  %d.load4.elem.load.elem.load = load i32, i32* %d.load4.elem.load.elem.addr, align 4
  store i32 0, i32* %d.load4.elem.load.elem.addr, align 4
  %d.load5 = load i32**, i32*** @d, align 8
  %d.load5.elem.addr = getelementptr inbounds i32*, i32** %d.load5, i32 1
  %d.load5.elem.load = load i32*, i32** %d.load5.elem.addr, align 8
  %r.load12 = load i32, i32* %r.addr, align 4
  %N.load6 = load i32, i32* @N, align 4
  %add12 = add i32 %r.load12, %N.load6
  %sub4 = sub i32 %add12, 1
  %c.load8 = load i32, i32* %c.addr, align 4
  %sub5 = sub i32 %sub4, %c.load8
  %d.load5.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load5.elem.load, i32 %sub5
  %d.load5.elem.load.elem.load = load i32, i32* %d.load5.elem.load.elem.addr, align 4
  store i32 0, i32* %d.load5.elem.load.elem.addr, align 4
  br label %if.exit2

if.false2:                                                ; preds = %lg.exit1 
  br label %if.exit2

if.exit2:                                                ; preds = %if.false2, %if.true2 
  br label %for.incr2

lg.nocut:                                                ; preds = %for.body2 
  %d.load = load i32**, i32*** @d, align 8
  %d.load.elem.addr = getelementptr inbounds i32*, i32** %d.load, i32 0
  %d.load.elem.load = load i32*, i32** %d.load.elem.addr, align 8
  %r.load4 = load i32, i32* %r.addr, align 4
  %c.load1 = load i32, i32* %c.addr, align 4
  %add6 = add i32 %r.load4, %c.load1
  %d.load.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load.elem.load, i32 %add6
  %d.load.elem.load.elem.load = load i32, i32* %d.load.elem.load.elem.addr, align 4
  %icmp6 = icmp eq i32 %d.load.elem.load.elem.load, 0
  br label %lg.exit

lg.exit:                                                ; preds = %for.body2, %lg.nocut 
  %phi = phi i1 [%icmp5, %for.body2], [%icmp6, %lg.nocut]
  br i1 %phi, label %lg.nocut1, label %lg.exit1

lg.nocut1:                                                ; preds = %lg.exit 
  %d.load1 = load i32**, i32*** @d, align 8
  %d.load1.elem.addr = getelementptr inbounds i32*, i32** %d.load1, i32 1
  %d.load1.elem.load = load i32*, i32** %d.load1.elem.addr, align 8
  %r.load5 = load i32, i32* %r.addr, align 4
  %N.load4 = load i32, i32* @N, align 4
  %add7 = add i32 %r.load5, %N.load4
  %sub = sub i32 %add7, 1
  %c.load2 = load i32, i32* %c.addr, align 4
  %sub1 = sub i32 %sub, %c.load2
  %d.load1.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load1.elem.load, i32 %sub1
  %d.load1.elem.load.elem.load = load i32, i32* %d.load1.elem.load.elem.addr, align 4
  %icmp7 = icmp eq i32 %d.load1.elem.load.elem.load, 0
  br label %lg.exit1

lg.exit1:                                                ; preds = %lg.nocut1, %lg.exit 
  %phi1 = phi i1 [%phi, %lg.exit], [%icmp7, %lg.nocut1]
  br i1 %phi1, label %if.true2, label %if.false2

exit13:                                                ; preds = %if.exit1 
  ret void
}

define i32 @main() {
entry14:
  %j.addr1 = alloca i32, align 4
  %i.addr1 = alloca i32, align 4
  %retreg.addr = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr, align 4
  %i.load4 = load i32, i32* %i.addr1, align 4
  store i32 0, i32* %i.addr1, align 4
  br label %for.cond3

for.cond3:                                                ; preds = %for.incr3, %entry14 
  %i.load5 = load i32, i32* %i.addr1, align 4
  %icmp8 = icmp slt i32 %i.load5, 8
  br i1 %icmp8, label %for.body3, label %for.exit3

for.incr3:                                                ; preds = %for.body3 
  %i.load6 = load i32, i32* %i.addr1, align 4
  %add13 = add i32 %i.load6, 1
  store i32 %add13, i32* %i.addr1, align 4
  br label %for.cond3

for.body3:                                                ; preds = %for.cond3 
  %row.load3 = load i32*, i32** @row, align 8
  %i.load7 = load i32, i32* %i.addr1, align 4
  %row.load3.elem.addr = getelementptr inbounds i32, i32* %row.load3, i32 %i.load7
  %row.load3.elem.load = load i32, i32* %row.load3.elem.addr, align 4
  store i32 0, i32* %row.load3.elem.addr, align 4
  %col.load2 = load i32*, i32** @col, align 8
  %i.load8 = load i32, i32* %i.addr1, align 4
  %col.load2.elem.addr = getelementptr inbounds i32, i32* %col.load2, i32 %i.load8
  %col.load2.elem.load = load i32, i32* %col.load2.elem.addr, align 4
  store i32 0, i32* %col.load2.elem.addr, align 4
  br label %for.incr3

for.exit3:                                                ; preds = %for.cond3 
  %i.load9 = load i32, i32* %i.addr1, align 4
  store i32 0, i32* %i.addr1, align 4
  br label %for.cond4

for.cond4:                                                ; preds = %for.exit3, %for.incr4 
  %i.load10 = load i32, i32* %i.addr1, align 4
  %icmp9 = icmp slt i32 %i.load10, 2
  br i1 %icmp9, label %for.body4, label %for.exit4

for.incr4:                                                ; preds = %for.exit5 
  %i.load11 = load i32, i32* %i.addr1, align 4
  %add14 = add i32 %i.load11, 1
  store i32 %add14, i32* %i.addr1, align 4
  br label %for.cond4

for.body4:                                                ; preds = %for.cond4 
  %d.load6 = load i32**, i32*** @d, align 8
  %i.load12 = load i32, i32* %i.addr1, align 4
  %d.load6.elem.addr = getelementptr inbounds i32*, i32** %d.load6, i32 %i.load12
  %d.load6.elem.load = load i32*, i32** %d.load6.elem.addr, align 8
  %add15 = add i32 8, 8
  %sub6 = sub i32 %add15, 1
  %mul3 = mul i32 %sub6, 4
  %add16 = add i32 %mul3, 4
  %_bot_malloc.call3 = call noalias i8* @_bot_malloc(i32 %add16)
  %bitcast6 = bitcast i8* %_bot_malloc.call3 to i32*
  store i32 %sub6, i32* %bitcast6, align 4
  %getelementptr7 = getelementptr inbounds i32, i32* %bitcast6, i32 1
  %bitcast7 = bitcast i32* %getelementptr7 to i32*
  store i32* %bitcast7, i32** %d.load6.elem.addr, align 8
  %j.load4 = load i32, i32* %j.addr1, align 4
  store i32 0, i32* %j.addr1, align 4
  br label %for.cond5

for.exit4:                                                ; preds = %for.cond4 
  call void @search(i32 0)
  store i32 0, i32* %retreg.addr, align 4
  br label %exit14

for.cond5:                                                ; preds = %for.incr5, %for.body4 
  %j.load5 = load i32, i32* %j.addr1, align 4
  %add17 = add i32 8, 8
  %sub7 = sub i32 %add17, 1
  %icmp10 = icmp slt i32 %j.load5, %sub7
  br i1 %icmp10, label %for.body5, label %for.exit5

for.incr5:                                                ; preds = %for.body5 
  %j.load6 = load i32, i32* %j.addr1, align 4
  %add18 = add i32 %j.load6, 1
  store i32 %add18, i32* %j.addr1, align 4
  br label %for.cond5

for.body5:                                                ; preds = %for.cond5 
  %d.load7 = load i32**, i32*** @d, align 8
  %i.load13 = load i32, i32* %i.addr1, align 4
  %d.load7.elem.addr = getelementptr inbounds i32*, i32** %d.load7, i32 %i.load13
  %d.load7.elem.load = load i32*, i32** %d.load7.elem.addr, align 8
  %j.load7 = load i32, i32* %j.addr1, align 4
  %d.load7.elem.load.elem.addr = getelementptr inbounds i32, i32* %d.load7.elem.load, i32 %j.load7
  %d.load7.elem.load.elem.load = load i32, i32* %d.load7.elem.load.elem.addr, align 4
  store i32 0, i32* %d.load7.elem.load.elem.addr, align 4
  br label %for.incr5

for.exit5:                                                ; preds = %for.cond5 
  br label %for.incr4

exit14:                                                ; preds = %for.exit4 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

