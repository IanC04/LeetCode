/**
 * @author: Ian Chen
 * @date: 1/25/2024
 */

package Easy.kidswiththegreatestnumberofcandies;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            answer.add(candies[i] + extraCandies >= max);
        }
        return answer;
    }
}