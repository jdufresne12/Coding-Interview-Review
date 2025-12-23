/*
    3512. Minimum Operations to Make Array Sum Divisible by K

    You are given an integer array nums and an integer k. You can perform the following operation any number of times:
    Select an index i and replace nums[i] with nums[i] - 1.
    Return the minimum number of operations required to make the sum of the array divisible by k.
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int num : nums)
            sum += num;
        return (int) (sum % k);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = { 3, 2, 5, 1, 7 };
        int k = 0;
        System.out.println(sol.minOperations(nums, k));
    }
}
