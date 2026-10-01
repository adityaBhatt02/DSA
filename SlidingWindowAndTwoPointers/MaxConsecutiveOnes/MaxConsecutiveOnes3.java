package SlidingWindowAndTwoPointers.MaxConsecutiveOnes;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, windowCount = 0, zeros = 0, maxCount = 0;

        while (right < nums.length) {
            windowCount++;

            if (nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;

                windowCount--;
                left++;
            }

            maxCount = Math.max(maxCount, windowCount);
            right++;
        }

        return maxCount;
    }
}
