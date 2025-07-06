package com.johar.test.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Traversal
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/14 14:36
 * @Since: 1.0.0
 */
public class Traversal {

    /**
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doPostorderTraversal(root, result);

        return result;
    }

    private void doPostorderTraversal(TreeNode node, List<Integer> data){
        if (node == null){
            return;
        }

        doPostorderTraversal(node.left, data);
        doPostorderTraversal(node.right, data);
        data.add(node.val);
    }

    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doPreorderTraversal(root, result);

        return result;
    }

    private void doPreorderTraversal(TreeNode node, List<Integer> data){
        if (node == null){
            return;
        }

        data.add(node.val);
        doPreorderTraversal(node.left, data);
        doPreorderTraversal(node.right, data);
    }
}