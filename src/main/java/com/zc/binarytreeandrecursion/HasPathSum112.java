package com.zc.binarytreeandrecursion;

/**
 * 描述:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
 *          /  \      \
 *         7    2      1
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 *
 * todo 111 404
 **/
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return goAndGetResult(root,sum);

    }

    private boolean goAndGetResult(TreeNode root, int sum) {

        if (root != null){
            if (root.left == null && root.right == null && root.val == sum)
                return true;
            else if (goAndGetResult(root.left,sum - root.val))
                return true;
            else if (goAndGetResult(root.right,sum - root.val))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode l = new TreeNode(4);
//        TreeNode r = new TreeNode(8);
//        root.left = l;
//        root.right = r;
//
//        TreeNode ll = new TreeNode(11);
//        TreeNode lll = new TreeNode(7);
//        l.left = ll;
//        ll.left = lll;
//        ll.right = new TreeNode(2);
//
//        TreeNode rl = new TreeNode(13);
//        TreeNode rr = new TreeNode(4);
//        r.left = rl;
//        r.right = rr;
//        rr.right = new TreeNode(1);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new HasPathSum112().hasPathSum(root, 1));
    }
}
