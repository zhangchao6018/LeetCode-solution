package com.zc.stackandqueue;

import javafx.util.Pair;

import java.util.*;

/**
 * 描述:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 107     103     199
 * @Author: zhangchao
 **/
public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return f2(root);
    }
    private List<List<Integer>> f2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList();
        queue.addLast(new Pair<>(root,0));

        while (!queue.isEmpty()){
            //出队
            Pair<TreeNode, Integer> first = queue.removeFirst();
            TreeNode key = first.getKey();
            //对应res的索引
            Integer level = first.getValue();
            //初始化
            if (level == res.size()){
                List<Integer> list = new ArrayList<>();
                list.add(key.val);
                res.add(list);
            }else {
                //添加对应层级元素
                res.get(level).add(key.val);
            }

            //左右节点入队
            if (key.left != null){
                queue.addLast(new Pair<>(key.left,level+1));
            }
            if (key.right != null){
                queue.addLast(new Pair<>(key.right,level+1));
            }
        }
        return res;
    }
    private List<List<Integer>> f1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        LinkedList<Map<TreeNode,Integer>> queue = new LinkedList();
        Map<TreeNode,Integer> init = new HashMap<>();
        init.put(root,0);
        queue.addLast(init);

        while (!queue.isEmpty()){
            //出队
            Map<TreeNode, Integer> first = queue.removeFirst();
            TreeNode key = first.keySet().iterator().next();
            //对应res的索引
            Integer level = first.get(key);
            //初始化
            if (level == res.size()){
                List<Integer> list = new ArrayList<>();
                list.add(key.val);
                res.add(list);
            }else {
                //添加对应层级元素
                res.get(level).add(key.val);
            }

            //左右节点入队
            if (key.left != null){
                Map<TreeNode,Integer> left = new HashMap<>();
                left.put(key.left,level+1);
                queue.addLast(left);
            }
            if (key.right != null){
                Map<TreeNode,Integer> right = new HashMap<>();
                right.put(key.right,level+1);
                queue.addLast(right);
            }

        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        List<List<Integer>> lists = new LevelOrder102().levelOrder(root);
        System.out.println(lists);
    }
}
