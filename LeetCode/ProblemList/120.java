/*
    120. Triangle Shortest Path Sum
    Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    Example 1:
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
    2
    3 4
    6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

    Example 2:
    Input: triangle = [[-10]]
    Output: -10
 */

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println(sol.minimumTotal(triangle));
    }
}