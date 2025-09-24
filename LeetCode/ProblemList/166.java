
/*
    166. Fraction to Recurring Decimal
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
    If the fractional part is repeating, enclose the repeating part in parentheses.
    If multiple answers are possible, return any of them.
    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.\
    
    Example 1:
    Input: numerator = 1, denominator = 2
    Output: "0.5"

    Example 2:
    Input: numerator = 2, denominator = 1
    Output: "2"

    Example 3:
    Input: numerator = 4, denominator = 333
    Output: "0.(012)"
 */
import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        num %= den;

        if (num == 0)
            return result.toString();

        result.append(".");

        Map<Long, Integer> remainder = new HashMap<>();
        while (num != 0) {
            if (remainder.containsKey(num)) {
                int index = remainder.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            remainder.put(num, result.length());

            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.fractionToDecimal(1, 2));
        System.out.println(sol.fractionToDecimal(2, 1));
        System.out.println(sol.fractionToDecimal(4, 333));
    }
}
