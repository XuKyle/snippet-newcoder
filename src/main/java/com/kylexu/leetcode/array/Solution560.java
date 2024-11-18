package com.kylexu.leetcode.array;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public static void main(String[] args) {
//        示例 1：
//
//        输入：nums = [1,1,1], k = 2
//        输出：2
//        示例 2：
//
//        输入：nums = [1,2,3], k = 3
//        输出：2

//        int[] nums = new int[]{1, 1, 1};
//        System.out.println(new Solution560().subarraySum(nums, 2));

        int[] nums = new int[]{0, 0, 0};
        System.out.println(new Solution560().subarraySum(nums, 0));
    }

//    public int subarraySum(int[] nums, int k) {
//        Map<Integer, Integer> acc = new HashMap<>();
//        acc.put(0, 1);
//
//        int an = 0;
//        int preAcc = 0;
//
//        for (int num : nums) {
//            preAcc += num;
//            acc.put(preAcc, acc.getOrDefault(preAcc, 0) + 1);
//        }
//
//        preAcc = 0;
//        for (int num : nums) {
//            preAcc += num;
//            if (acc.containsKey(preAcc - k)) {
//                an += acc.get(preAcc - k);
//            }
//        }
//
//        System.out.println("acc = " + acc);
//
//        return an;
//    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> acc = new HashMap<>();
        // 要是k为3，nums={3,1,2},那么第一个数字map是不是找不到key为0的，就会漏掉刚好等于k的情况
        acc.put(0, 1);

        int an = 0;
        int preAcc = 0;

        for (int num : nums) {
            preAcc += num;
            if (acc.containsKey(preAcc - k)) {
                an += acc.get(preAcc - k);
            }

            System.out.println("num = " + num + " preAcc:" + preAcc + " acc-k: " + (preAcc - k) + " | " + acc);

            acc.put(preAcc, acc.getOrDefault(preAcc, 0) + 1);
        }

        return an;
    }

//    public int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int[] acc = new int[n + 1];
//        acc[0] = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            acc[i + 1] = acc[i] + nums[i];
//        }
//
//        int count = 0;
//        for (int left = 0; left < n; left++) {
//            for (int right = left; right < n; right++) {
//                if (acc[right + 1] - acc[left] == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }


//    public int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int count = 0;
//
//        for (int left = 0; left < n; left++) {
//            for (int right = left; right < n; right++) {
//                int sum = 0;
//
//                for (int i = left; i <= right; i++) {
//                    sum += i;
//                }
//
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
}
