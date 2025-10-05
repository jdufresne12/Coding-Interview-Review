/*
 * 417. Pacific Atlantic water flow
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

  The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

  The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

  Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
*/

import java.util.*;

class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        m = heights.length;
        n = heights[0].length;
        
        // Track which cells can reach each ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from Pacific Ocean borders (top and left edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);  // Left edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);  // Top edge
        }
        
        // Start DFS from Atlantic Ocean borders (bottom and right edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);  // Right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j);  // Bottom edge
        }
        
        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] canReach, int row, int col) {
        // Mark this cell as reachable
        canReach[row][col] = true;
        
        // Explore all 4 directions
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check boundaries
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            }
            
            // Skip if already visited
            if (canReach[newRow][newCol]) {
                continue;
            }
            
            // Water can flow from newCell to current cell if newCell's height >= current height
            // So we can reach newCell from current cell if newCell's height >= current height
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, canReach, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
      System.out.println(sol.pacificAtlantic(heights));
    }
}
