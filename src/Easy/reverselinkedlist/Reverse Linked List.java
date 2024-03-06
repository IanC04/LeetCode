/**
 * @author: Ian Chen
 * @date: 3/6/2024
 */

package Easy.reverselinkedlist;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // // Iterative
        // ListNode prev = null;
        // while (head != null) {
        //     ListNode next = head.next;
        //     head.next = prev;
        //     prev = head;
        //     head = next;
        // }
        //
        // return prev;

        // Recursive
        if (head == null) {
            return null;
        }
        return recur(null, head);
    }

    private ListNode recur(ListNode prev, ListNode cur) {
        if (cur != null) {
            ListNode deepest = recur(cur, cur.next);
            cur.next = prev;
            return deepest;
        }

        return prev;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
