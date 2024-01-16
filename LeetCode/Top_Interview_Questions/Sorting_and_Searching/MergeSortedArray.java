
/* John Dufresne 01/15/2024
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
*/
public class MergeSortedArray{
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0)
            System.arraycopy(nums2, 0, nums1, 0, n);
        else if(n != 0){
            int i = 0, j = 0, k = 0;
            int[] temp = new int[m+n];
            while(i < m && j < n){
                if(nums1[i] < nums2[j]){
                    temp[k] = nums1[i];
                    i++;
                }
                else{
                    temp[k] = nums2[j];
                    j++;
                }
                k++;
            }
            while(i < m){
                temp[k] = nums1[i];
                i++;
                k++;
            }
            while(j < n){
                temp[k] = nums2[j];
                j++;
                k++;
            }
            System.arraycopy(temp, 0, nums1, 0, m+n);
        }
    } 
    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        printArray(nums1);
    }
}