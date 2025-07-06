package com.johar.test.algorithm.leetcode;

import com.johar.test.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: SerializeDeserializeBinaryTree
 * @Description:
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * @Author: Johar
 * @Date: 2023/7/16 18:20
 * @Since: 1.0.0
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.

    /**
     * deque: offer poll
     * deque: push pop
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        doSerialize(root, stringBuilder);

        return stringBuilder.toString();
    }

    private static void doSerialize(TreeNode node, StringBuilder stringBuilder){
        if (node == null){
            stringBuilder.append("null,");
            return;
        } else {
            stringBuilder.append(node.val);
            stringBuilder.append(',');
            doSerialize(node.left, stringBuilder);
            doSerialize(node.right, stringBuilder);
        }
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return doDeserialize(list);
    }

    private static TreeNode doDeserialize(List<String> data){
        if ("null".equals(data.get(0))){
            data.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        root.left = doDeserialize(data);
        root.right = doDeserialize(data);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = deserialize("[1,2,3,null,null,4,5]");
        System.out.println(serialize(node1));
    }
}