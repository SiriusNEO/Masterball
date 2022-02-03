set -e
java -jar Masterball.jar -ast-o ast.out -ir-o test.ll -log-o log.txt -opt-o test-opt.ll -asm-o output.s
