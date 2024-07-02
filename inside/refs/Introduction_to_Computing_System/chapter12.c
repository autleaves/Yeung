#include<stdio.h>

int global_var = 2;

int main(void) {
    
    /* Prime Numbers */
    int numOfTerms;
    double pi = 0;

    printf("Number of terms(must be 1 or larger):");
    scanf("%d", &numOfTerms);

    for(int count=1; count<=numOfTerms; count++) {
    if (count % 2){
        pi = pi + (4.0 / (2.0 * count - 1));    // odd
    } else {
        pi = pi - (4.0 / (2.0 * count - 1));    //even
    }
    }
    printf("pi = %f\n", pi); 

    // int local_var = 3;
    // printf("global_var = %d, local_var = %d\n", global_var, local_var);
    // {
    //     int local_var = 4;
    //     printf("global_var = %d, local_var = %d\n", global_var, local_var);
    // }
    // printf("global_var = %d, local_var = %d\n", global_var, local_var);
    // int object;
    // int *ptr; 

    // object = 4;
    // ptr = &object;
    // *ptr = *ptr + 1;

    // printf("object = %d", object);

    // _Bool prime = 1;

    // for (int num = 2; num < 100; num++)
    // {
    //     prime = 1;
    //     for (int divisor = 2; divisor <= 10; divisor++)
    //     {
    //         if (((num % divisor)==0) && (num != divisor))
    //         {
    //             prime = 0;
    //         }
    //     }
    //         if (prime) {
    //             printf("The number %d is prime\n", num);
    //         }
        
    // }
    
}