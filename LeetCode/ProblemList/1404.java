/*
    Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
        - If the current number is even, you have to divide it by 2.
        - If the current number is odd, you have to add 1 to it.
    It is guaranteed that you can always reach one for all test cases.
 */

class Solution {
    public int numSteps(String s) {
        if (s.length() == 1)
            return 0;

        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 1 || sb.charAt(0) != '1') {
            int lastIndex = sb.length() - 1;

            if (sb.charAt(lastIndex) == '0')
                sb.deleteCharAt(lastIndex);
            else
                addOne(sb);
            steps++;
        }

        return steps;
    }

    private void addOne(StringBuilder sb) {
        int carry = 1;

        for (int i = sb.length() - 1; i >= 0 && carry == 1; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                carry = 0;
            } else {
                sb.setCharAt(i, '0');
            }
        }
        if (carry == 1)
            sb.insert(0, '1');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "1111110011101010110011100100101110010100101110111010111110110010";
        System.out.println(sol.numSteps(s));
    }
}