package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MaxArea
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/20 02:28
 * @Since: 1.0.0
 */
public class MaxArea {

    public int maxArea(int[] height) {
        // 枚举
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = i + 1; j < height.length; j++){
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    public int maxArea1(int[] height) {
        // 枚举
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = height.length - 1; j > i; j--){
                if (j == height.length - 1 || (height[j] > height[j+1])) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {
        // 双指针
        int left = 0;
        int maxArea = 0;
        int right = height.length - 1;
        for (;left < right;){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}