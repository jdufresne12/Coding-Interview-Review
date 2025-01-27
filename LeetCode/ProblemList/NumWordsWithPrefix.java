// John Dufresne 1/21/2025

class NumWordsWithPrefix {
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if(word.indexOf(pref) == 0) {
                count++; 
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"leetcode","win","loops","success"};
        String pref = "code";
        System.out.println(prefixCount(words, pref));
    }
}
