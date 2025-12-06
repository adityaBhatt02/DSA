package DP;

import java.util.Arrays;

public class Fibonacci {

    // Memoization (top-down approach)
    public int fib(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);    // created a dp array that stores the initial values of all indexes as 1
            return helper(n , dp);
        }

        private int helper(int n , int[] dp) {
            if (n <= 1) return n;

            if (dp[n] != -1) return dp[n];    // if the value of that fibonacci number is present in inside the dp array directly return it rather than computing again and again

            return dp[n] = helper(n - 1 , dp) + helper(n - 2 , dp);
        }
    }
