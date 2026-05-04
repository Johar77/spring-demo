package com.johar.test.algorithm.leetcodenew;

import java.util.Arrays;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/3 10:09]
 * @updateUser : [johar]
 * @updateTime : [2026/5/3 10:09]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode547 {

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * 返回矩阵中 省份 的数量。
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, i, j);
            }
        }

    }
}
