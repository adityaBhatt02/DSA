/*
Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Same as MaximumSumSubarray question just at last divide by k (as k is fixed)
Ofco, if we find max sum subarray of size k then its avg is the highest by default.
 */

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        int currentSum = 0, maxSum = Integer.MIN_VALUE;

        while(right < nums.length) {
            currentSum += nums[right];

            if(right - left + 1 == k) {
                maxSum = Math.max(currentSum, maxSum);
                currentSum -= nums[left];
                left++;
            }

            right++;
        }
        return (double) maxSum/k;
    }
}