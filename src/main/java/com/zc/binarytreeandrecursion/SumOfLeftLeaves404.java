package com.zc.binarytreeandrecursion;

/**
 * 描述:
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class SumOfLeftLeaves404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root !=null && root.right == null && root.left == null){
            return 0;
        }
        return leftLeave(root,true);
    }



    /**
     *
     * @param cur       当前节点
     * @param isLeft    当前节点是左节点还是右节点
     */
    private int leftLeave(TreeNode cur, boolean isLeft) {
        int sum = 0;
        if (cur != null){
            if (cur.left == null && cur.right == null && isLeft){
                return cur.val;
            }
            sum += leftLeave(cur.left,true);
            sum += leftLeave(cur.right,false);
        }
        return sum;
    }
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root !=null && root.right == null && root.left == null){
//            return 0;
//        }
//        int sum = 0;
//        List<Integer> res = new ArrayList<>();
//        leftLeave(root,res,true);
//        for (Integer re : res) {
//            sum += re;
//        }
//        return sum;
//    }
//
//
//
//    /**
//     *
//     * @param cur       当前节点
//     * @param res       res存储了满足条件节点的值
//     * @param isLeft    当前节点是左节点还是右节点
//     */
//    private void leftLeave(TreeNode cur, List<Integer> res,boolean isLeft) {
//        if (cur != null){
//            //
//            if (cur.left == null && cur.right == null && isLeft){
//                res.add(cur.val);
//            }
//            leftLeave(cur.left,res,true);
//            leftLeave(cur.right,res,false);
//        }
//    }

    public static void main(String[] args) {

    }
}
