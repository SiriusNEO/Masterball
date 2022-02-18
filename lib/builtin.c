// extern link lib for @Masterball.

/*
declaration list:
    declare i8* @_bot_malloc(i32)
    declare i8* @_bot_str_cat(i8*, i8*)
    declare i1 @_bot_str_eq(i8*, i8*)
    declare i1 @_bot_str_neq(i8*, i8*)
    declare i1 @_bot_str_slt(i8*, i8*)
    declare i1 @_bot_str_sle(i8*, i8*)
    declare i1 @_bot_str_sgt(i8*, i8*)
    declare i1 @_bot_str_sge(i8*, i8*)
    declare void @print(i8*)
    declare void @println(i8*)
    declare void @printInt(i32)
    declare void @printlnInt(i32)
    declare i8* @getString()
    declare i32 @getInt()
    declare i8* @toString(i32)
    declare i32 @_str_length(i8*)
    declare i8* @_str_substring(i8*, i32, i32)
    declare i32 @_str_parseInt(i8*)
    declare i32 @_str_ord(i8*, i32)
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef bool i1;
typedef char i8;
typedef int i32;

/*
 *  IO_BUFFER_SIZE is the max length of string read in getString()
 *  NUM_BUFFER_SIZE is the max length of number turned to string
 * 
 *  WARNING: for performance, these arguments can be modified, but it may affect the stability  
 */

const int IO_BUFFER_SIZE = 256, NUM_BUFFER_SIZE = 20;

i8* _bot_malloc(i32 mallocSize) {
    return malloc(mallocSize);
}

i8* _bot_str_cat(i8* str1, i8* str2) {
    i8* ret = malloc(strlen(str1) + strlen(str2) + 1);
    strcpy(ret, str1);
    strcat(ret, str2);
    return ret;
}

i1 _bot_str_eq(i8* str1, i8* str2) {
    return strcmp(str1, str2) == 0;
}

i1 _bot_str_neq(i8* str1, i8* str2) {
    return strcmp(str1, str2) != 0;
}

i1 _bot_str_slt(i8* str1, i8* str2) {
    return strcmp(str1, str2) < 0;
}

i1 _bot_str_sle(i8* str1, i8* str2) {
    return strcmp(str1, str2) <= 0;
}

i1 _bot_str_sgt(i8* str1, i8* str2) {
    return strcmp(str1, str2) > 0;
}

i1 _bot_str_sge(i8* str1, i8* str2) {
    return strcmp(str1, str2) >= 0;
}

void print(i8* str) {
    printf("%s", str);
}

void println(i8* str) {
    printf("%s\n", str);
}

void printInt(i32 num) {
    printf("%d", num);
}

void printlnInt(i32 num) {
    printf("%d\n", num);
}

i8* getString() {
    i8* readBuf = malloc(IO_BUFFER_SIZE);
    scanf("%s", readBuf);
    return readBuf;
}

i32 getInt() {
    i32 ret;
    scanf("%d", &ret);
    return ret;
}

i8* toString(i32 num) {
    i8* numBuf = malloc(NUM_BUFFER_SIZE);
    sprintf(numBuf, "%d", num);
    return numBuf;
}

i32 _str_length(i8* str) {
    return strlen(str);
}

i8* _str_substring(i8* str, i32 left, i32 right) {
    i8* ret = malloc(sizeof(char) * (right - left + 1));
    memcpy(ret, str + left, right - left);
    ret[right - left] = '\0';
    return ret;
}

i32 _str_parseInt(i8* str) {
    i32 ret;
    sscanf(str, "%d", &ret);
    return ret;
}

i32 _str_ord(i8* str, int pos) {
    return str[pos];
}


