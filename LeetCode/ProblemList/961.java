/*
 * 961. N-Repeated Element in size 2N array
 * You are given an integer array nums with the following properties:
 * nums.length == 2 * n.
 * nums contains n + 1 unique elements.
 * Exactly one element of nums is repeated n times.
 * Return the element that is repeated n times.
*/
import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int nRepeat = nums.length / 2;
        int currNum = nums[0];
        int count = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(currNum == nums[i]){
                ++count;
                if(count == nRepeat){
                    if(i+1 == nums.length || nums[i+1] != currNum)
                        ans = nums[i];
                }
            } else {
                count = 1;
                currNum = nums[i];
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,2,3,3};
        System.out.println(sol.repeatedNTimes(nums));
    }
}
