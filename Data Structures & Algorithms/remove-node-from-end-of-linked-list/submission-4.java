/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n <= 0) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode follow = dummy;

        int idx = 0;
        while (idx < n) {
            head = head.next;
            idx++;
        }

        while (head != null) {
            head = head.next;
            follow = follow.next;
        }

        follow.next = follow.next.next;
        return dummy.next;
    }
}