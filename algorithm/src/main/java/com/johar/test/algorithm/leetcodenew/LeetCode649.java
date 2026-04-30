package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/28 11:17]
 * @updateUser : [johar]
 * @updateTime : [2026/4/28 11:17]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode649 {

    /**
     * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
     * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
     * 剥夺一名参议员的权利：一名参议员可以使另一名参议员在本轮及所有后续轮次中失去所有权利。
     * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
     * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        Deque<Integer> rQueue = new ArrayDeque<>();
        Deque<Integer> dQueue = new ArrayDeque<>();
        int lenth = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) {
                rQueue.offer(r + lenth);
            } else {
                dQueue.offer(r + lenth);
            }
        }

        if (!rQueue.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    public static void main(String[] args) {
        LeetCode649 leetCode649 = new LeetCode649();
        System.out.println(leetCode649.predictPartyVictory("RDD"));
    }
}
