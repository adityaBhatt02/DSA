/*
Implement the KthLargestElementInAStream class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 

Example 1:

Input:
["KthLargestElementInAStream", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

Output: [null, 4, 5, 5, 8, 8]

Explanation:

KthLargest KthLargestElementInAStream = new KthLargestElementInAStream(3, [4, 5, 8, 2]);
KthLargestElementInAStream.add(3); // return 4
KthLargestElementInAStream.add(5); // return 5
KthLargestElementInAStream.add(10); // return 5
KthLargestElementInAStream.add(9); // return 8
KthLargestElementInAStream.add(4); // return 8

Example 2:

Input:
["KthLargestElementInAStream", "add", "add", "add", "add"]
[[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]

Output: [null, 7, 7, 7, 8]

Explanation:

KthLargestElementInAStream KthLargestElementInAStream = new KthLargestElementInAStream(4, [7, 7, 7, 7, 8, 3]);
KthLargestElementInAStream.add(2); // return 7
KthLargestElementInAStream.add(10); // return 7
KthLargestElementInAStream.add(9); // return 7
KthLargestElementInAStream.add(9); // return 8
*/


class KthLargestElementInAStream {
    private final int k;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > this.k) pq.poll();
        }
    }    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > this.k) pq.poll();

        return pq.peek(); 
    }
}

/**
 * Your KthLargestElementInAStream object will be instantiated and called as such:
 * KthLargestElementInAStream obj = new KthLargestElementInAStream(k, nums);
 * int param_1 = obj.add(val);
 */
