/*
    You are given an integer array nums of length n.

    An array is trionic if there exist indices 0 < p < q < n − 1 such that:

    nums[0...p] is strictly increasing,
    nums[p...q] is strictly decreasing,
    nums[q...n − 1] is strictly increasing.
    Return true if nums is trionic, otherwise return false.
 */

class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length - 1;

        if (n < 3)
            return false;

        for (int p = 1; p < n - 1; p++) {
            if (isIncreasing(nums, 0, p)) {
                for (int q = p + 1; q < n; q++) {
                    if (isDecreasing(nums, p, q) && isIncreasing(nums, q, n))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean isIncreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }

        return true;
    }

    private boolean isDecreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 5, 9, 1, 7 };
        System.out.println(sol.isTrionic(nums));
    }
}
