
/*
    You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].
    A building is covered if there is at least one building in all four directions: left, right, above, and below.
    Return the number of covered buildings.
*/
import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // row -> [minX, maxX]
        Map<Integer, int[]> rowExtents = new HashMap<>();
        // col -> [minY, maxY]
        Map<Integer, int[]> colExtents = new HashMap<>();

        // 1) Precompute min/max for each row and column
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            // Row extents (same y, varying x)
            rowExtents.compute(y, (key, val) -> {
                if (val == null)
                    return new int[] { x, x };
                val[0] = Math.min(val[0], x); // minX
                val[1] = Math.max(val[1], x); // maxX
                return val;
            });

            // Column extents (same x, varying y)
            colExtents.compute(x, (key, val) -> {
                if (val == null)
                    return new int[] { y, y };
                val[0] = Math.min(val[0], y); // minY
                val[1] = Math.max(val[1], y); // maxY
                return val;
            });
        }

        // 2) Count covered buildings
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            int[] row = rowExtents.get(y); // [minX, maxX]
            int[] col = colExtents.get(x); // [minY, maxY]

            boolean hasLeft = x > row[0];
            boolean hasRight = x < row[1];
            boolean hasAbove = y > col[0];
            boolean hasBelow = y < col[1];

            if (hasLeft && hasRight && hasAbove && hasBelow) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] buildings = { { 1, 2 }, { 2, 2 }, { 3, 2 }, { 2, 1 }, { 2, 3 } };
        System.out.println(sol.countCoveredBuildings(3, buildings));
    }
}
