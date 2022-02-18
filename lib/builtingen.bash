set -e
clang -emit-llvm -S builtin.c -o builtin.ll -Ofast
llc builtin.ll -o builtin.s -O3