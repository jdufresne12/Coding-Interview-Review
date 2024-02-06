/*
 * John Dufresne 2/5/24
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //Holds the 2 numbers that sum to target
        int[] sum = new int[2];

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    sum[0] = i;
                    sum[1] = j;
                    return sum;
                }
            }
        }

        return sum;
    }
    public static void toString(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i] + ",");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;

        toString(twoSum(nums, target));
    }
}
