/*
Imagine k workers and nums represents jobs in order.
You must divide the jobs into k consecutive groups.
You care about the worker who gets the most total work.

Your goal is: Minimize the maximum workload.
That's exactly what: "the largest sum of any subarray is minimized"
 */

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int minSum = Integer.MIN_VALUE;
        int maxSum = 0;

        for(int num : nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }

        while(minSum < maxSum) {
            int mid = minSum + (maxSum - minSum)/2;

            if(canSplit(nums, k, mid)) {
                maxSum = mid;
            } else {
                minSum = mid + 1;
            }
        }
        return minSum;
    }

    private boolean canSplit(int[] nums, int k, int maxAllowedSum) {
        int currentSum = 0, subarrays = 1;

        for(int i = 0; i < nums.length; i++) {
            if(currentSum + nums[i] <= maxAllowedSum) {
                currentSum += nums[i];
            } else {
                subarrays++;
                currentSum = nums[i];
            }
        }
        return subarrays <= k;
    }
}