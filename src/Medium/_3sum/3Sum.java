/**
 * @author: Ian Chen
 * @date: 3/2/2024
 */

package Medium._3sum;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    --k;
                } else if (sum < 0) {
                    ++j;
                } else {
                    answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (k > 0 && nums[k] == nums[k - 1]) {
                        --k;
                    }
                    --k;
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        ++j;
                    }
                    ++j;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }

        return answers;
    }
}