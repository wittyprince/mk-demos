package com.mk.demos.leet;

import java.util.Stack;

/**
 * implement-queue-using-stacks 用栈实现队列
 *
 * 使用栈实现队列的下列操作：
 *      push(x) -- 将一个元素放入队列的尾部。
 *      pop() -- 从队列首部移除元素。
 *      peek() -- 返回队列首部的元素。
 *      empty() -- 返回队列是否为空。
 *
 * 示例:
 *      MyQueue queue = new MyQueue();
 *      queue.push(1);
 *      queue.push(2);
 *      queue.peek();  // 返回 1
 *      queue.pop();   // 返回 1
 *      queue.empty(); // 返回 false
 *
 * 说明:
 *  你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *  你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author WangChen
 * Created on 2019/11/26 15:17
 * @since 1.0
 */
public class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {// 非线程安全
        if (outputStack.isEmpty()){
            if (inputStack.isEmpty()){
                throw new RuntimeException("empty queue!");
            }
            while (!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
            return outputStack.pop();
        }else {
            return outputStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {// 非线程安全
        if (outputStack.isEmpty()){
            if (inputStack.isEmpty()){
                throw new RuntimeException("empty queue!");
            }
            while (!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
            return outputStack.peek();
        }else {
            return outputStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }

    public static void main(String[] args){

        /** Your MyQueue object will be instantiated and called as such: */
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();// 返回 1
        System.out.println(peek);
        int pop = queue.pop();// 返回 1
        System.out.println(pop);
        boolean empty = queue.empty();// 返回 false
        System.out.println(empty);
    }

}
