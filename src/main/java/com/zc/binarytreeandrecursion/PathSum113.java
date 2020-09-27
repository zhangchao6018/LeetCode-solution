package com.zc.binarytreeandrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        find(root,sum,"",res);
        return res;
    }

    private void find(TreeNode cur, int sum, String parentPath, List<List<Integer>> res) {
        if (cur == null)
            return;

        StringBuilder builder = new StringBuilder(parentPath);
        builder.append(cur.val);
        if (cur.left == null && cur.right == null && cur.val == sum){
            String[] split = builder.toString().split(",");
            List<Integer> list = new ArrayList<>();
            for (String s : split)
                list.add(Integer.valueOf(s));
            res.add(list);
            return;
        }

        builder.append(",");
        find(cur.left,sum-cur.val,builder.toString(),res);
        find(cur.right,sum-cur.val,builder.toString(),res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        l.right = new TreeNode(5);
        root.right = r;
        root.left = l;
        List<List<Integer>> lists = new PathSum113().pathSum(root, 8);
        System.out.println();
    }
}
