/**
 * @author: Ian Chen
 * @date: 7/5/2024
 */

package Medium.findtheminimumandmaximumnumberofnodesbetweencriticalpoints;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = {-1, -1};
        int first_idx = -1, cur_idx = 0, prev_idx = -1, prev_val = head.val;
        head = head.next;
        while (head != null && head.next != null) {
            final boolean crit = prev_val < head.val && head.val > head.next.val || prev_val > head.val && head.val < head.next.val;
            if (crit) {
                if (first_idx == -1) {
                    first_idx = cur_idx;
                } else {
                    res[1] = cur_idx - first_idx;
                    if (res[0] == -1) {
                        res[0] = cur_idx - first_idx;
                    } else if (prev_idx != -1) {
                        res[0] = Math.min(res[0], cur_idx - prev_idx);
                    }
                }
                prev_idx = cur_idx;
            }
            cur_idx++;
            prev_val = head.val;
            head = head.next;
        }
        return res;
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