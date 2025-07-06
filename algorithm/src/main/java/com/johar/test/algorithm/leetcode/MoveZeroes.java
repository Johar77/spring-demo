package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: MoveZeroes
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/6/20 02:59
 * @Since: 1.0.0
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int[] copy = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] != 0){
                copy[index++]=nums[i];
            }
        }

        for (int i = index; i < length; i++){
            copy[i] = 0;
        }
        nums = copy;
    }

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] == 0){
                continue;
            } else {
                if (index < i){
                    nums[index] = nums[i];
                }
                index++;
            }
        }

        for (int i = index; i < length; i++){
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] != 0){
                if (index < i){
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}