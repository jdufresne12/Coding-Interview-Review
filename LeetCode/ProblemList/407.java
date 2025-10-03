
/*
 *  407. Trapping Rain Water II
    Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

    Example 1:
    Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
    Output: 4
    Explanation: After the rain, water is trapped between the blocks.
        We have two small ponds 1 and 3 units trapped.
        The total volume of water trapped is 4.

    Example 2:
    Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
    Output: 10
 */
import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // Min-heap based on height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add border cells to the heap
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { i, 0, heightMap[i][0] });
            pq.offer(new int[] { i, n - 1, heightMap[i][n - 1] });
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[] { 0, j, heightMap[0][j] });
            pq.offer(new int[] { m - 1, j, heightMap[m - 1][j] });
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // If neighbor is lower, water can be trapped
                    totalWater += Math.max(0, h - heightMap[nx][ny]);

                    // Update boundary: max of current cell height and neighbor height
                    pq.offer(new int[] { nx, ny, Math.max(heightMap[nx][ny], h) });
                }
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] heightMap = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        System.out.println(sol.trapRainWater(heightMap));
    }
}
