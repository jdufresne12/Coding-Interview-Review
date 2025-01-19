// John Dufresne - Dynamic Programming Section

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
    
        int oneStepBefore = 1;    // represents ways to reach (n-1)th step
        int twoStepsBefore = 1;   // represents ways to reach (n-2)th step
        int allWays = 0;          // represents ways to reach current step
        
        for (int i = 2; i <= n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        
        return allWays;
    }
}
