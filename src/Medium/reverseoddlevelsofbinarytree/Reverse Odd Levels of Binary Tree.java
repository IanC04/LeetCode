/**
 * @author: Ian Chen
 * @date: 3/22/2024
 */

package Medium.reverseoddlevelsofbinarytree;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        boolean odd = false;
        int count = 1;
        while(!bfs.isEmpty()) {
            int temp = count;
            while (temp-- > 0) {
                TreeNode cur = bfs.remove();
                if (cur.left != null) {
                    bfs.offer(cur.left);
                    bfs.offer(cur.right);
                }
            }
            odd = !odd;
            count <<= 1;
            if (odd){
                int[] nums = new int[count];
                int index = 0;
                for (TreeNode node : bfs) {
                    nums[index++] = node.val;
                }
                int last = count - 1;
                for (TreeNode node : bfs) {
                    node.val = nums[last--];
                }
            }
        }
        return root;
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
