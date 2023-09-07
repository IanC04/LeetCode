/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium.singlenumberii;

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        int answer;
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int n : nums) {
            dict.put(n, dict.getOrDefault(n, 0) + 1);
            if (dict.get(n) == 3) {
                dict.remove(n);
            }
        }
        answer = (int)dict.keySet().toArray()[0];
        return answer;
    }
}