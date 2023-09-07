/*
    Written by Ian Chen
    GitHub: https://github.com/IanC04
 */

package Easy.twosum;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i]
            if (map.containsKey(other)) {
                answer[0] = map.get(other);
                answer[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return answer;
    }
}