#include <stdio.h>
#include <unistd.h>

int main(void) {
    printf("3>>1&4>>1=%d\n", (3>>1)&(4>>1));
    printf("3<<4|4<<3=%d\n", (3<<4)|(4<<3));
    
    
    return 0;
}