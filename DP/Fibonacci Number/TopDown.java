/*
Normal recursion (Recalculates subproblems)
Time : O(2n) upper bound
Space : O(n)

Top-down DP (Recursion + caching)
Time : O(n)
Space : O(n)

Bottom-up DP (Loop + array)
Time : O(n)
Space : O(n)
 */

public class TopDown {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if(n <= 1) return n;

        if(dp[n] != 0) return dp[n];                 // if already calculated reuse the answer

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);          // calculate and store the answer

        return dp[n];
    }
}