package com.zc.binarytreeandrecursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
 * @Author: zhangchao
 *
 * todo 111
 **/
public class MaxDepth104 {

    public int maxDepth(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root) {
        if (root == null)
            return 0;
        return  Math.max(count(root.left), count(root.right)) + 1;
    }


    public int maxDepth2(TreeNode root) {
        int res = count2(root, 1, 0);
        return res;
    }

    private int count2(TreeNode root, int deep, int res) {
        if (root != null){
            if (deep > res){
                res = deep;
            }
            int left = count2(root.left, deep + 1, res);
            int right = count2(root.right, deep + 1, res);
            res = Math.max(left, right);
        }
        return res;
    }


    public int maxDepth1(TreeNode root) {

        Set<Integer> set = new HashSet<>();
        count1(root,1,set);
        int res = 0;
        for (Integer integer : set) {
            if (integer > res)
                res  = integer;
        }
        return res;
    }

    private void count1(TreeNode root, int count, Set<Integer> set) {
        if (root != null){
            if (!set.contains(count)){
                set.add(count);
            }
            count1(root.left,count+1,set);
            count1(root.right,count+1,set);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        new MaxDepth104().maxDepth(root);
    }
}

