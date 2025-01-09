// John Dufresne 1/9/25

import java.util.ArrayList;

public class FirstUnique {
    public static int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        ArrayList<Character> used = new ArrayList<>();
    
        if(s.length() == 1) {
            return 0;
        } else {
            for(int i = 0; i < s.length(); i++) {  // Changed this line
                if(!used.contains(str[i])) {
                    used.add(str[i]);
        
                    boolean unique = true;
                    for(int j = i + 1; j < s.length(); j++) {
                        if (str[i] == str[j])
                            unique = false;
                    }
    
                    if(unique) {
                        // Also need to check characters before i
                        for(int j = 0; j < i; j++) {
                            if (str[i] == str[j]) {
                                unique = false;
                                break;
                            }
                        }
                        if(unique)
                            return i;
                    }
                }
            }
        
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "dddccdbba";

        System.out.println(firstUniqChar(s));
    }
}
