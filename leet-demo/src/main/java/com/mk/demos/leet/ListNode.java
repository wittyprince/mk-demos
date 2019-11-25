package com.mk.demos.leet;

/**
 * @author WangChen
 * Created on 2019/11/25 17:06
 * @since 1.0
 */
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
