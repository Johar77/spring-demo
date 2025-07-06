package com.johar.test.algorithm.leetcode;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.*;

/**
 * @ClassName: LargestRectangleHistogram
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/1 16:57
 * @Since: 1.0.0
 */
public class LargestRectangleHistogram {

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * https://leetcode.cn/problems/largest-rectangle-in-histogram/
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int max = heights[0];
        int length = heights.length;
        for (int i = 0; i < length; i++){
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]){
                left--;
            }
            int right = i;
            while (right < length - 1 && heights[right + 1] >= heights[i]){
                right++;
            }
            int area = (right - left + 1) * heights[i];
            max = Math.max(max, area);
        }

        return max;
    }

    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int max = heights[0];
        int len = heights.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] newHeights = new int[len+2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len = newHeights.length;
        deque.push(0);
        for (int i = 1; i < len; i++) {
            while (newHeights[i] < newHeights[deque.peek()]) {
                int index = deque.pop();
                int area = (i - deque.peek() - 1) * newHeights[index];
                max = Math.max(area, max);
            }
            deque.push(i);
        }

        return max;
    }


    public static int largestRectangleArea_error(int[] heights) {
        int max = heights[0];
        int n = heights.length;
        for (int i = 0, j = n - 1; i < j; ){
            int area = minArea(heights, i, j);
            max = Math.max(area, max);
            if (heights[i] < heights[j]){
                int h = heights[i];
                while (++i < j && heights[i] < h){
                    if (heights[i] == 0 && i < j){
                        i++;
                        break;
                    }
                }
            } else {
                int h = heights[j];
                while (i < --j && heights[j] < h){
                    if (heights[j] == 0 && i < j){
                        j--;
                        break;
                    }
                }
            }
        }

        return max;
    }

    public static int minArea(int[] nums, int from, int to){
        int min = nums[from];
        int maxArea = nums[from];
        int left = from;
        for (int i = from; i <= to; i++){
            if (nums[i] == 0){
                maxArea = Math.max(maxArea, min * (i - left));
                left = i+1;
                if (left > to){
                    min = 0;
                } else {
                    min = nums[left];
                }
                continue;
            }
            min = Math.min(nums[i], min);
        }
        if (left <= to) {
            maxArea = Math.max(maxArea, (to - left + 1) * min);
        }

        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int length = heights.length;
        int left = 0;
        int right = length - 1;
        int result = 0;
        int minHeight = Integer.MAX_VALUE;
        while (left <= right){
            minHeight = min(heights, left, right);
            int area = (right - left + 1) * minHeight;
            if (area > result) {
                result  = area;
            }
            if (left == right){
                break;
            }
            if (heights[left] < heights[right]){
                int temp = heights[left];
                while (left < right){
                    if (temp < heights[left]){
                        break;
                    }
                    left++;
                }
            } else {
                int temp = heights[right];
                while (left < right){
                    if (temp < heights[right]){
                        break;
                    }
                    right--;
                }
            }
        }

        return result;
    }

    private static int min(int[] heights, int left, int right){
        int minHeight = heights[left];
        for (int i = left + 1; i <= right; i++){
            if (heights[i] < minHeight){
                minHeight = heights[i];
            }
        }

        return minHeight;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[] {2,1,5,6,2,3 }));
    }
}