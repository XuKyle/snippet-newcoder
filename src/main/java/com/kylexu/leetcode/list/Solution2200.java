package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 * <p>
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 */
public class Solution2200 {
    public static void main(String[] args) {
//        nums = [3,4,9,1,3,9,5], key = 9, k = 1
        int[] nums = {2, 2, 2, 2, 2};
        int key = 2;
        int k = 2;
        List<Integer> kDistantIndices = new Solution2200().findKDistantIndices(nums, key, k);
        System.out.println("kDistantIndices = " + kDistantIndices);
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> rs = new ArrayList<>();

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                index.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; flag && j < index.size(); j++) {
                if (Math.abs(i - index.get(j)) <= k) {
                    rs.add(i);
                    flag = false;
                }
            }
        }

        return rs;
    }
}
