package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: ReverseInteger
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/29 00:35
 * @Since: 1.0.0
 */
public class ReverseInteger {

    public static int reverse(int x) {
        if (x == 0){
            return 0;
        }
        int positiveInt = Math.abs(x);
        int result = 0;
        int temp = 0;
        int single = 0;
        do {
            temp = result;
            single = positiveInt % 10;
            result = result * 10 + single;
            if ((result - single) / 10 != temp){
                result = 0;
                break;
            }
            positiveInt = positiveInt / 10;
            if (result < 0){
                result = 0;
                break;
            }
        } while (positiveInt > 0);

        if (x < 0){
            result = -1 * result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
    }
}