/* John Dufresne 1/17/24
 *  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * 
 *  Input: nums = [1,2,3,1]
    Output: true

    I used a merge sort to first sort items together, also checking if we compare 2 of the same numbers while sorting for optimized runtime.
    If not caught we still iteratively check the entire array for duplicates. 
 */

public class ContainsDuplicate{
    public int merge(int[] arr, int left, int middle, int right){
        int n1 = middle - left+1;
        int n2 = right - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left, flag= 0;
        
        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }
            else if(L[i] > R[j]){
                arr[k] = R[j];
                j++;
            }
            else{
                arr[k] = R[j];
                arr[++k] = L[i];
                i++;
                j++;
                flag = 1;
            }
            k++;
        }
        while(i < n1){
            arr[k] = L[i]; 
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j]; 
            j++;
            k++;
        }
        return flag;
    }

    public int sort(int[] nums, int left, int right){
        int flag = 0;
        if(left < right){
            int middle = left + (right - left)/2;
            sort(nums, left, middle);
            sort(nums, middle+1, right);
            int f = merge(nums, left, middle, right);
            if(f == 1)
                flag = 1;
        }
        return flag;
    }

    public boolean containsDuplicate(int[] nums){
        int ans = sort(nums, 0, nums.length-1);
        printArray(nums);
        if(ans == 1)
            return true;
        else{
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] == nums[i+1]) return true;
            }
            return false; 
        }       
    }
    static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }  
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {399,811,-220,962,-527,-690,-830,-639,-690,-524,349,-522,-975,-6,703,207,-626,-461,-422,-991,-701,-141,95,-243};
        ContainsDuplicate ex = new ContainsDuplicate();
        System.out.println(ex.containsDuplicate(nums));
    }
}