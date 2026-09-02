/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/


public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true) {
            ListNode kth = findKthNode(groupPrev, k);

            if(kth == null) break;

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode pres = groupPrev.next;

            while(pres != groupNext) {
                ListNode next = pres.next;
                pres.next = prev;
                prev = pres;
                pres = next;
            }

            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupStart;
        }
        return dummy.next;
    }

    private ListNode findKthNode(ListNode current, int k) {
        while(current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
}
