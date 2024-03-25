/**
 * @author: Ian Chen
 * @date: 3/25/2024
 */

package Medium.maximumofabsolutevalueexpression;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        // 4 cases after looking at solution...
        int s1, s2, s3, s4, d1, d2, d3, d4;
        s1 = s2 = s3 = s4 = Integer.MIN_VALUE;
        d1 = d2 = d3 = d4 = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            s1 = Math.max(arr1[i] + arr2[i] + i, s1);
            s2 = Math.max(arr1[i] + arr2[i] - i, s2);
            s3 = Math.max(arr1[i] - arr2[i] + i, s3);
            s4 = Math.max(arr1[i] - arr2[i] - i, s4);
            d1 = Math.min(arr1[i] + arr2[i] + i, d1);
            d2 = Math.min(arr1[i] + arr2[i] - i, d2);
            d3 = Math.min(arr1[i] - arr2[i] + i, d3);
            d4 = Math.min(arr1[i] - arr2[i] - i, d4);
        }

        return Math.max(Math.max(s1 - d1, s2 - d2), Math.max(s3 - d3, s4 - d4));
    }
}