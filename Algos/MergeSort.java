//John Dufresne - Merge Sort for reference
public class MergeSort{
    //Sort the 
    static void sort(int arr[], int left, int right){
        if(left < right){
            int middle = left + (right-left) / 2; //Find middle point of arr
            
            sort(arr, left, middle); //sort the left side of arr
            sort (arr, middle+1, right); //sort the right side of arr
            
            merge(arr, left, middle, right); //merge the sorted halves
        }
    }
    static void merge(int arr[], int left, int middle, int right){
        //Sizes of first two subarrays
        int n1 = middle - left+1;
        int n2 = right - middle;
        
        //Arrays to hold left and right halfs, and loops to fill them up.
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int l = 0; l < n1; l++)
            L[l] = arr[left + l];
        for(int r = 0; r < n2; r++)
            R[r] = arr[middle + 1 + r];
        
        int i = 0, j = 0; // Initial indexes of first and second sub-arrays
        int k = left; // Initial index of merged subarray array
        
        //Sort left and right arrays into one
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){ 
                arr[k] = L[i]; //left is less than right
                i++;
            } else{
                arr[k] = R[j]; //right is less than left
                j++;
            }
            k++;
        }

        //copy remaining elements from L[] and R[]
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
    }
    static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }  
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {15,2,56,74,3,9,20};
        System.out.print("Unsorted Array: ");
        printArray(arr);
        //call sort function sending it first index as left and last index as right 
        sort(arr, 0, arr.length-1);

        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}