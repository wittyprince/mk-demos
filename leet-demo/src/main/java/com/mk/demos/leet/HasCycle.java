package com.mk.demos.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * hasCycle 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *      输入：head = [3,2,0,-4], pos = 1
 *      输出：true
 *      解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author WangChen
 * Created on 2019/11/26 10:31
 * @since 1.0
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            set.add(node);
            node = node.next;
            if (set.contains(node)){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (set.contains(node)){
                return true;
            }else {
                set.add(node);
            }
            node = node.next;
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
        node1.next = node1;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;
        boolean b = new HasCycle().hasCycle(node1);
        System.out.println(b);
    }
}
