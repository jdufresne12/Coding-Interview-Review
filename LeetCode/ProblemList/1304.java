
/*
    1304. Find N Unique Integers Sum up to Zero
    Given an integer n, return any array containing n unique integers such that they add up to 0.

    Example 1:
    Input: n = 5
    Output: [-7,-1,1,3,4]
    Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

    Example 2:
    Input: n = 3
    Output: [-1,0,1]

    Example 3:
    Input: n = 1
    Output: [0]
 */
import java.util.Arrays;

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        // Fill pairs (i, -i)
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        // If n is odd, add a zero
        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.sumZero(5))); // Example: [1, -1, 2, -2, 0]
        System.out.println(Arrays.toString(solution.sumZero(3))); // Example: [1, -1, 0]
        System.out.println(Arrays.toString(solution.sumZero(1))); // Example: [0]
        System.out.println(Arrays.toString(solution.sumZero(4)));
    }
}