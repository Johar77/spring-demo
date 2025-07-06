package com.johar.test.algorithm.leetcode;

import java.util.Arrays;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/#/description
 *
 *
 * @ClassName: TrieTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/13 15:14
 * @Since: 1.0.0
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        int len = word.length();
        Trie tmp = this;
        for (int i = 0; i < len; i++){
            int index = word.charAt(i) - 'a';
            if (tmp.children[index] == null){
                tmp.children[index] = new Trie();
            }
            tmp = tmp.children[index];
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    private Trie searchPrefix(String prefix){
        Trie node = this;
        int len = prefix.length();
        for (int i = 0; i < len; i++){
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }

        return node;
    }
}