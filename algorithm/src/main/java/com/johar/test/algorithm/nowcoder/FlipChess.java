package com.johar.test.algorithm.nowcoder;

/**
 * @ClassName: FlipChess
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 22:53
 * @Since: 1.0.0
 */
public class FlipChess {

    public int[][] flipChess (int[][] A, int[][] f) {
        // write code here
        if (f == null || f.length == 0){
            return A;
        }

        int length = f.length;
        int x = 0, y = 0;
        for (int i = 0; i < length; i++){
            // 左 上 右 下
            x = f[i][0] - 1;
            y = f[i][1] - 1;
            if (x > 0){
                // 左
                A[x - 1][y] = revert(A[x - 1][y]);
            }
            if (y > 0){
                // 上
                A[x][y - 1] = revert(A[x][y-1]);
            }
            if (x < 3){
                // 右
                A[x+1][y] = revert(A[x+1][y]);
            }
            if (y < 3){
                // 下
                A[x][y+1] = revert(A[x][y+1]);
            }
        }

        return A;
    }

    private int revert(int num){
        if (num == 1){
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[2][3];
        System.out.println(nums[0].length);
        System.out.println(nums.length);
    }
}