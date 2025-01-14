public class StringString {
    public static int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty())
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if(match)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "butsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
    }
}
