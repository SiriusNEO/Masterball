	.text
	.file	test.ll
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry11:
	addi	sp, sp, -144
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 144
	lui	t1, %hi(N)
	sw	t1, 12(sp)
	li	t1, 8
	sw	t1, 16(sp)
	lw	t2, 12(sp)
	lw	t3, 16(sp)
	sw	t3, %lo(N)(t2)
	li	t1, 8
	sw	t1, 24(sp)
	li	t1, 4
	sw	t1, 28(sp)
	lw	t2, 24(sp)
	lw	t3, 28(sp)
	mul	t1, t2, t3
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	addi	t1, t2, 4
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	mv	t1, t2
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	lw	t3, 24(sp)
	sw	t3, 0(t2)
	lw	t2, 40(sp)
	addi	t1, t2, 4
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	mv	t1, t2
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	mv	t1, t2
	sw	t1, 52(sp)
	lui	t1, %hi(row)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	lw	t3, 52(sp)
	sw	t3, %lo(row)(t2)
	li	t1, 8
	sw	t1, 64(sp)
	li	t1, 4
	sw	t1, 68(sp)
	lw	t2, 64(sp)
	lw	t3, 68(sp)
	mul	t1, t2, t3
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	addi	t1, t2, 4
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	mv	t1, t2
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t3, 64(sp)
	sw	t3, 0(t2)
	lw	t2, 80(sp)
	addi	t1, t2, 4
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	mv	t1, t2
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	mv	t1, t2
	sw	t1, 92(sp)
	lui	t1, %hi(col)
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	lw	t3, 92(sp)
	sw	t3, %lo(col)(t2)
	li	t1, 2
	sw	t1, 104(sp)
	li	t1, 8
	sw	t1, 108(sp)
	lw	t2, 104(sp)
	lw	t3, 108(sp)
	mul	t1, t2, t3
	sw	t1, 100(sp)
	lw	t2, 100(sp)
	addi	t1, t2, 4
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	mv	t1, t2
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	lw	t3, 104(sp)
	sw	t3, 0(t2)
	lw	t2, 120(sp)
	addi	t1, t2, 4
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	mv	t1, t2
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	mv	t1, t2
	sw	t1, 132(sp)
	lui	t1, %hi(d)
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t3, 132(sp)
	sw	t3, %lo(d)(t2)
	j	exit11
exit11:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 144
	ret
.Lfunc_end0:
	.size	_glb_init, .Lfunc_end0-_glb_init
                                        # -- End function
	.globl	printBoard
	.p2align	1
	.type	printBoard,@function
printBoard:
entry12:
	addi	sp, sp, -144
	mv	t1, ra
	sw	t1, 12(sp)
	mv	t1, s0
	sw	t1, 16(sp)
	addi	s0, sp, 144
	lw	t1, 8(sp)
	sw	t1, 20(sp)
	sw	zero, 8(sp)
	j	for.cond
exit12:
	lw	t2, 12(sp)
	mv	ra, t2
	lw	t2, 16(sp)
	mv	s0, t2
	addi	sp, sp, 144
	ret
for.cond:
	lw	t1, 8(sp)
	sw	t1, 24(sp)
	lui	t1, %hi(N)
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 28(sp)
	lw	t2, 24(sp)
	lw	t3, 28(sp)
	blt	t2, t3, for.body
	j	for.exit
for.incr:
	lw	t1, 8(sp)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	addi	t1, t2, 1
	sw	t1, 40(sp)
	lw	t3, 40(sp)
	sw	t3, 8(sp)
	j	for.cond
for.body:
	lw	t1, 4(sp)
	sw	t1, 44(sp)
	sw	zero, 4(sp)
	j	for.cond1
for.exit:
	la	t1, anon.strconst2
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	mv	t1, t2
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	mv	a0, t2
	call	println
	j	exit12
for.cond1:
	lw	t1, 4(sp)
	sw	t1, 56(sp)
	lui	t1, %hi(N)
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 60(sp)
	lw	t2, 56(sp)
	lw	t3, 60(sp)
	blt	t2, t3, for.body1
	j	for.exit1
for.incr1:
	lw	t1, 4(sp)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	addi	t1, t2, 1
	sw	t1, 72(sp)
	lw	t3, 72(sp)
	sw	t3, 4(sp)
	j	for.cond1
for.body1:
	lui	t1, %hi(col)
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t1, %lo(col)(t2)
	sw	t1, 76(sp)
	lw	t1, 8(sp)
	sw	t1, 84(sp)
	li	t1, 4
	sw	t1, 100(sp)
	lw	t2, 84(sp)
	lw	t3, 100(sp)
	mul	t1, t2, t3
	sw	t1, 96(sp)
	lw	t2, 76(sp)
	lw	t3, 96(sp)
	add	t1, t2, t3
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	mv	t1, t2
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	lw	t1, 0(t2)
	sw	t1, 104(sp)
	lw	t1, 4(sp)
	sw	t1, 108(sp)
	lw	t2, 104(sp)
	lw	t3, 108(sp)
	beq	t2, t3, if.true
	j	if.false
for.exit1:
	la	t1, anon.strconst2
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	mv	t1, t2
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	mv	a0, t2
	call	println
	j	for.incr
if.true:
	la	t1, anon.strconst1
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	mv	t1, t2
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	mv	a0, t2
	call	print
	j	if.exit
if.false:
	la	t1, anon.strconst
	sw	t1, 132(sp)
	lw	t2, 132(sp)
	mv	t1, t2
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	mv	a0, t2
	call	print
	j	if.exit
if.exit:
	j	for.incr1
.Lfunc_end1:
	.size	printBoard, .Lfunc_end1-printBoard
                                        # -- End function
	.globl	search
	.p2align	1
	.type	search,@function
search:
entry13:
	addi	sp, sp, -624
	mv	t1, ra
	sw	t1, 12(sp)
	mv	t1, s0
	sw	t1, 16(sp)
	addi	s0, sp, 624
	mv	t1, a0
	sw	t1, 0(sp)
	lw	t3, 0(sp)
	sw	t3, 8(sp)
	lw	t1, 8(sp)
	sw	t1, 20(sp)
	lui	t1, %hi(N)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 24(sp)
	lw	t2, 20(sp)
	lw	t3, 24(sp)
	beq	t2, t3, if.true1
	j	if.false1
exit13:
	lw	t2, 12(sp)
	mv	ra, t2
	lw	t2, 16(sp)
	mv	s0, t2
	addi	sp, sp, 624
	ret
if.true1:
	call	printBoard
	j	if.exit1
if.false1:
	lw	t1, 4(sp)
	sw	t1, 32(sp)
	sw	zero, 4(sp)
	j	for.cond2
if.exit1:
	j	exit13
for.cond2:
	lw	t1, 4(sp)
	sw	t1, 36(sp)
	lui	t1, %hi(N)
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 40(sp)
	lw	t2, 36(sp)
	lw	t3, 40(sp)
	blt	t2, t3, for.body2
	j	for.exit2
for.incr2:
	lw	t1, 4(sp)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	addi	t1, t2, 1
	sw	t1, 52(sp)
	lw	t3, 52(sp)
	sw	t3, 4(sp)
	j	for.cond2
for.body2:
	lui	t1, %hi(row)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t1, %lo(row)(t2)
	sw	t1, 56(sp)
	lw	t1, 4(sp)
	sw	t1, 64(sp)
	li	t1, 4
	sw	t1, 80(sp)
	lw	t2, 64(sp)
	lw	t3, 80(sp)
	mul	t1, t2, t3
	sw	t1, 76(sp)
	lw	t2, 56(sp)
	lw	t3, 76(sp)
	add	t1, t2, t3
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	mv	t1, t2
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, 0(t2)
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	xori	t1, t2, 0
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	seqz	t1, t2
	sb	t1, 88(sp)
	lb	t2, 88(sp)
	bne	t2, zero, lg.nocut
	j	mid
for.exit2:
	j	if.exit1
if.true2:
	lui	t1, %hi(d)
	sw	t1, 100(sp)
	lw	t2, 100(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	addi	t1, t2, 8
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	mv	t1, t2
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	lw	t1, 0(t2)
	sw	t1, 112(sp)
	lw	t1, 4(sp)
	sw	t1, 116(sp)
	lui	t1, %hi(N)
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 120(sp)
	lw	t2, 116(sp)
	lw	t3, 120(sp)
	add	t1, t2, t3
	sw	t1, 128(sp)
	li	t1, 1
	sw	t1, 136(sp)
	lw	t2, 128(sp)
	lw	t3, 136(sp)
	sub	t1, t2, t3
	sw	t1, 132(sp)
	lw	t1, 8(sp)
	sw	t1, 140(sp)
	lw	t2, 132(sp)
	lw	t3, 140(sp)
	sub	t1, t2, t3
	sw	t1, 144(sp)
	li	t1, 4
	sw	t1, 160(sp)
	lw	t2, 144(sp)
	lw	t3, 160(sp)
	mul	t1, t2, t3
	sw	t1, 156(sp)
	lw	t2, 112(sp)
	lw	t3, 156(sp)
	add	t1, t2, t3
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	mv	t1, t2
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	lw	t1, 0(t2)
	sw	t1, 164(sp)
	li	t1, 1
	sw	t1, 168(sp)
	lw	t2, 148(sp)
	lw	t3, 168(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(d)
	sw	t1, 176(sp)
	lw	t2, 176(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 172(sp)
	lw	t2, 172(sp)
	mv	t1, t2
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	mv	t1, t2
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	lw	t1, 0(t2)
	sw	t1, 188(sp)
	lw	t1, 4(sp)
	sw	t1, 192(sp)
	lw	t1, 8(sp)
	sw	t1, 196(sp)
	lw	t2, 192(sp)
	lw	t3, 196(sp)
	add	t1, t2, t3
	sw	t1, 200(sp)
	li	t1, 4
	sw	t1, 216(sp)
	lw	t2, 200(sp)
	lw	t3, 216(sp)
	mul	t1, t2, t3
	sw	t1, 212(sp)
	lw	t2, 188(sp)
	lw	t3, 212(sp)
	add	t1, t2, t3
	sw	t1, 208(sp)
	lw	t2, 208(sp)
	mv	t1, t2
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t1, 0(t2)
	sw	t1, 220(sp)
	li	t1, 1
	sw	t1, 224(sp)
	lw	t2, 204(sp)
	lw	t3, 224(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(row)
	sw	t1, 232(sp)
	lw	t2, 232(sp)
	lw	t1, %lo(row)(t2)
	sw	t1, 228(sp)
	lw	t1, 4(sp)
	sw	t1, 236(sp)
	li	t1, 4
	sw	t1, 252(sp)
	lw	t2, 236(sp)
	lw	t3, 252(sp)
	mul	t1, t2, t3
	sw	t1, 248(sp)
	lw	t2, 228(sp)
	lw	t3, 248(sp)
	add	t1, t2, t3
	sw	t1, 244(sp)
	lw	t2, 244(sp)
	mv	t1, t2
	sw	t1, 240(sp)
	lw	t2, 240(sp)
	lw	t1, 0(t2)
	sw	t1, 256(sp)
	li	t1, 1
	sw	t1, 260(sp)
	lw	t2, 240(sp)
	lw	t3, 260(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(col)
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	lw	t1, %lo(col)(t2)
	sw	t1, 264(sp)
	lw	t1, 8(sp)
	sw	t1, 272(sp)
	li	t1, 4
	sw	t1, 288(sp)
	lw	t2, 272(sp)
	lw	t3, 288(sp)
	mul	t1, t2, t3
	sw	t1, 284(sp)
	lw	t2, 264(sp)
	lw	t3, 284(sp)
	add	t1, t2, t3
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	mv	t1, t2
	sw	t1, 276(sp)
	lw	t2, 276(sp)
	lw	t1, 0(t2)
	sw	t1, 292(sp)
	lw	t1, 4(sp)
	sw	t1, 296(sp)
	lw	t2, 276(sp)
	lw	t3, 296(sp)
	sw	t3, 0(t2)
	lw	t1, 8(sp)
	sw	t1, 300(sp)
	lw	t2, 300(sp)
	addi	t1, t2, 1
	sw	t1, 304(sp)
	lw	t2, 304(sp)
	mv	a0, t2
	call	search
	lui	t1, %hi(row)
	sw	t1, 312(sp)
	lw	t2, 312(sp)
	lw	t1, %lo(row)(t2)
	sw	t1, 308(sp)
	lw	t1, 4(sp)
	sw	t1, 316(sp)
	li	t1, 4
	sw	t1, 332(sp)
	lw	t2, 316(sp)
	lw	t3, 332(sp)
	mul	t1, t2, t3
	sw	t1, 328(sp)
	lw	t2, 308(sp)
	lw	t3, 328(sp)
	add	t1, t2, t3
	sw	t1, 324(sp)
	lw	t2, 324(sp)
	mv	t1, t2
	sw	t1, 320(sp)
	lw	t2, 320(sp)
	lw	t1, 0(t2)
	sw	t1, 336(sp)
	lw	t2, 320(sp)
	sw	zero, 0(t2)
	lui	t1, %hi(d)
	sw	t1, 344(sp)
	lw	t2, 344(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 340(sp)
	lw	t2, 340(sp)
	mv	t1, t2
	sw	t1, 352(sp)
	lw	t2, 352(sp)
	mv	t1, t2
	sw	t1, 348(sp)
	lw	t2, 348(sp)
	lw	t1, 0(t2)
	sw	t1, 356(sp)
	lw	t1, 4(sp)
	sw	t1, 360(sp)
	lw	t1, 8(sp)
	sw	t1, 364(sp)
	lw	t2, 360(sp)
	lw	t3, 364(sp)
	add	t1, t2, t3
	sw	t1, 368(sp)
	li	t1, 4
	sw	t1, 384(sp)
	lw	t2, 368(sp)
	lw	t3, 384(sp)
	mul	t1, t2, t3
	sw	t1, 380(sp)
	lw	t2, 356(sp)
	lw	t3, 380(sp)
	add	t1, t2, t3
	sw	t1, 376(sp)
	lw	t2, 376(sp)
	mv	t1, t2
	sw	t1, 372(sp)
	lw	t2, 372(sp)
	lw	t1, 0(t2)
	sw	t1, 388(sp)
	lw	t2, 372(sp)
	sw	zero, 0(t2)
	lui	t1, %hi(d)
	sw	t1, 396(sp)
	lw	t2, 396(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 392(sp)
	lw	t2, 392(sp)
	addi	t1, t2, 8
	sw	t1, 404(sp)
	lw	t2, 404(sp)
	mv	t1, t2
	sw	t1, 400(sp)
	lw	t2, 400(sp)
	lw	t1, 0(t2)
	sw	t1, 408(sp)
	lw	t1, 4(sp)
	sw	t1, 412(sp)
	lui	t1, %hi(N)
	sw	t1, 420(sp)
	lw	t2, 420(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 416(sp)
	lw	t2, 412(sp)
	lw	t3, 416(sp)
	add	t1, t2, t3
	sw	t1, 424(sp)
	li	t1, 1
	sw	t1, 432(sp)
	lw	t2, 424(sp)
	lw	t3, 432(sp)
	sub	t1, t2, t3
	sw	t1, 428(sp)
	lw	t1, 8(sp)
	sw	t1, 436(sp)
	lw	t2, 428(sp)
	lw	t3, 436(sp)
	sub	t1, t2, t3
	sw	t1, 440(sp)
	li	t1, 4
	sw	t1, 456(sp)
	lw	t2, 440(sp)
	lw	t3, 456(sp)
	mul	t1, t2, t3
	sw	t1, 452(sp)
	lw	t2, 408(sp)
	lw	t3, 452(sp)
	add	t1, t2, t3
	sw	t1, 448(sp)
	lw	t2, 448(sp)
	mv	t1, t2
	sw	t1, 444(sp)
	lw	t2, 444(sp)
	lw	t1, 0(t2)
	sw	t1, 460(sp)
	lw	t2, 444(sp)
	sw	zero, 0(t2)
	j	if.exit2
if.false2:
	j	if.exit2
if.exit2:
	j	for.incr2
lg.nocut:
	lui	t1, %hi(d)
	sw	t1, 468(sp)
	lw	t2, 468(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 464(sp)
	lw	t2, 464(sp)
	mv	t1, t2
	sw	t1, 476(sp)
	lw	t2, 476(sp)
	mv	t1, t2
	sw	t1, 472(sp)
	lw	t2, 472(sp)
	lw	t1, 0(t2)
	sw	t1, 480(sp)
	lw	t1, 4(sp)
	sw	t1, 484(sp)
	lw	t1, 8(sp)
	sw	t1, 488(sp)
	lw	t2, 484(sp)
	lw	t3, 488(sp)
	add	t1, t2, t3
	sw	t1, 492(sp)
	li	t1, 4
	sw	t1, 508(sp)
	lw	t2, 492(sp)
	lw	t3, 508(sp)
	mul	t1, t2, t3
	sw	t1, 504(sp)
	lw	t2, 480(sp)
	lw	t3, 504(sp)
	add	t1, t2, t3
	sw	t1, 500(sp)
	lw	t2, 500(sp)
	mv	t1, t2
	sw	t1, 496(sp)
	lw	t2, 496(sp)
	lw	t1, 0(t2)
	sw	t1, 512(sp)
	lw	t2, 512(sp)
	xori	t1, t2, 0
	sw	t1, 520(sp)
	lw	t2, 520(sp)
	seqz	t1, t2
	sb	t1, 516(sp)
	lb	t2, 516(sp)
	mv	t1, t2
	sb	t1, 524(sp)
	j	lg.exit
lg.exit:
	lb	t2, 524(sp)
	bne	t2, zero, lg.nocut1
	j	mid1
lg.nocut1:
	lui	t1, %hi(d)
	sw	t1, 532(sp)
	lw	t2, 532(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 528(sp)
	lw	t2, 528(sp)
	addi	t1, t2, 8
	sw	t1, 540(sp)
	lw	t2, 540(sp)
	mv	t1, t2
	sw	t1, 536(sp)
	lw	t2, 536(sp)
	lw	t1, 0(t2)
	sw	t1, 544(sp)
	lw	t1, 4(sp)
	sw	t1, 548(sp)
	lui	t1, %hi(N)
	sw	t1, 556(sp)
	lw	t2, 556(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 552(sp)
	lw	t2, 548(sp)
	lw	t3, 552(sp)
	add	t1, t2, t3
	sw	t1, 560(sp)
	li	t1, 1
	sw	t1, 568(sp)
	lw	t2, 560(sp)
	lw	t3, 568(sp)
	sub	t1, t2, t3
	sw	t1, 564(sp)
	lw	t1, 8(sp)
	sw	t1, 572(sp)
	lw	t2, 564(sp)
	lw	t3, 572(sp)
	sub	t1, t2, t3
	sw	t1, 576(sp)
	li	t1, 4
	sw	t1, 592(sp)
	lw	t2, 576(sp)
	lw	t3, 592(sp)
	mul	t1, t2, t3
	sw	t1, 588(sp)
	lw	t2, 544(sp)
	lw	t3, 588(sp)
	add	t1, t2, t3
	sw	t1, 584(sp)
	lw	t2, 584(sp)
	mv	t1, t2
	sw	t1, 580(sp)
	lw	t2, 580(sp)
	lw	t1, 0(t2)
	sw	t1, 596(sp)
	lw	t2, 596(sp)
	xori	t1, t2, 0
	sw	t1, 604(sp)
	lw	t2, 604(sp)
	seqz	t1, t2
	sb	t1, 600(sp)
	lb	t2, 600(sp)
	mv	t1, t2
	sb	t1, 608(sp)
	j	lg.exit1
lg.exit1:
	lb	t2, 608(sp)
	bne	t2, zero, if.true2
	j	if.false2
mid:
	lb	t2, 88(sp)
	mv	t1, t2
	sb	t1, 524(sp)
	j	lg.exit
mid1:
	lb	t2, 524(sp)
	mv	t1, t2
	sb	t1, 608(sp)
	j	lg.exit1
.Lfunc_end2:
	.size	search, .Lfunc_end2-search
                                        # -- End function
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry14:
	addi	sp, sp, -304
	mv	t1, ra
	sw	t1, 16(sp)
	mv	t1, s0
	sw	t1, 20(sp)
	addi	s0, sp, 304
	call	_glb_init
	sw	zero, 12(sp)
	lw	t1, 8(sp)
	sw	t1, 24(sp)
	sw	zero, 8(sp)
	j	for.cond3
exit14:
	lw	t1, 12(sp)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	mv	a0, t2
	lw	t2, 16(sp)
	mv	ra, t2
	lw	t2, 20(sp)
	mv	s0, t2
	addi	sp, sp, 304
	ret
for.cond3:
	lw	t1, 8(sp)
	sw	t1, 32(sp)
	li	t1, 8
	sw	t1, 36(sp)
	lw	t2, 32(sp)
	lw	t3, 36(sp)
	blt	t2, t3, for.body3
	j	for.exit3
for.incr3:
	lw	t1, 8(sp)
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	addi	t1, t2, 1
	sw	t1, 44(sp)
	lw	t3, 44(sp)
	sw	t3, 8(sp)
	j	for.cond3
for.body3:
	lui	t1, %hi(row)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	lw	t1, %lo(row)(t2)
	sw	t1, 48(sp)
	lw	t1, 8(sp)
	sw	t1, 56(sp)
	li	t1, 4
	sw	t1, 72(sp)
	lw	t2, 56(sp)
	lw	t3, 72(sp)
	mul	t1, t2, t3
	sw	t1, 68(sp)
	lw	t2, 48(sp)
	lw	t3, 68(sp)
	add	t1, t2, t3
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	mv	t1, t2
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t1, 0(t2)
	sw	t1, 76(sp)
	lw	t2, 60(sp)
	sw	zero, 0(t2)
	lui	t1, %hi(col)
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	lw	t1, %lo(col)(t2)
	sw	t1, 80(sp)
	lw	t1, 8(sp)
	sw	t1, 88(sp)
	li	t1, 4
	sw	t1, 104(sp)
	lw	t2, 88(sp)
	lw	t3, 104(sp)
	mul	t1, t2, t3
	sw	t1, 100(sp)
	lw	t2, 80(sp)
	lw	t3, 100(sp)
	add	t1, t2, t3
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	t1, t2
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	lw	t1, 0(t2)
	sw	t1, 108(sp)
	lw	t2, 92(sp)
	sw	zero, 0(t2)
	j	for.incr3
for.exit3:
	lw	t1, 8(sp)
	sw	t1, 112(sp)
	sw	zero, 8(sp)
	j	for.cond4
for.cond4:
	lw	t1, 8(sp)
	sw	t1, 116(sp)
	li	t1, 2
	sw	t1, 120(sp)
	lw	t2, 116(sp)
	lw	t3, 120(sp)
	blt	t2, t3, for.body4
	j	for.exit4
for.incr4:
	lw	t1, 8(sp)
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	addi	t1, t2, 1
	sw	t1, 128(sp)
	lw	t3, 128(sp)
	sw	t3, 8(sp)
	j	for.cond4
for.body4:
	lui	t1, %hi(d)
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 132(sp)
	lw	t1, 8(sp)
	sw	t1, 140(sp)
	li	t1, 8
	sw	t1, 156(sp)
	lw	t2, 140(sp)
	lw	t3, 156(sp)
	mul	t1, t2, t3
	sw	t1, 152(sp)
	lw	t2, 132(sp)
	lw	t3, 152(sp)
	add	t1, t2, t3
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	mv	t1, t2
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	lw	t1, 0(t2)
	sw	t1, 160(sp)
	li	t1, 8
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	addi	t1, t2, 8
	sw	t1, 164(sp)
	li	t1, 1
	sw	t1, 176(sp)
	lw	t2, 164(sp)
	lw	t3, 176(sp)
	sub	t1, t2, t3
	sw	t1, 172(sp)
	li	t1, 4
	sw	t1, 184(sp)
	lw	t2, 172(sp)
	lw	t3, 184(sp)
	mul	t1, t2, t3
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	addi	t1, t2, 4
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	mv	t1, t2
	sw	t1, 196(sp)
	lw	t2, 196(sp)
	lw	t3, 172(sp)
	sw	t3, 0(t2)
	lw	t2, 196(sp)
	addi	t1, t2, 4
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	mv	t1, t2
	sw	t1, 200(sp)
	lw	t2, 200(sp)
	mv	t1, t2
	sw	t1, 208(sp)
	lw	t2, 144(sp)
	lw	t3, 208(sp)
	sw	t3, 0(t2)
	lw	t1, 4(sp)
	sw	t1, 212(sp)
	sw	zero, 4(sp)
	j	for.cond5
for.exit4:
	li	a0, 0
	call	search
	sw	zero, 12(sp)
	j	exit14
for.cond5:
	lw	t1, 4(sp)
	sw	t1, 216(sp)
	li	t1, 8
	sw	t1, 224(sp)
	lw	t2, 224(sp)
	addi	t1, t2, 8
	sw	t1, 220(sp)
	li	t1, 1
	sw	t1, 232(sp)
	lw	t2, 220(sp)
	lw	t3, 232(sp)
	sub	t1, t2, t3
	sw	t1, 228(sp)
	lw	t2, 216(sp)
	lw	t3, 228(sp)
	blt	t2, t3, for.body5
	j	for.exit5
for.incr5:
	lw	t1, 4(sp)
	sw	t1, 236(sp)
	lw	t2, 236(sp)
	addi	t1, t2, 1
	sw	t1, 240(sp)
	lw	t3, 240(sp)
	sw	t3, 4(sp)
	j	for.cond5
for.body5:
	lui	t1, %hi(d)
	sw	t1, 248(sp)
	lw	t2, 248(sp)
	lw	t1, %lo(d)(t2)
	sw	t1, 244(sp)
	lw	t1, 8(sp)
	sw	t1, 252(sp)
	li	t1, 8
	sw	t1, 268(sp)
	lw	t2, 252(sp)
	lw	t3, 268(sp)
	mul	t1, t2, t3
	sw	t1, 264(sp)
	lw	t2, 244(sp)
	lw	t3, 264(sp)
	add	t1, t2, t3
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	mv	t1, t2
	sw	t1, 256(sp)
	lw	t2, 256(sp)
	lw	t1, 0(t2)
	sw	t1, 272(sp)
	lw	t1, 4(sp)
	sw	t1, 276(sp)
	li	t1, 4
	sw	t1, 292(sp)
	lw	t2, 276(sp)
	lw	t3, 292(sp)
	mul	t1, t2, t3
	sw	t1, 288(sp)
	lw	t2, 272(sp)
	lw	t3, 288(sp)
	add	t1, t2, t3
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	mv	t1, t2
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	lw	t1, 0(t2)
	sw	t1, 296(sp)
	lw	t2, 280(sp)
	sw	zero, 0(t2)
	j	for.incr5
for.exit5:
	j	for.incr4
.Lfunc_end3:
	.size	main, .Lfunc_end3-main
                                        # -- End function
	.type	N,@object
	.section	.bss
	.globl	N
N:
	.word	0
	.size	N, 4

	.type	row,@object
	.section	.bss
	.globl	row
row:
	.word	0
	.size	row, 4

	.type	col,@object
	.section	.bss
	.globl	col
col:
	.word	0
	.size	col, 4

	.type	d,@object
	.section	.bss
	.globl	d
d:
	.word	0
	.size	d, 4

	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	" ."
	.size	anon.strconst, 2

	.type	anon.strconst1,@object
	.section	.rodata
anon.strconst1:
	.asciz	" O"
	.size	anon.strconst1, 2

	.type	anon.strconst2,@object
	.section	.rodata
anon.strconst2:
	.asciz	""
	.size	anon.strconst2, 0

