set ff=UNIX
set -e
cat |java -cp /ulib/java/antlr-4.7.2-complete.jar:./out masterball/Masterball
