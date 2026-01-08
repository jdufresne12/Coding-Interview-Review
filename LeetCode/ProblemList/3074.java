/*
 * 3074. Apple Redistribution into boxes
 * You are given an array apple of size n and an array capacity of size m.
 * There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
 * Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
 * Note that, apples from the same pack can be distributed into different boxes.
*/
import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity); 
        int sumApples = 0;
        int numBoxes = 0;

        for(int i: apple){
            sumApples += i;
        }

        for(int i = capacity.length-1; i >= 0; i--){
            if(sumApples <= 0) break;
            sumApples -= capacity[i];
            numBoxes++;
        }

        return numBoxes;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] apples = {1,3,2};
        int[] capacity = {4,3,1,5,2};
        System.out.println(sol.minimumBoxes(apples, capacity));
    }
}
