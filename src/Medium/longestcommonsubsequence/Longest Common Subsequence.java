/**
 * @author: Ian Chen
 * @date: 1/24/2024
 */

package Medium.longestcommonsubsequence;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // I'll use a dynamic programming approach
        int[][] table = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                char t1 = text1.charAt(i - 1), t2 = text2.charAt(j - 1);
                if (t1 == t2) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
                else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[table.length - 1][table[0].length - 1];
    }
}