package LinkedListQuestions;

public class PalindromeOrNot {
            public boolean isPalindrome(ListNode head) {
                ListNode middle = middle(head);
                ListNode secondHead = reverse(middle);

                ListNode reverseHead = secondHead;

                while(head != null && secondHead != null) {
                    if(head.val != secondHead.val) {
                        reverse(reverseHead);
                        return false;
                    }
                    head = head.next;
                    secondHead = secondHead.next;
                }

                reverse(reverseHead);
                return true;
            }

            public ListNode middle(ListNode head) {
                ListNode s = head;
                ListNode f = head;

                while(f != null && f.next != null) {
                    s = s.next;
                    f = f.next.next;
                }
                return s;
            }

            public ListNode reverse(ListNode head) {
                ListNode prev = null;
                ListNode pres = head;
                ListNode next = pres.next;

                while(pres != null) {
                    pres.next = prev;
                    prev = pres;
                    pres = next;
                    if(next != null) next = next.next;
                }
                return prev;
            }
}
