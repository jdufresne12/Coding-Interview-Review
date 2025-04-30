class RemoveElement {
    public int removeElement(int[] nums, int val) { 
        int left = 0;
        int right = nums.length-1;
        int numVal = 0;
        
        while(nums[right] == val){
            nums[right] = -1;
            right--;
            numVal++;
        }

        while(left <= right) {
            if(nums[left] == val){
                nums[left] = nums[right];
                nums[right] = -1;
                right--;
                numVal++;
            }
            left++;
        }

        // printArray(nums);

        return numVal;
    }

    public void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(solution.removeElement(nums, val));
    }
}
