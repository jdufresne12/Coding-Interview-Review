// Input: n = 10
// Output: 182
// Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
// - 1 since 1 * 1 = 1
// - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
// - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
// Hence, the punishment number of 10 is 1 + 81 + 100 = 182

class PunishmentNumber {
    private static boolean isValidPartition(String squaredStr, int target, int index, int currentSum) {
        if (index == squaredStr.length()) {
            return currentSum == target;
        }

        int num = 0;
        for (int j = index; j < squaredStr.length(); j++) {
            num = num * 10 + (squaredStr.charAt(j) - '0');
            if (currentSum + num > target) {
                break;
            }
            if (isValidPartition(squaredStr, target, j + 1, currentSum + num)) {
                return true;
            }
        }
        return false;
    }

    public static int punishmentNumber(int n) {
        int totalSum = 0;

        for (int i = 1; i <= n; i++) {
            int squared = i * i;
            String squaredStr = String.valueOf(squared);

            if (isValidPartition(squaredStr, i, 0, 0)) {
                totalSum += squared;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int n = 10;
        PunishmentNumber solution = new PunishmentNumber();

        System.out.println(solution.punishmentNumber(n));
    }
}