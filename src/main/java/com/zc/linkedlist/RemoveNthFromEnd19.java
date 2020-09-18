package com.zc.linkedlist;

/**
 * 描述:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 61  143  234
 * @Author: zhangchao
 **/
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return f2(head, n);
    }
    private ListNode f2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        dummyHead.next = head;
        int r = 0;
        while (true){
            if (r < n){
                r++;
            }else {
                if (cur==null){//中止条件--pre下一个位置即为待删除位置
                    pre.next = pre.next.next;
                    return dummyHead.next;
                }
                pre = pre.next;
                r++;
            }
            cur = cur.next;
        }
    }
    private ListNode f1(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        int countDown = count+1-n;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        cur = head;
        for (int i = 1; i <= countDown; i++) {
            System.out.println(i);
            if (i == countDown){
                pre.next = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(head.toString());
        System.out.println(new RemoveNthFromEnd19().removeNthFromEnd(head,2).toString());
    }
}
