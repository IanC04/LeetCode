/**
 * @author: Ian Chen
 * @date: 9/17/2025
 */

package Medium.bitwiseorsofsubarrays;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    // // First solution
    // public int subarrayBitwiseORs(int[] arr) {
    //     Set<Integer> results = new HashSet<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         int[] dp = new int[arr.length];
    //         dp[i] = arr[i];
    //         results.add(dp[i]);
    //         for (int j = i + 1; j < arr.length; j++) {
    //             dp[j] = arr[j] | dp[j - 1];
    //             results.add(dp[j]);
    //         }
    //     }
    //
    //     return results.size();
    // }

    // Second solution
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> results = new HashSet<>();

        Set<Integer> current = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            Set<Integer> temp = new HashSet<>();
            temp.add(arr[i]);
            for (int val : current) {
                temp.add(val | arr[i]);
            }
            current = temp;

            results.addAll(current);
        }

        return results.size();
    }
}