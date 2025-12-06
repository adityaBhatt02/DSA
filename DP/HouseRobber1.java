package DP;

/*
So the approach is that we will focus on 3 houses at a time only last house which we are robbing is 'n' then
the house before that is n-1 and n-2 .
Now two conditions appear
-> first is if we stole from nth house then we can not steal from n-1th house so it's the
sum of total money stole till n-2th house + the nth house.
-> second is that if we don't steal from the nth house then it only mean that we stole from n-1th house
that's why we can steal it from nth house so now total money stole till n-1th house.

And we create a dp array that will store the maximum amount of money that can be stolen at that particular
index(house).

eg -> [2,7,9,3,1]
(2 + 9 + 1) = 12
 */

public class HouseRobber1 {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int[] dp = new int[nums.length];           // Memoization
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i] , dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
