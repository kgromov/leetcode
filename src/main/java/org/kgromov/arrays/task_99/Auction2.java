package org.kgromov.arrays.task_99;

public class Auction2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // Iterate through the array starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If today's price is higher than yesterday's price,
            // we can make a profit by buying yesterday and selling today
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
