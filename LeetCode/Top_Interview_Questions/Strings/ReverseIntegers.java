// John Dufresne 1/8/25

public class ReverseIntegers {
    public static int reverse(int x) {
        long reversed = 0;
        
        while (x != 0) {
            int digit = x % 10;  // Get last digit
            reversed = reversed * 10 + digit;  // Add digit to reversed
            x = x / 10;  // Remove last digit from x
        }
        
        
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int)reversed;
    }

    public static void main(String[] args) {
        int x = -123;

        System.out.println(reverse(x));
    }
}
