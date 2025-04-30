/*
    Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

    A subarray is defined as a contiguous sequence of numbers in an array.

    A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
 */
public class MaxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int currentSum = 0;
        int maxSum = 0;
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prev) {
                currentSum += nums[i];
                if (maxSum < currentSum)
                    maxSum = currentSum;
            } else
                currentSum = nums[i];

            prev = nums[i];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxAscendingSum solution = new MaxAscendingSum();
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        System.out.println(solution.maxAscendingSum(nums));
    }
}
