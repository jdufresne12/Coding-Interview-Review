class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x = 1221;
        System.out.println(solution.isPalindrome(x));
    }
}
