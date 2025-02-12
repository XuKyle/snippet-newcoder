package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：true
 * 解释：
 * 'a' 位于下标 0、1 和 2 ；而 'b' 位于下标 3、4 和 5 。
 * 因此，每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：s = "abab"
 * 输出：false
 * 解释：
 * 存在一个 'a' 位于下标 2 ，而一个 'b' 位于下标 1 。
 * 因此，不能满足每个 'a' 都出现在每个 'b' 之前，所以返回 false 。
 * 示例 3：
 * <p>
 * 输入：s = "bbb"
 * 输出：true
 * 解释：
 * 不存在 'a' ，因此可以视作每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 */
public class Solution2124 {
    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(new Solution2124().checkString(s));
    }

    public boolean checkString(String s) {
        int maxAIndex = -1;
        int minBIndex = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                maxAIndex = Math.max(maxAIndex, i);
            } else {
                minBIndex = Math.min(minBIndex, i);
            }
        }

        return maxAIndex < minBIndex;
    }
}
