package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: BinaryTreeLevelOrderTraversal
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/24 23:39
 * @Since: 1.0.0
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/#/description
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result){
        if (node == null){
            return;
        }

        if (result.size() > level){
            List<Integer> current = result.get(level);
            current.add(node.val);
        } else {
            List<Integer> current = new LinkedList<>();
            current.add(node.val);
            result.add(level, current);
        }
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }


    private void bfs(List<TreeNode> nodeList, List<List<Integer>> result){
        if (nodeList == null || nodeList.size() == 0){
            return;
        }

        List<TreeNode> nextLevelNodeList = new LinkedList<>();
        List<Integer> currentLevel = new LinkedList<>();
        for (TreeNode node : nodeList){
            currentLevel.add(node.val);
            if (node.left != null){
                nextLevelNodeList.add(node.left);
            }
            if (node.right != null){
                nextLevelNodeList.add(node.right);
            }
        }
        result.add(currentLevel);
        bfs(nextLevelNodeList, result);
    }
}