package com.johar.test.algorithm.leetcodenew;

import java.util.*;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/4 11:21]
 * @updateUser : [johar]
 * @updateTime : [2026/5/4 11:21]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode1466 {

    /**
     * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。
     * 去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
     * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
     * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
     * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
     * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        // key: from  value: to
        Map<Integer, List<Integer>> fromToMap = new HashMap<>();
        // key: to, value:from
        Map<Integer, List<Integer>> toFromMap = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            fromToMap.merge(from, new ArrayList<>(List.of(to)), (oldList, newList) ->  { oldList.addAll(newList); return oldList; } );
            toFromMap.merge(to, new ArrayList<>(List.of(from)), (oldList, newList) ->  { oldList.addAll(newList); return oldList; } );
        }

        Deque<Integer> queue = new LinkedList<>();
        boolean[] fromVisited = new boolean[n];
        boolean[] toVisited = new boolean[n];
        queue.offer(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> fromToList = fromToMap.getOrDefault(cur, new ArrayList<>());
                for (int j : fromToList) {
                    if (toVisited[j]) {
                        continue;
                    }
                    count++;
                    queue.offer(j);
                }
                List<Integer> toFromList = toFromMap.getOrDefault(cur, new ArrayList<>());
                for (int j : toFromList) {
                    if (fromVisited[j]) {
                        continue;
                    }
                    queue.offer(j);
                }
                fromVisited[cur] = true;
                toVisited[cur] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode1466 leetCode1466 = new LeetCode1466();
        int[][] c = new int[][]{{0,1}, {1, 3}, {2, 3}, {4, 0},{4,5}};
        System.out.println(leetCode1466.minReorder(6, c));
    }
}
