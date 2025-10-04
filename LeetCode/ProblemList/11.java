// 11. Container With Most Water
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int amount = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(amount, max);

            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(solution.maxArea(heights));
    }
}
