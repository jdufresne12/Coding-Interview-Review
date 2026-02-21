/*
    Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.

    Recall that the number of set bits an integer has is the number of 1's present when written in binary.

    For example, 21 written in binary is 10101, which has 3 set bits.
 */

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            System.out.println(setBits);
            if (isPrime(setBits))
                count++;
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimeSetBits(6, 10));
    }
}