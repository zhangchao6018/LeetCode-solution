package com.zc.linkedlist;

/**
 * 描述:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 92  83  86  328  2  445
 * @Author: zhangchao
 **/
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        return f2(head);
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private ListNode f2(ListNode head) {
        //校验
        if (head == null){
            return null;
        }

        return reverse(head);
    }

    public static ListNode reverse(ListNode cur) {
        //终止条件
        if (cur.next==null){
            return cur;
        }
        //否则翻转
        ListNode next = cur.next;
        ListNode newHead = reverse(next);
        next.next = cur;
        cur.next = null;
        return  newHead;
    }

    /**
     * 循环
     * @param head
     * @return
     */
    private ListNode f1(ListNode head) {
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
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = new ReverseList206().reverseList(head);
        System.out.println(node);
    }


}
