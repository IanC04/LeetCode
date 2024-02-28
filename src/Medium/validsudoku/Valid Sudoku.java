/**
 * @author: Ian Chen
 * @date: 2/28/2024
 */

package Medium.validsudoku;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur == '.') {
                    continue;
                }

                // Row duplicate
                boolean[] curRow = row[i];
                if (curRow[cur - '1']) {
                    return false;
                }
                curRow[cur - '1'] = true;

                // Col duplicate
                boolean[] curCol = col[j];
                if (curCol[cur - '1']) {
                    return false;
                }
                curCol[cur - '1'] = true;

                // Box duplicate
                boolean[] curBox = box[3 * (i / 3) + j / 3];
                if (curBox[cur - '1']) {
                    return false;
                }
                curBox[cur - '1'] = true;
            }
        }

        return true;
    }
}