package com.zc.linkedlist;

/**
 * 描述:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                ListNode temp = cur.next;
                while (temp !=null && temp.next!=null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(new int[]{1,2,3,3,4,4,5});
        ListNode listNode = new ListNode(new int[]{1,1,1,1,1,2,3});
        System.out.println(listNode.toString());
        System.out.println(new DeleteDuplicates82().deleteDuplicates(listNode).toString());
    }
}
