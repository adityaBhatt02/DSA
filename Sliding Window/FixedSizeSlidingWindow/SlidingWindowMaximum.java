public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        // processing the first window only first
        int right = 0;
        while(right < k) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) deque.pollLast();      // if some bigger rightmost comes then remove every element from the deque that is smaller than that from the last

            deque.offerLast(right);                         // add ever new element of the window inside the deque from the back
            right++;
        }
        result[0] = nums[deque.peekFirst()];        // the peek of the deque will be the greatest element of that window so we add in our result array at 0th index indicating that its the answer of first window

        // then we start i from 1 for result[1], result[2] .....
        for(int i = 1; i < result.length; i++) {
            while(!deque.isEmpty() && deque.peekFirst() < i) deque.pollFirst();         // now when a window ends when we enter a new element index in the deque we first remove the left most element whose index is basically smaller than current i

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i + k - 1]) deque.pollLast();           // now this is simple inserting of next element

            deque.offerLast(i + k - 1);                                     // adding that new element's index in the deque    i + k - 1 -> gives the current index which is running in the main array
            result[i] = nums[deque.peekFirst()];                            // the peek of the deque will be stored in result[i] indicating the maximum element in that particular window
        }

        return result;
    }
}







/*
Approach is reasonable: track the maximum, and when the outgoing element is the maximum, recalculate the maximum for the
remaining window. The problem is how much work that recalculation can require.

Imagine a decreasing array:

nums = [100, 99, 98, 97, 96, 95, 94, 93, ...]
k = 4

Every time the window shifts, its maximum leaves the window. Your code scans almost the entire window again to find the
new maximum.

First window: scan 4 elements.
Second window: scan 3 elements to recalculate.
Third window: scan 3 elements to recalculate.

This continues for potentially thousands of windows.

The worst-case time complexity becomes O(nk), whereas the problem is designed to be solved in O(n).
 */
class SlidingWindowSln {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0, maxNum = Integer.MIN_VALUE;

        while(right < nums.length) {
            maxNum = Math.max(maxNum, nums[right]);

            if(right - left + 1 == k) {
                result.add(maxNum);

                if(nums[left] == maxNum) {
                    int index = left + 1, windowMax = Integer.MIN_VALUE;

                    while(index <= right) {
                        windowMax = Math.max(windowMax, nums[index]);
                        index++;
                    }
                    maxNum = windowMax;
                }
                left++;
            }

            right++;
        }

        int ans[] = new int[result.size()];
        for(int i = 0; i < result.size(); i++) ans[i] = result.get(i);

        return ans;
    }
}