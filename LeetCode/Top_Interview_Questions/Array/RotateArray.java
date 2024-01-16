/* John Dufresne 01/11/2024
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
    
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/

public class RotateArray {
    public static void rotateArray(int[] nums, int k){
        int size = nums.length;
        int[] temp_nums = new int[size];
        //temp_nums = nums;
        for(int i = 0; i < size; i++){
            temp_nums[(i+k) % (size)] = nums[i];
        }

        System.arraycopy(temp_nums, 0, nums, 0, size);
    }
    public static void toString(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }
    public static void main(String args[]){
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(nums, k);
        toString(nums);
    }
}
/*
 * System.out.println("1");
            if(nums.length == 1)
                break;
            int temp = nums[nums.length-1];
            for(int j = 0; j < nums.length; j++){
                System.out.println("2");
                int t = nums[j];
                nums[j] = temp;
                temp = t; 
            }
 */