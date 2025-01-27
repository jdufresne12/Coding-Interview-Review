// John Dufresne - Driver class for dynamic programming section

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
            Input: n = 2
            Output: 2
            Explanation: There are two ways to climb to the top.
            1. 1 step + 1 step
            2. 2 steps
         */
        int n = 4;
        System.out.println(solution.climbStairs(n));

         //-----------------------------------------------------------------------------
    }
}
