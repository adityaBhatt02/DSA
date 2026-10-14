import java.util.*;

/*
Explanation: The input array is
[3,0,1,8,2,4,7,6].

The windows are -> [3,0,1,8,2], [0,1,8,2,4], [1,8,2,4,7] and [8,2,4,7,6],
and their minimums are 0,1 and 2.

Thus, the answer is -> 0 ^ 0 ^ 1 ^ 2 = 3.
 */
public class SlidingWindowMinimum {
    public static int minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int right = 0;
        while(right < k) {
            while(!deque.isEmpty() && nums[deque.peekLast()] >= nums[right]) deque.pollLast();

            deque.offerLast(right);
            right++;
        }
        result[0] = nums[deque.peekFirst()];

        for(int i = 1; i < result.length; i++) {
            while(!deque.isEmpty() && deque.peekFirst() < i) deque.pollFirst();

            while(!deque.isEmpty() && nums[deque.peekLast()] >= nums[i + k - 1]) deque.pollLast();

            deque.offerLast(i + k - 1);
            result[i] = nums[deque.peekFirst()];
        }

        // XOR
        int ans = 0;
        for(int res : result) ans ^= res;

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,8,2,4,7,6};
        int k = 3;

        System.out.println(minSlidingWindow(nums, k));
    }
}