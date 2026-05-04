package com.johar.test.algorithm.leetcodenew;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/3 9:33]
 * @updateUser : [johar]
 * @updateTime : [2026/5/3 9:33]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode841 {

    /**
     * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
     * 当你进入一个房间，你可能会在里面找到一套 不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
     * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0 || rooms.size() == 1) {
            return true;
        }

        Set<Integer> posSet = IntStream.range(0, rooms.size()).boxed().collect(Collectors.toSet());
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            int p = rooms.get(0).get(i);
            if (!visited.contains(p)) {
                queue.offer(p);
            }
        }
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            if (!visited.contains(p)) {
                visited.add(p);
                for (int i = 0; i < rooms.get(p).size(); i++) {
                    int index = rooms.get(p).get(i);
                    if (!visited.contains(index)) {
                        queue.offer(index);
                    }
                }
            }
        }

        return posSet.equals(visited);
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0 || rooms.size() == 1) {
            return true;
        }

        boolean[] visited = new boolean[rooms.size()];
        int n = rooms.size(), num = 0;
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            num++;
            for (Integer it : rooms.get(p)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.offer(it);
                }
            }
        }

        return n == num;
    }

    public static void main(String[] args) {
        LeetCode841 leetCode841 = new LeetCode841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());
        System.out.println(leetCode841.canVisitAllRooms(rooms));
    }
}
