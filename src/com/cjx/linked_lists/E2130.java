package com.cjx.linked_lists;

import java.util.LinkedList;

/**
 * @author cjx
 * @Description 2130. 链表最大孪生和【中等】
 * @date 2024/2/6 10:14
 **/
public class E2130 {
    public int pairSum(ListNode head) {
        // 快慢指针求链表的中点，求完后slow为后一半元素的第一个
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 经典双指针方法：反转后一半的链表元素
        ListNode pre = null;
        ListNode p = slow;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }

        int ans = 0;
        ListNode q;
        // 从前一半元素首元素和后一半尾元素向中间遍历
        for (p = head, q = pre; q != null; p = p.next, q = q.next) {
            ans = Math.max(ans, p.val + q.val);
        }
        return ans;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        System.out.println(new E2130().pairSum(head));
    }
}
