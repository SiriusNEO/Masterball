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
@fa = global i32* zeroinitializer, align 4
@rk = global i32* zeroinitializer, align 4
@e = global %class.Edge** zeroinitializer, align 4

%class.Edge = type {i32, i32, i32}

define void @Edge.Edge(%class.Edge* %this) {
Edge.Edge.entry:
  br label %Edge.Edge.exit

Edge.Edge.exit:
  ret void
}

define void @_glb_init() {
_glb_init.entry:
  store i32 0, i32* @ans
  store i32* null, i32** @fa
  store i32* null, i32** @rk
  store %class.Edge** null, %class.Edge*** @e
  br label %_glb_init.exit

_glb_init.exit:
  ret void
}

define void @qsort(%class.Edge** %e1, i32 %l, i32 %r) {
qsort.entry:
  %e.addr = alloca %class.Edge**, align 4
  store %class.Edge** %e1, %class.Edge*** %e.addr
  %l.addr = alloca i32, align 4
  store i32 %l, i32* %l.addr
  %r.addr = alloca i32, align 4
  store i32 %r, i32* %r.addr
  %l.load = load i32, i32* %l.addr, align 4
  %r.load = load i32, i32* %r.addr, align 4
  %icmp = icmp slt i32 %l.load, %r.load
  br i1 %icmp, label %qsort.if.true, label %qsort.if.false

qsort.if.true:
  %i.addr = alloca i32, align 4
  %l.load1 = load i32, i32* %l.addr, align 4
  store i32 %l.load1, i32* %i.addr
  %j.addr = alloca i32, align 4
  %r.load1 = load i32, i32* %r.addr, align 4
  store i32 %r.load1, i32* %j.addr
  %x.addr = alloca %class.Edge*, align 4
  %e.load = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %l.load2 = load i32, i32* %l.addr, align 4
  %e.load.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load, i32 %l.load2
  %e.load.elem.load = load %class.Edge*, %class.Edge** %e.load.elem.addr, align 4
  store %class.Edge* %e.load.elem.load, %class.Edge** %x.addr
  br label %qsort.wh.cond

qsort.if.false:
  br label %qsort.if.exit

qsort.if.exit:
  br label %qsort.exit

qsort.wh.cond:
  %i.load = load i32, i32* %i.addr, align 4
  %j.load = load i32, i32* %j.addr, align 4
  %icmp1 = icmp slt i32 %i.load, %j.load
  br i1 %icmp1, label %qsort.wh.body, label %qsort.wh.exit

qsort.wh.body:
  br label %qsort.wh.cond1

qsort.wh.exit:
  %e.load7 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %i.load10 = load i32, i32* %i.addr, align 4
  %e.load7.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load7, i32 %i.load10
  %e.load7.elem.load = load %class.Edge*, %class.Edge** %e.load7.elem.addr, align 4
  %x.load2 = load %class.Edge*, %class.Edge** %x.addr, align 4
  store %class.Edge* %x.load2, %class.Edge** %e.load7.elem.addr
  %e.load8 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %l.load3 = load i32, i32* %l.addr, align 4
  %i.load11 = load i32, i32* %i.addr, align 4
  %sub2 = sub i32 %i.load11, 1
  call void @qsort(%class.Edge** %e.load8, i32 %l.load3, i32 %sub2)
  %e.load9 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %i.load12 = load i32, i32* %i.addr, align 4
  %add2 = add i32 %i.load12, 1
  %r.load2 = load i32, i32* %r.addr, align 4
  call void @qsort(%class.Edge** %e.load9, i32 %add2, i32 %r.load2)
  br label %qsort.if.exit

qsort.wh.cond1:
  %i.load1 = load i32, i32* %i.addr, align 4
  %j.load1 = load i32, i32* %j.addr, align 4
  %icmp2 = icmp slt i32 %i.load1, %j.load1
  br i1 %icmp2, label %qsort.lg.nocut, label %qsort.lg.exit

qsort.wh.body1:
  %j.load3 = load i32, i32* %j.addr, align 4
  %sub = sub i32 %j.load3, 1
  store i32 %sub, i32* %j.addr
  br label %qsort.wh.cond1

qsort.wh.exit1:
  %i.load2 = load i32, i32* %i.addr, align 4
  %j.load4 = load i32, i32* %j.addr, align 4
  %icmp4 = icmp slt i32 %i.load2, %j.load4
  br i1 %icmp4, label %qsort.if.true1, label %qsort.if.false1

qsort.lg.nocut:
  %e.load1 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %j.load2 = load i32, i32* %j.addr, align 4
  %e.load1.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load1, i32 %j.load2
  %e.load1.elem.load = load %class.Edge*, %class.Edge** %e.load1.elem.addr, align 4
  %w.addr = getelementptr %class.Edge, %class.Edge* %e.load1.elem.load, i32 0, i32 2
  %w.load = load i32, i32* %w.addr, align 4
  %x.load = load %class.Edge*, %class.Edge** %x.addr, align 4
  %w.addr1 = getelementptr %class.Edge, %class.Edge* %x.load, i32 0, i32 2
  %w.load1 = load i32, i32* %w.addr1, align 4
  %icmp3 = icmp sge i32 %w.load, %w.load1
  br label %qsort.lg.exit

qsort.lg.exit:
  %phi = phi i1 [%icmp2, %qsort.wh.cond1], [%icmp3, %qsort.lg.nocut]
  br i1 %phi, label %qsort.wh.body1, label %qsort.wh.exit1

qsort.if.true1:
  %e.load2 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %i.load3 = load i32, i32* %i.addr, align 4
  %e.load2.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load2, i32 %i.load3
  %e.load2.elem.load = load %class.Edge*, %class.Edge** %e.load2.elem.addr, align 4
  %e.load3 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %j.load5 = load i32, i32* %j.addr, align 4
  %e.load3.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load3, i32 %j.load5
  %e.load3.elem.load = load %class.Edge*, %class.Edge** %e.load3.elem.addr, align 4
  store %class.Edge* %e.load3.elem.load, %class.Edge** %e.load2.elem.addr
  %i.load4 = load i32, i32* %i.addr, align 4
  %add = add i32 %i.load4, 1
  store i32 %add, i32* %i.addr
  br label %qsort.if.exit1

qsort.if.false1:
  br label %qsort.if.exit1

qsort.if.exit1:
  br label %qsort.wh.cond2

qsort.wh.cond2:
  %i.load5 = load i32, i32* %i.addr, align 4
  %j.load6 = load i32, i32* %j.addr, align 4
  %icmp5 = icmp slt i32 %i.load5, %j.load6
  br i1 %icmp5, label %qsort.lg.nocut1, label %qsort.lg.exit1

qsort.wh.body2:
  %i.load7 = load i32, i32* %i.addr, align 4
  %add1 = add i32 %i.load7, 1
  store i32 %add1, i32* %i.addr
  br label %qsort.wh.cond2

qsort.wh.exit2:
  %i.load8 = load i32, i32* %i.addr, align 4
  %j.load7 = load i32, i32* %j.addr, align 4
  %icmp7 = icmp slt i32 %i.load8, %j.load7
  br i1 %icmp7, label %qsort.if.true2, label %qsort.if.false2

qsort.lg.nocut1:
  %e.load4 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %i.load6 = load i32, i32* %i.addr, align 4
  %e.load4.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load4, i32 %i.load6
  %e.load4.elem.load = load %class.Edge*, %class.Edge** %e.load4.elem.addr, align 4
  %w.addr2 = getelementptr %class.Edge, %class.Edge* %e.load4.elem.load, i32 0, i32 2
  %w.load2 = load i32, i32* %w.addr2, align 4
  %x.load1 = load %class.Edge*, %class.Edge** %x.addr, align 4
  %w.addr3 = getelementptr %class.Edge, %class.Edge* %x.load1, i32 0, i32 2
  %w.load3 = load i32, i32* %w.addr3, align 4
  %icmp6 = icmp slt i32 %w.load2, %w.load3
  br label %qsort.lg.exit1

qsort.lg.exit1:
  %phi1 = phi i1 [%icmp5, %qsort.wh.cond2], [%icmp6, %qsort.lg.nocut1]
  br i1 %phi1, label %qsort.wh.body2, label %qsort.wh.exit2

qsort.if.true2:
  %e.load5 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %j.load8 = load i32, i32* %j.addr, align 4
  %e.load5.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load5, i32 %j.load8
  %e.load5.elem.load = load %class.Edge*, %class.Edge** %e.load5.elem.addr, align 4
  %e.load6 = load %class.Edge**, %class.Edge*** %e.addr, align 4
  %i.load9 = load i32, i32* %i.addr, align 4
  %e.load6.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load6, i32 %i.load9
  %e.load6.elem.load = load %class.Edge*, %class.Edge** %e.load6.elem.addr, align 4
  store %class.Edge* %e.load6.elem.load, %class.Edge** %e.load5.elem.addr
  %j.load9 = load i32, i32* %j.addr, align 4
  %sub1 = sub i32 %j.load9, 1
  store i32 %sub1, i32* %j.addr
  br label %qsort.if.exit2

qsort.if.false2:
  br label %qsort.if.exit2

qsort.if.exit2:
  br label %qsort.wh.cond

qsort.exit:
  ret void
}

define void @init() {
init.entry:
  %fa.load = load i32*, i32** @fa, align 4
  %n.load = load i32, i32* @n, align 4
  %add3 = add i32 %n.load, 1
  %mul = mul i32 %add3, 4
  %add4 = add i32 %mul, 4
  %_bot_malloc.call = call i8* @_bot_malloc(i32 %add4)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 %add3, i32* %bitcast
  %getelementptr = getelementptr i32, i32* %bitcast, i32 1
  %bitcast1 = bitcast i32* %getelementptr to i32*
  store i32* %bitcast1, i32** @fa
  %rk.load = load i32*, i32** @rk, align 4
  %n.load1 = load i32, i32* @n, align 4
  %add5 = add i32 %n.load1, 1
  %mul1 = mul i32 %add5, 4
  %add6 = add i32 %mul1, 4
  %_bot_malloc.call1 = call i8* @_bot_malloc(i32 %add6)
  %bitcast2 = bitcast i8* %_bot_malloc.call1 to i32*
  store i32 %add5, i32* %bitcast2
  %getelementptr1 = getelementptr i32, i32* %bitcast2, i32 1
  %bitcast3 = bitcast i32* %getelementptr1 to i32*
  store i32* %bitcast3, i32** @rk
  %i.addr1 = alloca i32, align 4
  %i.load13 = load i32, i32* %i.addr1, align 4
  store i32 1, i32* %i.addr1
  br label %init.for.cond

init.for.cond:
  %i.load14 = load i32, i32* %i.addr1, align 4
  %n.load2 = load i32, i32* @n, align 4
  %icmp8 = icmp sle i32 %i.load14, %n.load2
  br i1 %icmp8, label %init.for.body, label %init.for.exit

init.for.incr:
  %i.load15 = load i32, i32* %i.addr1, align 4
  %add7 = add i32 %i.load15, 1
  store i32 %add7, i32* %i.addr1
  br label %init.for.cond

init.for.body:
  %fa.load1 = load i32*, i32** @fa, align 4
  %i.load16 = load i32, i32* %i.addr1, align 4
  %fa.load1.elem.addr = getelementptr i32, i32* %fa.load1, i32 %i.load16
  %fa.load1.elem.load = load i32, i32* %fa.load1.elem.addr, align 4
  %i.load17 = load i32, i32* %i.addr1, align 4
  store i32 %i.load17, i32* %fa.load1.elem.addr
  %rk.load1 = load i32*, i32** @rk, align 4
  %i.load18 = load i32, i32* %i.addr1, align 4
  %rk.load1.elem.addr = getelementptr i32, i32* %rk.load1, i32 %i.load18
  %rk.load1.elem.load = load i32, i32* %rk.load1.elem.addr, align 4
  store i32 1, i32* %rk.load1.elem.addr
  br label %init.for.incr

init.for.exit:
  br label %init.exit

init.exit:
  ret void
}

define i32 @find(i32 %x) {
find.entry:
  %retreg.addr = alloca i32, align 4
  %x.addr1 = alloca i32, align 4
  store i32 %x, i32* %x.addr1
  %x.load3 = load i32, i32* %x.addr1, align 4
  %fa.load2 = load i32*, i32** @fa, align 4
  %x.load4 = load i32, i32* %x.addr1, align 4
  %fa.load2.elem.addr = getelementptr i32, i32* %fa.load2, i32 %x.load4
  %fa.load2.elem.load = load i32, i32* %fa.load2.elem.addr, align 4
  %icmp9 = icmp eq i32 %x.load3, %fa.load2.elem.load
  br i1 %icmp9, label %find.if.true, label %find.if.false

find.if.true:
  %x.load5 = load i32, i32* %x.addr1, align 4
  store i32 %x.load5, i32* %retreg.addr
  br label %find.exit

find.if.false:
  br label %find.if.exit

find.if.exit:
  %x.load6 = load i32, i32* %x.addr1, align 4
  %fa.load3 = load i32*, i32** @fa, align 4
  %x.load7 = load i32, i32* %x.addr1, align 4
  %fa.load3.elem.addr = getelementptr i32, i32* %fa.load3, i32 %x.load7
  %fa.load3.elem.load = load i32, i32* %fa.load3.elem.addr, align 4
  %find.call = call i32 @find(i32 %fa.load3.elem.load)
  store i32 %find.call, i32* %x.addr1
  %fa.load4 = load i32*, i32** @fa, align 4
  %x.load8 = load i32, i32* %x.addr1, align 4
  %fa.load4.elem.addr = getelementptr i32, i32* %fa.load4, i32 %x.load8
  %fa.load4.elem.load = load i32, i32* %fa.load4.elem.addr, align 4
  store i32 %fa.load4.elem.load, i32* %retreg.addr
  br label %find.exit

find.exit:
  %retreg.load = load i32, i32* %retreg.addr, align 4
  ret i32 %retreg.load
}

define i1 @union(i32 %x1, i32 %y) {
union.entry:
  %retreg.addr1 = alloca i8, align 1
  %x.addr2 = alloca i32, align 4
  store i32 %x1, i32* %x.addr2
  %y.addr = alloca i32, align 4
  store i32 %y, i32* %y.addr
  %x.load9 = load i32, i32* %x.addr2, align 4
  %x.load10 = load i32, i32* %x.addr2, align 4
  %find.call1 = call i32 @find(i32 %x.load10)
  store i32 %find.call1, i32* %x.addr2
  %y.load = load i32, i32* %y.addr, align 4
  %y.load1 = load i32, i32* %y.addr, align 4
  %find.call2 = call i32 @find(i32 %y.load1)
  store i32 %find.call2, i32* %y.addr
  %x.load11 = load i32, i32* %x.addr2, align 4
  %y.load2 = load i32, i32* %y.addr, align 4
  %icmp10 = icmp eq i32 %x.load11, %y.load2
  br i1 %icmp10, label %union.if.true, label %union.if.false

union.if.true:
  store i1 false, i8* %retreg.addr1
  br label %union.exit

union.if.false:
  br label %union.if.exit

union.if.exit:
  %rk.load2 = load i32*, i32** @rk, align 4
  %x.load12 = load i32, i32* %x.addr2, align 4
  %rk.load2.elem.addr = getelementptr i32, i32* %rk.load2, i32 %x.load12
  %rk.load2.elem.load = load i32, i32* %rk.load2.elem.addr, align 4
  %rk.load3 = load i32*, i32** @rk, align 4
  %y.load3 = load i32, i32* %y.addr, align 4
  %rk.load3.elem.addr = getelementptr i32, i32* %rk.load3, i32 %y.load3
  %rk.load3.elem.load = load i32, i32* %rk.load3.elem.addr, align 4
  %icmp11 = icmp sgt i32 %rk.load2.elem.load, %rk.load3.elem.load
  br i1 %icmp11, label %union.if.true1, label %union.if.false1

union.if.true1:
  %fa.load6 = load i32*, i32** @fa, align 4
  %y.load7 = load i32, i32* %y.addr, align 4
  %fa.load6.elem.addr = getelementptr i32, i32* %fa.load6, i32 %y.load7
  %fa.load6.elem.load = load i32, i32* %fa.load6.elem.addr, align 4
  %x.load15 = load i32, i32* %x.addr2, align 4
  store i32 %x.load15, i32* %fa.load6.elem.addr
  %rk.load7 = load i32*, i32** @rk, align 4
  %x.load16 = load i32, i32* %x.addr2, align 4
  %rk.load7.elem.addr = getelementptr i32, i32* %rk.load7, i32 %x.load16
  %rk.load7.elem.load = load i32, i32* %rk.load7.elem.addr, align 4
  %rk.load8 = load i32*, i32** @rk, align 4
  %x.load17 = load i32, i32* %x.addr2, align 4
  %rk.load8.elem.addr = getelementptr i32, i32* %rk.load8, i32 %x.load17
  %rk.load8.elem.load = load i32, i32* %rk.load8.elem.addr, align 4
  %rk.load9 = load i32*, i32** @rk, align 4
  %y.load8 = load i32, i32* %y.addr, align 4
  %rk.load9.elem.addr = getelementptr i32, i32* %rk.load9, i32 %y.load8
  %rk.load9.elem.load = load i32, i32* %rk.load9.elem.addr, align 4
  %add9 = add i32 %rk.load8.elem.load, %rk.load9.elem.load
  store i32 %add9, i32* %rk.load7.elem.addr
  br label %union.if.exit1

union.if.false1:
  %fa.load5 = load i32*, i32** @fa, align 4
  %x.load13 = load i32, i32* %x.addr2, align 4
  %fa.load5.elem.addr = getelementptr i32, i32* %fa.load5, i32 %x.load13
  %fa.load5.elem.load = load i32, i32* %fa.load5.elem.addr, align 4
  %y.load4 = load i32, i32* %y.addr, align 4
  store i32 %y.load4, i32* %fa.load5.elem.addr
  %rk.load4 = load i32*, i32** @rk, align 4
  %y.load5 = load i32, i32* %y.addr, align 4
  %rk.load4.elem.addr = getelementptr i32, i32* %rk.load4, i32 %y.load5
  %rk.load4.elem.load = load i32, i32* %rk.load4.elem.addr, align 4
  %rk.load5 = load i32*, i32** @rk, align 4
  %y.load6 = load i32, i32* %y.addr, align 4
  %rk.load5.elem.addr = getelementptr i32, i32* %rk.load5, i32 %y.load6
  %rk.load5.elem.load = load i32, i32* %rk.load5.elem.addr, align 4
  %rk.load6 = load i32*, i32** @rk, align 4
  %x.load14 = load i32, i32* %x.addr2, align 4
  %rk.load6.elem.addr = getelementptr i32, i32* %rk.load6, i32 %x.load14
  %rk.load6.elem.load = load i32, i32* %rk.load6.elem.addr, align 4
  %add8 = add i32 %rk.load5.elem.load, %rk.load6.elem.load
  store i32 %add8, i32* %rk.load4.elem.addr
  br label %union.if.exit1

union.if.exit1:
  store i1 true, i8* %retreg.addr1
  br label %union.exit

union.exit:
  %retreg.load1 = load i8, i8* %retreg.addr1, align 1
  %trunc = trunc i8 %retreg.load1 to i1
  ret i1 %trunc
}

define i32 @main() {
main.entry:
  %retreg.addr2 = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %retreg.addr2
  %n.load3 = load i32, i32* @n, align 4
  %getInt.call = call i32 @getInt()
  store i32 %getInt.call, i32* @n
  %m.load = load i32, i32* @m, align 4
  %getInt.call1 = call i32 @getInt()
  store i32 %getInt.call1, i32* @m
  %e.load10 = load %class.Edge**, %class.Edge*** @e, align 4
  %m.load1 = load i32, i32* @m, align 4
  %mul2 = mul i32 %m.load1, 4
  %add10 = add i32 %mul2, 4
  %_bot_malloc.call2 = call i8* @_bot_malloc(i32 %add10)
  %bitcast4 = bitcast i8* %_bot_malloc.call2 to i32*
  store i32 %m.load1, i32* %bitcast4
  %getelementptr2 = getelementptr i32, i32* %bitcast4, i32 1
  %bitcast5 = bitcast i32* %getelementptr2 to %class.Edge**
  store %class.Edge** %bitcast5, %class.Edge*** @e
  %i.addr2 = alloca i32, align 4
  %i.load19 = load i32, i32* %i.addr2, align 4
  store i32 0, i32* %i.addr2
  br label %main.for.cond

main.for.cond:
  %i.load20 = load i32, i32* %i.addr2, align 4
  %m.load2 = load i32, i32* @m, align 4
  %icmp12 = icmp slt i32 %i.load20, %m.load2
  br i1 %icmp12, label %main.for.body, label %main.for.exit

main.for.incr:
  %i.load21 = load i32, i32* %i.addr2, align 4
  %add11 = add i32 %i.load21, 1
  store i32 %add11, i32* %i.addr2
  br label %main.for.cond

main.for.body:
  %ed.addr = alloca %class.Edge*, align 4
  %_bot_malloc.call3 = call i8* @_bot_malloc(i32 12)
  %bitcast6 = bitcast i8* %_bot_malloc.call3 to %class.Edge*
  call void @Edge.Edge(%class.Edge* %bitcast6)
  store %class.Edge* %bitcast6, %class.Edge** %ed.addr
  %ed.load = load %class.Edge*, %class.Edge** %ed.addr, align 4
  %x.addr3 = getelementptr %class.Edge, %class.Edge* %ed.load, i32 0, i32 0
  %x.load18 = load i32, i32* %x.addr3, align 4
  %getInt.call2 = call i32 @getInt()
  store i32 %getInt.call2, i32* %x.addr3
  %ed.load1 = load %class.Edge*, %class.Edge** %ed.addr, align 4
  %y.addr1 = getelementptr %class.Edge, %class.Edge* %ed.load1, i32 0, i32 1
  %y.load9 = load i32, i32* %y.addr1, align 4
  %getInt.call3 = call i32 @getInt()
  store i32 %getInt.call3, i32* %y.addr1
  %ed.load2 = load %class.Edge*, %class.Edge** %ed.addr, align 4
  %w.addr4 = getelementptr %class.Edge, %class.Edge* %ed.load2, i32 0, i32 2
  %w.load4 = load i32, i32* %w.addr4, align 4
  %getInt.call4 = call i32 @getInt()
  store i32 %getInt.call4, i32* %w.addr4
  %e.load11 = load %class.Edge**, %class.Edge*** @e, align 4
  %i.load22 = load i32, i32* %i.addr2, align 4
  %e.load11.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load11, i32 %i.load22
  %e.load11.elem.load = load %class.Edge*, %class.Edge** %e.load11.elem.addr, align 4
  %ed.load3 = load %class.Edge*, %class.Edge** %ed.addr, align 4
  store %class.Edge* %ed.load3, %class.Edge** %e.load11.elem.addr
  br label %main.for.incr

main.for.exit:
  %e.load12 = load %class.Edge**, %class.Edge*** @e, align 4
  %m.load3 = load i32, i32* @m, align 4
  %sub3 = sub i32 %m.load3, 1
  call void @qsort(%class.Edge** %e.load12, i32 0, i32 %sub3)
  call void @init()
  %i.load23 = load i32, i32* %i.addr2, align 4
  store i32 0, i32* %i.addr2
  %j.addr1 = alloca i32, align 4
  store i32 0, i32* %j.addr1
  br label %main.wh.cond

main.wh.cond:
  %i.load24 = load i32, i32* %i.addr2, align 4
  %n.load4 = load i32, i32* @n, align 4
  %sub4 = sub i32 %n.load4, 1
  %icmp13 = icmp slt i32 %i.load24, %sub4
  br i1 %icmp13, label %main.wh.body, label %main.wh.exit

main.wh.body:
  %j.load10 = load i32, i32* %j.addr1, align 4
  %m.load4 = load i32, i32* @m, align 4
  %icmp14 = icmp sge i32 %j.load10, %m.load4
  br i1 %icmp14, label %main.if.true, label %main.if.false

main.wh.exit:
  %rk.load10 = load i32*, i32** @rk, align 4
  %find.call3 = call i32 @find(i32 1)
  %rk.load10.elem.addr = getelementptr i32, i32* %rk.load10, i32 %find.call3
  %rk.load10.elem.load = load i32, i32* %rk.load10.elem.addr, align 4
  %n.load5 = load i32, i32* @n, align 4
  %icmp15 = icmp eq i32 %rk.load10.elem.load, %n.load5
  br i1 %icmp15, label %main.if.true2, label %main.if.false2

main.if.true:
  %sub5 = sub i32 0, 1
  call void @printInt(i32 %sub5)
  store i32 0, i32* %retreg.addr2
  br label %main.exit

main.if.false:
  br label %main.if.exit

main.if.exit:
  %ed.addr1 = alloca %class.Edge*, align 4
  %e.load13 = load %class.Edge**, %class.Edge*** @e, align 4
  %j.load11 = load i32, i32* %j.addr1, align 4
  %e.load13.elem.addr = getelementptr %class.Edge*, %class.Edge** %e.load13, i32 %j.load11
  %e.load13.elem.load = load %class.Edge*, %class.Edge** %e.load13.elem.addr, align 4
  store %class.Edge* %e.load13.elem.load, %class.Edge** %ed.addr1
  %j.load12 = load i32, i32* %j.addr1, align 4
  %add12 = add i32 %j.load12, 1
  store i32 %add12, i32* %j.addr1
  %ed.load4 = load %class.Edge*, %class.Edge** %ed.addr1, align 4
  %x.addr4 = getelementptr %class.Edge, %class.Edge* %ed.load4, i32 0, i32 0
  %x.load19 = load i32, i32* %x.addr4, align 4
  %ed.load5 = load %class.Edge*, %class.Edge** %ed.addr1, align 4
  %y.addr2 = getelementptr %class.Edge, %class.Edge* %ed.load5, i32 0, i32 1
  %y.load10 = load i32, i32* %y.addr2, align 4
  %union.call = call i1 @union(i32 %x.load19, i32 %y.load10)
  br i1 %union.call, label %main.if.true1, label %main.if.false1

main.if.true1:
  %i.load25 = load i32, i32* %i.addr2, align 4
  %add13 = add i32 %i.load25, 1
  store i32 %add13, i32* %i.addr2
  %ans.load = load i32, i32* @ans, align 4
  %ans.load1 = load i32, i32* @ans, align 4
  %ed.load6 = load %class.Edge*, %class.Edge** %ed.addr1, align 4
  %w.addr5 = getelementptr %class.Edge, %class.Edge* %ed.load6, i32 0, i32 2
  %w.load5 = load i32, i32* %w.addr5, align 4
  %add14 = add i32 %ans.load1, %w.load5
  store i32 %add14, i32* @ans
  br label %main.if.exit1

main.if.false1:
  br label %main.if.exit1

main.if.exit1:
  br label %main.wh.cond

main.if.true2:
  %ans.load2 = load i32, i32* @ans, align 4
  call void @printInt(i32 %ans.load2)
  br label %main.if.exit2

main.if.false2:
  %sub6 = sub i32 0, 1
  call void @printInt(i32 %sub6)
  br label %main.if.exit2

main.if.exit2:
  store i32 0, i32* %retreg.addr2
  br label %main.exit

main.exit:
  %retreg.load2 = load i32, i32* %retreg.addr2, align 4
  ret i32 %retreg.load2
}

