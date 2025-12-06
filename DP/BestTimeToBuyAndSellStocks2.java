package DP;

/*
You are given an array prices[] where prices[i] is the price of a stock on day i.
You can make as many transactions as you want (buy → sell → buy → sell again),
but you cannot hold more than one stock at a time.
Return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation:
Buy at 1, sell at 5 → profit = 4
Buy at 3, sell at 6 → profit = 3
Total profit = 4 + 3 = 7

 */

public class BestTimeToBuyAndSellStocks2 {
        public int maxProfit(int[] prices) {
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];                         //Every time prices[i] > prices[i - 1],it means profit can be made between those two days.So you add all those differences
            }
            return profit;
        }
    }