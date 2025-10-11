/*
    3186. Maximum Total Damage With Spell Casting

    A magician has various spells.
    You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.
    It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.
    Each spell can be cast only once.
    Return the maximum possible total damage that a magician can cast.

    Example 1:
    Input: power = [1,1,3,4]
    Output: 6
    Explanation:
        The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.

    Example 2:
    Input: power = [7,1,6,6]
    Output: 13
    Explanation:
        The maximum possible damage of 13 is produced by casting spells 1, 2, 3 with damage 1, 6, 6.
*/
import java.util.*;
class Solution{
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);

        int n = unique.size();
        long[] dp = new long[n];

        // Base case
        dp[0] = (long) unique.get(0) * freq.get(unique.get(0));

        // Step 3: DP iteration
        for (int i = 1; i < n; i++) {
            int val = unique.get(i);
            long include = (long) val * freq.get(val); // always safe

            // Find last index j such that unique[j] < val - 2
            int j = binarySearch(unique, i - 1, val - 3);
            if (j >= 0) include += dp[j];

            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

     private int binarySearch(List<Integer> arr, int hi, int limit) {
        int lo = 0, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) <= limit) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] power = {1,1,3,4};
        System.out.println(sol.maximumTotalDamage(power));
    }
}
