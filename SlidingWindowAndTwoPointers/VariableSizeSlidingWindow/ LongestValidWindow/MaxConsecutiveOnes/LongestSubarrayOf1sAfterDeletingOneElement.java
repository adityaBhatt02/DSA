/*
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such
subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.


Approach -> Keep a window with at most 1 zero. Count only the 1s. If there is a zero, deleting it gives exactly windowSize. If there is
no zero, we must delete one 1, so the answer is n - 1.
 */

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, zeroes = 0, windowSize = 0, maxCount = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroes++;
            } else {
                windowSize++;
            }

            while(zeroes > 1) {
                if(nums[left] == 0) {
                    zeroes--;
                } else {
                    windowSize--;
                }

                left++;
            }

            maxCount = Math.max(windowSize, maxCount);
            right++;
        }

        // Just for 1 edge case where we dont have any zero in it only [1,1,1..] but the problem says You must delete exactly
        // one element.
        return Math.min(maxCount, nums.length - 1);
    }
}