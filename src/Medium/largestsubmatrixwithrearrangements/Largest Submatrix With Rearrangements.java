/**
 * @author: Ian Chen
 * @date: 3/7/2024
 */

package Medium.largestsubmatrixwithrearrangements;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int[][] conOnes = new int[matrix.length][matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            int counter = 0;
            for (int i = 0; i < matrix.length; i++) {
                counter = matrix[i][j] == 1 ? counter + 1 : 0;

                conOnes[i][j] = counter;
            }
        }

        int max = 0;
        for (int[] row : conOnes) {
            Arrays.sort(row);
            for (int j = 0; j < row.length; j++) {
                int cur = row[j] * (row.length - j);
                if (cur > max) {
                    max = cur;
                }
            }
        }

        return max;
    }
}