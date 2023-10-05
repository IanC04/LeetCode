/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium.majorityelementii;

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> top3 = new TreeSet<>();

        for (int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            if (top3.size() < 3) {
                top3.add(n);
            } else {
                if (map.get(n) > map.get(top3.first())) {
                    top3.remove(top3.first());
                    top3.add(n);
                }
            }
        }
        int oneThird = nums.length / 3;
        return top3.stream().filter(x -> map.get(x) > oneThird).toList();
    }
}