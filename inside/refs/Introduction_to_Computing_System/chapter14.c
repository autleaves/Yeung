#include <stdio.h>

int squared(int x);

int main(void) {
    int maxC;

    printf("Enter the maximum length of hypotenuse:");
    scanf("%d", &maxC);
    for (int sideC = 1; sideC <= maxC; sideC++) {
        for (int sideB = 1; sideB <= maxC; sideB++) {
            for (int sideA = 1; sideA <= maxC; sideA++) {
                /* code */
                if (squared(sideC) == squared(sideA) + squared(sideB))
                {
                    /* code */
                    printf("%d %d %d\n", sideA, sideB, sideC);
                }
                
            }
            
        }
        
        
    }
    
    

    return 0;
}

int squared(int x) {
    return x * x;
}