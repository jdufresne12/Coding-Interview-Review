/* John Dufresne 01/11/2024
    Display the intersection of 2 arrays
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
*/

public class Intersect_Two_Arrays {
    static int[] intersect(int[] nums1, int[] nums2) {
        int[] ans; //holds answer
        int num_matches = 0; //number of matches, intersections
        if(nums1.length < nums2.length){
            int n = nums1.length; //length of smallest array
            ans = new int[n];
            for(int i = 0; i < n; i++){
                int j = 0;
                while(j < nums2.length){ // loop through other array to find a match
                    if(nums1[i] == nums2[j]){
                        ans[num_matches] = nums1[i];
                        num_matches++;
                        nums2[j] = -1;
                        System.out.println(nums1[i]);
                        break;
                    }
                    else
                        j++;
                }
            }
            //Trims the array, if needed, so when we print we don't see unnecessary 0's
            if(num_matches == n)
                return ans;
            else{
                int[] trimmed_copy = new int[num_matches];
                System.arraycopy(ans, 0, trimmed_copy, 0, num_matches);
                return trimmed_copy;
            }
        }

        else{
            int n = nums2.length; //length of smallest array
            ans = new int[n]; 
            for(int i = 0; i < n; i++){
                int j = 0;
                while(j < nums1.length){
                    if(nums2[i] == nums1[j]){
                        ans[num_matches] = nums2[i];
                        num_matches++;
                        nums1[j] = -1;
                        break;
                    }
                    else
                        j++;
                }
            }
            //Trims the array, if needed, so when we print we don't see unnecessary 0's
            if(num_matches == n)
                return ans;
            else{
                int[] trimmed_copy = new int[num_matches];
                System.arraycopy(ans, 0, trimmed_copy, 0, num_matches);
                return trimmed_copy;
            }
        }
    }
    static void toString(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length-1)
                System.out.print(", ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};

        int[] ans = intersect(nums1, nums2);
        toString(ans);
    }
}
