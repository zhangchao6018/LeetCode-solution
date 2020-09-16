package com.zc.linkedlist;

/**
 * 描述:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (cur !=null){
            if (l1 != null && l2 != null){
                if (l1.val<l2.val){
                    ListNode res = new ListNode(l1.val);
                    l1 = l1.next;
                    cur.next = res;
                }else {
                    ListNode res = new ListNode(l2.val);
                    l2 = l2.next;
                    cur.next = res;
                }
            }else if (l1 == null && l2 != null){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if (l1 != null && l2 == null){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1,3,5,7,9});
        ListNode l2 = new ListNode(new int[]{2,4,6,8,10});
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(new MergeTwoLists21().mergeTwoLists(l1 , l2).toString());
    }
}
