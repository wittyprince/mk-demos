package com.mk.demos.leet;

/**
 * ReverseList 反转一个单链表。
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 * 进阶:
 *      你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * @author WangChen
 * Created on 2019/11/25 10:30
 * @since 1.0
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node1 = head;// node1代表从head开始向后遍历的游标
        while (node1.next != null){
            node1 = node1.next;
        }// 经过循环后得到的是tail
        ListNode tail = node1;

        ListNode node2 = tail;// node2代表的是从tail开始向前遍历的游标
        while (!node2.equals(head)){
            node1 = head;
            while (!node1.next.equals(node2)){// 从前向后遍历找到node2的前节点
                node1 = node1.next;
            }
            node2.next = node1;// 反转node1为node2的后节点
            node2 = node2.next;// 移动node2游标
        }
        // 上面处理的是node2 != head 的情况
        // 处理 head
        node2.next = null;
        return tail;
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
        ListNode listNode = new ReverseList().reverseList(node1);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListNode){
            if (((ListNode) obj).val == this.val){
                return true;
            }
        }
        return super.equals(obj);
    }
}