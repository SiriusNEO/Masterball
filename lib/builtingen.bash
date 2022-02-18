set -e
clang -emit-llvm -S builtin.c -o builtin.ll --target=riscv32 -Ofast
llc builtin.ll -o builtin.s --march=riscv32 --mattr=+m -O3