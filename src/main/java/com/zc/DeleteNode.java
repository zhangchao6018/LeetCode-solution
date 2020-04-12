package com.zc;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/11/20 8:08 下午
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 **/
public class DeleteNode {
    public static ListNode deleteNode(ListNode head, int val) {
        return m5(head, val);
    }

    /**
     * 有个漏洞 如果头节点之后的节点也是待删除元素 该方法错误
     * @see     DeleteNode m2
     * @param head
     * @param val
     * @return
     */
    private static ListNode m1(ListNode head, int val) {
        //头节点特殊情况
        if (head.val == val){
            head=head.next;
        }

        ListNode pre = head;
        while (true){
            if (pre == null){
                break;
            }
            if (pre.next !=null && pre.next.val == val){
                pre.next = pre.next.next;
            }

            pre = pre.next;
        }
        return head;
    }

    /**
     * 处理了[5,5,.....] 5  头节点后重复元素的情况
     * @param head
     * @param val
     * @return
     */
    private static ListNode m2(ListNode head, int val) {
        //头节点特殊情况
        while (head.val == val){
            head=head.next;
        }

        ListNode pre = head;
        while (true){
            if (pre == null){
                break;
            }
            if (pre.next !=null && pre.next.val == val){
                pre.next = pre.next.next;
            }

            pre = pre.next;
        }
        return head;
    }

    /**
     * 引入虚拟头节点
     * @param head
     * @param val
     * @return
     */
    private static ListNode m3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-2);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next !=null) {
            if (pre.next.val == val){
                pre.next=pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        //思考一下 为什么不是返回head
        return dummyHead.next;
    }

    /**
     * 递归的方式解决
     * @param head
     * @param val
     * @return
     */
    private static ListNode m4(ListNode head, int val) {
        if (head==null)
            return null;
        if (head.val == val)
            head = head.next;
        else
            return head;

        return m4(head,val);
    }
    /**
     * 简洁的递归(跟m4是等效的)
     * @param head
     * @param val
     * @return
     */
    private static ListNode m5(ListNode head, int val) {
        if (head==null)
            return null;
        head.next = m5(head.next,val);
        return head.val==val?head.next:head;
    }

    public static void main(String[] args) {
//        ListNode node2 = new ListNode(4);
//        ListNode node =  new ListNode(5);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(1);
//        ListNode node6 = new ListNode(3);

//        ListNode node =  new ListNode(5);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(5);
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        ListNode listNode = deleteNode(head, 5);
        System.out.println(listNode);
    }
}
