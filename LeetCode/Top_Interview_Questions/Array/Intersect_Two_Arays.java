/* John Dufresne 01/11/2024
    Display the intersection of 2 arrays
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    BE BACK TO THIS
*/

public class Intersect_Two_Arays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] ans = {};
        return ans;
    }

    public static void toString(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void main(String args[]){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] ans = intersect(nums1, nums2);
        toString(ans);
    }
}
