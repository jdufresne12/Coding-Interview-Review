// John Dufresne 1/14/25

public class StringToInt {
    public static int myAtoi(String s) {
        // Handle empty string
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Handle case where string is all whitespace
        if (i >= n) {
            return 0;
        }
        
        // Step 2: Handle signs
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        
        // Step 3: Convert digits
        long result = 0;  // Using long to handle overflow
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            // Step 4: Handle overflow cases
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int)(sign * result);
    }

    public static void main(String args[]) {
        String s = "     69aaaaa";

        System.out.println(myAtoi(s));
    }
}