package com.zc.binarytreeandrecursion;

/**
 * 描述:
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最小深度  2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class MinDepth111 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        //终止条件
        if (root.left == null && root.right == null){
            return 1;
        }

        //每一次取左右节点的最小值返回
        int c = Integer.MAX_VALUE;
        if (root.right != null){
            c = Math.min(minDepth(root.right), c);
        }
        if (root.left != null) {
            c = Math.min(minDepth(root.left), c);
        }
        return c + 1;
    }
    public int minDepthWrong(TreeNode root) {
        if (root ==null){
            return 0;
        }
        if (root.left==null && root.right !=null ){
            root.left = new TreeNode(-1);
        }
        if (root.right==null && root.left!=null){
            root.right = new TreeNode(-1);
        }
        int count = count(root);
        return count;
    }

    private int count(TreeNode cur) {
        if (cur == null)
            return 0 ;
        return Math.min(count(cur.left),count(cur.right)) + 1;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(15);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int i = new MinDepth111().minDepth(root);
        System.out.println(i);
    }
}
