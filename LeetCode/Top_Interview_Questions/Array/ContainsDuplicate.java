/* John Dufresne 1/17/24
 *  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * 
 *  Input: nums = [1,2,3,1]
    Output: true
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

        int i = 0, j = 0, k = left;
        
        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }
            else if(L[i] > R[j]){
                arr[k] = R[j];
                j++;
            }
            else
                return 1;
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
        return 0;
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
        if(ans == 1)
            return true;
        else{
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] == nums[i+1]) return true;
            }
            return false; 
        }       
    }
    public static void main(String[] args) {
        int[] nums = {2,14,18,22,22};
        ContainsDuplicate ex = new ContainsDuplicate();
        System.out.println(ex.containsDuplicate(nums));
    }
}