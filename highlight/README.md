

a simple syntax-only highlight for MxStar language in IntelliJ IDEA.

### Usage

run `name_gen.py` first.

in IntelliJ IDEA, `File-Settings-File Types`

in `Recognized File Types`, click add button to register your MxStar file pattern.

Set basic syntax highlighting.

paste Keyword 1~4 into IDEA.



### Basic Syntax Highlighting

Line comments: `//`

Block comments start: `/*`

Block comments end: `*/`

Hex prefix: `0x`

Support XXX: click Yes



### Name Highlight Support

all name are letters (a-z, A-Z). support:

- builtin-function names
- Var/Function Name: all lower case, name length in 1~3
- Class Name: start with upper case, name length in 1~3
- some frequently used names.



