
//John Dufresne 01/06/2024
//Remove Duplicates from an int array, IN PLACE, thats already been sorted in acsending order.
//If they were not sorted i would first sort using mergesort then perform my function below.
//import java.util.Arrays; //for testing

public class RemoveDuplicates {
    public  static int removeDuplicates(int[] nums) {
        int count = 0;
        if (nums.length == 1)
            return 1;
        else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == -101)
                    break;
                if (nums[i] == nums[i + 1]) {
                    while (nums[i] == nums[i + 1]) {
                        int j = i+1, n = nums.length - 1;
                        while (j < n) {
                            nums[j] = nums[j + 1];
                            j++;
                        }
                        nums[n] = -101;
                    }
                }
                count++;
            }
        }
        // System.out.println(Arrays.toString(nums)); //for testing
        if(nums[nums.length-1] != -101)
            count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2}; // Input array
        int k = removeDuplicates(nums); // Calls your implementation
        System.out.println(k);
    }
}
