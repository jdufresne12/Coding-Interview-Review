/*
 * 3423. Count Partitions with Even Sum Difference
 * You are given an integer array nums of length n.
 * A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
 * Left subarray contains indices [0, i].
 * Right subarray contains indices [i + 1, n - 1].
 * Return the number of partitions where the difference between the sum of the left and right subarrays is even.
*/
class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for (int x : nums) {
            total += x;
        }

        // If total sum is odd, no partition works
        if ((total & 1L) == 1L) {
            return 0;
        }

        // Otherwise, all n-1 possible partitions work
        return nums.length - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countPartitions(new int[]{10, 10, 3, 7, 6})); // 4
        System.out.println(sol.countPartitions(new int[]{1, 2, 2}));         // 0
        System.out.println(sol.countPartitions(new int[]{2, 4, 6, 8}));      // 3
    }
}
