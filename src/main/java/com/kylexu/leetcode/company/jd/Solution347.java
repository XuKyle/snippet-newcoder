package com.kylexu.leetcode.company.jd;

import java.util.*;

public class Solution347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new Solution347().topKFrequent(nums, 2)));
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (Integer key : count.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (count.get(key) > count.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        // 取出最小堆中的元素
        int[] rs = new int[k];
        for (int i = 0; i < k; i++) {
            rs[i] = queue.remove();
        }
        return rs;
    }

}
