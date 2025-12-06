package LinkedListQuestions;

public class RotateList {
        public Node rotateRight(Node head, int k) {
            if (head == null || head.next == null || k == 0) return head;

            // 1️⃣ Find length and last node
            Node temp = head;
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }

            // 2️⃣ Connect tail to head (make it circular)
            temp.next = head;

            // 3️⃣ Find new tail position
            k = k % length; // in case k > length
            int stepsToNewTail = length - k;

            // 4️⃣ Move to new tail
            Node newTail = head;
            for (int i = 1; i < stepsToNewTail; i++) {
                newTail = newTail.next;
            }

            // 5️⃣ New head and break the circle
            Node newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }
    }
