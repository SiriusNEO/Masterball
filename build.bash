set ff=UNIX
set -e
mkdir -p "out"
find ./src -name "*.java"|javac -d out -cp /ulib/java/antlr-4.7.2-complete.jar:. @/dev/stdin
