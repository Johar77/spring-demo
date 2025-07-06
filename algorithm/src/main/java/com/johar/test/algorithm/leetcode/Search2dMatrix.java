package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: Search2dMatrix
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/5 23:29
 * @Since: 1.0.0
 */
public class Search2dMatrix {

    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非递减顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     *
     * https://leetcode.cn/problems/search-a-2d-matrix/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]){
            return false;
        }
        for (int i = 0; i < row; i++){
            if (target < matrix[i][0] || target > matrix[i][col - 1]){
                continue;
            }
            int low = 0, high = col - 1;
            while (low <= high){
                int mid = low + ((high - low) >> 1);
                int t = matrix[i][mid];
                if (t == target){
                    return true;
                } else if (t < target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            break;
        }

        return false;
    }
}