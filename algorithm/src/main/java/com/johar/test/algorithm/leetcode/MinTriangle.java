package com.johar.test.algorithm.leetcode;

import java.util.List;

/**
 * @ClassName: MinTriangle
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/12 15:36
 * @Since: 1.0.0
 */
public class MinTriangle {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * https://leetcode.cn/problems/triangle/description/
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = row - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[col + 1];
        for (int i = row - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}