// John Dufresne 1/10/25

public class Palindrome {
    public static boolean isPalindrome(String s) {
        // Convert to lowercase and remove non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Determines if character is a number
    public static boolean isNumber(char letter) {
        if((int) letter > 47 && (int) letter < 58)
            return true;
        return false;
    }


    // Determines if character is a letter 
    public static boolean isLetter(char letter){
        if((int) letter > 64 && (int) letter < 91)
            return true;
        else if((int) letter > 96 && (int) letter < 123)
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "race car";

        System.out.println(isPalindrome(s));
    }
}
