/*
  1488. Avoid Flood in The City
   Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.

  Given an integer array rains where:

  rains[i] > 0 means there will be rains over the rains[i] lake.
  rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
  Return an array ans where:

  ans.length == rains.length
  ans[i] == -1 if rains[i] > 0.
  ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
  If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.

  Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.


  Example 1:

  Input: rains = [1,2,3,4]
  Output: [-1,-1,-1,-1]
  Explanation: After the first day full lakes are [1]
  After the second day full lakes are [1,2]
  After the third day full lakes are [1,2,3]
  After the fourth day full lakes are [1,2,3,4]
  There's no day to dry any lake and there is no flood in any lake.
*/

import java.util.*;

class Solution {
  public int[] avoidFlood(int[] rains) {
    int ans[] = new int[rains.length];
    
    Map<Integer, Integer> lakeFull = new HashMap<>();
    TreeSet<Integer> dryDays = new TreeSet<>();

     for (int i = 0; i < rains.length; i++) {
      if (rains[i] > 0) {
        int lake = rains[i];
        ans[i] = -1; // raining day

        if (lakeFull.containsKey(lake)) {
          // find the earliest dry day after last fill
          Integer dryDay = dryDays.higher(lakeFull.get(lake));
          if (dryDay == null) {
            return new int[0]; // impossible, flood
          }
          ans[dryDay] = lake; // dry this lake
          dryDays.remove(dryDay);
        }

        lakeFull.put(lake, i); // mark lake as full
      } else {
        ans[i] = 1; // default, will replace later if needed
        dryDays.add(i);
      }
    }
    return ans;
  }

  private static void print(int[] ans) {
    for(int i: ans){
      System.out.print(i);
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] rains = {1,2,3,4};
    print(sol.avoidFlood(rains));
  }
}
