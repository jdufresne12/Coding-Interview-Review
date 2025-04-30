import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HappyStrings {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(n, "", happyStrings);

        Collections.sort(happyStrings);

        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }

    private void generateHappyStrings(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (char c : new char[] { 'a', 'b', 'c' }) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                generateHappyStrings(n, current + c, result);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        HappyStrings solution = new HappyStrings();

        System.out.println(solution.getHappyString(n, k));
    }
}
