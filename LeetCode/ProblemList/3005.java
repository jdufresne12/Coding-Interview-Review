
/*
    3005. Count Elements With Maximum Frequency

    You are given an array nums consisting of positive integers.
    Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
    The frequency of an element is the number of occurrences of that element in the array.

    Example 1:
    Input: nums = [1,2,2,3,1,4]
    Output: 4
    Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
    So the number of elements in the array with maximum frequency is 4.

    Example 2:
    Input: nums = [1,2,3,4,5]
    Output: 5
    Explanation: All elements of the array have a frequency of 1 which is the maximum.
    So the number of elements in the array with maximum frequency is 5.
 */
import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 1;
        int maxFreqCount = 0;

        for (Integer count : frequencies.values()) {
            if (count > maxFreq) {
                maxFreq = count;
                maxFreqCount = 1;
            } else if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        return maxFreq * maxFreqCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 2, 2, 3, 1, 4 };
        System.out.println(sol.maxFrequencyElements(nums1)); // Output: 4

        int[] nums2 = { 1, 2, 3, 4, 5 };
        System.out.println(sol.maxFrequencyElements(nums2)); // Output: 5
    }
}
