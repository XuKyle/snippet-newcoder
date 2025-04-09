package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
    public static void main(String[] args) {

    }


}


/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 */

class MyStack {
    Queue<Integer> stackIn;
    Queue<Integer> stackOut;

    public MyStack() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.add(x);
        while (!stackOut.isEmpty()) {
            stackIn.add(stackOut.poll());
        }
        Queue<Integer> tmp = stackIn;
        stackIn = stackOut;
        stackOut = tmp;
    }

    public int pop() {
        return stackOut.poll();
    }

    public int top() {
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */