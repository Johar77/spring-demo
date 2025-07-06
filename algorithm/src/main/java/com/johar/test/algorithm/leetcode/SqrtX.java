package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: SqrtX
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/13 19:10
 * @Since: 1.0.0
 */
public class SqrtX {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int result = 0;
        int num = 0;
        int temp;
        while (true){
            temp = num * num;
            if (temp == x){
                result = num;
                break;
            } else if (temp > x){
                result = num - 1;
                break;
            } else {
                num++;
            }
        }

        return result;
    }

    public static int mySqrt11(int x) {
        int result = 0;
        int low = 0, high = x;
        while (low < high){
            int mid = low + ((high - low) >> 1);
            long mul = 1L * mid * mid;
            if (mul > x){
                high = mid - 1;
            } else if (mul == x) {
                result = mid;
                break;
            } else {
                low = mid + 1;
                result = mid;
            }
        }

        return result;
    }

    public static int mySqrt1(int x) {
        int result = 0;
        int low = 0, high= x;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if ((long)mid * mid <= x){
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public boolean isPerfectSquare(int num) {
        int result = 0;
        int low = 0, high = num;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            long mul = (long)mid * mid;
            if (mul == num){
                return true;
            } else if(mul < num){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static double mySqrtEx(int x) {
        double result = 0;
        double low = 0, high= x;
        double temp = 0;
        while (Math.abs(x - temp) > 0.000000000001){
            double mid = low + ((high - low) / 2.0);
            temp = mid * mid;
            if (temp <= x){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            result = mid;
        }

        return result;
    }



    public static void main(String[] args) {
        System.out.println(mySqrt11(1));
        System.out.println(mySqrt11(8));
    }
}