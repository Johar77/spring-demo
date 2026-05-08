package com.johar.test.algorithm.leetcodenew;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/5 11:08]
 * @updateUser : [johar]
 * @updateTime : [2026/5/5 11:08]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1926 {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
     * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
     * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        int sx = entrance[0];
        int sy = entrance[1];
        visited[sx][sy] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int[] dir : DIRS) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && maze[x][y] == '.') {
                        if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
                            return res;
                        }

                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return -1;
    }
}
