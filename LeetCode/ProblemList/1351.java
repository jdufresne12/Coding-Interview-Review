/*
 * 1351. Count Negative Numbers in a sorted Matrix 
 *
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid.length-1 , m = grid[0].length-1;

        for(int i = n; i >= 0; i--){
            int j = m;
            while(j >= 0 && grid[i][j] < 0){
                count++;
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(sol.countNegatives(grid));
    }
}
