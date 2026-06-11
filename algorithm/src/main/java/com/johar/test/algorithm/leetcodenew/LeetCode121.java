package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/5/28 11:30]
 * @updateUser : [johar]
 * @updateTime : [2026/5/28 11:30]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode121 {

    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }

        return max;
    }
}
