package com.zc.binarytreeandrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 *
 * todo 113 129
 **/
public class BinaryTreePaths257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        getChild(root,"",res);
        return res;
    }

    /**
     *
     * @param cur         当前节点
     * @param res         最终返回结果
     * @param fatherPath  当前节点的串
     */
    private void getChild(TreeNode cur, String fatherPath, List<String> res) {
        if (cur == null)
            return;
        StringBuilder builder = new StringBuilder(fatherPath);
        builder.append(cur.val);

        if (cur.left == null && cur.right == null)
            res.add(builder.toString());
        builder.append("->");
        getChild(cur.left,builder.toString(),res);
        getChild(cur.right,builder.toString(),res);
    }

    public List<String> f1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null){
            res.add(root.val+"");
        }
        List<String> lList = f1(root.left);
        List<String> rList = f1(root.right);
        for (String s : lList) {
            res.add(root.val+"->"+s);
        }
        for (String s : rList) {
            res.add(root.val+"->"+s);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        l.right = new TreeNode(5);
        root.right = r;
        root.left = l;
        List<String> list = new BinaryTreePaths257().binaryTreePaths(root);
        System.out.println();
    }
}
