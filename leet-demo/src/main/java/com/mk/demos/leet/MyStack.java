package com.mk.demos.leet;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * implement-stack-using-queues 用队列实现栈
 *
 * 使用队列实现栈的下列操作：
 *      push(x) -- 元素 x 入栈
 *      pop() -- 移除栈顶元素
 *      top() -- 获取栈顶元素
 *      empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author WangChen
 * Created on 2019/11/26 15:42
 * @since 1.0
 */
public class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> assistQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        assistQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue.size() == 0){
            queue.add(x);
        }else {
            assistQueue.add(x);
            while (!queue.isEmpty()){
                assistQueue.add(queue.remove());
            }
            Queue<Integer> tempQueue = assistQueue;
            assistQueue = queue;
            queue = tempQueue;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty()){
            throw new RuntimeException("empty queue!");
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty()){
            throw new RuntimeException("empty queue!");
        }
        return queue.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args){
        /** Your MyQueue object will be instantiated and called as such: */
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int top = stack.top();// 返回 3
        System.out.println(top);
        int pop = stack.pop();// 返回 3
        System.out.println(pop);
        boolean empty = stack.empty();// 返回 false
        System.out.println(empty);
    }
}
