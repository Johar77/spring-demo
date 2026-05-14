package com.johar.test.algorithm.leetcodenew;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/11 10:11]
 * @updateUser : [johar]
 * @updateTime : [2026/5/11 10:11]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode746 {
    private Integer minCost;

    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        minCost = Integer.MAX_VALUE;
        dfs(cost, 0, 0);
        dfs(cost, 1, 0);
        return minCost;
    }

    private void dfs(int[] cost, int i, int curCost) {
        if (i > cost.length - 1) {
            minCost = Math.min(minCost, curCost);
            return;
        }
        curCost += cost[i];
        dfs(cost, i + 1, curCost);
        dfs(cost, i + 2, curCost);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int  n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i < n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
