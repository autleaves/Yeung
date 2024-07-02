#include <stdio.h>

int main(void) {
    char char1,char2;

    printf("Input character 1:\n");
    char1 = getchar();
    printf("Input character 2:\n");
    char2 = getchar();

    printf("Character 1 is %c\n", char1);
    printf("Character 2 is %c\n", char2);
    
    return 0;
}