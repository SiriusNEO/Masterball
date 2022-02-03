# fileName: output.s	 compiled by @Masterball.
	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry11:
	addi	sp, sp, 0
	j	exit11
exit11:
	addi	sp, sp, 0
	ret
	.size	_glb_init, .-_glb_init
                                        # -- End function
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry12:
	addi	sp, sp, -16
	sw	ra, 4(sp)
	call	_glb_init
	sw	zero, 0(sp)
	la	a0, anon.strconst
	call	println
	j	exit12
exit12:
	lw	a0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
	.size	main, .-main
                                        # -- End function
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	"Hello"
	.size	anon.strconst, 5

