/**
 * @author: Ian Chen
 * @date: 3/8/2024
 */

package Medium.subsets;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        recur(answer,  new ArrayList<>(), nums, 0);

        return answer;
    }

    private void recur(List<List<Integer>> all,  List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            all.add(new ArrayList<>(cur));
            return;
        }

        recur(all, cur, nums, index + 1);
        int listLength = cur.size();
        cur.add(nums[index]);
        recur(all, cur, nums, index + 1);
        cur.remove(listLength);
    }
}