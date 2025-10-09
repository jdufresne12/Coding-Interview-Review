/*
  3494. Find the minimum time to brew potions
  You are given two integer arrays, skill and mana, of length n and m, respectively.
  In a laboratory, n wizards must brew m potions in order. Each potion has a mana capacity mana[j] and must pass through all the wizards sequentially to be brewed properly. The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].
  Since the brewing process is delicate, a potion must be passed to the next wizard immediately after the current wizard completes their work. This means the timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​
  Return the minimum amount of time required for the potions to be brewed properly.

  Example 1:
  Input: skill = [1,5,2,4], mana = [5,1,4,2]
  Output: 110
 */
class Solution {
  public long minTime(int[] skill, int[] mana) {
    int n = skill.length, m = mana.length;

    // prefix sums of skills: pre[i] = sum_{k=0..i} skill[k]
    long[] pre = new long[n];
    pre[0] = skill[0];
    for (int i = 1; i < n; i++)
      pre[i] = pre[i - 1] + skill[i];

    long makespanGaps = 0; // sum of G[j] over j = 0..m-2
    for (int j = 0; j + 1 < m; j++) {
      long best = Long.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        long left = pre[i] * (long) mana[j];
        long right = (i == 0 ? 0L : pre[i - 1] * (long) mana[j + 1]);
        long delta = left - right;
        if (delta > best)
          best = delta;
      }
      makespanGaps += best; // G[j]
    }

    long totalSkill = pre[n - 1];
    long lastJobTime = totalSkill * (long) mana[m - 1];

    return makespanGaps + lastJobTime;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.minTime(new int[] { 1, 5, 2, 4 }, new int[] { 5, 1, 4, 2 })); // 110
    System.out.println(sol.minTime(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 })); // 5
    System.out.println(sol.minTime(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2 })); // 21
  }
}
