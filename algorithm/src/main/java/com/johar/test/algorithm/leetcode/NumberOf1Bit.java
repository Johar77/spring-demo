package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: HammingWeight
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/15 23:16
 * @Since: 1.0.0
 */
public class NumberOf1Bit {


    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     *
     * https://leetcode.cn/problems/number-of-1-bits/
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0){
            n = n & (n - 1);
            result++;
        }

        return result;
    }
}