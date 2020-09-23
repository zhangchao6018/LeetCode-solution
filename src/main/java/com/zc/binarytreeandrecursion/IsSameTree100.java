package com.zc.binarytreeandrecursion;

/**
 * 描述:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p ==null && q == null)
            return true;
        else if (p ==null || q ==null)
            return false;
        else if (p.val != q.val)
            return false;
        else
        return (isSameTree(p.left,q.left) && isSameTree(p.right , q.right));
    }

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        List<Integer> pElements = new ArrayList();
//        List<Integer> qElements = new ArrayList();
//        pElements = preOrder(p,pElements);
//        qElements = preOrder(q,qElements);
//        if (pElements.size() != qElements.size()){
//            return false;
//        }
//        for (int i = 0; i < pElements.size(); i++) {
//            if (pElements.get(i) != qElements.get(i)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private List<Integer> preOrder(TreeNode cur, List<Integer> list) {
//        List<Integer> res = new ArrayList<>();
//        colectData(res,cur);
//        return res;
//    }
//
//    private void colectData(List<Integer> res, TreeNode cur) {
//        if (cur != null){
//            res.add(cur.val);
//            colectData(res,cur.left);
//            colectData(res,cur.right);
//        }
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new  TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new  TreeNode(2);

        System.out.println(new IsSameTree100().isSameTree(root, root2));

    }
}
