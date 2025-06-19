package com.kylexu.leetcode.design;

import java.util.*;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 示例 1：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * <p>
 * 输出：[null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * <p>
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // 返回 4
 * kthLargest.add(5); // 返回 5
 * kthLargest.add(10); // 返回 5
 * kthLargest.add(9); // 返回 8
 * kthLargest.add(4); // 返回 8
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add"]
 * [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
 * <p>
 * 输出：[null, 7, 7, 7, 8]
 * <p>
 * 解释：
 * <p>
 * KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
 * kthLargest.add(2); // 返回 7
 * kthLargest.add(10); // 返回 7
 * kthLargest.add(9); // 返回 7
 * kthLargest.add(9); // 返回 8
 */
public class Solution703 {
    public static void main(String[] args) {
        int k = 4;
        int[] nums = new int[]{7, 7, 7, 7, 8, 3};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
    }
}

class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        this.queue.offer(val);
        if (this.queue.size() > k) {
            this.queue.poll();
        }
        return this.queue.peek();
    }
}

class KthLargest1 {
    private Map<Integer, Integer> holder = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer left, Integer right) {
            return Integer.compare(right, left);
        }
    });
    private int k = 0;

    public KthLargest1(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            holder.merge(num, 1, Integer::sum);
        }
    }

    public int add(int val) {
        holder.merge(val, 1, Integer::sum);

        int top = 0;
        for (Map.Entry<Integer, Integer> entry : holder.entrySet()) {
            if (top + entry.getValue() >= k) {
                return entry.getKey();
            } else {
                top += entry.getValue();
            }
        }

        return 1;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */