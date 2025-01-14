// John Dufresne 1/14/25
// Longest Common Prefix

public class LCP {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) 
            return "";
        if(strs.length == 1)
            return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While current string doesn't start with prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten prefix by removing last character
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
