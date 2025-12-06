package LinkedListQuestions;

public class CLL {
    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtLast(int val) {
        Node node = new Node(val);
        if(head == null) {
            insertAtFirst(val);
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }


    public void insertAtFirst(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
            head = node;
            tail.next = head;
        }else {
            head = node;
            tail = node;
        }
    }


    public void insert(int val , int index) {
        Node node = new Node(val);
        if (index == 0) {
            insertAtFirst(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }


    public void deleteFromStart() {
        if(head == null) {
            System.out.println("Cannot delete becz list is empty!");
            return;
        }

        tail.next = head.next;
        head = head.next;
    }

    public void deleteFromLast() {
        if(head == null) {
            System.out.println("Cannot delete becz list is empty!");
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = tail.next;
        tail = temp;
    }

    public void delete(int index) {
        if (head == null) {
            System.out.println("Cannot delete becz list is empty!");
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }




// Ques-Is cycle present or not(Cycle detection in LL).
    public boolean isCycle() {
        if(head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    // ques- cycleII {return from where the cycle started}
        public Node detectCycle(Node head) {
            if(head == null) return null;

            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast) {
                    slow = head;

                    while(slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return null;
        }

    // ques-length of the cycle.
    public int lengthOfCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int count = 0;
                do {
                    slow = slow.next;
                    count++;
                }while (slow != fast);
                return count;
            }
        }
        return -1;
    }


    public void display() {
        if(head != null) {
        Node temp = head;
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println(head.value + "(head)");
        }else {
            System.out.println("List is empty!");
        }
    }
}

