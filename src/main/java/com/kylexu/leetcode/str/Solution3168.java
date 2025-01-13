package com.kylexu.leetcode.str;

/**
 * 输入：s = "EEEEEEE"
 * 输出：7
 * 解释：
 * 每秒后都有一个顾客进入候诊室，没有人离开。因此，至少需要 7 把椅子。
 * <p>
 * 示例 2：
 * 输入：s = "ELELEEL"
 * 输出：2
 * 解释：
 * 假设候诊室里有 2 把椅子。下表显示了每秒钟等候室的状态。
 */
public class Solution3168 {
    public static void main(String[] args) {
        String s = "EEEEEEE";
        System.out.println(new Solution3168().minimumChairs(s));
    }

    public int minimumChairs(String s) {
        int max = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            int add = 'E' == c ? 1 : -1;
            current += add;
            max = Math.max(current, max);
        }

        return max;
    }
}
