package com.johar.test.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: NQueens
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/23 18:49
 * @Since: 1.0.0
 */
public class NQueens {

    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * https://leetcode.cn/problems/n-queens/
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(n, 0, new ArrayList<String>(), new HashSet<>(), new HashSet<>(), new HashSet<>(), result);
        return result;
    }

    private void dfs(int n, int row, List<String> cur, Set<Integer> colSet, Set<Integer> sumSet, Set<Integer> subtractSet, List<List<String>> result){
        if (n == row){
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int col = 0; col < n; col++){
            int sum = col + row;
            int subtract = col - row;
            if (colSet.contains(col) || sumSet.contains(sum) || subtractSet.contains(subtract)){
                continue;
            }

            String curLine = setPosition(n, col);
            cur.add(curLine);
            colSet.add(col);
            sumSet.add(sum);
            subtractSet.add(subtract);
            dfs(n, row + 1, cur, colSet, sumSet, subtractSet, result);
            cur.remove(cur.size() - 1);
            colSet.remove(col);
            sumSet.remove(sum);
            subtractSet.remove(subtract);
        }
    }

    private String setPosition(int len, int index){
        char[] chars = new char[len];
        Arrays.fill(chars, '.');
        chars[index] = 'Q';

        return new String(chars);
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.solveNQueens(1));
    }
}