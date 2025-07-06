package com.kylexu.leetcode.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution865 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        System.out.println(findSumPairs.count(7));  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        System.out.println("findSumPairs = " + findSumPairs);

        System.out.println(findSumPairs.count(8));  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        System.out.println(findSumPairs.count(4));  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        System.out.println("findSumPairs = " + findSumPairs);
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        System.out.println("findSumPairs = " + findSumPairs);
        System.out.println(findSumPairs.count(7));
    }

}


class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> numsCount;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        numsCount = new HashMap<>();
        for (int i : nums2) {
            numsCount.merge(i, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        numsCount.put(nums2[index], numsCount.get(nums2[index]) - 1);
        nums2[index] += val;
        numsCount.put(nums2[index], numsCount.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int rs = 0;
        for (int i = 0; i < nums1.length; i++) {
            rs += numsCount.getOrDefault(tot - nums1[i], 0);
        }
        return rs;
    }

    @Override
    public String toString() {
        return "FindSumPairs{" +
                "nums1=" + Arrays.toString(nums1) +
                ", nums2=" + Arrays.toString(nums2) +
                '}';
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */