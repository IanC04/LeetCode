/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium._123pattern;

import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int[] minPrefix = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            minPrefix[i] = Math.min(minPrefix[i - 1], minPrefix[i]);
        }

        TreeSet<Integer> suffix = new TreeSet<>();

        for(int i = nums.length - 1; i > 0; i--) {
            Object smallestGreaterThanPrefix = suffix.higher(minPrefix[i]);
            if (smallestGreaterThanPrefix != null) {
                if (nums[i] > (int) smallestGreaterThanPrefix) {
                    return true;
                }
            }
            suffix.add(nums[i]);
        }
        return false;
    }
}