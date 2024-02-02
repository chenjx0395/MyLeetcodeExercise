package com.cjx.linked_lists;

/**
 * @Description E206. 反转链表【简单】
 * @Author cjx
 * @Date 2024/2/2 11:20
 **/
public class E206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre  = null;
        ListNode cur = head;
        ListNode temp = head.next;
        while (temp != null){
            cur.next = pre;
            pre = cur;
            cur = temp;
            temp = cur.next;
        }
        cur.next = pre;
        return cur;
    }

}
