set -e
clang -emit-llvm -S builtin.c -o builtin.ll
llc builtin.ll -o builtin.s