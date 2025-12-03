/*
 * 1716. Calculate Money in Leetcode Bank
 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
*/

class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int prevDay = 0;
        int prevMonday = 0;

        for(int i = 1; i <= n; i++){
            if(i % 7 == 1){
                prevMonday = prevMonday + 1;
                prevDay = prevMonday;
                total += prevMonday;
            } else {
                prevDay++;
                total += prevDay;
            }
        }

        return total;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int n = 10;

        System.out.println(sol.totalMoney(n));
    }
}
