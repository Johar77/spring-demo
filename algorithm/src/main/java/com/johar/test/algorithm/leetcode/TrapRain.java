package com.johar.test.algorithm.leetcode;

import org.apache.logging.log4j.message.ReusableMessage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: TrapRain
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/5 00:26
 * @Since: 1.0.0
 */
public class TrapRain {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;
        if (height == null || height.length == 0 || height.length == 1){
            return result;
        }
        int left = 0;
        int right = height.length - 1;
        int min = height[left];
        for (int i = right - 1; i > left; i--){
            if (height[i] >= height[right]){
                right = i;
            } else {
                break;
            }
        }
        int sum = 0;
        for (int i = left + 1; i < right; i++){
            if (height[i] >= height[left]){
                min = Math.min(height[left], height[i]);
                result = result + min * (i - left -1) - sum;
                left = i;
                sum = 0;
            } else {
                sum += height[i];
            }
        }
        sum = 0;
        for (int i = right; i > left; i--){
            if (height[i] >= height[right]){
                min = Math.min(height[i], height[right]);
                result = result + min * (right - i - 1) - sum;
                right = i;
            } else {
                sum += height[i];
            }
        }
        min = Math.min(height[left], height[right]);
        result = result + min * (right - left - 1) - sum(height, left, right);

        return result;
    }

    public int trap1(int[] height) {
        int result = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }

    public int trap2(int[] height){
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        int len = height.length;
        for (int i = 0; i < len; i++){
            while (!deque.isEmpty() && height[i] > height[deque.peekLast()]){
                int top = deque.pollLast();
                if (deque.isEmpty()){
                    break;
                }

                int left = deque.peekLast();
                int w = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[top];
                result += w * h;
            }
            deque.offerLast(i);
        }

        return result;
    }

    private static int sum(int[] nums, int left, int right){
        int sum = 0;
        for (int i = left + 1; i < right; i++){
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }));
        System.out.println(trap(new int[] { 1 }));
        System.out.println(trap(new int[] { 5,4,1,2 }));
        System.out.println(trap(new int[] { 9,6,8,8,5,6,3 }));
        System.out.println(trap(new int[] { 6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3 }));
    }
}