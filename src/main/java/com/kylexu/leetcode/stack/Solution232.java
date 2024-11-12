package com.kylexu.leetcode.stack;

public class Solution232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println("param_2 = " + param_2);
        int param_3 = obj.peek();
        System.out.println("param_3 = " + param_3);
        boolean param_4 = obj.empty();

        System.out.println("param_4 = " + param_4);
    }
}

