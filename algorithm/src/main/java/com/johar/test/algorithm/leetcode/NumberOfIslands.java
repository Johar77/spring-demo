package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: NumberOfIslands
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/25 23:28
 * @Since: 1.0.0
 */
public class NumberOfIslands {

    private int[][] moveFlag = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * https://leetcode.cn/problems/number-of-islands/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                result += sinkIfNecessary(grid, i, j);
            }
        }

        return result;
    }

    private int sinkIfNecessary(char[][] grid, int row, int col){
        if (grid[row][col] != '1'){
            return 0;
        }

        grid[row][col] = '0';
        for (int i = 0; i < moveFlag.length; i++){
            int x = col + moveFlag[i][0];
            int y = row + moveFlag[i][1];
            if (x < 0 || y < 0 || y >= grid.length || x >= grid[row].length){
                continue;
            }
            sinkIfNecessary(grid, y, x);
        }

        return 1;
    }

    public int numIslands1(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                result += sinkIfNecessary(grid, i, j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfIslands o = new NumberOfIslands();
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(o.numIslands(grid));
    }
}