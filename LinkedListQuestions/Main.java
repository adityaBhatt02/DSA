package LinkedListQuestions;

public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertAtFirst(4);
//        list.insertAtFirst(2);
//        list.insertAtFirst(1);
//        list.insert(3,2);
//        list.insertAtLast(3);
//        list.insertAtLast(6);
//        list.insertAtLast(6);
//        list.insertAtLast(9);
//        list.insertAtLast(9);
//        list.insertAtLast(12);
//        list.removeDuplicate();
//        list.display();
//
//        System.out.println();
//
//        LL list1 = new LL();
//        list1.insertAtLast(2);
//        list1.insertAtLast(4);
//        list1.insertAtLast(4);
//        list1.insertAtLast(7);
//        list1.insertAtLast(7);
//        list1.insertAtLast(10);
//        list1.display();
//
//
//        System.out.println();
//        LL list2 = list.mergeTwoSortedLists(list, list1);
//        list2.display();


//        list.deleteAtFirst();
//        list.deleteAtLast();
//        list.delete(1);
//        list.display();

//        list.reverse();
//        list.display();


        CLL list = new CLL();
        list.insertAtLast(23);
        list.insertAtLast(25);
        list.insertAtLast(49);
        list.insertAtFirst(93);
        list.insertAtFirst(69);
        list.insert(3 , 2);
        list.deleteFromStart();
        list.deleteFromLast();
        list.delete(1);
        list.display();
        System.out.println(list.isCycle());
        System.out.println(list.lengthOfCycle());
    }


}
