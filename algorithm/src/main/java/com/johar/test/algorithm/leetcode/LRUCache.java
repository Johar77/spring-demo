package com.johar.test.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: LRUCache
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/8/17 23:59
 * @Since: 1.0.0
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


}