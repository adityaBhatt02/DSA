package LinkedListQuestions;

/*
(Approach) We solve this in three main steps:
-> Find the middle of the list.
-> Reverse the second half of the list (mid + 1) node.
-> Merge both halves alternately.

Given L0 → L1 → … → Ln-1 → Ln,
reorder it to:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

Input:  1 → 2 → 3 → 4 → 5
Output: 1 → 5 → 2 → 4 → 3
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode middleNode = middle(head);
        ListNode second = reverse(middleNode.next);

        middleNode.next = null;
        ListNode first = head;

        while(second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode pres = head;

        while(pres != null) {
            ListNode next = pres.next;

            pres.next = prev;
            prev = pres;
            pres = next;
        }
        return prev;
    }
}
