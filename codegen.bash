set -e
java -jar Masterball.jar -ast-o ast.out -llvm-o test.ll -debug-o log.txt -rv-o output.s
