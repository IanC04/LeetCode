/**
 * @author: Ian Chen
 * @date: 1/25/2024
 */

package Hard.medianoftwosortedarrays;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Idea: Binary search
        int low1 = nums1[0], high1 = nums1[nums1.length - 1];
        int low2 = nums2[0], high2 = nums2[nums2.length - 1];
        while (true) {
            int mid1 = (low1 + high1) >>> 1;
            int mid2 = (low2 + high2) >>> 1;
            if (mid1 == mid2) {
                return mid1;
            } else if (mid1 < mid2) {
                low1 = mid1;
                high2 = mid2;
            } else {
                high1 = mid1;
                low2 = mid2;
            }
        }
    }
}