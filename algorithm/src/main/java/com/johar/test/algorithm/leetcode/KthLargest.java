package com.johar.test.algorithm.leetcode;

import java.util.Arrays;

/**
 * @ClassName: KthLargest
 * @Description:
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Johar
 * @Date: 2023/5/13 22:45
 * @Since: 1.0.0
 */
public class KthLargest {

    private int[] data;
    private int capacity = 0;
    private int size = 0;
    private int k;
    private int half_max = Integer.MAX_VALUE >> 1;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.size = nums.length;
        this.capacity = compute(nums.length);
        this.data = new int[this.capacity];
        Arrays.sort(nums);
        System.arraycopy(nums, 0, this.data, 0, nums.length);
    }

    private int compute(int length){
        if (length > half_max){
            return Integer.MAX_VALUE;
        } else {
            return length << 1;
        }
    }

    public int add(int val) {
        if (this.size == this.capacity){
            int newCapacity = compute(this.capacity);
            int[] newData = new int[newCapacity];
            System.arraycopy(this.data, 0, newData, 0, this.size);
            this.data = newData;
            this.capacity = newCapacity;
        }
        int index = bsearch(this.data, this.size, val);
        if (index < 0){
            this.data[this.size] = val;
        } else {
            System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
            this.data[index] = val;
        }
        this.size++;
        return this.data[this.size - this.k];
    }

    /**
     * 查找第一个大于等于value的数
     * @param a
     * @param n
     * @param value
     * @return
     */
    private int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n -1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value){
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}