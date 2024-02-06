/*
    John Dufresne

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Input: nums = [0]
    Output: [0]
*/ 

public class MoveZeroes{
    public static void moveZeroes(int[] nums) {
        int size = nums.length-1;
        int i = 0;
        while(i < size){
            if(nums[i] != 0)
                i++;
            else{
                for(int j = i; j < size; j++){
                    nums[j] = nums[j+1];
                    nums[j+1] = 0;
                }
                --size;
            }
        }
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
        int nums[] = {0};
        moveZeroes(nums);
        toString(nums);

    }
}