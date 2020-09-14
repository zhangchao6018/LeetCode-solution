package com.zc.linkedlist;

/**
 * 描述:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //m-1位置节点其开始开始脱离
        ListNode open = null;
        //n位置开始翻转
        ListNode close = null;

        ListNode pre = null;
        ListNode cur = head;
        int count = 1;
        while (count<=n){
            ListNode next = cur.next;
            if (m == count){
                open = pre;
                close =cur;
            }
            if (n == count){
                close.next = cur.next;
                if (open!=null){
                    open.next=cur;
                }
            }
            if (count>m && count<=n){
                cur.next=pre;
            }

            pre = cur;
            cur = next;
            count++;
        }
        //当其实位置是1,头节点将是n位置的元素
        if (m==1){
            return pre;
        }
        //其实位置不是1,头节点不变
        return head;
    }

    public static void main(String[] args) {

        ListNode node = test2();
        System.out.println(node);
    }

    private static ListNode test1() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return new ReverseBetween92().reverseBetween(head,2,4);
    }
    private static ListNode test2() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(12);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        return new ReverseBetween92().reverseBetween(head,1,4);
    }
}
