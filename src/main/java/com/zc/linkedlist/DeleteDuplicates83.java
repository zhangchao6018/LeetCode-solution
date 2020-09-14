package com.zc.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        //由于链表已排序,直接比较即可
        return f2(head);
    }

    private ListNode f2(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            //node值重复
            if (pre !=null && cur.val==pre.val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    private ListNode f1(ListNode head) {
        if (head==null){
            return null;
        }
        //过滤器
        Set<Integer> set = new HashSet<>();
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            if (set.contains(cur.val)){
                //移除该节点
                pre.next = cur.next;
            }else{
                //添加到过滤器
                set.add(cur.val);
                //更新
                pre = cur;
            }

            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5, 6});
        ListNode listNode = new ListNode(new int[]{1,1,1});
        System.out.println(listNode.toString());
        System.out.println(new DeleteDuplicates83().deleteDuplicates(listNode).toString());
    }
}
