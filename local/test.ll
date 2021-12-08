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

@n = global i32 zeroinitializer, align 4
@m = global i32 zeroinitializer, align 4
@ans = global i32 zeroinitializer, align 4
@fa = global i32* zeroinitializer, align 8
@rk = global i32* zeroinitializer, align 8
@e = global %class.Edge** zeroinitializer, align 8
@x = global i32 zeroinitializer, align 4
@y = global i32 zeroinitializer, align 4
@w = global i32 zeroinitializer, align 4

%class.Edge = type {i32, i32, i32}

define void @Edge.Edge(%class.Edge* %this) {
entry12:
  br label %exit12

exit12:                                                ; preds = %entry12 
  ret void
}

define void @_glb_init() {
entry11:
  store i32 0, i32* @ans, align 4
  store i32* null, i32** @fa, align 8
  store i32* null, i32** @rk, align 8
  store %class.Edge** null, %class.Edge*** @e, align 8
  br label %exit11

exit11:                                                ; preds = %entry11 
  ret void
}

define void @qsort(%class.Edge** %e1, i32 %l, i32 %r) {
entry13:
  %x.addr = alloca %class.Edge*, align 8
  %j.addr = alloca i32, align 4
  %i.addr = alloca i32, align 4
  %r.addr = alloca i32, align 4
  %l.addr = alloca i32, align 4
  %e.addr = alloca %class.Edge**, align 8
  store %class.Edge** %e1, %class.Edge*** %e.addr, align 8
  store i32 %l, i32* %l.addr, align 4
  store i32 %r, i32* %r.addr, align 4
  %l.load = load i32, i32* %l.addr, align 4
  %r.load = load i32, i32* %r.addr, align 4
  %icmp = icmp slt i32 %l.load, %r.load
  br i1 %icmp, label %if.true, label %if.false

if.true:                                                ; preds = %entry13 
  %l.load1 = load i32, i32* %l.addr, align 4
  store i32 %l.load1, i32* %i.addr, align 4
  %r.load1 = load i32, i32* %r.addr, align 4
  store i32 %r.load1, i32* %j.addr, align 4
  %e.load = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %l.load2 = load i32, i32* %l.addr, align 4
  %e.load.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load, i32 %l.load2
  %e.load.elem.load = load %class.Edge*, %class.Edge** %e.load.elem.addr, align 8
  store %class.Edge* %e.load.elem.load, %class.Edge** %x.addr, align 8
  br label %wh.cond

if.false:                                                ; preds = %entry13 
  br label %if.exit

if.exit:                                                ; preds = %if.false, %wh.exit 
  br label %exit13

wh.cond:                                                ; preds = %if.true, %if.exit2 
  %i.load = load i32, i32* %i.addr, align 4
  %j.load = load i32, i32* %j.addr, align 4
  %icmp1 = icmp slt i32 %i.load, %j.load
  br i1 %icmp1, label %wh.body, label %wh.exit

wh.body:                                                ; preds = %wh.cond 
  br label %wh.cond1

wh.exit:                                                ; preds = %wh.cond 
  %e.load7 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load10 = load i32, i32* %i.addr, align 4
  %e.load7.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load7, i32 %i.load10
  %e.load7.elem.load = load %class.Edge*, %class.Edge** %e.load7.elem.addr, align 8
  %x.load2 = load %class.Edge*, %class.Edge** %x.addr, align 8
  store %class.Edge* %x.load2, %class.Edge** %e.load7.elem.addr, align 8
  %e.load8 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %l.load3 = load i32, i32* %l.addr, align 4
  %i.load11 = load i32, i32* %i.addr, align 4
  %sub2 = sub i32 %i.load11, 1
  call void @qsort(%class.Edge** %e.load8, i32 %l.load3, i32 %sub2)
  %e.load9 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load12 = load i32, i32* %i.addr, align 4
  %add2 = add i32 %i.load12, 1
  %r.load2 = load i32, i32* %r.addr, align 4
  call void @qsort(%class.Edge** %e.load9, i32 %add2, i32 %r.load2)
  br label %if.exit

wh.cond1:                                                ; preds = %wh.body, %wh.body1 
  %i.load1 = load i32, i32* %i.addr, align 4
  %j.load1 = load i32, i32* %j.addr, align 4
  %icmp2 = icmp slt i32 %i.load1, %j.load1
  br i1 %icmp2, label %lg.nocut, label %mid

wh.body1:                                                ; preds = %lg.exit 
  %j.load3 = load i32, i32* %j.addr, align 4
  %sub = sub i32 %j.load3, 1
  store i32 %sub, i32* %j.addr, align 4
  br label %wh.cond1

wh.exit1:                                                ; preds = %lg.exit 
  %i.load2 = load i32, i32* %i.addr, align 4
  %j.load4 = load i32, i32* %j.addr, align 4
  %icmp4 = icmp slt i32 %i.load2, %j.load4
  br i1 %icmp4, label %if.true1, label %if.false1

lg.nocut:                                                ; preds = %wh.cond1 
  %e.load1 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %j.load2 = load i32, i32* %j.addr, align 4
  %e.load1.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load1, i32 %j.load2
  %e.load1.elem.load = load %class.Edge*, %class.Edge** %e.load1.elem.addr, align 8
  %w.addr = getelementptr inbounds %class.Edge, %class.Edge* %e.load1.elem.load, i32 0, i32 2
  %w.load = load i32, i32* %w.addr, align 4
  %x.load = load %class.Edge*, %class.Edge** %x.addr, align 8
  %w.addr1 = getelementptr inbounds %class.Edge, %class.Edge* %x.load, i32 0, i32 2
  %w.load1 = load i32, i32* %w.addr1, align 4
  %icmp3 = icmp sge i32 %w.load, %w.load1
  move %phi, %icmp3
  br label %lg.exit

lg.exit:                                                ; preds = %mid, %wh.cond1, %lg.nocut 
  br i1 %phi, label %wh.body1, label %wh.exit1

if.true1:                                                ; preds = %wh.exit1 
  %e.load2 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load3 = load i32, i32* %i.addr, align 4
  %e.load2.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load2, i32 %i.load3
  %e.load2.elem.load = load %class.Edge*, %class.Edge** %e.load2.elem.addr, align 8
  %e.load3 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %j.load5 = load i32, i32* %j.addr, align 4
  %e.load3.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load3, i32 %j.load5
  %e.load3.elem.load = load %class.Edge*, %class.Edge** %e.load3.elem.addr, align 8
  store %class.Edge* %e.load3.elem.load, %class.Edge** %e.load2.elem.addr, align 8
  %i.load4 = load i32, i32* %i.addr, align 4
  %add = add i32 %i.load4, 1
  store i32 %add, i32* %i.addr, align 4
  br label %if.exit1

if.false1:                                                ; preds = %wh.exit1 
  br label %if.exit1

if.exit1:                                                ; preds = %if.true1, %if.false1 
  br label %wh.cond2

wh.cond2:                                                ; preds = %wh.body2, %if.exit1 
  %i.load5 = load i32, i32* %i.addr, align 4
  %j.load6 = load i32, i32* %j.addr, align 4
  %icmp5 = icmp slt i32 %i.load5, %j.load6
  br i1 %icmp5, label %lg.nocut1, label %mid1

wh.body2:                                                ; preds = %lg.exit1 
  %i.load7 = load i32, i32* %i.addr, align 4
  %add1 = add i32 %i.load7, 1
  store i32 %add1, i32* %i.addr, align 4
  br label %wh.cond2

wh.exit2:                                                ; preds = %lg.exit1 
  %i.load8 = load i32, i32* %i.addr, align 4
  %j.load7 = load i32, i32* %j.addr, align 4
  %icmp7 = icmp slt i32 %i.load8, %j.load7
  br i1 %icmp7, label %if.true2, label %if.false2

lg.nocut1:                                                ; preds = %wh.cond2 
  %e.load4 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load6 = load i32, i32* %i.addr, align 4
  %e.load4.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load4, i32 %i.load6
  %e.load4.elem.load = load %class.Edge*, %class.Edge** %e.load4.elem.addr, align 8
  %w.addr2 = getelementptr inbounds %class.Edge, %class.Edge* %e.load4.elem.load, i32 0, i32 2
  %w.load2 = load i32, i32* %w.addr2, align 4
  %x.load1 = load %class.Edge*, %class.Edge** %x.addr, align 8
  %w.addr3 = getelementptr inbounds %class.Edge, %class.Edge* %x.load1, i32 0, i32 2
  %w.load3 = load i32, i32* %w.addr3, align 4
  %icmp6 = icmp slt i32 %w.load2, %w.load3
  move %phi1, %icmp6
  br label %lg.exit1

lg.exit1:                                                ; preds = %wh.cond2, %lg.nocut1, %mid1 
  br i1 %phi1, label %wh.body2, label %wh.exit2

if.true2:                                                ; preds = %wh.exit2 
  %e.load5 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %j.load8 = load i32, i32* %j.addr, align 4
  %e.load5.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load5, i32 %j.load8
  %e.load5.elem.load = load %class.Edge*, %class.Edge** %e.load5.elem.addr, align 8
  %e.load6 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load9 = load i32, i32* %i.addr, align 4
  %e.load6.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load6, i32 %i.load9
  %e.load6.elem.load = load %class.Edge*, %class.Edge** %e.load6.elem.addr, align 8
  store %class.Edge* %e.load6.elem.load, %class.Edge** %e.load5.elem.addr, align 8
  %j.load9 = load i32, i32* %j.addr, align 4
  %sub1 = sub i32 %j.load9, 1
  store i32 %sub1, i32* %j.addr, align 4
  br label %if.exit2

if.false2:                                                ; preds = %wh.exit2 
  br label %if.exit2

if.exit2:                                                ; preds = %if.true2, %if.false2 
  br label %wh.cond

mid:
  move %phi, %icmp2
  br label %lg.exit

mid1:
  move %phi1, %icmp5
  br label %lg.exit1

exit13:                                                ; preds = %if.exit 
  ret void
}

define void @init() {
entry14:
  %i.addr1 = alloca i32, align 4
  %fa.load = load i32*, i32** @fa, align 8
  %n.load = load i32, i32* @n, align 4
  %add3 = add i32 %n.load, 1
  %mul = mul i32 %add3, 4
  %add4 = add i32 %mul, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add4)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 %add3, i32* %bitcast, align 4
  %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast1 = bitcast i32* %getelementptr to i32*
  store i32* %bitcast1, i32** @fa, align 8
  %rk.load = load i32*, i32** @rk, align 8
  %n.load1 = load i32, i32* @n, align 4
  %add5 = add i32 %n.load1, 1
  %mul1 = mul i32 %add5, 4
  %add6 = add i32 %mul1, 4
  %_bot_malloc.call1 = call noalias i8* @_bot_malloc(i32 %add6)
  %bitcast2 = bitcast i8* %_bot_malloc.call1 to i32*
  store i32 %add5, i32* %bitcast2, align 4
  %getelementptr1 = getelementptr inbounds i32, i32* %bitcast2, i32 1
  %bitcast3 = bitcast i32* %getelementptr1 to i32*
  store i32* %bitcast3, i32** @rk, align 8
  %i.load13 = load i32, i32* %i.addr1, align 4
  store i32 1, i32* %i.addr1, align 4
  br label %for.cond

for.cond:                                                ; preds = %entry14, %for.incr 
  %i.load14 = load i32, i32* %i.addr1, align 4
  %n.load2 = load i32, i32* @n, align 4
  %icmp8 = icmp sle i32 %i.load14, %n.load2
  br i1 %icmp8, label %for.body, label %for.exit

for.incr:                                                ; preds = %for.body 
  %i.load15 = load i32, i32* %i.addr1, align 4
  %add7 = add i32 %i.load15, 1
  store i32 %add7, i32* %i.addr1, align 4
  br label %for.cond

for.body:                                                ; preds = %for.cond 
  %fa.load1 = load i32*, i32** @fa, align 8
  %i.load16 = load i32, i32* %i.addr1, align 4
  %fa.load1.elem.addr = getelementptr inbounds i32, i32* %fa.load1, i32 %i.load16
  %fa.load1.elem.load = load i32, i32* %fa.load1.elem.addr, align 4
  %i.load17 = load i32, i32* %i.addr1, align 4
  store i32 %i.load17, i32* %fa.load1.elem.addr, align 4
  %rk.load1 = load i32*, i32** @rk, align 8
  %i.load18 = load i32, i32* %i.addr1, align 4
  %rk.load1.elem.addr = getelementptr inbounds i32, i32* %rk.load1, i32 %i.load18
  %rk.load1.elem.load = load i32, i32* %rk.load1.elem.addr, align 4
  store i32 1, i32* %rk.load1.elem.addr, align 4
  br label %for.incr

for.exit:                                                ; preds = %for.cond 
  br label %exit14

exit14:                                                ; preds = %for.exit 
  ret void
}

define i32 @find(i32 %x1) {
entry15:
  %x.addr1 = alloca i32, align 4
  %retreg.addr = alloca i32, align 4
  store i32 %x1, i32* %x.addr1, align 4
  %x.load3 = load i32, i32* %x.addr1, align 4
  %fa.load2 = load i32*, i32** @fa, align 8
  %x.load4 = load i32, i32* %x.addr1, align 4
  %fa.load2.elem.addr = getelementptr inbounds i32, i32* %fa.load2, i32 %x.load4
  %fa.load2.elem.load = load i32, i32* %fa.load2.elem.addr, align 4
  %icmp9 = icmp eq i32 %x.load3, %fa.load2.elem.load
  br i1 %icmp9, label %if.true3, label %if.false3

if.true3:                                                ; preds = %entry15 
  %x.load5 = load i32, i32* %x.addr1, align 4
  store i32 %x.load5, i32* %retreg.addr, align 4
  br label %mid2

if.false3:                                                ; preds = %entry15 
  br label %if.exit3

if.exit3:                                                ; preds = %if.false3, %mid3, %if.true3 
  %x.load6 = load i32, i32* %x.addr1, align 4
  %fa.load3 = load i32*, i32** @fa, align 8
  %x.load7 = load i32, i32* %x.addr1, align 4
  %fa.load3.elem.addr = getelementptr inbounds i32, i32* %fa.load3, i32 %x.load7
  %fa.load3.elem.load = load i32, i32* %fa.load3.elem.addr, align 4
  %find.call = call i32 @find(i32 %fa.load3.elem.load)
  store i32 %find.call, i32* %x.addr1, align 4
  %fa.load4 = load i32*, i32** @fa, align 8
  %x.load8 = load i32, i32* %x.addr1, align 4
  %fa.load4.elem.addr = getelementptr inbounds i32, i32* %fa.load4, i32 %x.load8
  %fa.load4.elem.load = load i32, i32* %fa.load4.elem.addr, align 4
  store i32 %fa.load4.elem.load, i32* %retreg.addr, align 4
  br label %exit15

mid2:
  br label %exit15

mid3:
  br label %if.exit3

exit15:                                                ; preds = %mid2, %if.exit3, %if.true3 
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

define i1 @union(i32 %x2, i32 %y1) {
entry16:
  %y.addr = alloca i32, align 4
  %x.addr2 = alloca i32, align 4
  %retreg.addr1 = alloca i8, align 1
  store i32 %x2, i32* %x.addr2, align 4
  store i32 %y1, i32* %y.addr, align 4
  %x.load9 = load i32, i32* %x.addr2, align 4
  %x.load10 = load i32, i32* %x.addr2, align 4
  %find.call1 = call i32 @find(i32 %x.load10)
  store i32 %find.call1, i32* %x.addr2, align 4
  %y.load = load i32, i32* %y.addr, align 4
  %y.load1 = load i32, i32* %y.addr, align 4
  %find.call2 = call i32 @find(i32 %y.load1)
  store i32 %find.call2, i32* %y.addr, align 4
  %x.load11 = load i32, i32* %x.addr2, align 4
  %y.load2 = load i32, i32* %y.addr, align 4
  %icmp10 = icmp eq i32 %x.load11, %y.load2
  br i1 %icmp10, label %if.true4, label %if.false4

if.true4:                                                ; preds = %entry16 
  %zext = zext i1 false to i8
  store i8 %zext, i8* %retreg.addr1, align 1
  br label %mid4

if.false4:                                                ; preds = %entry16 
  br label %if.exit4

if.exit4:                                                ; preds = %mid5, %if.false4, %if.true4 
  %rk.load2 = load i32*, i32** @rk, align 8
  %x.load12 = load i32, i32* %x.addr2, align 4
  %rk.load2.elem.addr = getelementptr inbounds i32, i32* %rk.load2, i32 %x.load12
  %rk.load2.elem.load = load i32, i32* %rk.load2.elem.addr, align 4
  %rk.load3 = load i32*, i32** @rk, align 8
  %y.load3 = load i32, i32* %y.addr, align 4
  %rk.load3.elem.addr = getelementptr inbounds i32, i32* %rk.load3, i32 %y.load3
  %rk.load3.elem.load = load i32, i32* %rk.load3.elem.addr, align 4
  %icmp11 = icmp sgt i32 %rk.load2.elem.load, %rk.load3.elem.load
  br i1 %icmp11, label %if.true5, label %if.false5

if.true5:                                                ; preds = %if.exit4 
  %fa.load6 = load i32*, i32** @fa, align 8
  %y.load7 = load i32, i32* %y.addr, align 4
  %fa.load6.elem.addr = getelementptr inbounds i32, i32* %fa.load6, i32 %y.load7
  %fa.load6.elem.load = load i32, i32* %fa.load6.elem.addr, align 4
  %x.load15 = load i32, i32* %x.addr2, align 4
  store i32 %x.load15, i32* %fa.load6.elem.addr, align 4
  %rk.load7 = load i32*, i32** @rk, align 8
  %x.load16 = load i32, i32* %x.addr2, align 4
  %rk.load7.elem.addr = getelementptr inbounds i32, i32* %rk.load7, i32 %x.load16
  %rk.load7.elem.load = load i32, i32* %rk.load7.elem.addr, align 4
  %rk.load8 = load i32*, i32** @rk, align 8
  %x.load17 = load i32, i32* %x.addr2, align 4
  %rk.load8.elem.addr = getelementptr inbounds i32, i32* %rk.load8, i32 %x.load17
  %rk.load8.elem.load = load i32, i32* %rk.load8.elem.addr, align 4
  %rk.load9 = load i32*, i32** @rk, align 8
  %y.load8 = load i32, i32* %y.addr, align 4
  %rk.load9.elem.addr = getelementptr inbounds i32, i32* %rk.load9, i32 %y.load8
  %rk.load9.elem.load = load i32, i32* %rk.load9.elem.addr, align 4
  %add9 = add i32 %rk.load8.elem.load, %rk.load9.elem.load
  store i32 %add9, i32* %rk.load7.elem.addr, align 4
  br label %if.exit5

if.false5:                                                ; preds = %if.exit4 
  %fa.load5 = load i32*, i32** @fa, align 8
  %x.load13 = load i32, i32* %x.addr2, align 4
  %fa.load5.elem.addr = getelementptr inbounds i32, i32* %fa.load5, i32 %x.load13
  %fa.load5.elem.load = load i32, i32* %fa.load5.elem.addr, align 4
  %y.load4 = load i32, i32* %y.addr, align 4
  store i32 %y.load4, i32* %fa.load5.elem.addr, align 4
  %rk.load4 = load i32*, i32** @rk, align 8
  %y.load5 = load i32, i32* %y.addr, align 4
  %rk.load4.elem.addr = getelementptr inbounds i32, i32* %rk.load4, i32 %y.load5
  %rk.load4.elem.load = load i32, i32* %rk.load4.elem.addr, align 4
  %rk.load5 = load i32*, i32** @rk, align 8
  %y.load6 = load i32, i32* %y.addr, align 4
  %rk.load5.elem.addr = getelementptr inbounds i32, i32* %rk.load5, i32 %y.load6
  %rk.load5.elem.load = load i32, i32* %rk.load5.elem.addr, align 4
  %rk.load6 = load i32*, i32** @rk, align 8
  %x.load14 = load i32, i32* %x.addr2, align 4
  %rk.load6.elem.addr = getelementptr inbounds i32, i32* %rk.load6, i32 %x.load14
  %rk.load6.elem.load = load i32, i32* %rk.load6.elem.addr, align 4
  %add8 = add i32 %rk.load5.elem.load, %rk.load6.elem.load
  store i32 %add8, i32* %rk.load4.elem.addr, align 4
  br label %if.exit5

if.exit5:                                                ; preds = %if.false5, %if.true5 
  %zext1 = zext i1 true to i8
  store i8 %zext1, i8* %retreg.addr1, align 1
  br label %exit16

mid4:
  br label %exit16

mid5:
  br label %if.exit4

exit16:                                                ; preds = %if.exit5, %if.true4, %mid4 
  %retreg.load1 = load i8, i8* %retreg.addr1, align 1
  %trunc = trunc i8 %retreg.load1 to i1
  ret i1 %trunc
}

define i32 @main() {
entry17:
  %ed.addr1 = alloca %class.Edge*, align 8
  %j.addr1 = alloca i32, align 4
  %ed.addr = alloca %class.Edge*, align 8
  %i.addr2 = alloca i32, align 4
  %retreg.addr2 = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr2, align 4
  %n.load3 = load i32, i32* @n, align 4
  %getInt.call = call i32 @getInt()
  store i32 %getInt.call, i32* @n, align 4
  %m.load = load i32, i32* @m, align 4
  %getInt.call1 = call i32 @getInt()
  store i32 %getInt.call1, i32* @m, align 4
  %e.load10 = load %class.Edge**, %class.Edge*** @e, align 8
  %m.load1 = load i32, i32* @m, align 4
  %mul2 = mul i32 %m.load1, 8
  %add10 = add i32 %mul2, 4
  %_bot_malloc.call2 = call noalias i8* @_bot_malloc(i32 %add10)
  %bitcast4 = bitcast i8* %_bot_malloc.call2 to i32*
  store i32 %m.load1, i32* %bitcast4, align 4
  %getelementptr2 = getelementptr inbounds i32, i32* %bitcast4, i32 1
  %bitcast5 = bitcast i32* %getelementptr2 to %class.Edge**
  store %class.Edge** %bitcast5, %class.Edge*** @e, align 8
  %i.load19 = load i32, i32* %i.addr2, align 4
  store i32 0, i32* %i.addr2, align 4
  br label %for.cond1

for.cond1:                                                ; preds = %entry17, %for.incr1 
  %i.load20 = load i32, i32* %i.addr2, align 4
  %m.load2 = load i32, i32* @m, align 4
  %icmp12 = icmp slt i32 %i.load20, %m.load2
  br i1 %icmp12, label %for.body1, label %for.exit1

for.incr1:                                                ; preds = %for.body1 
  %i.load21 = load i32, i32* %i.addr2, align 4
  %add11 = add i32 %i.load21, 1
  store i32 %add11, i32* %i.addr2, align 4
  br label %for.cond1

for.body1:                                                ; preds = %for.cond1 
  %_bot_malloc.call3 = call noalias i8* @_bot_malloc(i32 12)
  %bitcast6 = bitcast i8* %_bot_malloc.call3 to %class.Edge*
  call void @Edge.Edge(%class.Edge* %bitcast6)
  store %class.Edge* %bitcast6, %class.Edge** %ed.addr, align 8
  %ed.load = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %x.addr3 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load, i32 0, i32 0
  %x.load18 = load i32, i32* %x.addr3, align 4
  %getInt.call2 = call i32 @getInt()
  store i32 %getInt.call2, i32* %x.addr3, align 4
  %ed.load1 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %y.addr1 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load1, i32 0, i32 1
  %y.load9 = load i32, i32* %y.addr1, align 4
  %getInt.call3 = call i32 @getInt()
  store i32 %getInt.call3, i32* %y.addr1, align 4
  %ed.load2 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %w.addr4 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load2, i32 0, i32 2
  %w.load4 = load i32, i32* %w.addr4, align 4
  %getInt.call4 = call i32 @getInt()
  store i32 %getInt.call4, i32* %w.addr4, align 4
  %e.load11 = load %class.Edge**, %class.Edge*** @e, align 8
  %i.load22 = load i32, i32* %i.addr2, align 4
  %e.load11.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load11, i32 %i.load22
  %e.load11.elem.load = load %class.Edge*, %class.Edge** %e.load11.elem.addr, align 8
  %ed.load3 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  store %class.Edge* %ed.load3, %class.Edge** %e.load11.elem.addr, align 8
  br label %for.incr1

for.exit1:                                                ; preds = %for.cond1 
  %e.load12 = load %class.Edge**, %class.Edge*** @e, align 8
  %m.load3 = load i32, i32* @m, align 4
  %sub3 = sub i32 %m.load3, 1
  call void @qsort(%class.Edge** %e.load12, i32 0, i32 %sub3)
  call void @init()
  %i.load23 = load i32, i32* %i.addr2, align 4
  store i32 0, i32* %i.addr2, align 4
  store i32 0, i32* %j.addr1, align 4
  br label %wh.cond3

wh.cond3:                                                ; preds = %for.exit1, %if.exit7 
  %i.load24 = load i32, i32* %i.addr2, align 4
  %n.load4 = load i32, i32* @n, align 4
  %sub4 = sub i32 %n.load4, 1
  %icmp13 = icmp slt i32 %i.load24, %sub4
  br i1 %icmp13, label %wh.body3, label %wh.exit3

wh.body3:                                                ; preds = %wh.cond3 
  %j.load10 = load i32, i32* %j.addr1, align 4
  %m.load4 = load i32, i32* @m, align 4
  %icmp14 = icmp sge i32 %j.load10, %m.load4
  br i1 %icmp14, label %if.true6, label %if.false6

wh.exit3:                                                ; preds = %wh.cond3 
  %rk.load10 = load i32*, i32** @rk, align 8
  %find.call3 = call i32 @find(i32 1)
  %rk.load10.elem.addr = getelementptr inbounds i32, i32* %rk.load10, i32 %find.call3
  %rk.load10.elem.load = load i32, i32* %rk.load10.elem.addr, align 4
  %n.load5 = load i32, i32* @n, align 4
  %icmp15 = icmp eq i32 %rk.load10.elem.load, %n.load5
  br i1 %icmp15, label %if.true8, label %if.false8

if.true6:                                                ; preds = %wh.body3 
  %sub5 = sub i32 0, 1
  call void @printInt(i32 %sub5)
  store i32 0, i32* %retreg.addr2, align 4
  br label %mid6

if.false6:                                                ; preds = %wh.body3 
  br label %if.exit6

if.exit6:                                                ; preds = %if.false6, %if.true6, %mid7 
  %e.load13 = load %class.Edge**, %class.Edge*** @e, align 8
  %j.load11 = load i32, i32* %j.addr1, align 4
  %e.load13.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load13, i32 %j.load11
  %e.load13.elem.load = load %class.Edge*, %class.Edge** %e.load13.elem.addr, align 8
  store %class.Edge* %e.load13.elem.load, %class.Edge** %ed.addr1, align 8
  %j.load12 = load i32, i32* %j.addr1, align 4
  %add12 = add i32 %j.load12, 1
  store i32 %add12, i32* %j.addr1, align 4
  %ed.load4 = load %class.Edge*, %class.Edge** %ed.addr1, align 8
  %x.addr4 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load4, i32 0, i32 0
  %x.load19 = load i32, i32* %x.addr4, align 4
  %ed.load5 = load %class.Edge*, %class.Edge** %ed.addr1, align 8
  %y.addr2 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load5, i32 0, i32 1
  %y.load10 = load i32, i32* %y.addr2, align 4
  %union.call = call i1 @union(i32 %x.load19, i32 %y.load10)
  br i1 %union.call, label %if.true7, label %if.false7

if.true7:                                                ; preds = %if.exit6 
  %i.load25 = load i32, i32* %i.addr2, align 4
  %add13 = add i32 %i.load25, 1
  store i32 %add13, i32* %i.addr2, align 4
  %ans.load = load i32, i32* @ans, align 4
  %ans.load1 = load i32, i32* @ans, align 4
  %ed.load6 = load %class.Edge*, %class.Edge** %ed.addr1, align 8
  %w.addr5 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load6, i32 0, i32 2
  %w.load5 = load i32, i32* %w.addr5, align 4
  %add14 = add i32 %ans.load1, %w.load5
  store i32 %add14, i32* @ans, align 4
  br label %if.exit7

if.false7:                                                ; preds = %if.exit6 
  br label %if.exit7

if.exit7:                                                ; preds = %if.false7, %if.true7 
  br label %wh.cond3

if.true8:                                                ; preds = %wh.exit3 
  %ans.load2 = load i32, i32* @ans, align 4
  call void @printInt(i32 %ans.load2)
  br label %if.exit8

if.false8:                                                ; preds = %wh.exit3 
  %sub6 = sub i32 0, 1
  call void @printInt(i32 %sub6)
  br label %if.exit8

if.exit8:                                                ; preds = %if.true8, %if.false8 
  store i32 0, i32* %retreg.addr2, align 4
  br label %exit17

mid6:
  br label %exit17

mid7:
  br label %if.exit6

exit17:                                                ; preds = %if.true6, %mid6, %if.exit8 
  %retreg.load2 = load i32, i32* %retreg.addr2, align 4
  ret i32 %retreg.load2
}

