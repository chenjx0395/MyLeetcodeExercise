package com.cjx.leetcode.linked_lists;

/**
 * @Description E2095. 删除链表的中间节点【中等】
 * @Author cjx
 * @Date 2024/2/2 9:27
 **/
public class E2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
        if (head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode sentryNode = new ListNode(0,head);
        ListNode left = sentryNode , right = head;
        while (right != null && right.next != null){
            right = right.next.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }

    private int getMiddle(ListNode head) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count / 2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        System.out.println(new E2095().deleteMiddle(head));

    }

}

