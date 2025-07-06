package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: PowerOfTwo
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/15 23:20
 * @Since: 1.0.0
 */
public class PowerOfTwo {

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     *
     * https://leetcode.cn/problems/power-of-two/
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        n = n & (n - 1);
        if (n == 0){
            return true;
        } else {
            return false;
        }
    }
}