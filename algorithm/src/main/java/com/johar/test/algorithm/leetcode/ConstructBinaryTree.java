package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ConstructBinaryTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/18 23:32
 * @Since: 1.0.0
 */
public class ConstructBinaryTree {

    private Map<Integer, Integer> map;

    /**
     * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        map = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return buildTreeNode(preorder, inorder, 0, n - 1, 0, n- 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight){
            return null;
        }

        int preorderRoot = preLeft;
        int inorderRoot = map.get(preorder[preorderRoot]);
        int leftTreeSize = inorderRoot - inLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        root.left = buildTreeNode(preorder, inorder, preLeft + 1, preLeft + leftTreeSize, inLeft, inorderRoot - 1);
        root.right = buildTreeNode(preorder, inorder, preLeft + leftTreeSize + 1, preRight, inorderRoot + 1, inRight);
        return root;
    }
}