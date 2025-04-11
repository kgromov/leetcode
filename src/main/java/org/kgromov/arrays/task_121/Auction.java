package org.kgromov.arrays.task_121;

import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <br>
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * <br>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Auction {
    public int maxProfit_slow(int[] prices) {
        if (prices.length < 1) {
            throw new IllegalArgumentException("Prices should not be empty");
        }
        int minRate = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] >= minRate && i > 0) {
                continue;
            }
            minRate = prices[i];
            for (int j = 1; j < prices.length; j++) {
                if (j <= i) {
                    continue;
                }
                int nextDayPrice = prices[j];
                int currentProfit = nextDayPrice - minRate;
                if (currentProfit < 0) {
                    break;
                } else if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            int profit = price - least;
            if (profit >= 0) {
                max = Math.max(profit, max);
            } else {
                least = price;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {2, 1, 2, 1, 0, 1, 2};
        int[] prices4 = {1, 2};
        var solution = new Auction();
        int profit = solution.maxProfit_slow(prices4);
    }
}
