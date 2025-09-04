#include <stdio.h>
#include <stdlib.h>

/*
    You are given three integers x, y, and z, representing the positions of three people on a number line:

    x is the position of Person 1.
    y is the position of Person 2.
    z is the position of Person 3, who does not move.
    Both Person 1 and Person 2 move toward Person 3 at the same speed.

    Determine which person reaches Person 3 first:

    Return 1 if Person 1 arrives first.
    Return 2 if Person 2 arrives first.
    Return 0 if both arrive at the same time.
    Return the result accordingly.
*/

int findClosest(int x, int y, int z)
{
    int xDiff = abs(x - z);
    int yDiff = abs(y - z);

    return (xDiff < yDiff)   ? 1
           : (xDiff > yDiff) ? 2
                             : 0;
}

int main()
{
    int x = findClosest(2, 5, 6);
    printf("%d\n", x);

    return 0;
}
