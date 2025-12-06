package PriorityQueue;

import java.util.PriorityQueue;

/*
Input: nums = ["3","6","7","10"], k = 4
Output: "3"

remember we have to use custom comparator for this as because they are String not Integer first of all so by just adding them in the PriorityQueue will compare them according
to lexicographic eg : "10" < "2"(lexicographically as 2 -> 50 and 10 ka 1 -> 49 {it checks with first digit only}) but numerically it is larger than that.

So our logic is simple that while creating the PriorityQueue we initialise it with a comparator in which it compares the 2 strings first if length are same then lexicographically
(like "2" and "3") and if length is not same then whosoever length is longer is obviously greater)

And then now we have our own PriorityQueue with our comparator now just loop through the array and if the size is more than k then just poll and at last return the peek.
 */

public class KthLargestElementInAStringArray {
        public String kthLargestNumber(String[] nums, int k) {
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b); // lexicographic compare if same length
                return Integer.compare(a.length(), b.length()); // shorter = smaller
            });

            for (String num : nums) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }

            return pq.peek();
        }
    }
