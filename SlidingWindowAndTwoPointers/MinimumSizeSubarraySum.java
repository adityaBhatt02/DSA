package SlidingWindowAndTwoPointers;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

public class MinimumSizeSubarraySum {
        public int minSubArrayLen(int target, int[] nums) {
            int l = 0 , r = 0 , currentSum = 0 , minLen = Integer.MAX_VALUE;

            while(r < nums.length){
                currentSum += nums[r];

                while(currentSum >= target) {
                    minLen = Math.min(minLen , r - l + 1);
                    currentSum -= nums[l];
                    l++;
                }
                r++;
            }

            if (minLen == Integer.MAX_VALUE) return 0;

            return minLen;
        }
    }

