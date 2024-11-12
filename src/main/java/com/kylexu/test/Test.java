package com.kylexu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {

//   Test 问题描述：
//            "两个不定长单向链表，将链表的数据按右对齐的方式，对应位相加，给出一个新链表。相加结果超过10，向前进位。
//    不推荐使用链表反转方式
//
//## 示例
//    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 8 -> 0 -> 7"


    public void reverse(LinkedNode list1, LinkedNode list2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (list1 != null && list1.data != null) {
            stack1.add(list1.data);
            list1 = list1.next;
        }

        while (list2 != null && list2.data != null) {
            stack2.add(list2.data);
            list2 = list2.next;
        }

        int c = 0;
        List<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = 0;
            int b = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                b = stack2.pop();
            }
            int added = a + b + c;
            if (added > 9) {
                c = 1;
            } else {
                c = 0;
            }
        }


    }


    class LinkedNode {
        Integer data;
        LinkedNode next;

        public LinkedNode(Integer data) {
            this.data = data;
        }

        public void setNext(LinkedNode node) {
            this.next = node;
        }
    }
}
