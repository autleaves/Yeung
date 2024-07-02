#include <stdio.h>

#define MAX_NUMS 10

void InsertionSort(int list[]);

int main(void) {
    int numbers[MAX_NUMS];

    printf("Enter %d numbers.\n", MAX_NUMS);
    for (int index = 0; index < MAX_NUMS; index++)
    {
        printf("Input number %d : ", index);
        scanf("%d", &numbers[index]);
    }

    InsertionSort(numbers);

    printf("\nThe input set, in ascending order:\n");
    for (int index = 0; index < MAX_NUMS; index++)
    {
        printf("%d\n", numbers[index]);
    }
}

void InsertionSort(int list[]) {
    int unsorted, sorted, unsortedItem;

    for (unsorted = 1; unsorted < MAX_NUMS; unsorted++)
    {
        unsortedItem = list[unsorted];

        for (sorted = (unsorted - 1);
             (sorted >= 0) && (list[sorted] > unsortedItem); 
             sorted--) {
            list[sorted + 1] = list[sorted];
        }
        
        list[sorted + 1] = unsortedItem;
        
    }
    

}