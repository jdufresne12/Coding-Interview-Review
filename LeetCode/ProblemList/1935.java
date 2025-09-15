/*
    1935. Maximum Number of Words You Can Type
    There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

    Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

    Example 1:
    Input: text = "hello world", brokenLetters = "ad"
    Output: 1
    Explanation: We cannot type "world" because the 'd' key is broken.
    
    Example 2:
    Input: text = "leet code", brokenLetters = "lt"
    Output: 1
    Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
    
    Example 3:
    Input: text = "leet code", brokenLetters = "e"
    Output: 0
    Explanation: We cannot type either word because the 'e' key is broken.
 */
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int canBeTyped = 0;

        for (String word : words) {
            boolean canTypeWord = true;
            for (int i = 0; i < brokenLetters.length(); i++) {
                if (word.contains(brokenLetters.charAt(i) + "")) {
                    canTypeWord = false;
                    break;
                }
            }

            if (canTypeWord)
                canBeTyped++;
        }

        return canBeTyped;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canBeTypedWords("hello world", "ad")); // 1
        System.out.println(s.canBeTypedWords("leet code", "lt")); // 1
        System.out.println(s.canBeTypedWords("leet code", "e")); // 0
    }
}