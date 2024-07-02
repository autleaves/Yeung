#include<stdio.h>

int main(void) {
    // for (int i = 0; i < 10; i++)
    // {
    //     /* code */
    //     if(i == 5)
    //         continue;;
    //     printf("%d ", i);
    // }
    int operand1, operand2;
    int result = 0;
    char operation;

    printf("Enter first operand: ");
    scanf("%d", &operand1);
    printf("Enter operation to perform (+, -, *, /): ");
    scanf("\n%c", &operation);
    printf("Enter second operand: ");
    scanf("%d", &operand2);

    switch (operation)
    {
    case '+':
        result = operand1 + operand2;
        break;
    case '-':
        result = operand1 - operand2;
        break;
    case '*':
        result = operand1 * operand2;
        break;
    case '/':
        result = operand1 / operand2;
        break;
    
    default:
        printf("Invalid operation!\n");
        break;
    }
    printf("The answer is %d\n", result);
}