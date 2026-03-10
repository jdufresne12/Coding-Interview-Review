/*
    1582. Special Positions in a Binary Matrix
    Given an m x n binary matrix mat, return the number of special positions in mat.
    A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
*/
class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    boolean isSpecial = true;

                    for (int col = 0; col < n; col++) {
                        if (col != j && mat[i][col] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }

                    if (isSpecial) {
                        for (int row = 0; row < m; row++) {
                            if (row != i && mat[row][j] == 1) {
                                isSpecial = false;
                                break;
                            }
                        }
                    }

                    if (isSpecial) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        System.out.println(sol.numSpecial(mat)); // Output: 1

    }
}
