package com.johar.test.algorithm.leetcodenew;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/26 9:47]
 * @updateUser : [johar]
 * @updateTime : [2026/4/26 9:47]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode2352 {

    /**
     * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
     * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> colMap = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < col; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < row; j++) {
                stringBuilder.append(grid[j][i]).append(",");
            }
            String key = stringBuilder.toString();
            int count = colMap.getOrDefault(key, 0);
            colMap.put(key, count + 1);
        }
        for (int i = 0; i < row; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < col; j++) {
                stringBuilder.append(grid[i][j]).append(",");
            }
            String key = stringBuilder.toString();
            int count = colMap.getOrDefault(key, 0);
            result += count;
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode2352 leetCode2352 = new LeetCode2352();
        System.out.println(leetCode2352.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(leetCode2352.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }
}
