/**
 * @author: Ian Chen
 * @date: 8/29/2024
 */

package Medium.searcha2dmatrix;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length - 1;
        final int[] coord = {0, 0};

        while (low <= high) {
            int mid = (low + high) >> 1;
            setCoordByIndex(mid, coord, matrix[0].length);
            int elem = matrix[coord[0]][coord[1]];
            if (elem == target) {
                return true;
            }
            if (elem < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    private void setCoordByIndex(int index, int[] coord, int cols) {
        coord[0] = index / cols;
        coord[1] = index % cols;
    }
}