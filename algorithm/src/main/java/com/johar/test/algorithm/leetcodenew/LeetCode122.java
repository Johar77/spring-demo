package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/5/28 11:43]
 * @updateUser : [johar]
 * @updateTime : [2026/5/28 11:43]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode122 {

    /**
     * 122. 买卖股票的最佳时机 II
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
     *
     * 返回 你能获得的 最大 利润 。
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
        // dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
        // dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n-1][0];
    }
}
