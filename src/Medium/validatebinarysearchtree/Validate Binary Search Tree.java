/**
 * @author: Ian Chen
 * @date: 9/17/2025
 */

package Medium.validatebinarysearchtree;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        long[] val = new long[1];
        val[0] = Long.MIN_VALUE;

        return inOrderTraversal(root, val);
    }

    boolean inOrderTraversal(TreeNode node, long[] val) {
        if (node == null) {
            return true;
        }
        boolean leftSubtree = inOrderTraversal(node.left, val);
        if (!leftSubtree) {
            return false;
        }

        if (node.val <= val[0]) {
            return false;
        }
        val[0] = node.val;
        return inOrderTraversal(node.right, val);
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