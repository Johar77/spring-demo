package com.johar.test.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PowxN
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/22 21:54
 * @Since: 1.0.0
 */
public class PowxN {

    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
     * https://leetcode.cn/problems/powx-n/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n < 0){
            x = 1 / x;
            n = -n;
        }
        double result = 1D;
        for (int i = 0; i < n; i++){
            result = result * x;
        }

        return result;
    }

    public double myPow2(double x, int n) {
        if (x == 1 || n == 0){
            return 1D;
        }
        if (n < 0){
            x = 1.0 / x;
            n = -n;
        }

        return doPow(x, n);
    }

    public double myPow2X(double x, int n) {
        if (x == 1 || n == 0){
            return 1D;
        }

        return doPow(x, n);
    }

    private double doPow(double x, long n){
        if (n == 1) {
            return x;
        }
        double temp = doPow(x, n >> 1);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow3(double x, int n) {
        if (x == 1 || n == 0){
            return 1D;
        }
        long total = n;
        if (total < 0){
            x = 1 / x;
            total = -total;
        }
        Map<Long, Double> map = new HashMap<>();
        map.put(1L, x);
        double t = x;
        long max = 1;
        for (long i = 2; i <= total; ){
            max = i;
            t = t * t;
            map.put(i, t);
            i = i * 2;
        }
        double result = 1D;
        while (total > 0){
            while (max > total){
                max = max >> 1;
            }
            total = total - max;
            result *= map.get(max);
            if (result == 0){
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println(powxN.myPow3(2.00000D, -2147483648));
    }
}