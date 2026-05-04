package com.johar.test.algorithm.leetcodenew;

import java.util.*;

/**
 * @author : [johar]
 * @description : https://leetcode.cn/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75
 * @createTime : [2026/5/4 12:39]
 * @updateUser : [johar]
 * @updateTime : [2026/5/4 12:39]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LeetCode399 {

    /**
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
     * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Set<String> set = new HashSet<String>();
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            set.add(a);
            set.add(b);
            map.put(String.format("%s/%s", a, b), values[i]);
            map.put(String.format("%s/%s", b, a), 1.0D / values[i]);
        }
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!set.contains(a) || !set.contains(b)) {
                res[i] = -1.0D;
                continue;
            }
            if (Objects.equals(a, b)) {
                res[i] = 1.0D;
                continue;
            }
            String uniqueId = String.format("%s/%s", a, b);
            if (map.containsKey(uniqueId)) {
                res[i] = map.get(uniqueId);
                continue;
            }
            // 需要转化的情况
            String startWith = String.format("%s/", a);
            String endWith = String.format("/%s", b);
            boolean flag = false;
            for (String key: map.keySet()) {
                if (key.startsWith(startWith)) {
                    String matchEnd = getSecond(key);
                    String matchKey = String.format("%s/%s", matchEnd, b);
                    if (map.containsKey(matchKey)) {
                        flag = true;
                        res[i] = map.get(key) * map.get(matchKey);
                        break;
                    }
                } else if (key.startsWith(endWith)) {
                    String matchStart = getFirst(key);
                    String matchKey = String.format("%s/%s", a, matchStart);
                    if (map.containsKey(matchKey)) {
                        flag = true;
                        res[i] = map.get(key) * map.get(matchKey);
                        break;
                    }
                }
            }
            if (!flag) {
                res[i] = -1.0D;
            }
        }

        return res;
    }

    private String getFirst(String s) {
        String[] array = s.split("/");
        return array[0];
    }

    private String getSecond(String s) {
        String[] array = s.split("/");
        return array[1];
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind unionFind = new UnionFind(n * 2);
        Map<String, Integer> map = new HashMap<>(n * 2);
        int index = 0;
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, index);
                index++;
            }
            if (!map.containsKey(b)) {
                map.put(b, index);
                index++;
            }
            unionFind.union(map.get(a), map.get(b), values[i]);
        }

        int len = queries.size();
        double[]  res = new double[len];
        for (int i = 0; i < len; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Integer idA = map.get(a);
            Integer idB = map.get(b);
            if (idA == null || idB == null) {
                res[i] = -1.0D;
            } else {
                res[i] = unionFind.isConnected(idA, idB);
            }

        }

        return res;
    }

    private class UnionFind {
        private int[] parent;
        private double[] ratio;
        public UnionFind(int n) {
            parent = new int[n];
            ratio = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                ratio[i] = 1.0D;
            }
        }
        public int find(int a) {
            if (parent[a] != a) {
                int origin = parent[a];
                parent[a] = find(parent[a]);
                ratio[a] *= ratio[origin];
            }
            return parent[a];
        }

        public void union(int a, int b, double value) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            parent[rootA] = rootB;
            ratio[rootA] = ratio[b] * value / ratio[a];
        }

        public double isConnected(int idA, int idB) {
            int rootA = find(idA);
            int rootB = find(idB);
            if (rootA == rootB) {
                return ratio[idA] / ratio[idB];
            } else {
                return -1.0D;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = List.of(List.of("x1","x2"), List.of("x2","x3"), List.of("x3","x4"), List.of("x4","x5"));
        double[] values = new double[] { 3.0,4.0,5.0,6.0};
        List<List<String>> queries = List.of(List.of("x1","x5"), List.of("x5","x2"),List.of("x2","x4"), List.of("x2","x2"), List.of("x2","x9"), List.of("x9","x9"));
        double[] res = leetCode399.calcEquation2(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }
}
