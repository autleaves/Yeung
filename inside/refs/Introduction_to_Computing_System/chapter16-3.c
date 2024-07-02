#include <stdio.h>
// #include <string.h>
#define MAX_STRING 20

int string_length(char string[]);
int string_generate(int);

int main(void) {
    char input[MAX_STRING];
    int length = 10;

    string_generate(length);
    // printf("Input a word (less than 20 characters): ");
    // scanf("%s", input);

    // length = string_length(input);
    // printf("The word contains %d characters\n", length);
}

int string_length(char string[]) {
    int index = 0;
    while (string[index] != '\0')
    {
        index++;
    }

    return index;
}
int string_generate(int len) {
    int data[len];
    for (int i = 0; i < len; i++)
    {
        data[i] = i+10;
        printf("data[%d]= %d\n", i, data[i]);
    }
    return 0;
}