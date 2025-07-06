package com.johar.test.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LemonadeChange
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/11 16:36
 * @Since: 1.0.0
 */
public class LemonadeChange {

    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0){
            return true;
        }
        Map<Integer, Integer> coinMap = new HashMap<>(6);
        coinMap.put(5, 0);
        coinMap.put(10, 0);
        coinMap.put(20, 0);
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5){
                coinMap.put(5, coinMap.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
                Integer num = coinMap.get(5);
                if (num < 1){
                    return false;
                }
                coinMap.put(5, num - 1);
                coinMap.put(10, coinMap.getOrDefault(10, 0) + 1);
            } else if (bills[i] == 20) {
                Integer num1 = coinMap.get(5);
                Integer num2 = coinMap.get(10);
                if (num1 < 1){
                    return false;
                }
                if (num2 < 1 && num1 < 3){
                    return false;
                }
                if (num2 > 0){
                    coinMap.put(5, num1 - 1);
                    coinMap.put(10, num2 - 1);
                } else {
                    coinMap.put(5, num1 - 3);
                }


                coinMap.put(20, coinMap.getOrDefault(20, 0) + 1);
            } else {
                throw new IllegalArgumentException("不支持5,10,20之外的金额");
            }
        }

        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int[] coinNum = new int[2];
        for (int i = 0; i < bills.length; i++){
            if (!change(bills[i], coinNum)){
                return false;
            }
        }

        return true;
    }

    private boolean change(int pay, int[] coinNum){
        if (pay == 5) {
            coinNum[0]++;
        } else if (pay == 10){
            coinNum[1]++;
        }
        int toReturn = pay - 5;
        if (toReturn ==  0){
            return true;
        }
        if (coinNum[1] > 0 && toReturn >= 10){
            toReturn -= 10;
            coinNum[1]--;
        }

        int count = toReturn / 5;
        if (count > 0 && coinNum[0] >= count){
            toReturn = 0;
            coinNum[0] = coinNum[0] - count;
        }

        return toReturn == 0;
    }
}