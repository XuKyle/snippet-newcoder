package com.kylexu.leetcode.company.jd;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution46().permute(nums));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        dfs(nums, path, rs);

        return rs;
    }

    private void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> rs) {
        if (nums.length == path.size()) {
            rs.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }

            path.add(num);
            dfs(nums, path, rs);
            path.remove(num);
        }
    }


}
