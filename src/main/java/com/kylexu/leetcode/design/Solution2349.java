package com.kylexu.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2349 {

}
class NumberContainers {
    private Map<Integer, Integer> nums = new HashMap<>();
    private Map<Integer, PriorityQueue<Integer>> heaps = new HashMap<>();

    public void change(int index, int number) {
        nums.put(index, number);
        heaps.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }

    public int find(int number) {
        PriorityQueue<Integer> heap = heaps.get(number);
        if (heap == null) {
            return -1;
        }
        while (!heap.isEmpty() && !nums.get(heap.peek()).equals(number)) {
            heap.poll();
        }
        return heap.isEmpty() ? -1 : heap.peek();
    }
}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/design-a-number-container-system/solutions/3768923/she-ji-shu-zi-rong-qi-xi-tong-by-leetcod-zsgc/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
