// John Dufresne 1/10/25
import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] sortedS = s.toCharArray();
        Arrays.sort(sortedS);
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedT);

        return Arrays.equals(sortedS, sortedT);
    } 

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
