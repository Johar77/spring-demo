package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @ClassName: TreeQuestion
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/7/9 19:07
 * @Since: 1.0.0
 */
public class TreeQuestion {

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     *
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> currentLevel = new ArrayList<>();
        currentLevel.add(root.val);
        result.add(currentLevel);
        getNextNodes(root.children, result);

        return result;
    }

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        if (left.size() > 0){
            result.addAll(left);
        }
        result.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        if (right.size() > 0){
            result.addAll(right);
        }

        return result;
    }

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * https://leetcode.cn/problems/binary-tree-preorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        if (left != null && left.size() > 0){
            result.addAll(left);
        }
        List<Integer> right = preorderTraversal(root.right);
        if (right != null && right.size() > 0){
            result.addAll(right);
        }

        return result;
    }

    /**
     * 给定一个 n叉树的根节点root，返回 其节点值的 后序遍历 。
     *
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/n-ary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (Node node : root.children){
            List<Integer> child = postorder(node);
            if (child != null && child.size() > 0){
                result.addAll(child);
            }
        }
        result.add(root.val);

        return result;
    }

    /**
     * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
     *
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/n-ary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                List<Integer> child = preorder(node);
                if (child != null && child.size() > 0){
                    result.addAll(child);
                }
            }
        }
        return result;
    }

    public List<Integer> preorder1(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        deque.push(root);
        while (!deque.isEmpty()){
            Node node = deque.peek();
            result.add(node.val);
            if (node.children.size() == 0 || visited.contains(node)){
                deque.pop();
                continue;
            }

            for (int i = node.children.size() - 1; i >= 0; i--){
                deque.push(node.children.get(i));
            }
            visited.add(node);
        }
        return result;
    }

    public List<Integer> postorder1(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        deque.push(root);
        while (!deque.isEmpty()){
            Node node = deque.peek();
            if (node.children.size() == 0 || visited.contains(node)){
                deque.pop();
                result.add(node.val);
                continue;
            }

            for (int i = node.children.size() - 1; i >= 0; i--){
                deque.push(node.children.get(i));
            }
            visited.add(node);
        }

        return result;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                result.add(root.val);
                deque.push(root);
                root = root.left;
            }
            root = deque.poll();
            root = root.right;
        }

        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode temp = root;
        while (temp != null || !deque.isEmpty()){
            while (temp != null){
                deque.push(temp);
                temp = temp.left;
            }
            temp = deque.poll();
            result.add(temp.val);
            temp = temp.right;
        }

        return result;
    }



    public List<List<Integer>> levelOrder1(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int count = deque.size();
            List<Integer> level = new ArrayList<>(count);
            for (int i = 0; i < count; i++){
                Node node = deque.pop();
                level.add(node.val);
                if (node.children == null || node.children.size() == 0){
                    continue;
                }
                for (Node n : node.children){
                    deque.offer(n);
                }
            }
            result.add(level);
        }

        return result;
    }

    private void getNextNodes(List<Node> nodes, List<List<Integer>> result){
        if (nodes == null || nodes.size() == 0){
            return;
        }
        List<Node> nextNodeList = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<Integer>();
        for (Node node : nodes){
            currentLevel.add(node.val);
            if (node.children == null || node.children.size() == 0){
                continue;
            }
            nextNodeList.addAll(node.children);
        }
        result.add(currentLevel);
        getNextNodes(nextNodeList, result);
    }



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}