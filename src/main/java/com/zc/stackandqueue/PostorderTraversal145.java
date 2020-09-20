package com.zc.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *               10
 *             /   \
 *           8      15
 *         /      /   \
 *       5      11    18
 *    /   \         /   \
 *  4      7     16      20
 *
 *  4,7,5,8,11,16,20,18,15,10
 *
 *  todo 341
 * @Author: zhangchao
 **/
public class PostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return f2(root);
    }
    private List<Integer> f2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            resStack.push(pop.val);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }
        while (!resStack.isEmpty()){
            res.add(resStack.pop());
        }
        return res;
    }

    private List<Integer> f1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        collectData(res,root);
        return res;
    }

    private void collectData(List<Integer> res, TreeNode cur) {
        if (cur != null){
            collectData(res,cur.left);
            collectData(res,cur.right);
            res.add(cur.val);
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

        List<Integer> integers = new PostorderTraversal145().postorderTraversal(root);
                                    System.out.println(integers);
    }
}
