package DP;

/*
Each price[i] represents price of a particular stock at ith day.
Interview : "I'll maintain the minimum price seen so far as the best buying point. For each current price, I'll calculate the profit if I sell today and keep track of the maximum profit. 
This gives O(n) time and O(1) space"

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation:
Buy on day 2 (price = 1)
Sell on day 5 (price = 6)
Profit = 6 - 1 = 5
 */

public class BestTimeToBuyAndSellStocks1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;          // currently price jo minimum chl rha hae
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
