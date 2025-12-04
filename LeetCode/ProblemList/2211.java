/*
 * 2211. Count Collisions on Road
 * There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.

 * You are given a 0-indexed string directions of length n. directions[i] can be either 'L', 'R', or 'S' denoting whether the ith car is moving towards the left, 
 * towards the right, or staying at its current point respectively. Each moving car has the same speed.

 * The number of collisions can be calculated as follows:

 * When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
 * When a moving car collides with a stationary car, the number of collisions increases by 1.
 * After a collision, the cars involved can no longer move and will stay at the point where they collided. Other than that, cars cannot change their state or direction of motion.

 * Return the total number of collisions that will happen on the road.
*/

import java.util.*;

class Solution {
    public int countCollisions(String directions) {
        int collisions = 0;
        Stack<Character> stack = new Stack<>();

        for (char car : directions.toCharArray()) {
            if (car == 'R') {
                stack.push('R');
            } else if (car == 'L') {
                if (stack.isEmpty()) {
                    // leading L, goes off the road, no collisions
                    continue;
                } else if (stack.peek() == 'S') {
                    // L hits a stationary car
                    collisions += 1;
                    // both are now stationary, but S already on stack
                } else if (stack.peek() == 'R') {
                    // First R-L collision: +2
                    collisions += 2;
                    stack.pop(); // remove the R involved in head-on

                    // Now the result is an S at this position.
                    // Any earlier R's will collide into this S: +1 each
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collisions += 1;
                        stack.pop();
                    }
                    stack.push('S');
                }
                // if peek() == 'L', nothing happens (L behind L, same direction)
            } else { // car == 'S'
                // Any R's behind will crash into this S one by one
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    collisions += 1;
                    stack.pop();
                }
                stack.push('S');
            }
        }

        return collisions;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String directions = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        System.out.println(sol.countCollisions(directions));
    }
}
