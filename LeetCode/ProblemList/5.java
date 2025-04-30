public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // For odd length palindromes (centered at a character)
            int len1 = expandAroundCenter(s, i, i);

            // For even length palindromes (centered between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Length of palindrome = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = "bb";

        /* TESTING ISPALINDROME FUNCTION */
        // System.out.println(solution.isPalindrome(s, 0, s.length() - 1));
        // System.out.println(s.length());

        System.out.println(solution.longestPalindrome(s));
    }
}
