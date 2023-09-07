/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
 */

package Medium.nonoverlappingintervals;

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int numRemoved = 0;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        // System.out.println("Sorted array: " + Arrays.deepToString(intervals));

        // Sort list by starting indices and calculate current interval and adjust to fit next interval or not include it
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart < prevEnd) {
                numRemoved++;
                prevEnd = Math.min(prevEnd, curEnd);
            } else {
                prevEnd = Math.max(prevEnd, curEnd);
            }
        }

        return numRemoved;
    }
}