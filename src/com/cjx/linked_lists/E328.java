package com.cjx.linked_lists;

/**
 * @Description E328. 奇偶链表【中等】
 * @Author cjx
 * @Date 2024/2/2 10:16
 **/
public class E328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode evenNode = head.next;
        ListNode odd = head , even = head.next;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenNode;
        return head;
    }
}
