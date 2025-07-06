package com.johar.test.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: WordSearch
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/13 15:47
 * @Since: 1.0.0
 */
public class WordSearch {

    private int[][] op =  {
        {-1, 0},
        {0, -1},
        {1, 0},
        {0, 1}
    };

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * https://leetcode.cn/problems/word-search/
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean result = dfs(board, visited, i, j, word, 0);
                    if (result){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int index){
        if (board[row][col] != word.charAt(index)){
            return false;
        }
        if (index == word.length() - 1){
            return true;
        }
        int y = board.length;
        int x = board[0].length;
        visited[row][col] = true;
        for (int i = 0; i < op.length; i++){
            int newCol = col + op[i][0];
            int newRow = row + op[i][1];
            if (newRow < 0 || newRow >= y || newCol < 0 || newCol >= x || visited[newRow][newCol]){
                continue;
            }
            boolean result = dfs(board, visited, newRow, newCol, word, index + 1);
            if (result){
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }


    /**
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
     *
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * https://leetcode.cn/problems/word-search-ii/
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                dfs1(board, i, j, trie, "", visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs1(char[][] board, int row, int col, Trie trie, String current, boolean[][] visited, Set<String> result){
        int index = board[row][col] - 'a';
        Trie[] tries = trie.getChildren();
        Trie newTrie = tries[index];
        if (newTrie == null){
            return;
        }
        if (newTrie.isEnd()){
            result.add(current + board[row][col]);
        }

        visited[row][col] = true;
        int yLen = board.length;
        int xLen = board[0].length;
        for (int i = 0; i < op.length; i++){
            int newCol = col + op[i][0];
            int newRow = row + op[i][1];
            if (newRow < 0 || newRow >= yLen || newCol < 0 || newCol >= xLen || visited[newRow][newCol]){
                continue;
            }
            dfs1(board, newRow, newCol, newTrie, current + board[row][col], visited, result);
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        //char[][] board = {{'a','a','a', 'a'},{'a','a','a', 'a'},{'a','a','a', 'a'}};
        //boolean result = ws.exist(board, "aaaaaaaaaaaaa");
        //System.out.println(result);
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = ws.findWords(board, words);
        System.out.println(result);
    }
}