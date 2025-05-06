package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 */
public class Solution2451 {
    public static void main(String[] args) {
        String[] words = {"adc", "wzy", "abc"};
        String rs = new Solution2451().oddString(words);
        System.out.println("rs = " + rs);
    }

    public String oddString(String[] words) {
        String firstStringOdd = od(words[0]);
        boolean flag = true;
        int cnt = 0;
        int index = -1;

        for (int i = 1; i < words.length; i++) {
            String od = od(words[i]);
            if (!od.equals(firstStringOdd)) {
                cnt++;
                index = i;
            }
        }

        if (cnt == 1) {
            return words[index];
        }
        return words[0];
    }

    private String od(String word) {
        StringBuilder rs = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            rs.append(word.charAt(i) - word.charAt(i - 1));
            rs.append("|");
        }
        return rs.toString();
    }
}
