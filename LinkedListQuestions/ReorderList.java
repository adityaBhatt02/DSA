package LinkedListQuestions;

/*
(Approach) We solve this in three main steps:
-> Find the middle of the list using slow & fast pointers.
-> Reverse the second half of the list.
-> Merge both halves alternately.

Given L0 → L1 → … → Ln-1 → Ln,
reorder it to:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

Input:  1 → 2 → 3 → 4 → 5
Output: 1 → 5 → 2 → 4 → 3
 */

public class ReorderList {
        public void reorderList(Node head) {
            if (head == null || head.next == null) return;

            // Step 1: Find middle (slow will point to middle)
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2: Reverse second half
            Node second = reverseList(slow.next);
            slow.next = null; // cut the list into two halves

            // Step 3: Merge two halves
            Node first = head;
            while (second != null) {
                Node temp1 = first.next;
                Node temp2 = second.next;

                first.next = second;
                second.next = temp1;

                first = temp1;
                second = temp2;
            }
        }

        // Helper function to reverse a linked list
        private Node reverseList(Node head) {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
}
