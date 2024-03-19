/**
 * @author: Ian Chen
 * @date: 3/19/2024
 */

package Medium.flattenbinarytreetolinkedlist;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        preorder(root);
    }

    /**
     * Not really preorder since node operation last, a better solution is (right, left, root)
     * @param cur current node
     */
    private void preorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode l = cur.left, r = cur.right;
        if (prev != null) {
            prev.left = null;
            prev.right = cur;
        }
        prev = cur;
        preorder(l);
        preorder(r);
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
