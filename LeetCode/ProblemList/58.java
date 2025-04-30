public class LastWordLength {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        if (s.length() == 1) {
            if (s == " ")
                return 0;
            else
                return 1;
        }

        int length = 0;
        int i = s.length() - 1;

        System.out.println(s);
        System.out.println(i);
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        LastWordLength solution = new LastWordLength();
        String s = "    day";

        System.out.println(solution.lengthOfLastWord(s));
    }
}
