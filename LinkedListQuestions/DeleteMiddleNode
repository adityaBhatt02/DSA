/*
Example 1:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]

Explanation:
Since n = 7, node 3 with value 7 is the middle node.
We return the new list after removing this node. 


Example 2:
Input: head = [1,2,3,4]
Output: [1,2,4]

Explanation:
For n = 4, node 2 with value 3 is the middle node.


Example 3:
Input: head = [2,1]
Output: [2]

Explanation:
For n = 2, node 1 with value 1 is the middle node.
Node 0 with value 2 is the only node remaining after removing node 1.
*/


class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
