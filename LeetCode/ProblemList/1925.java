/*
 * 1925. Count Square Sum Triples
 * A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
 * Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
*/ 

class Solution {
    public int countTriples(int n){
        int triplesCount = 0;

        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                for(int c = 1; c <= n; c++){
                    if((a*a) + (b*b) == (c*c))
                        triplesCount++;
                }
            }
        }

        return triplesCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countTriples(1000));
    }
}
