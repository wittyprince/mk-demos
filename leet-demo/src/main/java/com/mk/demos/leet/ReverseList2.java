package com.mk.demos.leet;

/**
 * ReverseList2
 *
 * @author WangChen
 * Created on 2019/11/25 13:09
 * @since 1.0
 */
public class ReverseList2 {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        while (node != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = new ReverseList2().reverseList(node1);
        System.out.println(listNode);
    }
}

