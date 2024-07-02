#include<stdio.h>

#define MAX_NUMS 10

int main(void) {
    int repIndex;
    int numbers[MAX_NUMS];
    int repeats[MAX_NUMS];

    printf("Enter %d numbers.\n", MAX_NUMS);
    for (int index = 0; index < MAX_NUMS; index++)
    {
        printf("Input number %d : ", index);
        scanf("%d", &numbers[index]);
    }
    for (int index = 0; index < MAX_NUMS; index++)
    {
        repeats[index] = 0;
        for (repIndex = 0; repIndex < MAX_NUMS; repIndex++)
        {
            /* code */
            if (numbers[repIndex] == numbers[index])
            {
                repeats[index]++;
            }
        }
    }
    for (int index = 0; index < MAX_NUMS; index++)
    {
        printf("Original number %d. Number of repeats %d\n", numbers[index], repeats[index]);
    }
    
    
}