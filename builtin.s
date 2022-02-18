	.text
	.file	"builtin.c"
	.globl	_bot_malloc             # -- Begin function _bot_malloc
	.p2align	4, 0x90
	.type	_bot_malloc,@function
_bot_malloc:                            # @_bot_malloc
	.cfi_startproc
# %bb.0:
	movslq	%edi, %rdi
	jmp	malloc                  # TAILCALL
.Lfunc_end0:
	.size	_bot_malloc, .Lfunc_end0-_bot_malloc
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_cat            # -- Begin function _bot_str_cat
	.p2align	4, 0x90
	.type	_bot_str_cat,@function
_bot_str_cat:                           # @_bot_str_cat
	.cfi_startproc
# %bb.0:
	pushq	%r15
	.cfi_def_cfa_offset 16
	pushq	%r14
	.cfi_def_cfa_offset 24
	pushq	%r12
	.cfi_def_cfa_offset 32
	pushq	%rbx
	.cfi_def_cfa_offset 40
	pushq	%rax
	.cfi_def_cfa_offset 48
	.cfi_offset %rbx, -40
	.cfi_offset %r12, -32
	.cfi_offset %r14, -24
	.cfi_offset %r15, -16
	movq	%rsi, %r14
	movq	%rdi, %r12
	callq	strlen
	movq	%rax, %r15
	movq	%r14, %rdi
	callq	strlen
	leaq	(%r15,%rax), %rdi
	addq	$1, %rdi
	callq	malloc
	movq	%rax, %rbx
	movq	%rax, %rdi
	movq	%r12, %rsi
	callq	strcpy
	movq	%rbx, %rdi
	movq	%r14, %rsi
	addq	$8, %rsp
	.cfi_def_cfa_offset 40
	popq	%rbx
	.cfi_def_cfa_offset 32
	popq	%r12
	.cfi_def_cfa_offset 24
	popq	%r14
	.cfi_def_cfa_offset 16
	popq	%r15
	.cfi_def_cfa_offset 8
	jmp	strcat                  # TAILCALL
.Lfunc_end1:
	.size	_bot_str_cat, .Lfunc_end1-_bot_str_cat
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_eq             # -- Begin function _bot_str_eq
	.p2align	4, 0x90
	.type	_bot_str_eq,@function
_bot_str_eq:                            # @_bot_str_eq
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	testl	%eax, %eax
	sete	%al
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end2:
	.size	_bot_str_eq, .Lfunc_end2-_bot_str_eq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_neq            # -- Begin function _bot_str_neq
	.p2align	4, 0x90
	.type	_bot_str_neq,@function
_bot_str_neq:                           # @_bot_str_neq
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	testl	%eax, %eax
	setne	%al
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end3:
	.size	_bot_str_neq, .Lfunc_end3-_bot_str_neq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_slt            # -- Begin function _bot_str_slt
	.p2align	4, 0x90
	.type	_bot_str_slt,@function
_bot_str_slt:                           # @_bot_str_slt
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	shrl	$31, %eax
                                        # kill: def $al killed $al killed $eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end4:
	.size	_bot_str_slt, .Lfunc_end4-_bot_str_slt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sle            # -- Begin function _bot_str_sle
	.p2align	4, 0x90
	.type	_bot_str_sle,@function
_bot_str_sle:                           # @_bot_str_sle
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	testl	%eax, %eax
	setle	%al
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end5:
	.size	_bot_str_sle, .Lfunc_end5-_bot_str_sle
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sgt            # -- Begin function _bot_str_sgt
	.p2align	4, 0x90
	.type	_bot_str_sgt,@function
_bot_str_sgt:                           # @_bot_str_sgt
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	testl	%eax, %eax
	setg	%al
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end6:
	.size	_bot_str_sgt, .Lfunc_end6-_bot_str_sgt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sge            # -- Begin function _bot_str_sge
	.p2align	4, 0x90
	.type	_bot_str_sge,@function
_bot_str_sge:                           # @_bot_str_sge
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	strcmp
	testl	%eax, %eax
	setns	%al
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end7:
	.size	_bot_str_sge, .Lfunc_end7-_bot_str_sge
	.cfi_endproc
                                        # -- End function
	.globl	print                   # -- Begin function print
	.p2align	4, 0x90
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	movq	%rdi, %rsi
	movl	$.L.str, %edi
	xorl	%eax, %eax
	jmp	printf                  # TAILCALL
.Lfunc_end8:
	.size	print, .Lfunc_end8-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	4, 0x90
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	jmp	puts                    # TAILCALL
.Lfunc_end9:
	.size	println, .Lfunc_end9-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	4, 0x90
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	movl	%edi, %esi
	movl	$.L.str.2, %edi
	xorl	%eax, %eax
	jmp	printf                  # TAILCALL
.Lfunc_end10:
	.size	printInt, .Lfunc_end10-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	4, 0x90
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	movl	%edi, %esi
	movl	$.L.str.3, %edi
	xorl	%eax, %eax
	jmp	printf                  # TAILCALL
.Lfunc_end11:
	.size	printlnInt, .Lfunc_end11-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	4, 0x90
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	pushq	%rbx
	.cfi_def_cfa_offset 16
	.cfi_offset %rbx, -16
	movl	$256, %edi              # imm = 0x100
	callq	malloc
	movq	%rax, %rbx
	movl	$.L.str, %edi
	movq	%rax, %rsi
	xorl	%eax, %eax
	callq	__isoc99_scanf
	movq	%rbx, %rax
	popq	%rbx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end12:
	.size	getString, .Lfunc_end12-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	4, 0x90
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	leaq	4(%rsp), %rsi
	movl	$.L.str.2, %edi
	xorl	%eax, %eax
	callq	__isoc99_scanf
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end13:
	.size	getInt, .Lfunc_end13-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	4, 0x90
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	pushq	%rbx
	.cfi_def_cfa_offset 24
	pushq	%rax
	.cfi_def_cfa_offset 32
	.cfi_offset %rbx, -24
	.cfi_offset %rbp, -16
	movl	%edi, %ebp
	movl	$20, %edi
	callq	malloc
	movq	%rax, %rbx
	movl	$.L.str.2, %esi
	movq	%rax, %rdi
	movl	%ebp, %edx
	xorl	%eax, %eax
	callq	sprintf
	movq	%rbx, %rax
	addq	$8, %rsp
	.cfi_def_cfa_offset 24
	popq	%rbx
	.cfi_def_cfa_offset 16
	popq	%rbp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end14:
	.size	toString, .Lfunc_end14-toString
	.cfi_endproc
                                        # -- End function
	.globl	_str_length             # -- Begin function _str_length
	.p2align	4, 0x90
	.type	_str_length,@function
_str_length:                            # @_str_length
	.cfi_startproc
# %bb.0:
	jmp	strlen                  # TAILCALL
.Lfunc_end15:
	.size	_str_length, .Lfunc_end15-_str_length
	.cfi_endproc
                                        # -- End function
	.globl	_str_substring          # -- Begin function _str_substring
	.p2align	4, 0x90
	.type	_str_substring,@function
_str_substring:                         # @_str_substring
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	pushq	%r15
	.cfi_def_cfa_offset 24
	pushq	%r14
	.cfi_def_cfa_offset 32
	pushq	%rbx
	.cfi_def_cfa_offset 40
	pushq	%rax
	.cfi_def_cfa_offset 48
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	.cfi_offset %rbp, -16
	movl	%edx, %ebx
	movl	%esi, %r15d
	movq	%rdi, %r14
	subl	%esi, %ebx
	leal	1(%rbx), %eax
	movslq	%eax, %rdi
	callq	malloc
	movq	%rax, %rbp
	movslq	%r15d, %rsi
	addq	%r14, %rsi
	movslq	%ebx, %rbx
	movq	%rax, %rdi
	movq	%rbx, %rdx
	callq	memcpy
	movb	$0, (%rbp,%rbx)
	movq	%rbp, %rax
	addq	$8, %rsp
	.cfi_def_cfa_offset 40
	popq	%rbx
	.cfi_def_cfa_offset 32
	popq	%r14
	.cfi_def_cfa_offset 24
	popq	%r15
	.cfi_def_cfa_offset 16
	popq	%rbp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end16:
	.size	_str_substring, .Lfunc_end16-_str_substring
	.cfi_endproc
                                        # -- End function
	.globl	_str_parseInt           # -- Begin function _str_parseInt
	.p2align	4, 0x90
	.type	_str_parseInt,@function
_str_parseInt:                          # @_str_parseInt
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	leaq	4(%rsp), %rdx
	movl	$.L.str.2, %esi
	xorl	%eax, %eax
	callq	__isoc99_sscanf
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end17:
	.size	_str_parseInt, .Lfunc_end17-_str_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	_str_ord                # -- Begin function _str_ord
	.p2align	4, 0x90
	.type	_str_ord,@function
_str_ord:                               # @_str_ord
	.cfi_startproc
# %bb.0:
	movslq	%esi, %rax
	movsbl	(%rdi,%rax), %eax
	retq
.Lfunc_end18:
	.size	_str_ord, .Lfunc_end18-_str_ord
	.cfi_endproc
                                        # -- End function
	.type	IO_BUFFER_SIZE,@object  # @IO_BUFFER_SIZE
	.section	.rodata,"a",@progbits
	.globl	IO_BUFFER_SIZE
	.p2align	2
IO_BUFFER_SIZE:
	.long	256                     # 0x100
	.size	IO_BUFFER_SIZE, 4

	.type	NUM_BUFFER_SIZE,@object # @NUM_BUFFER_SIZE
	.globl	NUM_BUFFER_SIZE
	.p2align	2
NUM_BUFFER_SIZE:
	.long	20                      # 0x14
	.size	NUM_BUFFER_SIZE, 4

	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

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
