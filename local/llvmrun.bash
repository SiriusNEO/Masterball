set -e
java -jar Masterball.jar -i test.mx -ast-o ast.out -llvm-o test.ll -debug-o log.txt
cp ../lib/builtin.ll builtin.ll
clang test.ll builtin.ll -o code
./code