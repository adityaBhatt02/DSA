package PriorityQueue;

import java.util.PriorityQueue;


/*
TreeSet - Stores unique elements (like all Sets)
Keeps them automatically sorted (ascending by default)

add()
remove()
contains()
first() - gives the first element of the set
last() - gives last element of the set
pollFirst()
pollLast()
 */

class KthLargestElementAnIntegerArray {
//    public int thirdMax(int[] nums) {
//        TreeSet<Integer> set = new TreeSet<>();
//
//        for(int num : nums) {
//            set.add(num);
//            if(set.size() > 3) {
//                set.pollFirst();
//            }
//        }
//
//        if(set.size() < 3) {
//            return set.last();
//        }
//
//        return set.first();
//    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // remove smallest among the window -> keeps k largest
            }
        }
        return pq.peek(); // kth largest (counts duplicates)
    }
}


/*
Note : If in the ques it says take duplicate also then u have to use PriorityQueue becz as in TreeSet it
        removes duplicates.
peek() → returns the smallest
poll() → removes the smallest
 */