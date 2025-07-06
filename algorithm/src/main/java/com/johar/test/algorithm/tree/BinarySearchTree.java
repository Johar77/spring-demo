package com.johar.test.algorithm.tree;

/**
 * @ClassName: BinarySearchTree
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/14 14:55
 * @Since: 1.0.0
 */
public class BinarySearchTree {

    public static TreeNode find(TreeNode root, int data){
        TreeNode dummyRoot = root;
        while (dummyRoot != null){
            if (dummyRoot.val > data){
                dummyRoot = dummyRoot.left;
            } else if (dummyRoot.val < data){
                dummyRoot = dummyRoot.right;
            } else {
                return dummyRoot;
            }
        }

        return null;
    }

    public static void insert(TreeNode root, int data){
        if (root == null){
            root = new TreeNode(data);
            return;
        }

        TreeNode p = root;
        while (p != null){
            if (p.val < data){
                if (p.right == null){
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null){
                    p.left = new TreeNode(data);
                    return;
                }
                p = root.left;
            }
        }
    }



    public static void delete(TreeNode root, int data) {
        TreeNode p = root; // p指向要删除的节点，初始化指向根节点
        TreeNode pp = null; // pp记录的是p的父节点
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            TreeNode minP = p.right;
            TreeNode minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) root = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }
}