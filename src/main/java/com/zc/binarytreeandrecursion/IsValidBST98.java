package com.zc.binarytreeandrecursion;

import java.util.ArrayList;

/**
 * 描述:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class IsValidBST98 {

    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }

    /**
     *
     * @param cur  当前节点
     * @param l    左临界
     * @param r    右临界
     * @return
     */
    private boolean isValid(TreeNode cur, Integer l, Integer r) {
        if (cur == null)
            return true;//叶子
        int val = cur.val;
        if (l != null && l >= val)
            return false;
        if (r != null && r <= val)
            return false;
        if (!isValid(cur.right,val, r))
            return false;
        if (!isValid(cur.left,l,val))
            return false;
        return true;
    }

    //中序遍历
    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();

        inOrder(list,root);

        for (int i = 0; i < list.size()-1 ; i++) {
            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(ArrayList<Integer> list, TreeNode cur) {
        if (cur != null){
            inOrder(list,cur.left);
            list.add(cur.val);
            inOrder(list,cur.right);
        }
    }

    public static void main(String[] args) {

    }
}
