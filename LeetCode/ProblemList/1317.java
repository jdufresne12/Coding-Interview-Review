/*
    No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

    Given an integer n, return a list of two integers [a, b] where:

    a and b are No-Zero integers.
    a + b = n

    Example 1:
    Input: n = 2
    Output: [1,1]
    Explanation: Let a = 1 and b = 1.
    Both a and b are no-zero integers, and a + b = 2 = n.

    Example 2:
    Input: n = 11
    Output: [2,9]
    Explanation: Let a = 2 and b = 9.
    Both a and b are no-zero integers, and a + b = 11 = n.
    Note that there are other valid answers as [8, 3] that can be accepted.
 */
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        int a, b;

        for (int i = 1; i < n; i++) {
            a = i;
            b = n - a;
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")) {
                res[0] = a;
                res[1] = b;
                break;
            }
        }

        return res;
    }

    public void printArray(int[] ans) {
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 20;

        sol.printArray(sol.getNoZeroIntegers(n));
    }
}