package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2899 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -1, -1};
        List<Integer> integers = new Solution2899().lastVisitedIntegers(nums);
        System.out.println("integers = " + integers);
    }

    public List<Integer> lastVisitedIntegers(int[] nums) {
        LinkedList<Integer> seen = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                seen.addFirst(nums[i]);
                k = 0;
            } else if (nums[i] == -1) {
                k++;
                if (seen.size() >= k) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
}
