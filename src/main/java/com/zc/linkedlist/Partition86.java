package com.zc.linkedlist;

/**
 * 描述:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode preHead = null;
        ListNode preCur = null;

        ListNode endHead = null;
        ListNode endCur = null;

        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            if (cur.val<x){
                if (preHead == null){
                    preHead = new ListNode(cur.val);
                    preCur = preHead;
                }else{
                    preCur.next = new ListNode(cur.val);
                    preCur=preCur.next;
                }
            }else {
                if (endHead == null){
                    endHead = new ListNode(cur.val);
                    endCur = endHead;
                }else {
                    endCur.next=new ListNode(cur.val);
                    endCur=endCur.next;
                }
            }
            cur = next;
        }
        if (preCur != null){
            preCur.next = endHead;
        }

        if (preHead == null){
            return endHead;
        }
        return preHead;
    }
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(new int[]{1,4,3,2,5,2});
//        System.out.println(listNode.toString());
//        System.out.println(new Partition86().partition(listNode,3).toString());

//        ListNode listNode = new ListNode(new int[]{1,4,3,2,5,2});
//        System.out.println(listNode.toString());
//        System.out.println(new Partition86().partition(listNode,3).toString());

        ListNode listNode = new ListNode(new int[]{3,3,1,2,4});
        System.out.println(listNode.toString());
        System.out.println(new Partition86().partition(listNode,2).toString());
    }
}
