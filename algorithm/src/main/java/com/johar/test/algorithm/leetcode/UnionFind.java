package com.johar.test.algorithm.leetcode;

/**
 * 并查集
 * @ClassName: UnionFind
 * @Description: 并查集
 * @Author: Johar
 * @Date: 2023/8/13 22:07
 * @Since: 1.0.0
 */
public class UnionFind {

    private int[] fa;

    public UnionFind(int n){
        if (n < 1){
            throw new IllegalArgumentException("n must greater 0");
        }
        fa = new int[n];
        for (int i = 0; i < n; i++){
            fa[i] = i;
        }
    }

    int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        else {
            //父节点设为根节点
            fa[x] = find(fa[x]);
            //返回父节点
            return fa[x];
        }
    }

    void merge(int i, int j) {
        fa[find(i)] = find(j);
    }
}