package LinkedListQuestions;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Input: head = []
Output: []

Input: head = [1]
Output: [1]

Input: head = [1,2,3]
Output: [2,1,3]
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while(current.next != null && current.next.next != null) {
            ListNode swap1 = current.next;
            ListNode swap2 = current.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;
            current.next = swap2;

            current = swap1;
        }
        return dummy.next;
    }
}
