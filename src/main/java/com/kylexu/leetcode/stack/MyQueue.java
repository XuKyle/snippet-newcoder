package com.kylexu.leetcode.stack;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackIn.add(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            in2Out();
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            in2Out();
        }

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    public void in2Out() {
        while (!stackIn.isEmpty()) {
            stackOut.add(stackIn.pop());
        }
    }
}
