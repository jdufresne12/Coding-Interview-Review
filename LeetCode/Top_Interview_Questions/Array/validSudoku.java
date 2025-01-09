// John Dufresne 1/8/25

import java.util.HashSet;

public class validSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // Stores seen numbers 
        HashSet<String> seen = new HashSet<>();
        
        // Iterate through each cell in the 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                // Skip empty cells
                if (number == '.') {
                    continue;
                }
                
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in box " + (i/3) + "-" + (j/3))) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void toString(char[][] string) {
        for(int i = 0; i < 9; i++){
            if(i != 0)
                System.out.print("\n");

            for(int j = 0; j < 9; j++){
                System.out.print(string[i][j]);
            }
        }
        System.out.print("\n");
    }

    public static void main (String args[]) {
        char[][] board = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };        

        toString(board);
        System.out.println("Is the board valid: " + (isValidSudoku(board) == true ? "Yes" : "False"));
    }
}