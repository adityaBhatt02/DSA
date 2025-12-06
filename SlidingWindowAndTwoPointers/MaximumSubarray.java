package SlidingWindowAndTwoPointers;

public class MaximumSubarray {
        public int maxSubArray(int[] nums) {
            int l = 0;
            int r = 0;
            int maxSum = nums[0];
            int currentSum = 0;

            while (r < nums.length) {
                currentSum += nums[r];
                maxSum = Math.max(maxSum, currentSum);

                if (currentSum < 0) {
                    currentSum = 0;
                    l = r + 1;
                }
                r++;
            }
            return maxSum;
        }
    }
