package com.mk.demos.leet;

/**
 * HasCycle2
 *
 * @author WangChen
 * Created on 2019/11/26 10:38
 * @since 1.0
 */
public class HasCycle2 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && slow != null){
            if (fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        boolean b = new HasCycle2().hasCycle(node1);
        System.out.println(b);
    }
}
