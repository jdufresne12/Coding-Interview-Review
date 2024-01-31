/*
    John Dufresne 1/30/24
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in 
    left-to-right order. The large integer does not contain any leading 0's. Increment the large integer by one and return the resulting array of digits.

    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].

    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].
 */

import java.util.Arrays;

public class PlusOne{
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len-1] != 9){
            digits[len-1] += 1;
            return digits;
        }
        else if(digits[0] != 9){
            for(int i = len-1; i >= 0; i++){
                if(digits[i] != 9){
                    digits[i] += 1;
                    return digits;
                } 
                else
                    digits[i] = 0;
            }
            return digits;
        }
        else{
            int new_digits[] = Arrays.copyOf(digits, digits.length+1);
            for(int i = len-1; i >= 0; i++){
                if(new_digits[i] != 9){
                    new_digits[i] += 1;
                    return new_digits;
                } 
                else
                    new_digits[i] = 0;
            }
            return new_digits;
        }
    }
    public static void toString(int[] digits){
        System.out.print("[");
        for(int i = 0; i < digits.length; i++){
            if(i == digits.length - 1)
                System.out.print(digits[i]);
            else
                System.out.print(digits[i] + ",");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        int digits[] = {1,9};
        int new_digits[] = Arrays.copyOf(digits, digits.length+1);
        
        // toString(new_digits);
        toString(plusOne(digits));
    }
}