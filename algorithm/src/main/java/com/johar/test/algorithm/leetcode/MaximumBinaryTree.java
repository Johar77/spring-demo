package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

/**
 * @ClassName: MaximumBinaryTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/5 23:02
 * @Since: 1.0.0
 */
public class MaximumBinaryTree {

    /**
     * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
     *
     * 创建一个根节点，其值为nums 中的最大值。
     * 递归地在最大值左边的子数组前缀上构建左子树。
     * 递归地在最大值 右边 的子数组后缀上构建右子树。
     * 返回nums 构建的 最大二叉树 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode dummyHead = buildBinaryTree(nums, 0, nums.length - 1);
        return dummyHead;
    }

    private static TreeNode buildBinaryTree(int[] nums, int begin, int end) {
        if (begin > end){
            return null;
        }
        if (begin == end){
            return new TreeNode(nums[begin]);
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = begin; i <= end; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildBinaryTree(nums, begin, maxIndex - 1);
        node.right = buildBinaryTree(nums,maxIndex + 1, end);
        return node;
    }


    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{ 3,2,1,6,0,5});
    }
}