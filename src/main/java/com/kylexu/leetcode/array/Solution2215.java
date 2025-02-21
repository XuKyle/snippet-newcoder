package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2215 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 3};
        int[] nums2 = new int[]{1, 1, 2, 2};
        List<List<Integer>> rs = new Solution2215().findDifference(nums1, nums2);

        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        List<Integer> rs1 = new ArrayList<>();
        List<Integer> rs2 = new ArrayList<>();
        List<List<Integer>> rs = new ArrayList<>();

        for (int i : set1) {
            if (!set2.contains(i)) {
                rs1.add(i);
            }
        }

        for (int i : set2) {
            if (!set1.contains(i)) {
                rs2.add(i);
            }
        }

        rs.add(rs1);
        rs.add(rs2);
        return rs;
    }
}
