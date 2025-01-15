// John Dufresne 1/15/25

public class FirstBad {
    public static int firstBadVersion(int n, int bad) {
        int left = 1, right = n;

        while(left < right) {
           int mid = left + (right - left) / 2;

           if (mid <= bad ) {
                right = mid;
           }
           else {
            left = mid + 1;
           }
        }

        return left;
    }

    public static void main(String[] args) {
        int n = 5, bad = 4;

        System.out.println(firstBadVersion(n, bad));
    }
}
