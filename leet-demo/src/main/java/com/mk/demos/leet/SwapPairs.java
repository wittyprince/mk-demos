package com.mk.demos.leet;

/**
 * swapPairs 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author WangChen
 * Created on 2019/11/25 17:01
 * @since 1.0
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = head;
        while (node != null && node.next != null){
            ListNode next = node.next;
            ListNode nextNext = next.next;
            next.next = node;
            node.next = nextNext;
            node = nextNext;
            System.out.println(node);
        }
        return pre.next;
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
        ListNode listNode = new SwapPairs().swapPairs(node1);
        System.out.println(listNode);
    }
}
