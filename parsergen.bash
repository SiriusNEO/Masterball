set -e
cp src/masterball/grammar/MxStar.g4 src/masterball/compiler/frontend/parser/ 
antlr4 src/masterball/compiler/frontend/parser/MxStar.g4 -visitor
rm src/masterball/compiler/frontend/parser/MxStar.g4
