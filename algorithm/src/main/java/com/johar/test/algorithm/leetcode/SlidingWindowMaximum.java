package com.johar.test.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: SlidingWindowMaximum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/3 23:20
 * @Since: 1.0.0
 */
public class SlidingWindowMaximum {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (k == length){
            int max = max(nums, 0, length - 1);
            return new int[] { max };
        }

        int[] result = new int[length - k + 1];
        for (int i = 0; i <= length - k;i++){
            result[i] = max(nums, i, i + k - 1);
        }

        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++){
            queue.offer(new int[]{ nums[i], i});
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++){
            queue.offer(new int[]{ nums[i], i});
            while (queue.peek()[1] <= i - k){
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }

        return result;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++){
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] result = new int[len - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < len; i++){
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }

    private static int max(int[] nums, int from, int to){
        int max = nums[from];
        for (int i = from + 1; i <= to; i++){
            max = Math.max(nums[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }
}