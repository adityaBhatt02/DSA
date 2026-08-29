package LinkedListQuestions;

/*
Find the node where two linked lists physically become the same list.

List A:    4 → 1 ──────┐
                       ↓
                       8 → 4 → 5
                       ↑
                       |
List B:    5 → 6 → 1 ──┘

The important thing is: A's node 8 == B's node 8
They're literally the same ListNode object in memory.

Not: 8.val == 8.val
*/

public class IntersectionOfTwoLinkedList {
       public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            if(a == null) {
                a = headB;
            }else {
                a = a.next;
            }

            if(b == null) {
                b = headA;
            }else {
                b = b.next;
            }
        }
        return a;
    }
}

