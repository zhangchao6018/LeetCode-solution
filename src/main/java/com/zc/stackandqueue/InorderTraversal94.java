package com.zc.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
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
 *  4,5,7,8,10,11,15,16,18,20
 * @Author: zhangchao
 **/
public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return f2(root);
    }
    private List<Integer> f2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while ( cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
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
        collectData(res,root);
        return res;
    }

    private void collectData(List<Integer> res, TreeNode cur) {
        if (cur != null){
            collectData(res,cur.left);
            res.add(cur.val);
            collectData(res,cur.right);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode right = new TreeNode(2);
//        TreeNode rightLeft = new TreeNode(3);
//        right.left = rightLeft;
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
        List<Integer> integers = new InorderTraversal94().inorderTraversal(root);
        System.out.println(integers);
    }
}
