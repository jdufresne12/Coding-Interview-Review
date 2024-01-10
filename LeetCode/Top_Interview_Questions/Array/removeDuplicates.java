//John Dufresne 01/06/2024
//Remove Duplicates from an int array thats alreadyb sorted in acsending order.
//If they were not sorted i would first sort using mergesort then perform my function below.
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1])
                count++;
            if(i+1 == nums.length)
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums= {1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        System.out.println(removeDuplicates(nums));
    }
}
