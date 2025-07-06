package com.johar.test.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: CoinChange
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/11 17:01
 * @Since: 1.0.0
 */
public class CoinChange {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/gaM7Ch
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] < i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]) + 1;
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(amount);
        visited.add(amount);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int num = queue.poll();
                if (num == 0){
                    return level;
                }
                for (int j = 0; j < coins.length; j++){
                    int newNum = num - coins[j];
                    if (newNum >= 0 && !visited.contains(newNum)){
                        visited.add(newNum);
                        queue.offer(newNum);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange1(coins, 100));
    }
}