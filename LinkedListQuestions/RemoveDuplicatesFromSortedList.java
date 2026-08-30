/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
*/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while(current != null) {
            if(current.next != null && current.val == current.next.val) {
                int value = current.val;

                while(current != null && current.val == value) current = current.next;

                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
