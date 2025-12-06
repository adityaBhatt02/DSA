package LinkedListQuestions;

public class LL {
    private Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    public void insert(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            insertAtFirst(val);
            return;
        }
        if (index == size) {
            insertAtLast(val);
            return;
        }


        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;

        size++;
    }

    public void insertAtFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertAtLast(int val) {
        if (head == null) {
            insertAtFirst(val);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node node = new Node(val);
        temp.next = node;
        node.next = null;
        size++;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteAtFirst();
            return;
        }
        if (index == size - 1) {
            deleteAtLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteAtLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        size--;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    // Ques-Remove Duplicates from Sorted List
    public void removeDuplicate() {                            // 1 -> 2 -> 3 -> 3 -> 3 -> 4                  to           // 1 -> 2 -> 3 -> 4
        Node temp1 = head;
        Node temp2 = head.next;

        while (temp2 != null) {
            if (temp1.value != temp2.value) {
                temp1 = temp2;
                temp2 = temp2.next;
            }else {
                temp2 = temp2.next;
                temp1.next = temp2;
            }
        }
    }

    // Ques- MergeTwoSortedLists
    public LL mergeTwoSortedLists(LL list1 , LL list2) {
        LL list3 = new LL();
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while (temp1 != null && temp2 != null) {
            if (temp1.value <= temp2.value) {
                list3.insertAtLast(temp1.value);
                temp1 = temp1.next;
            }else {
                list3.insertAtLast(temp2.value);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null) {
            list3.insertAtLast(temp1.value);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            list3.insertAtLast(temp2.value);
            temp2 = temp2.next;
        }

        return list3;
    }



    public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node pres = head;
        Node next = pres.next;


        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }


    public Node middle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}


