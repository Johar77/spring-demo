package com.johar.test.algorithm.leetcodenew;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/4/27 11:01]
 * @updateUser : [johar]
 * @updateTime : [2026/4/27 11:01]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode735 {

    /**
     * 给定一个整数数组 asteroids，表示在同一行的小行星。数组中小行星的索引表示它们在空间中的相对位置。
     * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
     * 每一颗小行星以相同的速度移动。
     * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，
     * 则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length;) {
            Integer last = stack.peek();
            if (last == null) {
                stack.push(asteroids[i]);
                i++;
                continue;
            }
            if ((last > 0 && asteroids[i] < 0)) {
                int absLeft = Math.abs(last);
                int absRight = Math.abs(asteroids[i]);
                if (absLeft == absRight) {
                    stack.pop();
                    i++;
                } else if (absLeft > absRight) {
                    // no thing
                    i++;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(asteroids[i]);
                i++;
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (i >= 0) {
            res[i] = stack.pop();
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode735 leetCode735 = new LeetCode735();
        print(leetCode735.asteroidCollision(new int[] { 5,10,-5 }));
        print(leetCode735.asteroidCollision(new int[] { 8,-8 }));
        print(leetCode735.asteroidCollision(new int[] { 10,2,-5 }));
        print(leetCode735.asteroidCollision(new int[] { 3,5,-6,2,-1,4}));
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
