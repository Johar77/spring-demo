package com.johar.test.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: WordLadder
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/29 23:28
 * @Since: 1.0.0
 */
public class WordLadder {

    /**
     *
     * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
     *
     * 每一对相邻的单词只差一个字母。
     *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
     *
     * https://leetcode.cn/problems/word-ladder/description/
     *
     * sand
     * acne
     *
     *
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            return 0;
        }
        if (wordList.size() == 0){
            return 0;
        }
        if (!wordList.contains(endWord)){
            return 0;
        }
        String english = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = english.toCharArray();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++){
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++){
                    for (int k = 0; k < chars.length; k++){
                        if (chars[k] == current.charAt(j)){
                            continue;
                        }

                        StringBuilder sb = new StringBuilder(current);
                        sb.setCharAt(j, chars[k]);
                        String next = sb.toString();
                        if (!visited.contains(next) && wordSet.contains(next)){
                            if (endWord.equals(next)){
                                return step + 1;
                            }

                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            step++;
        }

        return 0;
    }


    /**
     * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
     *
     * 每对相邻的单词之间仅有单个字母不同。
     * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
     *
     * https://leetcode.cn/problems/word-ladder-ii/description/
     *
     * red
     * tax
     *
     *
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            return new ArrayList<>();
        }
        if (wordList.size() == 0){
            return new ArrayList<>();
        }
        if (!wordList.contains(endWord)){
            return new ArrayList<>();
        }
        String english = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = english.toCharArray();
       //Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<QueueItem> queue = new ArrayDeque<>();
        List<String> rootPath = new LinkedList<>();
        rootPath.add(beginWord);
        queue.add(new QueueItem(beginWord, rootPath));
        //visited.add(beginWord);
        boolean flag = false;
        List<List<String>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++){
                QueueItem item = queue.poll();
                String current = item.word;
                List<String> path = item.path;
                for (int j = 0; j < current.length(); j++){
                    for (int k = 0; k < chars.length; k++){
                        if (chars[k] == current.charAt(j)){
                            continue;
                        }

                        StringBuilder sb = new StringBuilder(current);
                        sb.setCharAt(j, chars[k]);
                        String next = sb.toString();
                        //if (!visited.contains(next) && wordSet.contains(next)){
                        if (wordSet.contains(next)){
                            List<String> nextPath = new LinkedList<>(path);
                            nextPath.add(next);
                            if (endWord.equals(next)){
                                flag = true;
                                result.add(nextPath);
                                continue;
                            }

                            //visited.add(next);
                            queue.add(new QueueItem(next, nextPath));
                        }
                    }
                }
            }
            if (flag){
                break;
            }
        }

        return result;
    }

    class QueueItem {
        private String word;

        private List<String> path;

        public QueueItem() {
        }

        public QueueItem(String word, List<String> path) {
            this.word = word;
            this.path = path;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public List<String> getPath() {
            return path;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }
    }
}