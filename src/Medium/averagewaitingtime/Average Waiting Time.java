/**
 * @author: Ian Chen
 * @date: 7/8/2024
 */

package Medium.averagewaitingtime;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitTime = 0, endTime = 0;
        for (int[] customer : customers) {
            endTime = Math.max(endTime, customer[0]) + customer[1];
            totalWaitTime += endTime - customer[0];
        }

        return (double) totalWaitTime / customers.length;
    }
}