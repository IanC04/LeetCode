/**
 * @author: Ian Chen
 * @date: 8/31/2024
 */

package Medium.maximumproductsubarray;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], curMin = nums[0], curMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tempMax = Math.max(n, Math.max(curMin * n, curMax *  n));
            curMin = Math.min(n, Math.min(curMin * n, curMax * n));
            curMax = tempMax;

            max = Math.max(max, curMax);
        }

        return max;
    }
}