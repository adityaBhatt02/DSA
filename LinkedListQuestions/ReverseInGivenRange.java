package LinkedListQuestions;

public class ReverseInGivenRange {
    // prev last node of the reversed list not of the whole list and pres is uske just baad out of that reversed list.
        public Node reverseBetween(Node head, int left, int right) {
            if(head == null || left == right) {
                return head;
            }

            Node prev = null;
            Node pres = head;

            // left waale pr pres usse phle prev
            for(int i = 1 ; pres != null && i < left ; i++) {
                prev = pres;
                pres = pres.next;
            }

            // store krdiya becz connect krenge at last
            Node last = prev;
            Node newEnd = pres;

            Node next = pres.next;

            // r-l+1 gives length ke kitne nodes ko reverse krna hae
            for(int i = 0 ; i < right - left + 1 ; i++) {
                pres.next = prev;
                prev = pres;
                pres = next;
                if(next != null) {
                    next = next.next;
                }
            }

            // agr last jo humne store krke rkha tha wo null hae to connect nhi krna becz null.next errorDega
            if(last != null) {
                last.next = prev;
            }else {
                head = prev;
            }

            newEnd.next = pres;

            return head;
        }
    }

//    1 -> 2 -> 3 -> 4 -> 5 -> 6           left = 2 , r = 5
