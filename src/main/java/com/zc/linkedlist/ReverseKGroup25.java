package com.zc.linkedlist;

/**
 * 描述:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1 || head == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode dummyCur = dummyHead;

        ListNode cur = head;
        //最后这一段长度<k的节点
        ListNode rollBack = null;
        while (cur!=null){
            ListNode rollBackTemp = cur;
            ListNode toReverse = new ListNode(0);
            ListNode reverseCur = toReverse;
            int i =0;
            //以长度k为单位的待翻转链表
            for (; i < k && cur != null; i++) {
                reverseCur.next= cur;
                cur=cur.next;
                reverseCur=reverseCur.next;
            }
            if (i==k) {
                //翻转并加入尾节点
                //reverse之前记录一下头节点
                ListNode curHead = toReverse.next;
                reverseCur.next=null;
                dummyCur.next = reverse(toReverse.next);
                dummyCur = curHead;
            }else {
                //最后这一段长度<k,需要直接添加到尾部
                rollBack = rollBackTemp;
            }
        }
        dummyCur.next = rollBack;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(new int[]{1,2,3,4,5});
//        System.out.println(head.toString());
//        System.out.println(new ReverseKGroup25().reverseKGroup(head,2).toString());

        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(head.toString());
        System.out.println(new ReverseKGroup25().reverseKGroup(head,3).toString());


    }
}
