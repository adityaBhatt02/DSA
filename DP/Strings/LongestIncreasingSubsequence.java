/*
Whenever you see “Longest Increasing Subsequence,” think:

-> State: dp[i] = length of the longest increasing subsequence ending exactly at index i.
-> Initialize: Every element can stand alone, so dp[i] = 1.
-> Look backward: For each current element nums[i], check every previous element nums[j].
-> Transition: If nums[j] < nums[i], append the current element to the subsequence ending at j: dp[i] = Math.max(dp[i], dp[j] + 1)
-> Answer: Return the maximum value anywhere in dp, not necessarily the last element.
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = 1;

        int maxLen = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
/*
Time: O(n^2)
Space:O(n)
[3,4,-1,0,6,2,3]  --> dp = [1,2,1,2,3,3,4]  --> maxLen = 4
 j            i
*/