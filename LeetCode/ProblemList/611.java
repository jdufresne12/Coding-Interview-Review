
/*
    611. Valid Triangle Number

    Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

    Example 1:
    Input: nums = [2,2,3,4]
    Output: 3
    Explanation: Valid combinations are: 
    2,3,4 (using the first 2)
    2,3,4 (using the second 2)
    2,2,3

    Example 2:
    Input: nums = [4,2,3,4]
    Output: 4
 */
import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        int numTriplets = 0;
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    numTriplets += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return numTriplets;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 2, 2, 3, 4 };
        System.out.println(sol.triangleNumber(nums1));

        int[] nums2 = { 4, 2, 3, 4 };
        System.out.println(sol.triangleNumber(nums2));
    }
}