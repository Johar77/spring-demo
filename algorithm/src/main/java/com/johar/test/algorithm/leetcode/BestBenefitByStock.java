package com.johar.test.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: BestBenifitByStock
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/30 18:11
 * @Since: 1.0.0
 */
public class BestBenefitByStock {

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null){
            return 0;
        }
        int result = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }

    /**
     *
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int result = 0;
        int min = prices[0];
        int max = prices[0];
        for(int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > prices[i - 1]){
                max = Math.max(max, prices[i]);
                result = Math.max(result, max - min);
            }
        }

        return result;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int buy1 = - prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < len; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }

        return Math.max(sell1, sell2);
    }


    /**
     * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit4(int k, int[] prices) {
        int result = Integer.MIN_VALUE;
        int len = prices.length;
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++){
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
            result = Math.max(result, dp[i][1]);
        }
        for (int i = 1; i < len; i++){
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], prices[i] + dp[0][0]);
            result = Math.max(result, dp[0][1]);
            for (int j = 1; j < k; j++){
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], prices[i] + dp[j][0]);
                result = Math.max(result, dp[j][1]);
            }
        }

        return result;
    }

    /**
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit5(int[] prices, int fee) {
        int len = prices.length;
        int result = 0;
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = -fee;
        for (int i = 1; i < len; i++){
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], prices[i] + dp[0] - fee);
            result = Math.max(result, Math.max(dp[0], dp[1]));
        }

        return result;
    }
}