import itertools    

builtin_func_list = [
    "print",
    "println",
    "printInt",
    "printlnInt",
    "getString",
    "getInt",
    "toString",
    "size",
    "length",
    "substring",
    "parseInt",
    "ord"
]

keyword_list = [
    "bool",
    "break",
    "class",
    "continue",
    "else",
    "false",
    "for",
    "if",
    "int",
    "new",
    "null",
    "return",
    "string",
    "this",
    "true",
    "void",
    "while"
]

operator_list = [
    "!",
    "!=",
    "%",
    "&",
    "&&",
    "*",
    "+",
    "++",
    "-",
    "--",
    "/",
    "<",
    "<<",
    "<=",
    "=",
    "==",
    ">",
    ">=",
    ">>",
    "^",
    "|",
    "||",
    "~"
]

frequently_used_name = [
    "main",
    "func",
    "init",
    "test",
    "temp",
    "pointer",
    "apple",
    "sirius",
    "banana",
    "asdf",
    "block",
    "lock",
    "array",
    "buffer",
    "index",
    "book",
    "python",
    "ticket",
    "list",
    "wrong",
    "entry",
    "door",
    "water",
    "bird",
    "fuck",
    "yield",
    "field",
    "application",
    "register",
    "clang",
    "rust",
    "pear",
    "bear",
    "honey",
    "haha",
    "papa",
    "rabbit",
    "china"
]

upper_letter_set = range(ord("A"), ord("Z")+1)
lower_letter_set = range(ord("a"), ord("z")+1)


def keyword_check(name: str):
    for keyword in keyword_list:
        if name == keyword:
            return False
    return True

fp = open("Keyword1.txt", "w")
for keyword in keyword_list:
    fp.write(keyword + "\n")
fp.close()

fp = open("Keyword3.txt", "w")
for op in operator_list:
    fp.write(op + "\n")
fp.close()

fp = open("Keyword2.txt", "w")
for start in range(ord("A"), ord("Z")+1):
    for j in range(0, 3):
        for per in itertools.product(lower_letter_set, repeat=j):
            output = ""
            for i in range(len(per)):
                output += chr(per[i])
            fp.write(chr(start) + output + "\n")            
fp.close()

fp = open("Keyword4.txt", "w")
for j in range(1, 4):
    for per in itertools.product(lower_letter_set, repeat=j):
        output = ""
        for i in range(len(per)):
            output += chr(per[i])
        fp.write(output + "\n")
for name in frequently_used_name:
    fp.write(name + "\n")    
fp.close()

