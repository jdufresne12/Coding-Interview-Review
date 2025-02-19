public class SmallestDIStringNumber {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] result = new char[n + 1];
        boolean[] used = new boolean[10];
        backtrack(pattern, 0, result, used);
        return new String(result);
    }

    private boolean backtrack(String pattern, int pos, char[] result, boolean[] used) {
        if (pos == result.length) {
            return true;
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (used[digit])
                continue;

            if (pos > 0) {
                char prevChar = result[pos - 1];
                int prevDigit = prevChar - '0';

                if (pattern.charAt(pos - 1) == 'I' && digit <= prevDigit)
                    continue;
                if (pattern.charAt(pos - 1) == 'D' && digit >= prevDigit)
                    continue;
            }

            result[pos] = (char) (digit + '0');
            used[digit] = true;

            if (backtrack(pattern, pos + 1, result, used)) {
                return true;
            }
            used[digit] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        SmallestDIStringNumber solution = new SmallestDIStringNumber();

        System.out.println(solution.smallestNumber(pattern));
    }
}
