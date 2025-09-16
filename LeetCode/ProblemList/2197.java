import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();

        for (int num : nums) {
            long current = num;

            // Merge with stack top while gcd > 1
            while (!stack.isEmpty()) {
                long top = stack.peek();
                long g = gcd(top, current);
                if (g == 1)
                    break; // coprime → stop merging
                current = lcm(top, current, g); // merge
                stack.pop(); // remove old top
            }

            stack.push(current);
        }

        // Convert back to list of integers
        List<Integer> result = new ArrayList<>();
        for (long val : stack) {
            result.add((int) val); // safe since problem guarantees ≤ 1e8
        }
        return result;
    }

    // GCD using Euclidean algorithm
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // LCM using gcd
    private static long lcm(long a, long b, long g) {
        return (a / g) * b;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 6, 4, 3, 2, 7, 6, 2 };
        System.out.println(sol.replaceNonCoprimes(nums1)); // [12, 7, 6]

        int[] nums2 = { 2, 2, 1, 1, 3, 3, 3 };
        System.out.println(sol.replaceNonCoprimes(nums2)); // [2, 1, 1, 3]
    }
}
