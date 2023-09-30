/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium.addtwonumbers;

import java.util.*;

 /*
    Definition for singly-linked list.
 */

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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode cur = answer;
        int sum, carry = 0;
        boolean hasNext = false;
        while (l1 != null || l2 != null || carry != 0) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            cur.val = sum % 10;
            if (l1 != null || l2 != null || carry != 0) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return answer;
    }
}