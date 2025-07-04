package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 */
public class Solution216 {
    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> lists = new Solution216().combinationSum3(k, n);
        System.out.println("lists = " + lists);
    }

    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return rs;
    }

    private void helper(int k, int n, int startIndex) {
        if (path.size() == k && sum(path) == n) {
            rs.add(new ArrayList<>(path));
            return;
        }

        if (path.size() >= k || sum(path) >= n) {
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            helper(k, n, ++startIndex);
            path.removeLast();
        }
    }

    private int sum(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }


}
