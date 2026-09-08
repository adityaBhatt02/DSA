public class MaximumSumSubarray {
    public int findMaxSum(int[] nums, k) {
        int left = 0, right = 0, currentSum = 0, maxSum = Integer.MIN_VALUE;

        while(right < nums.length) {
            currentSum += nums[r];

            if(r - l + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
            r++;
        }
        return maxSum;
    }
}