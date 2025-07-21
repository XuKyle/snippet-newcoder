package com.kylexu.leetcode.array;

import java.util.PriorityQueue;

public class Solution2163 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        long l = new Solution2163().minimumDifference(nums);
        System.out.println("l = " + l);
    }

    public long minimumDifference(int[] nums) {
        long ret = Long.MAX_VALUE;
        int n = nums.length / 3;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long[] part1 = new long[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (i - 1 >= 0) {
                part1[i] = part1[i - 1];
            }
            part1[i] += nums[i];
            maxHeap.add(nums[i]);
            if (maxHeap.size() > n) {
                part1[i] -= maxHeap.poll();
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long part2 = 0;
        for (int i = 3 * n - 1; i >= n; i--) {
            part2 += nums[i];
            minHeap.add(nums[i]);
            if (minHeap.size() > n) {
                part2 -= minHeap.poll();
            }
            if (i <= 2 * n) {
                ret = Math.min(ret, part1[i - 1] - part2);
            }
        }
        return ret;

    }
}
