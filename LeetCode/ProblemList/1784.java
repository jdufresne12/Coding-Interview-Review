/*
 * 1784. Check if Binary String has at most one segment of Ones 
 * Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.
 */

class Solution {
    public boolean checkOnesSegment(String s) {
        if (s.length() == 1)
            return true;
        return !s.contains("01");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "1001";
        System.out.println(sol.checkOnesSegment(s));
    }
}
