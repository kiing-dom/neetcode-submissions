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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        ListNode scan = groupPrev;

        while (true) {
            scan = groupPrev;
            for (int i = 0; i < k; i++) {
                scan = scan.next;
                if (scan == null) {
                    return dummy.next;
                }
            }

            // reverse here
            ListNode groupNext = scan.next;

            reverse(groupPrev.next, groupNext);

            // move groupPrev to end of reversedGroup
            ListNode tmp = groupPrev.next;
            groupPrev.next = scan;
            groupPrev = tmp;
        }
    }

    private void reverse(ListNode node, ListNode endExclusive) {
        ListNode prev = endExclusive;
        ListNode curr = node;

        while (curr != endExclusive) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}