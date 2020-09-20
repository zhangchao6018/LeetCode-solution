package com.zc.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *               10
 *             /   \
 *           8      15
 *         /      /   \
 *       5      11    18
 *    /   \         /   \
 *  4      7     16      20
 *
 *  10,8,5,4,7,15,11,18,16,20
 * @Author: zhangchao
 **/
public class PreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return f2(root);
    }

    private List<Integer> f2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right!=null) {
                stack.push(cur.right);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
            }

        }
        return res;
    }
    /**
     * 递归
     * @param root
     * @return
     */
    private List<Integer> f1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        colectData(res,root);
        return res;
    }

    private void colectData(List<Integer> res, TreeNode cur) {
        if (cur != null){
            res.add(cur.val);
            colectData(res,cur.left);
            colectData(res,cur.right);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode right = new TreeNode(2);
//        TreeNode rightLeft = new TreeNode(3);
//        right.left = rightLeft;
//        root.right = right;

//        TreeNode root = new TreeNode(3);
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(10);
//        root.left = left;
//        root.right = right;

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.right.right.right = new TreeNode(20);
        root.right.left = new TreeNode(11);
        root.right.right.left = new TreeNode(16);

        List<Integer> integers = new PreorderTraversal144().preorderTraversal(root);
        System.out.println(integers);
    }
}


