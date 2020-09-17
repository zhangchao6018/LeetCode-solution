package com.zc.linkedlist;

/**
 * 描述:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 25  147  148
 * @Author: zhangchao
 **/
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        return f2(head);
    }

    /**
     * 节省空间
     * @param head
     * @return
     */
    private ListNode f2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next!=null ){
            //交换
            ListNode cur = pre.next;
            ListNode next = pre.next.next.next;

            pre.next = pre.next.next;
            pre.next.next = cur;
            cur.next = next;

            pre=pre.next.next;
        }
        return dummyHead.next;
    }

    private ListNode f1(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null ){
            //交换
            if (cur.next != null) {
                ListNode cur1 = cur;
                ListNode next1 = cur.next.next;

                pre.next = pre.next.next;
                pre.next.next = cur1;
                cur1.next = next1;

                pre = cur1;
                cur = cur1.next;
            }else {
                break;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4});
        System.out.println(head.toString());
        System.out.println(new SwapPairs24().swapPairs(head).toString());
    }
}
