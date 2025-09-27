
/*
    812. Largest Triangle Area
    Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.

    Example 1:
    Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
    Output: 2.00000
    Explanation: The five points are shown in the above figure. The red triangle is the largest.

    Example 2:
    Input: points = [[1,0],[0,0],[0,1]]
    Output: 0.50000
 */

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = area(points[i], points[j], points[k]);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private double area(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(
                p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1]));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println(sol.largestTriangleArea(points));
    }
}
