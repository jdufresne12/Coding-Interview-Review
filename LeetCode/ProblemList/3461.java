/*
 * 3461. Check If Digits Are Equal in String After Operations 1
 * You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
 * For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
 * Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
 * Return true if the final two digits in s are the same; otherwise, return false
*/

class Solution {
    public boolean hasSameDigits(String s) {
         while(s.length() > 2) {
            StringBuilder next = new StringBuilder();
            for(int i = 0; i < s.length() - 1; i++){
                int num1 = s.charAt(i);
                int num2 = s.charAt(i + 1);
                next.append((num1 + num2) % 10);
            }
            s = next.toString();
         }
         return s.charAt(0) == s.charAt(1) ? true : false;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s = "3902";
        System.out.println(sol.hasSameDigits(s));
    }
}
