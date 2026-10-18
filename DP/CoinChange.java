/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a
total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Let: A be amount and
C be the number of coin denominations.

Time: O(A×C), because you try every coin for every amount.
Space: O(A), because you store one DP value for each amount from zero to amount.
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;

        int[] minCostDp = new int[amount + 1];        // the minimum number of coins needed to make amount i.
        minCostDp[0] = 0;                     // to make amount 0, no coins needed

        for(int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;

            for(int coin : coins) {
                /* if the amount is equal or greater than the coin we can use it but if in the minCostDp value of difference of
                 the current amount and the coin we will use is Integer.MAX_VALUE it depicts that there was no way to make that
                 amount from the coins we have given so we cannot make current amount also with this coin atleast */
                if(i >= coin && minCostDp[i - coin] != Integer.MAX_VALUE) {
                    int diff = i - coin;
                    minCoins = Math.min(minCoins, 1 + minCostDp[diff]);
                }
            }

            minCostDp[i] = minCoins;
        }

        if(minCostDp[amount] == Integer.MAX_VALUE) return -1;    // means we cannot make that amount with the given coins

        return minCostDp[amount];
    }
}
/*
why greedy approach doesnt work ?
-> [1,5,6,9], amount = 11
you take 9 becz its greatest and then take two 1's so total no. of coins used = 3
but the answer would be 2 (becz of 5 and 6 these 2 coins alone can make 11)

So greedy will give for some test cases wrong o/p.
 */