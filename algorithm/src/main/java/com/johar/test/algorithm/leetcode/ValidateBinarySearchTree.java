package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

import javax.print.attribute.standard.NumberUp;

/**
 * @ClassName: ValidateBinarySearchTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/16 16:56
 * @Since: 1.0.0
 */
public class ValidateBinarySearchTree {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper){
        if (root == null){
            return true;
        }

        if (root.val <= lower || root.val >= upper){
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}