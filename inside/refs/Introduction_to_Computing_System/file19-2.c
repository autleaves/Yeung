#include <stdio.h>
#define TOTAL_FLIGHTS 100

struct flight_type
{
    char ID[3];
    short altitude;
    short longitude;
    short latitude;
    short heading;
    double air_speed;
};
typedef struct flight_type Flight;

double air_distance(Flight * aircraftA, Flight * aircraftB) {
    // return distance;
}

int main() {
    printf("size of struct flight_type = %d\n", sizeof(Flight));
    return 0;
}
