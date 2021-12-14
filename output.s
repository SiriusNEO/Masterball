	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry11:
	addi	sp, sp, -96
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 96
	lui	t1, %hi(make)
	sw	t1, 12(sp)
	lw	t2, 12(sp)
	sw	zero, %lo(make)(t2)
	li	t1, 10
	sw	t1, 20(sp)
	li	t1, 4
	sw	t1, 24(sp)
	lw	t2, 20(sp)
	lw	t3, 24(sp)
	mul	t1, t2, t3
	sw	t1, 16(sp)
	lw	t2, 16(sp)
	addi	t1, t2, 4
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	mv	t1, t2
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t3, 20(sp)
	sw	t3, 0(t2)
	lw	t2, 36(sp)
	addi	t1, t2, 4
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	mv	t1, t2
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 48(sp)
	lui	t1, %hi(color)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	lw	t3, 48(sp)
	sw	t3, %lo(color)(t2)
	li	t1, 1
	sw	t1, 60(sp)
	li	t1, 4
	sw	t1, 64(sp)
	lw	t2, 60(sp)
	lw	t3, 64(sp)
	mul	t1, t2, t3
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	addi	t1, t2, 4
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	mv	t1, t2
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	lw	t3, 60(sp)
	sw	t3, 0(t2)
	lw	t2, 76(sp)
	addi	t1, t2, 4
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	mv	t1, t2
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	mv	t1, t2
	sw	t1, 88(sp)
	lui	t1, %hi(count)
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	lw	t3, 88(sp)
	sw	t3, %lo(count)(t2)
	j	exit11
exit11:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 96
	ret
	.size	_glb_init, .-_glb_init
                                        # -- End function
	.globl	origin
	.p2align	1
	.type	origin,@function
origin:
entry12:
	addi	sp, sp, -288
	mv	t1, ra
	sw	t1, 8(sp)
	mv	t1, s0
	sw	t1, 12(sp)
	addi	s0, sp, 288
	mv	t1, a0
	sw	t1, 0(sp)
	lw	t3, 0(sp)
	sw	t3, 4(sp)
	lui	t1, %hi(make)
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 16(sp)
	lw	t1, 4(sp)
	sw	t1, 24(sp)
	li	t1, 8
	sw	t1, 32(sp)
	lw	t2, 24(sp)
	lw	t3, 32(sp)
	mul	t1, t2, t3
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	addi	t1, t2, 4
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	lw	t3, 24(sp)
	sw	t3, 0(t2)
	lw	t2, 44(sp)
	addi	t1, t2, 4
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	mv	t1, t2
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	mv	t1, t2
	sw	t1, 56(sp)
	lui	t1, %hi(make)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t3, 56(sp)
	sw	t3, %lo(make)(t2)
	lui	t1, %hi(i)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 64(sp)
	lui	t1, %hi(i)
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	sw	zero, %lo(i)(t2)
	j	for.cond
exit12:
	lw	t2, 8(sp)
	mv	ra, t2
	lw	t2, 12(sp)
	mv	s0, t2
	addi	sp, sp, 288
	ret
for.cond:
	lui	t1, %hi(i)
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 76(sp)
	lw	t1, 4(sp)
	sw	t1, 84(sp)
	lw	t2, 76(sp)
	lw	t3, 84(sp)
	blt	t2, t3, for.body
	j	for.exit
for.incr:
	lui	t1, %hi(i)
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	addi	t1, t2, 1
	sw	t1, 96(sp)
	lui	t1, %hi(i)
	sw	t1, 100(sp)
	lw	t2, 100(sp)
	lw	t3, 96(sp)
	sw	t3, %lo(i)(t2)
	j	for.cond
for.body:
	lui	t1, %hi(make)
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 104(sp)
	lui	t1, %hi(i)
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 112(sp)
	li	t1, 8
	sw	t1, 132(sp)
	lw	t2, 112(sp)
	lw	t3, 132(sp)
	mul	t1, t2, t3
	sw	t1, 128(sp)
	lw	t2, 104(sp)
	lw	t3, 128(sp)
	add	t1, t2, t3
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	mv	t1, t2
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	lw	t1, 0(t2)
	sw	t1, 136(sp)
	lw	t1, 4(sp)
	sw	t1, 140(sp)
	li	t1, 4
	sw	t1, 148(sp)
	lw	t2, 140(sp)
	lw	t3, 148(sp)
	mul	t1, t2, t3
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	addi	t1, t2, 4
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	mv	t1, t2
	sw	t1, 160(sp)
	lw	t2, 160(sp)
	lw	t3, 140(sp)
	sw	t3, 0(t2)
	lw	t2, 160(sp)
	addi	t1, t2, 4
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	mv	t1, t2
	sw	t1, 164(sp)
	lw	t2, 164(sp)
	mv	t1, t2
	sw	t1, 172(sp)
	lw	t2, 120(sp)
	lw	t3, 172(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(j)
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 176(sp)
	lui	t1, %hi(j)
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	sw	zero, %lo(j)(t2)
	j	for.cond1
for.exit:
	j	exit12
for.cond1:
	lui	t1, %hi(j)
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 188(sp)
	lw	t1, 4(sp)
	sw	t1, 196(sp)
	lw	t2, 188(sp)
	lw	t3, 196(sp)
	blt	t2, t3, for.body1
	j	for.exit1
for.incr1:
	lui	t1, %hi(j)
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 200(sp)
	lw	t2, 200(sp)
	addi	t1, t2, 1
	sw	t1, 208(sp)
	lui	t1, %hi(j)
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	lw	t3, 208(sp)
	sw	t3, %lo(j)(t2)
	j	for.cond1
for.body1:
	lui	t1, %hi(make)
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 216(sp)
	lui	t1, %hi(i)
	sw	t1, 228(sp)
	lw	t2, 228(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 224(sp)
	li	t1, 8
	sw	t1, 244(sp)
	lw	t2, 224(sp)
	lw	t3, 244(sp)
	mul	t1, t2, t3
	sw	t1, 240(sp)
	lw	t2, 216(sp)
	lw	t3, 240(sp)
	add	t1, t2, t3
	sw	t1, 236(sp)
	lw	t2, 236(sp)
	mv	t1, t2
	sw	t1, 232(sp)
	lw	t2, 232(sp)
	lw	t1, 0(t2)
	sw	t1, 248(sp)
	lui	t1, %hi(j)
	sw	t1, 256(sp)
	lw	t2, 256(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 252(sp)
	li	t1, 4
	sw	t1, 272(sp)
	lw	t2, 252(sp)
	lw	t3, 272(sp)
	mul	t1, t2, t3
	sw	t1, 268(sp)
	lw	t2, 248(sp)
	lw	t3, 268(sp)
	add	t1, t2, t3
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	mv	t1, t2
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	lw	t1, 0(t2)
	sw	t1, 276(sp)
	lw	t2, 260(sp)
	sw	zero, 0(t2)
	j	for.incr1
for.exit1:
	j	for.incr
	.size	origin, .-origin
                                        # -- End function
	.globl	search
	.p2align	1
	.type	search,@function
search:
entry13:
	li	s1, -2448
	add	sp, sp, s1
	mv	t1, ra
	sw	t1, 36(sp)
	sub	s0, sp, s1
	mv	t1, s0
	sw	t1, 40(sp)
	mv	t1, a0
	sw	t1, 0(sp)
	mv	t1, a1
	sw	t1, 4(sp)
	mv	t1, a2
	sw	t1, 8(sp)
	lw	t3, 0(sp)
	sw	t3, 32(sp)
	lw	t3, 4(sp)
	sw	t3, 28(sp)
	lw	t3, 8(sp)
	sw	t3, 24(sp)
	lw	t1, 28(sp)
	sw	t1, 44(sp)
	lw	t3, 44(sp)
	slt	t1, zero, t3
	sb	t1, 48(sp)
	lb	t2, 48(sp)
	bne	t2, zero, mid
	j	lg.nocut
exit13:
	lw	t2, 36(sp)
	mv	ra, t2
	lw	t2, 40(sp)
	mv	s0, t2
	li	s1, 2448
	add	sp, sp, s1
	ret
if.true:
	lw	t1, 32(sp)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	xori	t1, t2, 2
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	seqz	t1, t2
	sb	t1, 56(sp)
	lb	t2, 56(sp)
	bne	t2, zero, lg.nocut3
	j	mid1
if.false:
	j	if.exit
if.exit:
	j	exit13
lg.nocut:
	lw	t1, 28(sp)
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	slti	t1, t2, 0
	sb	t1, 68(sp)
	lb	t2, 68(sp)
	mv	t1, t2
	sb	t1, 72(sp)
	j	lg.exit
lg.exit:
	lb	t2, 72(sp)
	bne	t2, zero, mid2
	j	lg.nocut1
lg.nocut1:
	lw	t1, 32(sp)
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	xori	t1, t2, 0
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	seqz	t1, t2
	sb	t1, 80(sp)
	lb	t2, 80(sp)
	mv	t1, t2
	sb	t1, 88(sp)
	j	lg.exit1
lg.exit1:
	lb	t2, 88(sp)
	bne	t2, zero, mid3
	j	lg.nocut2
lg.nocut2:
	lui	t1, %hi(make)
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 92(sp)
	lw	t1, 32(sp)
	sw	t1, 100(sp)
	li	t1, 1
	sw	t1, 108(sp)
	lw	t2, 100(sp)
	lw	t3, 108(sp)
	sub	t1, t2, t3
	sw	t1, 104(sp)
	li	t1, 8
	sw	t1, 124(sp)
	lw	t2, 104(sp)
	lw	t3, 124(sp)
	mul	t1, t2, t3
	sw	t1, 120(sp)
	lw	t2, 92(sp)
	lw	t3, 120(sp)
	add	t1, t2, t3
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	mv	t1, t2
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	lw	t1, 0(t2)
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	mv	t1, t2
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	mv	t1, t2
	sw	t1, 132(sp)
	lw	t2, 132(sp)
	lw	t1, 0(t2)
	sw	t1, 140(sp)
	lui	t1, %hi(make)
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 144(sp)
	lw	t1, 32(sp)
	sw	t1, 152(sp)
	li	t1, 1
	sw	t1, 160(sp)
	lw	t2, 152(sp)
	lw	t3, 160(sp)
	sub	t1, t2, t3
	sw	t1, 156(sp)
	li	t1, 8
	sw	t1, 176(sp)
	lw	t2, 156(sp)
	lw	t3, 176(sp)
	mul	t1, t2, t3
	sw	t1, 172(sp)
	lw	t2, 144(sp)
	lw	t3, 172(sp)
	add	t1, t2, t3
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	mv	t1, t2
	sw	t1, 164(sp)
	lw	t2, 164(sp)
	lw	t1, 0(t2)
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	addi	t1, t2, 4
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	mv	t1, t2
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, 0(t2)
	sw	t1, 192(sp)
	lw	t2, 140(sp)
	lw	t3, 192(sp)
	add	t1, t2, t3
	sw	t1, 196(sp)
	lui	t1, %hi(make)
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 200(sp)
	lw	t1, 32(sp)
	sw	t1, 208(sp)
	li	t1, 1
	sw	t1, 216(sp)
	lw	t2, 208(sp)
	lw	t3, 216(sp)
	sub	t1, t2, t3
	sw	t1, 212(sp)
	li	t1, 8
	sw	t1, 232(sp)
	lw	t2, 212(sp)
	lw	t3, 232(sp)
	mul	t1, t2, t3
	sw	t1, 228(sp)
	lw	t2, 200(sp)
	lw	t3, 228(sp)
	add	t1, t2, t3
	sw	t1, 224(sp)
	lw	t2, 224(sp)
	mv	t1, t2
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, 0(t2)
	sw	t1, 236(sp)
	lw	t2, 236(sp)
	addi	t1, t2, 8
	sw	t1, 244(sp)
	lw	t2, 244(sp)
	mv	t1, t2
	sw	t1, 240(sp)
	lw	t2, 240(sp)
	lw	t1, 0(t2)
	sw	t1, 248(sp)
	lw	t2, 196(sp)
	lw	t3, 248(sp)
	add	t1, t2, t3
	sw	t1, 252(sp)
	lw	t2, 252(sp)
	xori	t1, t2, 15
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	seqz	t1, t2
	sb	t1, 256(sp)
	lb	t2, 256(sp)
	mv	t1, t2
	sb	t1, 264(sp)
	j	lg.exit2
lg.exit2:
	lb	t2, 264(sp)
	bne	t2, zero, if.true
	j	if.false
if.true1:
	lui	t1, %hi(make)
	sw	t1, 272(sp)
	lw	t2, 272(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	addi	t1, t2, 16
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	mv	t1, t2
	sw	t1, 276(sp)
	lw	t2, 276(sp)
	lw	t1, 0(t2)
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	addi	t1, t2, 8
	sw	t1, 292(sp)
	lw	t2, 292(sp)
	mv	t1, t2
	sw	t1, 288(sp)
	lw	t2, 288(sp)
	lw	t1, 0(t2)
	sw	t1, 296(sp)
	lw	t1, 24(sp)
	sw	t1, 300(sp)
	li	t1, 45
	sw	t1, 308(sp)
	lw	t2, 308(sp)
	lw	t3, 300(sp)
	sub	t1, t2, t3
	sw	t1, 304(sp)
	lw	t2, 288(sp)
	lw	t3, 304(sp)
	sw	t3, 0(t2)
	lw	t1, 20(sp)
	sw	t1, 312(sp)
	lui	t1, %hi(make)
	sw	t1, 320(sp)
	lw	t2, 320(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 316(sp)
	lw	t2, 316(sp)
	mv	t1, t2
	sw	t1, 328(sp)
	lw	t2, 328(sp)
	mv	t1, t2
	sw	t1, 324(sp)
	lw	t2, 324(sp)
	lw	t1, 0(t2)
	sw	t1, 332(sp)
	lw	t2, 332(sp)
	mv	t1, t2
	sw	t1, 340(sp)
	lw	t2, 340(sp)
	mv	t1, t2
	sw	t1, 336(sp)
	lw	t2, 336(sp)
	lw	t1, 0(t2)
	sw	t1, 344(sp)
	lui	t1, %hi(make)
	sw	t1, 352(sp)
	lw	t2, 352(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 348(sp)
	lw	t2, 348(sp)
	mv	t1, t2
	sw	t1, 360(sp)
	lw	t2, 360(sp)
	mv	t1, t2
	sw	t1, 356(sp)
	lw	t2, 356(sp)
	lw	t1, 0(t2)
	sw	t1, 364(sp)
	lw	t2, 364(sp)
	addi	t1, t2, 4
	sw	t1, 372(sp)
	lw	t2, 372(sp)
	mv	t1, t2
	sw	t1, 368(sp)
	lw	t2, 368(sp)
	lw	t1, 0(t2)
	sw	t1, 376(sp)
	lw	t2, 344(sp)
	lw	t3, 376(sp)
	add	t1, t2, t3
	sw	t1, 380(sp)
	lui	t1, %hi(make)
	sw	t1, 388(sp)
	lw	t2, 388(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 384(sp)
	lw	t2, 384(sp)
	mv	t1, t2
	sw	t1, 396(sp)
	lw	t2, 396(sp)
	mv	t1, t2
	sw	t1, 392(sp)
	lw	t2, 392(sp)
	lw	t1, 0(t2)
	sw	t1, 400(sp)
	lw	t2, 400(sp)
	addi	t1, t2, 8
	sw	t1, 408(sp)
	lw	t2, 408(sp)
	mv	t1, t2
	sw	t1, 404(sp)
	lw	t2, 404(sp)
	lw	t1, 0(t2)
	sw	t1, 412(sp)
	lw	t2, 380(sp)
	lw	t3, 412(sp)
	add	t1, t2, t3
	sw	t1, 416(sp)
	lw	t3, 416(sp)
	sw	t3, 20(sp)
	lui	t1, %hi(make)
	sw	t1, 424(sp)
	lw	t2, 424(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 420(sp)
	lw	t2, 420(sp)
	addi	t1, t2, 8
	sw	t1, 432(sp)
	lw	t2, 432(sp)
	mv	t1, t2
	sw	t1, 428(sp)
	lw	t2, 428(sp)
	lw	t1, 0(t2)
	sw	t1, 436(sp)
	lw	t2, 436(sp)
	mv	t1, t2
	sw	t1, 444(sp)
	lw	t2, 444(sp)
	mv	t1, t2
	sw	t1, 440(sp)
	lw	t2, 440(sp)
	lw	t1, 0(t2)
	sw	t1, 448(sp)
	lui	t1, %hi(make)
	sw	t1, 456(sp)
	lw	t2, 456(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 452(sp)
	lw	t2, 452(sp)
	addi	t1, t2, 8
	sw	t1, 464(sp)
	lw	t2, 464(sp)
	mv	t1, t2
	sw	t1, 460(sp)
	lw	t2, 460(sp)
	lw	t1, 0(t2)
	sw	t1, 468(sp)
	lw	t2, 468(sp)
	addi	t1, t2, 4
	sw	t1, 476(sp)
	lw	t2, 476(sp)
	mv	t1, t2
	sw	t1, 472(sp)
	lw	t2, 472(sp)
	lw	t1, 0(t2)
	sw	t1, 480(sp)
	lw	t2, 448(sp)
	lw	t3, 480(sp)
	add	t1, t2, t3
	sw	t1, 484(sp)
	lui	t1, %hi(make)
	sw	t1, 492(sp)
	lw	t2, 492(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 488(sp)
	lw	t2, 488(sp)
	addi	t1, t2, 8
	sw	t1, 500(sp)
	lw	t2, 500(sp)
	mv	t1, t2
	sw	t1, 496(sp)
	lw	t2, 496(sp)
	lw	t1, 0(t2)
	sw	t1, 504(sp)
	lw	t2, 504(sp)
	addi	t1, t2, 8
	sw	t1, 512(sp)
	lw	t2, 512(sp)
	mv	t1, t2
	sw	t1, 508(sp)
	lw	t2, 508(sp)
	lw	t1, 0(t2)
	sw	t1, 516(sp)
	lw	t2, 484(sp)
	lw	t3, 516(sp)
	add	t1, t2, t3
	sw	t1, 520(sp)
	lw	t1, 20(sp)
	sw	t1, 524(sp)
	lw	t2, 520(sp)
	lw	t3, 524(sp)
	xor	t1, t2, t3
	sw	t1, 532(sp)
	lw	t2, 532(sp)
	seqz	t1, t2
	sb	t1, 528(sp)
	lb	t2, 528(sp)
	bne	t2, zero, lg.nocut6
	j	mid4
if.false1:
	lw	t1, 28(sp)
	sw	t1, 536(sp)
	li	t1, 2
	sw	t1, 540(sp)
	lw	t2, 536(sp)
	lw	t3, 540(sp)
	beq	t2, t3, if.true2
	j	if.false2
if.exit1:
	j	if.exit
lg.nocut3:
	lw	t1, 28(sp)
	sw	t1, 544(sp)
	lw	t2, 544(sp)
	xori	t1, t2, 2
	sw	t1, 552(sp)
	lw	t2, 552(sp)
	seqz	t1, t2
	sb	t1, 548(sp)
	lb	t2, 548(sp)
	mv	t1, t2
	sb	t1, 556(sp)
	j	lg.exit3
lg.exit3:
	lb	t2, 556(sp)
	bne	t2, zero, if.true1
	j	if.false1
if.true2:
	lui	t1, %hi(make)
	sw	t1, 564(sp)
	lw	t2, 564(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 560(sp)
	lw	t1, 32(sp)
	sw	t1, 568(sp)
	li	t1, 8
	sw	t1, 584(sp)
	lw	t2, 568(sp)
	lw	t3, 584(sp)
	mul	t1, t2, t3
	sw	t1, 580(sp)
	lw	t2, 560(sp)
	lw	t3, 580(sp)
	add	t1, t2, t3
	sw	t1, 576(sp)
	lw	t2, 576(sp)
	mv	t1, t2
	sw	t1, 572(sp)
	lw	t2, 572(sp)
	lw	t1, 0(t2)
	sw	t1, 588(sp)
	lw	t1, 28(sp)
	sw	t1, 592(sp)
	li	t1, 4
	sw	t1, 608(sp)
	lw	t2, 592(sp)
	lw	t3, 608(sp)
	mul	t1, t2, t3
	sw	t1, 604(sp)
	lw	t2, 588(sp)
	lw	t3, 604(sp)
	add	t1, t2, t3
	sw	t1, 600(sp)
	lw	t2, 600(sp)
	mv	t1, t2
	sw	t1, 596(sp)
	lw	t2, 596(sp)
	lw	t1, 0(t2)
	sw	t1, 612(sp)
	lui	t1, %hi(make)
	sw	t1, 620(sp)
	lw	t2, 620(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 616(sp)
	lw	t1, 32(sp)
	sw	t1, 624(sp)
	li	t1, 8
	sw	t1, 640(sp)
	lw	t2, 624(sp)
	lw	t3, 640(sp)
	mul	t1, t2, t3
	sw	t1, 636(sp)
	lw	t2, 616(sp)
	lw	t3, 636(sp)
	add	t1, t2, t3
	sw	t1, 632(sp)
	lw	t2, 632(sp)
	mv	t1, t2
	sw	t1, 628(sp)
	lw	t2, 628(sp)
	lw	t1, 0(t2)
	sw	t1, 644(sp)
	lw	t2, 644(sp)
	mv	t1, t2
	sw	t1, 652(sp)
	lw	t2, 652(sp)
	mv	t1, t2
	sw	t1, 648(sp)
	lw	t2, 648(sp)
	lw	t1, 0(t2)
	sw	t1, 656(sp)
	li	t1, 15
	sw	t1, 664(sp)
	lw	t2, 664(sp)
	lw	t3, 656(sp)
	sub	t1, t2, t3
	sw	t1, 660(sp)
	lui	t1, %hi(make)
	sw	t1, 672(sp)
	lw	t2, 672(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 668(sp)
	lw	t1, 32(sp)
	sw	t1, 676(sp)
	li	t1, 8
	sw	t1, 692(sp)
	lw	t2, 676(sp)
	lw	t3, 692(sp)
	mul	t1, t2, t3
	sw	t1, 688(sp)
	lw	t2, 668(sp)
	lw	t3, 688(sp)
	add	t1, t2, t3
	sw	t1, 684(sp)
	lw	t2, 684(sp)
	mv	t1, t2
	sw	t1, 680(sp)
	lw	t2, 680(sp)
	lw	t1, 0(t2)
	sw	t1, 696(sp)
	lw	t2, 696(sp)
	addi	t1, t2, 4
	sw	t1, 704(sp)
	lw	t2, 704(sp)
	mv	t1, t2
	sw	t1, 700(sp)
	lw	t2, 700(sp)
	lw	t1, 0(t2)
	sw	t1, 708(sp)
	lw	t2, 660(sp)
	lw	t3, 708(sp)
	sub	t1, t2, t3
	sw	t1, 712(sp)
	lw	t2, 596(sp)
	lw	t3, 712(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(make)
	sw	t1, 720(sp)
	lw	t2, 720(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 716(sp)
	lw	t1, 32(sp)
	sw	t1, 724(sp)
	li	t1, 8
	sw	t1, 740(sp)
	lw	t2, 724(sp)
	lw	t3, 740(sp)
	mul	t1, t2, t3
	sw	t1, 736(sp)
	lw	t2, 716(sp)
	lw	t3, 736(sp)
	add	t1, t2, t3
	sw	t1, 732(sp)
	lw	t2, 732(sp)
	mv	t1, t2
	sw	t1, 728(sp)
	lw	t2, 728(sp)
	lw	t1, 0(t2)
	sw	t1, 744(sp)
	lw	t1, 28(sp)
	sw	t1, 748(sp)
	li	t1, 4
	sw	t1, 764(sp)
	lw	t2, 748(sp)
	lw	t3, 764(sp)
	mul	t1, t2, t3
	sw	t1, 760(sp)
	lw	t2, 744(sp)
	lw	t3, 760(sp)
	add	t1, t2, t3
	sw	t1, 756(sp)
	lw	t2, 756(sp)
	mv	t1, t2
	sw	t1, 752(sp)
	lw	t2, 752(sp)
	lw	t1, 0(t2)
	sw	t1, 768(sp)
	lw	t3, 768(sp)
	slt	t1, zero, t3
	sb	t1, 772(sp)
	lb	t2, 772(sp)
	bne	t2, zero, lg.nocut4
	j	mid5
if.false2:
	lw	t1, 16(sp)
	sw	t1, 776(sp)
	li	t1, 1
	sw	t1, 780(sp)
	lw	t3, 780(sp)
	sw	t3, 16(sp)
	j	for.cond2
if.exit2:
	j	if.exit1
for.cond2:
	lw	t1, 16(sp)
	sw	t1, 784(sp)
	li	t1, 9
	sw	t1, 788(sp)
	lw	t2, 788(sp)
	lw	t3, 784(sp)
	bge	t2, t3, for.body2
	j	for.exit2
for.incr2:
	lw	t1, 16(sp)
	sw	t1, 792(sp)
	lw	t2, 792(sp)
	addi	t1, t2, 1
	sw	t1, 796(sp)
	lw	t3, 796(sp)
	sw	t3, 16(sp)
	j	for.cond2
for.body2:
	lui	t1, %hi(color)
	sw	t1, 804(sp)
	lw	t2, 804(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 800(sp)
	lw	t1, 16(sp)
	sw	t1, 808(sp)
	li	t1, 4
	sw	t1, 824(sp)
	lw	t2, 808(sp)
	lw	t3, 824(sp)
	mul	t1, t2, t3
	sw	t1, 820(sp)
	lw	t2, 800(sp)
	lw	t3, 820(sp)
	add	t1, t2, t3
	sw	t1, 816(sp)
	lw	t2, 816(sp)
	mv	t1, t2
	sw	t1, 812(sp)
	lw	t2, 812(sp)
	lw	t1, 0(t2)
	sw	t1, 828(sp)
	lw	t2, 828(sp)
	beq	t2, zero, if.true3
	j	if.false3
for.exit2:
	j	if.exit2
if.true3:
	lui	t1, %hi(color)
	sw	t1, 836(sp)
	lw	t2, 836(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 832(sp)
	lw	t1, 16(sp)
	sw	t1, 840(sp)
	li	t1, 4
	sw	t1, 856(sp)
	lw	t2, 840(sp)
	lw	t3, 856(sp)
	mul	t1, t2, t3
	sw	t1, 852(sp)
	lw	t2, 832(sp)
	lw	t3, 852(sp)
	add	t1, t2, t3
	sw	t1, 848(sp)
	lw	t2, 848(sp)
	mv	t1, t2
	sw	t1, 844(sp)
	lw	t2, 844(sp)
	lw	t1, 0(t2)
	sw	t1, 860(sp)
	li	t1, 1
	sw	t1, 864(sp)
	lw	t2, 844(sp)
	lw	t3, 864(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(make)
	sw	t1, 872(sp)
	lw	t2, 872(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 868(sp)
	lw	t1, 32(sp)
	sw	t1, 876(sp)
	li	t1, 8
	sw	t1, 892(sp)
	lw	t2, 876(sp)
	lw	t3, 892(sp)
	mul	t1, t2, t3
	sw	t1, 888(sp)
	lw	t2, 868(sp)
	lw	t3, 888(sp)
	add	t1, t2, t3
	sw	t1, 884(sp)
	lw	t2, 884(sp)
	mv	t1, t2
	sw	t1, 880(sp)
	lw	t2, 880(sp)
	lw	t1, 0(t2)
	sw	t1, 896(sp)
	lw	t1, 28(sp)
	sw	t1, 900(sp)
	li	t1, 4
	sw	t1, 916(sp)
	lw	t2, 900(sp)
	lw	t3, 916(sp)
	mul	t1, t2, t3
	sw	t1, 912(sp)
	lw	t2, 896(sp)
	lw	t3, 912(sp)
	add	t1, t2, t3
	sw	t1, 908(sp)
	lw	t2, 908(sp)
	mv	t1, t2
	sw	t1, 904(sp)
	lw	t2, 904(sp)
	lw	t1, 0(t2)
	sw	t1, 920(sp)
	lw	t1, 16(sp)
	sw	t1, 924(sp)
	lw	t2, 904(sp)
	lw	t3, 924(sp)
	sw	t3, 0(t2)
	lw	t1, 28(sp)
	sw	t1, 928(sp)
	li	t1, 2
	sw	t1, 932(sp)
	lw	t2, 928(sp)
	lw	t3, 932(sp)
	beq	t2, t3, if.true4
	j	if.false4
if.false3:
	j	if.exit3
if.exit3:
	j	for.incr2
if.true4:
	lw	t1, 32(sp)
	sw	t1, 936(sp)
	lw	t2, 936(sp)
	addi	t1, t2, 1
	sw	t1, 940(sp)
	lw	t1, 24(sp)
	sw	t1, 944(sp)
	lw	t1, 16(sp)
	sw	t1, 948(sp)
	lw	t2, 944(sp)
	lw	t3, 948(sp)
	add	t1, t2, t3
	sw	t1, 952(sp)
	lw	t2, 940(sp)
	mv	a0, t2
	li	a1, 0
	lw	t2, 952(sp)
	mv	a2, t2
	call	search
	j	if.exit4
if.false4:
	lw	t1, 32(sp)
	sw	t1, 956(sp)
	lw	t1, 28(sp)
	sw	t1, 960(sp)
	lw	t2, 960(sp)
	addi	t1, t2, 1
	sw	t1, 964(sp)
	lw	t1, 24(sp)
	sw	t1, 968(sp)
	lw	t1, 16(sp)
	sw	t1, 972(sp)
	lw	t2, 968(sp)
	lw	t3, 972(sp)
	add	t1, t2, t3
	sw	t1, 976(sp)
	lw	t2, 956(sp)
	mv	a0, t2
	lw	t2, 964(sp)
	mv	a1, t2
	lw	t2, 976(sp)
	mv	a2, t2
	call	search
	j	if.exit4
if.exit4:
	lui	t1, %hi(make)
	sw	t1, 984(sp)
	lw	t2, 984(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 980(sp)
	lw	t1, 32(sp)
	sw	t1, 988(sp)
	li	t1, 8
	sw	t1, 1004(sp)
	lw	t2, 988(sp)
	lw	t3, 1004(sp)
	mul	t1, t2, t3
	sw	t1, 1000(sp)
	lw	t2, 980(sp)
	lw	t3, 1000(sp)
	add	t1, t2, t3
	sw	t1, 996(sp)
	lw	t2, 996(sp)
	mv	t1, t2
	sw	t1, 992(sp)
	lw	t2, 992(sp)
	lw	t1, 0(t2)
	sw	t1, 1008(sp)
	lw	t1, 28(sp)
	sw	t1, 1012(sp)
	li	t1, 4
	sw	t1, 1028(sp)
	lw	t2, 1012(sp)
	lw	t3, 1028(sp)
	mul	t1, t2, t3
	sw	t1, 1024(sp)
	lw	t2, 1008(sp)
	lw	t3, 1024(sp)
	add	t1, t2, t3
	sw	t1, 1020(sp)
	lw	t2, 1020(sp)
	mv	t1, t2
	sw	t1, 1016(sp)
	lw	t2, 1016(sp)
	lw	t1, 0(t2)
	sw	t1, 1032(sp)
	lw	t2, 1016(sp)
	sw	zero, 0(t2)
	lui	t1, %hi(color)
	sw	t1, 1040(sp)
	lw	t2, 1040(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 1036(sp)
	lw	t1, 16(sp)
	sw	t1, 1044(sp)
	li	t1, 4
	sw	t1, 1060(sp)
	lw	t2, 1044(sp)
	lw	t3, 1060(sp)
	mul	t1, t2, t3
	sw	t1, 1056(sp)
	lw	t2, 1036(sp)
	lw	t3, 1056(sp)
	add	t1, t2, t3
	sw	t1, 1052(sp)
	lw	t2, 1052(sp)
	mv	t1, t2
	sw	t1, 1048(sp)
	lw	t2, 1048(sp)
	lw	t1, 0(t2)
	sw	t1, 1064(sp)
	lw	t2, 1048(sp)
	sw	zero, 0(t2)
	j	if.exit3
if.true5:
	lui	t1, %hi(color)
	sw	t1, 1072(sp)
	lw	t2, 1072(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 1068(sp)
	lui	t1, %hi(make)
	sw	t1, 1080(sp)
	lw	t2, 1080(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1076(sp)
	lw	t1, 32(sp)
	sw	t1, 1084(sp)
	li	t1, 8
	sw	t1, 1100(sp)
	lw	t2, 1084(sp)
	lw	t3, 1100(sp)
	mul	t1, t2, t3
	sw	t1, 1096(sp)
	lw	t2, 1076(sp)
	lw	t3, 1096(sp)
	add	t1, t2, t3
	sw	t1, 1092(sp)
	lw	t2, 1092(sp)
	mv	t1, t2
	sw	t1, 1088(sp)
	lw	t2, 1088(sp)
	lw	t1, 0(t2)
	sw	t1, 1104(sp)
	lw	t1, 28(sp)
	sw	t1, 1108(sp)
	li	t1, 4
	sw	t1, 1124(sp)
	lw	t2, 1108(sp)
	lw	t3, 1124(sp)
	mul	t1, t2, t3
	sw	t1, 1120(sp)
	lw	t2, 1104(sp)
	lw	t3, 1120(sp)
	add	t1, t2, t3
	sw	t1, 1116(sp)
	lw	t2, 1116(sp)
	mv	t1, t2
	sw	t1, 1112(sp)
	lw	t2, 1112(sp)
	lw	t1, 0(t2)
	sw	t1, 1128(sp)
	li	t1, 4
	sw	t1, 1144(sp)
	lw	t2, 1128(sp)
	lw	t3, 1144(sp)
	mul	t1, t2, t3
	sw	t1, 1140(sp)
	lw	t2, 1068(sp)
	lw	t3, 1140(sp)
	add	t1, t2, t3
	sw	t1, 1136(sp)
	lw	t2, 1136(sp)
	mv	t1, t2
	sw	t1, 1132(sp)
	lw	t2, 1132(sp)
	lw	t1, 0(t2)
	sw	t1, 1148(sp)
	li	t1, 1
	sw	t1, 1152(sp)
	lw	t2, 1132(sp)
	lw	t3, 1152(sp)
	sw	t3, 0(t2)
	lw	t1, 28(sp)
	sw	t1, 1156(sp)
	li	t1, 2
	sw	t1, 1160(sp)
	lw	t2, 1156(sp)
	lw	t3, 1160(sp)
	beq	t2, t3, if.true6
	j	if.false6
if.false5:
	j	if.exit5
if.exit5:
	j	if.exit2
lg.nocut4:
	lui	t1, %hi(make)
	sw	t1, 1168(sp)
	lw	t2, 1168(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1164(sp)
	lw	t1, 32(sp)
	sw	t1, 1172(sp)
	li	t1, 8
	sw	t1, 1188(sp)
	lw	t2, 1172(sp)
	lw	t3, 1188(sp)
	mul	t1, t2, t3
	sw	t1, 1184(sp)
	lw	t2, 1164(sp)
	lw	t3, 1184(sp)
	add	t1, t2, t3
	sw	t1, 1180(sp)
	lw	t2, 1180(sp)
	mv	t1, t2
	sw	t1, 1176(sp)
	lw	t2, 1176(sp)
	lw	t1, 0(t2)
	sw	t1, 1192(sp)
	lw	t1, 28(sp)
	sw	t1, 1196(sp)
	li	t1, 4
	sw	t1, 1212(sp)
	lw	t2, 1196(sp)
	lw	t3, 1212(sp)
	mul	t1, t2, t3
	sw	t1, 1208(sp)
	lw	t2, 1192(sp)
	lw	t3, 1208(sp)
	add	t1, t2, t3
	sw	t1, 1204(sp)
	lw	t2, 1204(sp)
	mv	t1, t2
	sw	t1, 1200(sp)
	lw	t2, 1200(sp)
	lw	t1, 0(t2)
	sw	t1, 1216(sp)
	lw	t2, 1216(sp)
	slti	t1, t2, 10
	sb	t1, 1220(sp)
	lb	t2, 1220(sp)
	mv	t1, t2
	sb	t1, 1224(sp)
	j	lg.exit4
lg.exit4:
	lb	t2, 1224(sp)
	bne	t2, zero, lg.nocut5
	j	mid6
lg.nocut5:
	lui	t1, %hi(color)
	sw	t1, 1232(sp)
	lw	t2, 1232(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 1228(sp)
	lui	t1, %hi(make)
	sw	t1, 1240(sp)
	lw	t2, 1240(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1236(sp)
	lw	t1, 32(sp)
	sw	t1, 1244(sp)
	li	t1, 8
	sw	t1, 1260(sp)
	lw	t2, 1244(sp)
	lw	t3, 1260(sp)
	mul	t1, t2, t3
	sw	t1, 1256(sp)
	lw	t2, 1236(sp)
	lw	t3, 1256(sp)
	add	t1, t2, t3
	sw	t1, 1252(sp)
	lw	t2, 1252(sp)
	mv	t1, t2
	sw	t1, 1248(sp)
	lw	t2, 1248(sp)
	lw	t1, 0(t2)
	sw	t1, 1264(sp)
	lw	t1, 28(sp)
	sw	t1, 1268(sp)
	li	t1, 4
	sw	t1, 1284(sp)
	lw	t2, 1268(sp)
	lw	t3, 1284(sp)
	mul	t1, t2, t3
	sw	t1, 1280(sp)
	lw	t2, 1264(sp)
	lw	t3, 1280(sp)
	add	t1, t2, t3
	sw	t1, 1276(sp)
	lw	t2, 1276(sp)
	mv	t1, t2
	sw	t1, 1272(sp)
	lw	t2, 1272(sp)
	lw	t1, 0(t2)
	sw	t1, 1288(sp)
	li	t1, 4
	sw	t1, 1304(sp)
	lw	t2, 1288(sp)
	lw	t3, 1304(sp)
	mul	t1, t2, t3
	sw	t1, 1300(sp)
	lw	t2, 1228(sp)
	lw	t3, 1300(sp)
	add	t1, t2, t3
	sw	t1, 1296(sp)
	lw	t2, 1296(sp)
	mv	t1, t2
	sw	t1, 1292(sp)
	lw	t2, 1292(sp)
	lw	t1, 0(t2)
	sw	t1, 1308(sp)
	lw	t2, 1308(sp)
	xori	t1, t2, 0
	sw	t1, 1316(sp)
	lw	t2, 1316(sp)
	seqz	t1, t2
	sb	t1, 1312(sp)
	lb	t2, 1312(sp)
	mv	t1, t2
	sb	t1, 1320(sp)
	j	lg.exit5
lg.exit5:
	lb	t2, 1320(sp)
	bne	t2, zero, if.true5
	j	if.false5
if.true6:
	lw	t1, 32(sp)
	sw	t1, 1324(sp)
	lw	t2, 1324(sp)
	addi	t1, t2, 1
	sw	t1, 1328(sp)
	lw	t1, 24(sp)
	sw	t1, 1332(sp)
	lui	t1, %hi(make)
	sw	t1, 1340(sp)
	lw	t2, 1340(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1336(sp)
	lw	t1, 32(sp)
	sw	t1, 1344(sp)
	li	t1, 8
	sw	t1, 1360(sp)
	lw	t2, 1344(sp)
	lw	t3, 1360(sp)
	mul	t1, t2, t3
	sw	t1, 1356(sp)
	lw	t2, 1336(sp)
	lw	t3, 1356(sp)
	add	t1, t2, t3
	sw	t1, 1352(sp)
	lw	t2, 1352(sp)
	mv	t1, t2
	sw	t1, 1348(sp)
	lw	t2, 1348(sp)
	lw	t1, 0(t2)
	sw	t1, 1364(sp)
	lw	t1, 28(sp)
	sw	t1, 1368(sp)
	li	t1, 4
	sw	t1, 1384(sp)
	lw	t2, 1368(sp)
	lw	t3, 1384(sp)
	mul	t1, t2, t3
	sw	t1, 1380(sp)
	lw	t2, 1364(sp)
	lw	t3, 1380(sp)
	add	t1, t2, t3
	sw	t1, 1376(sp)
	lw	t2, 1376(sp)
	mv	t1, t2
	sw	t1, 1372(sp)
	lw	t2, 1372(sp)
	lw	t1, 0(t2)
	sw	t1, 1388(sp)
	lw	t2, 1332(sp)
	lw	t3, 1388(sp)
	add	t1, t2, t3
	sw	t1, 1392(sp)
	lw	t2, 1328(sp)
	mv	a0, t2
	li	a1, 0
	lw	t2, 1392(sp)
	mv	a2, t2
	call	search
	j	if.exit6
if.false6:
	lw	t1, 32(sp)
	sw	t1, 1396(sp)
	lw	t1, 28(sp)
	sw	t1, 1400(sp)
	lw	t2, 1400(sp)
	addi	t1, t2, 1
	sw	t1, 1404(sp)
	lw	t1, 24(sp)
	sw	t1, 1408(sp)
	lui	t1, %hi(make)
	sw	t1, 1416(sp)
	lw	t2, 1416(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1412(sp)
	lw	t1, 32(sp)
	sw	t1, 1420(sp)
	li	t1, 8
	sw	t1, 1436(sp)
	lw	t2, 1420(sp)
	lw	t3, 1436(sp)
	mul	t1, t2, t3
	sw	t1, 1432(sp)
	lw	t2, 1412(sp)
	lw	t3, 1432(sp)
	add	t1, t2, t3
	sw	t1, 1428(sp)
	lw	t2, 1428(sp)
	mv	t1, t2
	sw	t1, 1424(sp)
	lw	t2, 1424(sp)
	lw	t1, 0(t2)
	sw	t1, 1440(sp)
	lw	t1, 28(sp)
	sw	t1, 1444(sp)
	li	t1, 4
	sw	t1, 1460(sp)
	lw	t2, 1444(sp)
	lw	t3, 1460(sp)
	mul	t1, t2, t3
	sw	t1, 1456(sp)
	lw	t2, 1440(sp)
	lw	t3, 1456(sp)
	add	t1, t2, t3
	sw	t1, 1452(sp)
	lw	t2, 1452(sp)
	mv	t1, t2
	sw	t1, 1448(sp)
	lw	t2, 1448(sp)
	lw	t1, 0(t2)
	sw	t1, 1464(sp)
	lw	t2, 1408(sp)
	lw	t3, 1464(sp)
	add	t1, t2, t3
	sw	t1, 1468(sp)
	lw	t2, 1396(sp)
	mv	a0, t2
	lw	t2, 1404(sp)
	mv	a1, t2
	lw	t2, 1468(sp)
	mv	a2, t2
	call	search
	j	if.exit6
if.exit6:
	lui	t1, %hi(color)
	sw	t1, 1476(sp)
	lw	t2, 1476(sp)
	lw	t1, %lo(color)(t2)
	sw	t1, 1472(sp)
	lui	t1, %hi(make)
	sw	t1, 1484(sp)
	lw	t2, 1484(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1480(sp)
	lw	t1, 32(sp)
	sw	t1, 1488(sp)
	li	t1, 8
	sw	t1, 1504(sp)
	lw	t2, 1488(sp)
	lw	t3, 1504(sp)
	mul	t1, t2, t3
	sw	t1, 1500(sp)
	lw	t2, 1480(sp)
	lw	t3, 1500(sp)
	add	t1, t2, t3
	sw	t1, 1496(sp)
	lw	t2, 1496(sp)
	mv	t1, t2
	sw	t1, 1492(sp)
	lw	t2, 1492(sp)
	lw	t1, 0(t2)
	sw	t1, 1508(sp)
	lw	t1, 28(sp)
	sw	t1, 1512(sp)
	li	t1, 4
	sw	t1, 1528(sp)
	lw	t2, 1512(sp)
	lw	t3, 1528(sp)
	mul	t1, t2, t3
	sw	t1, 1524(sp)
	lw	t2, 1508(sp)
	lw	t3, 1524(sp)
	add	t1, t2, t3
	sw	t1, 1520(sp)
	lw	t2, 1520(sp)
	mv	t1, t2
	sw	t1, 1516(sp)
	lw	t2, 1516(sp)
	lw	t1, 0(t2)
	sw	t1, 1532(sp)
	li	t1, 4
	sw	t1, 1548(sp)
	lw	t2, 1532(sp)
	lw	t3, 1548(sp)
	mul	t1, t2, t3
	sw	t1, 1544(sp)
	lw	t2, 1472(sp)
	lw	t3, 1544(sp)
	add	t1, t2, t3
	sw	t1, 1540(sp)
	lw	t2, 1540(sp)
	mv	t1, t2
	sw	t1, 1536(sp)
	lw	t2, 1536(sp)
	lw	t1, 0(t2)
	sw	t1, 1552(sp)
	lw	t2, 1536(sp)
	sw	zero, 0(t2)
	j	if.exit5
if.true7:
	lui	t1, %hi(count)
	sw	t1, 1560(sp)
	lw	t2, 1560(sp)
	lw	t1, %lo(count)(t2)
	sw	t1, 1556(sp)
	lw	t2, 1556(sp)
	mv	t1, t2
	sw	t1, 1568(sp)
	lw	t2, 1568(sp)
	mv	t1, t2
	sw	t1, 1564(sp)
	lw	t2, 1564(sp)
	lw	t1, 0(t2)
	sw	t1, 1572(sp)
	lui	t1, %hi(count)
	sw	t1, 1580(sp)
	lw	t2, 1580(sp)
	lw	t1, %lo(count)(t2)
	sw	t1, 1576(sp)
	lw	t2, 1576(sp)
	mv	t1, t2
	sw	t1, 1588(sp)
	lw	t2, 1588(sp)
	mv	t1, t2
	sw	t1, 1584(sp)
	lw	t2, 1584(sp)
	lw	t1, 0(t2)
	sw	t1, 1592(sp)
	lw	t2, 1592(sp)
	addi	t1, t2, 1
	sw	t1, 1596(sp)
	lw	t2, 1564(sp)
	lw	t3, 1596(sp)
	sw	t3, 0(t2)
	lw	t1, 16(sp)
	sw	t1, 1600(sp)
	sw	zero, 16(sp)
	j	for.cond3
if.false7:
	j	if.exit7
if.exit7:
	j	if.exit1
lg.nocut6:
	lui	t1, %hi(make)
	sw	t1, 1608(sp)
	lw	t2, 1608(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1604(sp)
	lw	t2, 1604(sp)
	addi	t1, t2, 16
	sw	t1, 1616(sp)
	lw	t2, 1616(sp)
	mv	t1, t2
	sw	t1, 1612(sp)
	lw	t2, 1612(sp)
	lw	t1, 0(t2)
	sw	t1, 1620(sp)
	lw	t2, 1620(sp)
	mv	t1, t2
	sw	t1, 1628(sp)
	lw	t2, 1628(sp)
	mv	t1, t2
	sw	t1, 1624(sp)
	lw	t2, 1624(sp)
	lw	t1, 0(t2)
	sw	t1, 1632(sp)
	lui	t1, %hi(make)
	sw	t1, 1640(sp)
	lw	t2, 1640(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1636(sp)
	lw	t2, 1636(sp)
	addi	t1, t2, 16
	sw	t1, 1648(sp)
	lw	t2, 1648(sp)
	mv	t1, t2
	sw	t1, 1644(sp)
	lw	t2, 1644(sp)
	lw	t1, 0(t2)
	sw	t1, 1652(sp)
	lw	t2, 1652(sp)
	addi	t1, t2, 4
	sw	t1, 1660(sp)
	lw	t2, 1660(sp)
	mv	t1, t2
	sw	t1, 1656(sp)
	lw	t2, 1656(sp)
	lw	t1, 0(t2)
	sw	t1, 1664(sp)
	lw	t2, 1632(sp)
	lw	t3, 1664(sp)
	add	t1, t2, t3
	sw	t1, 1668(sp)
	lui	t1, %hi(make)
	sw	t1, 1676(sp)
	lw	t2, 1676(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1672(sp)
	lw	t2, 1672(sp)
	addi	t1, t2, 16
	sw	t1, 1684(sp)
	lw	t2, 1684(sp)
	mv	t1, t2
	sw	t1, 1680(sp)
	lw	t2, 1680(sp)
	lw	t1, 0(t2)
	sw	t1, 1688(sp)
	lw	t2, 1688(sp)
	addi	t1, t2, 8
	sw	t1, 1696(sp)
	lw	t2, 1696(sp)
	mv	t1, t2
	sw	t1, 1692(sp)
	lw	t2, 1692(sp)
	lw	t1, 0(t2)
	sw	t1, 1700(sp)
	lw	t2, 1668(sp)
	lw	t3, 1700(sp)
	add	t1, t2, t3
	sw	t1, 1704(sp)
	lw	t1, 20(sp)
	sw	t1, 1708(sp)
	lw	t2, 1704(sp)
	lw	t3, 1708(sp)
	xor	t1, t2, t3
	sw	t1, 1716(sp)
	lw	t2, 1716(sp)
	seqz	t1, t2
	sb	t1, 1712(sp)
	lb	t2, 1712(sp)
	mv	t1, t2
	sb	t1, 1720(sp)
	j	lg.exit6
lg.exit6:
	lb	t2, 1720(sp)
	bne	t2, zero, lg.nocut7
	j	mid7
lg.nocut7:
	lui	t1, %hi(make)
	sw	t1, 1728(sp)
	lw	t2, 1728(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1724(sp)
	lw	t2, 1724(sp)
	mv	t1, t2
	sw	t1, 1736(sp)
	lw	t2, 1736(sp)
	mv	t1, t2
	sw	t1, 1732(sp)
	lw	t2, 1732(sp)
	lw	t1, 0(t2)
	sw	t1, 1740(sp)
	lw	t2, 1740(sp)
	mv	t1, t2
	sw	t1, 1748(sp)
	lw	t2, 1748(sp)
	mv	t1, t2
	sw	t1, 1744(sp)
	lw	t2, 1744(sp)
	lw	t1, 0(t2)
	sw	t1, 1752(sp)
	lui	t1, %hi(make)
	sw	t1, 1760(sp)
	lw	t2, 1760(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1756(sp)
	lw	t2, 1756(sp)
	addi	t1, t2, 8
	sw	t1, 1768(sp)
	lw	t2, 1768(sp)
	mv	t1, t2
	sw	t1, 1764(sp)
	lw	t2, 1764(sp)
	lw	t1, 0(t2)
	sw	t1, 1772(sp)
	lw	t2, 1772(sp)
	mv	t1, t2
	sw	t1, 1780(sp)
	lw	t2, 1780(sp)
	mv	t1, t2
	sw	t1, 1776(sp)
	lw	t2, 1776(sp)
	lw	t1, 0(t2)
	sw	t1, 1784(sp)
	lw	t2, 1752(sp)
	lw	t3, 1784(sp)
	add	t1, t2, t3
	sw	t1, 1788(sp)
	lui	t1, %hi(make)
	sw	t1, 1796(sp)
	lw	t2, 1796(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1792(sp)
	lw	t2, 1792(sp)
	addi	t1, t2, 16
	sw	t1, 1804(sp)
	lw	t2, 1804(sp)
	mv	t1, t2
	sw	t1, 1800(sp)
	lw	t2, 1800(sp)
	lw	t1, 0(t2)
	sw	t1, 1808(sp)
	lw	t2, 1808(sp)
	mv	t1, t2
	sw	t1, 1816(sp)
	lw	t2, 1816(sp)
	mv	t1, t2
	sw	t1, 1812(sp)
	lw	t2, 1812(sp)
	lw	t1, 0(t2)
	sw	t1, 1820(sp)
	lw	t2, 1788(sp)
	lw	t3, 1820(sp)
	add	t1, t2, t3
	sw	t1, 1824(sp)
	lw	t1, 20(sp)
	sw	t1, 1828(sp)
	lw	t2, 1824(sp)
	lw	t3, 1828(sp)
	xor	t1, t2, t3
	sw	t1, 1836(sp)
	lw	t2, 1836(sp)
	seqz	t1, t2
	sb	t1, 1832(sp)
	lb	t2, 1832(sp)
	mv	t1, t2
	sb	t1, 1840(sp)
	j	lg.exit7
lg.exit7:
	lb	t2, 1840(sp)
	bne	t2, zero, lg.nocut8
	j	mid8
lg.nocut8:
	lui	t1, %hi(make)
	sw	t1, 1848(sp)
	lw	t2, 1848(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1844(sp)
	lw	t2, 1844(sp)
	mv	t1, t2
	sw	t1, 1856(sp)
	lw	t2, 1856(sp)
	mv	t1, t2
	sw	t1, 1852(sp)
	lw	t2, 1852(sp)
	lw	t1, 0(t2)
	sw	t1, 1860(sp)
	lw	t2, 1860(sp)
	addi	t1, t2, 4
	sw	t1, 1868(sp)
	lw	t2, 1868(sp)
	mv	t1, t2
	sw	t1, 1864(sp)
	lw	t2, 1864(sp)
	lw	t1, 0(t2)
	sw	t1, 1872(sp)
	lui	t1, %hi(make)
	sw	t1, 1880(sp)
	lw	t2, 1880(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1876(sp)
	lw	t2, 1876(sp)
	addi	t1, t2, 8
	sw	t1, 1888(sp)
	lw	t2, 1888(sp)
	mv	t1, t2
	sw	t1, 1884(sp)
	lw	t2, 1884(sp)
	lw	t1, 0(t2)
	sw	t1, 1892(sp)
	lw	t2, 1892(sp)
	addi	t1, t2, 4
	sw	t1, 1900(sp)
	lw	t2, 1900(sp)
	mv	t1, t2
	sw	t1, 1896(sp)
	lw	t2, 1896(sp)
	lw	t1, 0(t2)
	sw	t1, 1904(sp)
	lw	t2, 1872(sp)
	lw	t3, 1904(sp)
	add	t1, t2, t3
	sw	t1, 1908(sp)
	lui	t1, %hi(make)
	sw	t1, 1916(sp)
	lw	t2, 1916(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1912(sp)
	lw	t2, 1912(sp)
	addi	t1, t2, 16
	sw	t1, 1924(sp)
	lw	t2, 1924(sp)
	mv	t1, t2
	sw	t1, 1920(sp)
	lw	t2, 1920(sp)
	lw	t1, 0(t2)
	sw	t1, 1928(sp)
	lw	t2, 1928(sp)
	addi	t1, t2, 4
	sw	t1, 1936(sp)
	lw	t2, 1936(sp)
	mv	t1, t2
	sw	t1, 1932(sp)
	lw	t2, 1932(sp)
	lw	t1, 0(t2)
	sw	t1, 1940(sp)
	lw	t2, 1908(sp)
	lw	t3, 1940(sp)
	add	t1, t2, t3
	sw	t1, 1944(sp)
	lw	t1, 20(sp)
	sw	t1, 1948(sp)
	lw	t2, 1944(sp)
	lw	t3, 1948(sp)
	xor	t1, t2, t3
	sw	t1, 1956(sp)
	lw	t2, 1956(sp)
	seqz	t1, t2
	sb	t1, 1952(sp)
	lb	t2, 1952(sp)
	mv	t1, t2
	sb	t1, 1960(sp)
	j	lg.exit8
lg.exit8:
	lb	t2, 1960(sp)
	bne	t2, zero, lg.nocut9
	j	mid9
lg.nocut9:
	lui	t1, %hi(make)
	sw	t1, 1968(sp)
	lw	t2, 1968(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1964(sp)
	lw	t2, 1964(sp)
	mv	t1, t2
	sw	t1, 1976(sp)
	lw	t2, 1976(sp)
	mv	t1, t2
	sw	t1, 1972(sp)
	lw	t2, 1972(sp)
	lw	t1, 0(t2)
	sw	t1, 1980(sp)
	lw	t2, 1980(sp)
	addi	t1, t2, 8
	sw	t1, 1988(sp)
	lw	t2, 1988(sp)
	mv	t1, t2
	sw	t1, 1984(sp)
	lw	t2, 1984(sp)
	lw	t1, 0(t2)
	sw	t1, 1992(sp)
	lui	t1, %hi(make)
	sw	t1, 2000(sp)
	lw	t2, 2000(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 1996(sp)
	lw	t2, 1996(sp)
	addi	t1, t2, 8
	sw	t1, 2008(sp)
	lw	t2, 2008(sp)
	mv	t1, t2
	sw	t1, 2004(sp)
	lw	t2, 2004(sp)
	lw	t1, 0(t2)
	sw	t1, 2012(sp)
	lw	t2, 2012(sp)
	addi	t1, t2, 8
	sw	t1, 2020(sp)
	lw	t2, 2020(sp)
	mv	t1, t2
	sw	t1, 2016(sp)
	lw	t2, 2016(sp)
	lw	t1, 0(t2)
	sw	t1, 2024(sp)
	lw	t2, 1992(sp)
	lw	t3, 2024(sp)
	add	t1, t2, t3
	sw	t1, 2028(sp)
	lui	t1, %hi(make)
	sw	t1, 2036(sp)
	lw	t2, 2036(sp)
	lw	t1, %lo(make)(t2)
	sw	t1, 2032(sp)
	lw	t2, 2032(sp)
	addi	t1, t2, 16
	sw	t1, 2044(sp)
	lw	t2, 2044(sp)
	mv	t1, t2
	sw	t1, 2040(sp)
	lw	t2, 2040(sp)
	lw	t1, 0(t2)
	li	s1, 2048
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2048
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 8
	li	s1, 2056
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2056
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2052
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2052
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2060
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t2, 2028(sp)
	li	s1, 2060
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2064
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t1, 20(sp)
	li	s1, 2068
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2064
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2068
	add	s1, s1, sp
	lw	t3, 0(s1)
	xor	t1, t2, t3
	li	s1, 2076
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2076
	add	s1, s1, sp
	lw	t2, 0(s1)
	seqz	t1, t2
	li	s1, 2072
	add	s1, s1, sp
	sb	t1, 0(s1)
	li	s1, 2072
	add	s1, s1, sp
	lb	t2, 0(s1)
	mv	t1, t2
	li	s1, 2080
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit9
lg.exit9:
	li	s1, 2080
	add	s1, s1, sp
	lb	t2, 0(s1)
	bne	t2, zero, lg.nocut10
	j	mid10
lg.nocut10:
	lui	t1, %hi(make)
	li	s1, 2088
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2088
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2084
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2084
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2096
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2096
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2092
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2092
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2100
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2100
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2108
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2108
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2104
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2104
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2112
	add	s1, s1, sp
	sw	t1, 0(s1)
	lui	t1, %hi(make)
	li	s1, 2120
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2120
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2116
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2116
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 8
	li	s1, 2128
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2128
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2124
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2124
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2132
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2132
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 4
	li	s1, 2140
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2140
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2136
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2136
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2144
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2112
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2144
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2148
	add	s1, s1, sp
	sw	t1, 0(s1)
	lui	t1, %hi(make)
	li	s1, 2156
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2156
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2152
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2152
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 16
	li	s1, 2164
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2164
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2160
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2160
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2168
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2168
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 8
	li	s1, 2176
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2176
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2172
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2172
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2180
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2148
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2180
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2184
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t1, 20(sp)
	li	s1, 2188
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2184
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2188
	add	s1, s1, sp
	lw	t3, 0(s1)
	xor	t1, t2, t3
	li	s1, 2196
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2196
	add	s1, s1, sp
	lw	t2, 0(s1)
	seqz	t1, t2
	li	s1, 2192
	add	s1, s1, sp
	sb	t1, 0(s1)
	li	s1, 2192
	add	s1, s1, sp
	lb	t2, 0(s1)
	mv	t1, t2
	li	s1, 2200
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit10
lg.exit10:
	li	s1, 2200
	add	s1, s1, sp
	lb	t2, 0(s1)
	bne	t2, zero, lg.nocut11
	j	mid11
lg.nocut11:
	lui	t1, %hi(make)
	li	s1, 2208
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2208
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2204
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2204
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 16
	li	s1, 2216
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2216
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2212
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2212
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2220
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2220
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2228
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2228
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2224
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2224
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2232
	add	s1, s1, sp
	sw	t1, 0(s1)
	lui	t1, %hi(make)
	li	s1, 2240
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2240
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2236
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2236
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 8
	li	s1, 2248
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2248
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2244
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2244
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2252
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2252
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 4
	li	s1, 2260
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2260
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2256
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2256
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2264
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2232
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2264
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2268
	add	s1, s1, sp
	sw	t1, 0(s1)
	lui	t1, %hi(make)
	li	s1, 2276
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2276
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2272
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2272
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2284
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2284
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2280
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2280
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2288
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2288
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 8
	li	s1, 2296
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2296
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2292
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2292
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2300
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2268
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2300
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2304
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t1, 20(sp)
	li	s1, 2308
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2304
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2308
	add	s1, s1, sp
	lw	t3, 0(s1)
	xor	t1, t2, t3
	li	s1, 2316
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2316
	add	s1, s1, sp
	lw	t2, 0(s1)
	seqz	t1, t2
	li	s1, 2312
	add	s1, s1, sp
	sb	t1, 0(s1)
	li	s1, 2312
	add	s1, s1, sp
	lb	t2, 0(s1)
	mv	t1, t2
	li	s1, 2320
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit11
lg.exit11:
	li	s1, 2320
	add	s1, s1, sp
	lb	t2, 0(s1)
	bne	t2, zero, if.true7
	j	if.false7
for.cond3:
	lw	t1, 16(sp)
	li	s1, 2324
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	t1, 2
	li	s1, 2328
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2328
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2324
	add	s1, s1, sp
	lw	t3, 0(s1)
	bge	t2, t3, for.body3
	j	for.exit3
for.incr3:
	lw	t1, 16(sp)
	li	s1, 2332
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2332
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 1
	li	s1, 2336
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2336
	add	s1, s1, sp
	lw	t3, 0(s1)
	sw	t3, 16(sp)
	j	for.cond3
for.body3:
	lw	t1, 12(sp)
	li	s1, 2340
	add	s1, s1, sp
	sw	t1, 0(s1)
	sw	zero, 12(sp)
	j	for.cond4
for.exit3:
	la	t1, anon.strconst1
	li	s1, 2348
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2348
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2344
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2344
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	a0, t2
	call	print
	j	if.exit7
for.cond4:
	lw	t1, 12(sp)
	li	s1, 2352
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	t1, 2
	li	s1, 2356
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2356
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2352
	add	s1, s1, sp
	lw	t3, 0(s1)
	bge	t2, t3, for.body4
	j	for.exit4
for.incr4:
	lw	t1, 12(sp)
	li	s1, 2360
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2360
	add	s1, s1, sp
	lw	t2, 0(s1)
	addi	t1, t2, 1
	li	s1, 2364
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2364
	add	s1, s1, sp
	lw	t3, 0(s1)
	sw	t3, 12(sp)
	j	for.cond4
for.body4:
	lui	t1, %hi(make)
	li	s1, 2372
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2372
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, %lo(make)(t2)
	li	s1, 2368
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t1, 16(sp)
	li	s1, 2376
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	t1, 8
	li	s1, 2392
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2376
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2392
	add	s1, s1, sp
	lw	t3, 0(s1)
	mul	t1, t2, t3
	li	s1, 2388
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2368
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2388
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2384
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2384
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2380
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2380
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2396
	add	s1, s1, sp
	sw	t1, 0(s1)
	lw	t1, 12(sp)
	li	s1, 2400
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	t1, 4
	li	s1, 2416
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2400
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2416
	add	s1, s1, sp
	lw	t3, 0(s1)
	mul	t1, t2, t3
	li	s1, 2412
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2396
	add	s1, s1, sp
	lw	t2, 0(s1)
	li	s1, 2412
	add	s1, s1, sp
	lw	t3, 0(s1)
	add	t1, t2, t3
	li	s1, 2408
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2408
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2404
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2404
	add	s1, s1, sp
	lw	t2, 0(s1)
	lw	t1, 0(t2)
	li	s1, 2420
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2420
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	a0, t2
	call	toString
	mv	t1, a0
	li	s1, 2424
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2424
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	a0, t2
	call	print
	la	t1, anon.strconst
	li	s1, 2432
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2432
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2428
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2428
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	a0, t2
	call	print
	j	for.incr4
for.exit4:
	la	t1, anon.strconst1
	li	s1, 2440
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2440
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	t1, t2
	li	s1, 2436
	add	s1, s1, sp
	sw	t1, 0(s1)
	li	s1, 2436
	add	s1, s1, sp
	lw	t2, 0(s1)
	mv	a0, t2
	call	print
	j	for.incr3
mid:
	lb	t2, 48(sp)
	mv	t1, t2
	sb	t1, 72(sp)
	j	lg.exit
mid1:
	lb	t2, 56(sp)
	mv	t1, t2
	sb	t1, 556(sp)
	j	lg.exit3
mid2:
	lb	t2, 72(sp)
	mv	t1, t2
	sb	t1, 88(sp)
	j	lg.exit1
mid3:
	lb	t2, 88(sp)
	mv	t1, t2
	sb	t1, 264(sp)
	j	lg.exit2
mid4:
	lb	t2, 528(sp)
	mv	t1, t2
	sb	t1, 1720(sp)
	j	lg.exit6
mid5:
	lb	t2, 772(sp)
	mv	t1, t2
	sb	t1, 1224(sp)
	j	lg.exit4
mid6:
	lb	t2, 1224(sp)
	mv	t1, t2
	sb	t1, 1320(sp)
	j	lg.exit5
mid7:
	lb	t2, 1720(sp)
	mv	t1, t2
	sb	t1, 1840(sp)
	j	lg.exit7
mid8:
	lb	t2, 1840(sp)
	mv	t1, t2
	sb	t1, 1960(sp)
	j	lg.exit8
mid9:
	lb	t2, 1960(sp)
	mv	t1, t2
	li	s1, 2080
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit9
mid10:
	li	s1, 2080
	add	s1, s1, sp
	lb	t2, 0(s1)
	mv	t1, t2
	li	s1, 2200
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit10
mid11:
	li	s1, 2200
	add	s1, s1, sp
	lb	t2, 0(s1)
	mv	t1, t2
	li	s1, 2320
	add	s1, s1, sp
	sb	t1, 0(s1)
	j	lg.exit11
	.size	search, .-search
                                        # -- End function
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry14:
	addi	sp, sp, -80
	mv	t1, ra
	sw	t1, 16(sp)
	mv	t1, s0
	sw	t1, 20(sp)
	addi	s0, sp, 80
	call	_glb_init
	sw	zero, 12(sp)
	lui	t1, %hi(count)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	lw	t1, %lo(count)(t2)
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	mv	t1, t2
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	mv	t1, t2
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	lw	t1, 0(t2)
	sw	t1, 40(sp)
	lw	t2, 32(sp)
	sw	zero, 0(t2)
	li	a0, 3
	call	origin
	li	a0, 0
	li	a1, 0
	li	a2, 0
	call	search
	lui	t1, %hi(count)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t1, %lo(count)(t2)
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	mv	t1, t2
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	mv	t1, t2
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	lw	t1, 0(t2)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	mv	a0, t2
	call	println
	sw	zero, 12(sp)
	j	exit14
exit14:
	lw	t1, 12(sp)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	mv	a0, t2
	lw	t2, 16(sp)
	mv	ra, t2
	lw	t2, 20(sp)
	mv	s0, t2
	addi	sp, sp, 80
	ret
	.size	main, .-main
                                        # -- End function
	.type	make,@object
	.section	.bss
	.globl	make
make:
	.word	0
	.size	make, 4

	.type	color,@object
	.section	.bss
	.globl	color
color:
	.word	0
	.size	color, 4

	.type	count,@object
	.section	.bss
	.globl	count
count:
	.word	0
	.size	count, 4

	.type	i,@object
	.section	.bss
	.globl	i
i:
	.word	0
	.size	i, 4

	.type	j,@object
	.section	.bss
	.globl	j
j:
	.word	0
	.size	j, 4

	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	" "
	.size	anon.strconst, 1

	.type	anon.strconst1,@object
	.section	.rodata
anon.strconst1:
	.asciz	"\n"
	.size	anon.strconst1, 1

