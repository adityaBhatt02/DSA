package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Max Heap se sbse bde weight waala stone sbse upar honge and then unhe nikalenge from PriorityQueue
if they are not equal then just a - b (bada stone - chota) and then unka result add it to the PriorityQueue
ofco if they are equal then do nothing.  And run the loop till there is only 1 stone left and return
the weight of the stone then bss.

Input: stones = [2,7,4,1,8,1]
Output: 1
 */

public class LastStoneWeight {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int stone : stones) pq.offer(stone);

            while(pq.size() > 1) {
                int a = pq.poll();    // largest
                int b = pq.poll();    // secondLargest

                if(a != b) pq.offer(a - b);
            }

            return pq.isEmpty() ? 0 : pq.poll();
        }
    }

