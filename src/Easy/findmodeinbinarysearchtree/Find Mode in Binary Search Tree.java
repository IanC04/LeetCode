/**
 * @author: Ian Chen
 * @date: 3/11/2024
 */

package Easy.findmodeinbinarysearchtree;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    int maxCount = 0;
    TreeNode prev = null;
    int curCount = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        recur(root, modes);

        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    private void recur(TreeNode node, List<Integer> modes) {
        if (node == null) {
            return;
        }

        recur(node.left, modes);
        if (prev != null && node.val == prev.val) {
            ++curCount;
        } else {
            curCount = 1;
        }
        if (curCount > maxCount) {
            modes.clear();
            modes.add(node.val);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            modes.add(node.val);
        }
        prev = node;
        recur(node.right, modes);
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