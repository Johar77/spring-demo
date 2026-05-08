package com.johar.test.algorithm.leetcodenew;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/5 11:29]
 * @updateUser : [johar]
 * @updateTime : [2026/5/5 11:29]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode994 {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int goodCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    goodCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        if (goodCount == 0){
            return 0;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int[] dir : DIRS) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < rows && y < cols && !visited[x][y] && grid[x][y] == 1) {
                        goodCount--;
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }

            if (goodCount == 0) {
                return res;
            }
        }

        return -1;
    }
}
