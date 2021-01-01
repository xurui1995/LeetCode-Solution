package javacode;

public class Solution36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rowArray = new int[9][9];
        int[][] colArray = new int[9][9];
        int[][] boxsArray = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '1';
                if (rowArray[i][value] == 1) {
                    return false;
                }
                if (colArray[j][value] == 1) {
                    return false;
                }
                int boxIndex = i / 3 + j / 3 * 3;
                if (boxsArray[boxIndex][value] == 1) {
                    return false;
                }
                rowArray[i][value] = 1;
                colArray[j][value] = 1;
                boxsArray[boxIndex][value] = 1;
            }
        }
        return true;
    }
}
