/**
 * @author: Ian Chen
 * @date: 3/5/2024
 */

package Medium.maximumsubarray;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // // Greedy- O(n)
        // int max = nums[0], cur = 0;
        // for (int n : nums) {
        //     cur = Math.max(n, cur + n);
        //     if (cur > max) {
        //         max = cur;
        //     }
        // }
        //
        // return max;

        // Divide & Conquer- O(nlog n)
        return dc(0, nums.length, nums);
    }

    /**
     * @param s    inclusive
     * @param e    exclusive
     * @param nums
     * @return maximum subarray
     */
    private int dc(int s, int e, int[] nums) {
        if (s == e - 1) {
            return nums[s];
        }
        int mid = (s + e) >>> 1;
        int leftSum = dc(s, mid, nums), rightSum = dc(mid, e, nums);

        int maxSuffix = nums[mid - 1], maxPrefix = nums[mid];
        int cur = maxSuffix;
        for (int i = mid - 2; i >= s; --i) {
            cur += nums[i];
            if (cur > maxSuffix) {
                maxSuffix = cur;
            }
        }
        cur = maxPrefix;
        for (int i = mid + 1; i < e; ++i) {
            cur += nums[i];
            if (cur > maxPrefix) {
                maxPrefix = cur;
            }
        }

        return Math.max(Math.max(leftSum, rightSum), maxPrefix + maxSuffix);
    }
}