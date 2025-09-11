import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        char[] t = new char[s.length()];
        int vowelIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                t[i] = vowels.get(vowelIndex++);
            } else {
                t[i] = s.charAt(i);
            }
        }

        return new String(t);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "lEetcOde";

        System.out.println(sol.sortVowels(s));
    }
}
