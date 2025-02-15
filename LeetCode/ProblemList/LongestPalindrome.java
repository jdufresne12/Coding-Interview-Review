public class LongestPalindrome {
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        return "";
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = "babad";

        /* TESTING ISPALINDROME FUNCTION */
        // System.out.println(solution.isPalindrome(s, 0, s.length() - 1));

        System.out.println(solution.longestPalindrome(s));
    }
}
