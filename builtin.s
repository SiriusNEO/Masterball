	.text
	.file	"builtin.c"
	.globl	_bot_malloc             # -- Begin function _bot_malloc
	.p2align	2
	.type	_bot_malloc,@function
_bot_malloc:                            # @_bot_malloc
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	srai	a1, a0, 31
	call	malloc
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	_bot_malloc, .Lfunc_end0-_bot_malloc
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_cat            # -- Begin function _bot_str_cat
	.p2align	2
	.type	_bot_str_cat,@function
_bot_str_cat:                           # @_bot_str_cat
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	sw	a0, 16(sp)
	sw	a1, 8(sp)
	call	strlen
	lw	a2, 8(sp)
	mv	s0, a0
	mv	s1, a1
	mv	a0, a2
	call	strlen
	add	a1, s1, a1
	add	a2, s0, a0
	sltu	a0, a2, s0
	add	a1, a1, a0
	addi	a0, a2, 4
	sltu	a2, a0, a2
	add	a1, a1, a2
	call	malloc
	lw	a1, 16(sp)
	sw	a0, 0(sp)
	call	strcpy
	lw	a0, 0(sp)
	lw	a1, 8(sp)
	call	strcat
	lw	a0, 0(sp)
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end1:
	.size	_bot_str_cat, .Lfunc_end1-_bot_str_cat
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_eq             # -- Begin function _bot_str_eq
	.p2align	2
	.type	_bot_str_eq,@function
_bot_str_eq:                            # @_bot_str_eq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	_bot_str_eq, .Lfunc_end2-_bot_str_eq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_neq            # -- Begin function _bot_str_neq
	.p2align	2
	.type	_bot_str_neq,@function
_bot_str_neq:                           # @_bot_str_neq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end3:
	.size	_bot_str_neq, .Lfunc_end3-_bot_str_neq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_slt            # -- Begin function _bot_str_slt
	.p2align	2
	.type	_bot_str_slt,@function
_bot_str_slt:                           # @_bot_str_slt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	_bot_str_slt, .Lfunc_end4-_bot_str_slt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sle            # -- Begin function _bot_str_sle
	.p2align	2
	.type	_bot_str_sle,@function
_bot_str_sle:                           # @_bot_str_sle
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	_bot_str_sle, .Lfunc_end5-_bot_str_sle
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sgt            # -- Begin function _bot_str_sgt
	.p2align	2
	.type	_bot_str_sgt,@function
_bot_str_sgt:                           # @_bot_str_sgt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	sgtz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	_bot_str_sgt, .Lfunc_end6-_bot_str_sgt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sge            # -- Begin function _bot_str_sge
	.p2align	2
	.type	_bot_str_sge,@function
_bot_str_sge:                           # @_bot_str_sge
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 0(sp)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end7:
	.size	_bot_str_sge, .Lfunc_end7-_bot_str_sge
	.cfi_endproc
                                        # -- End function
	.globl	print                   # -- Begin function print
	.p2align	2
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	mv	a1, a0
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	printf
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end8:
	.size	print, .Lfunc_end8-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	2
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	mv	a1, a0
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	call	printf
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	println, .Lfunc_end9-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	2
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	mv	a1, a0
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	call	printf
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end10:
	.size	printInt, .Lfunc_end10-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	2
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	mv	a1, a0
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	call	printf
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end11:
	.size	printlnInt, .Lfunc_end11-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	2
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	addi	a0, zero, 1024
	mv	a1, zero
	call	malloc
	mv	a1, a0
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	__isoc99_scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	getString, .Lfunc_end12-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	2
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	__isoc99_scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	getInt, .Lfunc_end13-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	2
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	addi	a0, zero, 20
	mv	a1, zero
	call	malloc
	lw	a2, 8(sp)
	sw	a0, 0(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	call	sprintf
	lw	a0, 0(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	toString, .Lfunc_end14-toString
	.cfi_endproc
                                        # -- End function
	.globl	_str_length             # -- Begin function _str_length
	.p2align	2
	.type	_str_length,@function
_str_length:                            # @_str_length
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	call	strlen
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	_str_length, .Lfunc_end15-_str_length
	.cfi_endproc
                                        # -- End function
	.globl	_str_substring          # -- Begin function _str_substring
	.p2align	2
	.type	_str_substring,@function
_str_substring:                         # @_str_substring
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	.cfi_offset ra, -4
	sw	a0, 24(sp)
	sw	a1, 20(sp)
	sw	a2, 16(sp)
	sub	a0, a2, a1
	addi	a0, a0, 1
	srai	a1, a0, 31
	call	malloc
	lw	a1, 24(sp)
	lw	a2, 20(sp)
	lw	a3, 16(sp)
	sw	a0, 8(sp)
	add	a1, a1, a2
	sub	a2, a3, a2
	call	memcpy
	lw	a0, 16(sp)
	lw	a1, 20(sp)
	lw	a2, 8(sp)
	sub	a0, a0, a1
	add	a0, a2, a0
	sb	zero, 0(a0)
	lw	a0, 8(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end16:
	.size	_str_substring, .Lfunc_end16-_str_substring
	.cfi_endproc
                                        # -- End function
	.globl	_str_parseInt           # -- Begin function _str_parseInt
	.p2align	2
	.type	_str_parseInt,@function
_str_parseInt:                          # @_str_parseInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 4
	call	__isoc99_sscanf
	lw	a0, 4(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	_str_parseInt, .Lfunc_end17-_str_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	_str_ord                # -- Begin function _str_ord
	.p2align	2
	.type	_str_ord,@function
_str_ord:                               # @_str_ord
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	add	a0, a0, a1
	lb	a0, 0(a0)
	addi	sp, sp, 16
	ret
.Lfunc_end18:
	.size	_str_ord, .Lfunc_end18-_str_ord
	.cfi_endproc
                                        # -- End function
	.type	IO_BUFFER_SIZE,@object  # @IO_BUFFER_SIZE
	.section	.rodata,"a",@progbits
	.globl	IO_BUFFER_SIZE
	.p2align	2
IO_BUFFER_SIZE:
	.word	1024                    # 0x400
	.size	IO_BUFFER_SIZE, 4

	.type	NUM_BUFFER_SIZE,@object # @NUM_BUFFER_SIZE
	.globl	NUM_BUFFER_SIZE
	.p2align	2
NUM_BUFFER_SIZE:
	.word	20                      # 0x14
	.size	NUM_BUFFER_SIZE, 4

	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
