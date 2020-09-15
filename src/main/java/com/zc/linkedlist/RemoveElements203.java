package com.zc.linkedlist;

/**
 * 描述:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author: zhangchao
 **/
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        return f3(head, val);
    }

    /**
     * 虚拟头节点
     * 解决头节点和非头节点代码处理逻辑不一致问题
     * @param head
     * @param val
     * @return
     */
    private ListNode f3(ListNode head, int val) {
        if (head == null){
            return null;
        }
        //虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur!=null){
            if (cur.next != null && cur.next.val == val) {
                //该情况相当于更新了next节点，因此无需手动更新cur
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
    private ListNode f2(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        while (cur!=null){
            if (cur.val == val){
                head=head.next;
                cur = head;
            }else {
                if (cur.next != null && cur.next.val == val) {
                    //该情况相当于更新了next节点，因此无需手动更新cur
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }
        }
        return head;
    }
    private ListNode f1(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode curHead = null;
        ListNode curTemp = null;

        ListNode cur = head;
        while (cur!=null){
            if (cur.val != val){
                ListNode newNode = new ListNode(cur.val);
                if (curHead !=null){
                    curTemp.next = newNode;
                    curTemp = curTemp.next;
                }else {
                    curHead = newNode;
                    curTemp = newNode;
                }
            }
            cur = cur.next;
        }
        return curHead;
    }

    public static void main(String[] args) {

//        ListNode listNode = new ListNode(new int[]{1,2,6,3,4,5,6});
//        System.out.println(listNode.toString());
//        System.out.println(new RemoveElements203().removeElements(listNode,6).toString());
//
        ListNode listNode = new ListNode(new int[]{1,2,2,1});
        System.out.println(listNode.toString());
        System.out.println(new RemoveElements203().removeElements(listNode,2).toString());
    }
}
