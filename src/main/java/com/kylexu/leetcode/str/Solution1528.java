package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 * <p>
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 */
public class Solution1528 {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(new Solution1528().restoreString(s, indices));
    }

    public String restoreString(String s, int[] indices) {
        List<Character> rs = new ArrayList<>(Collections.nCopies(indices.length, '0'));
        for (int i = 0; i < indices.length; i++) {
            rs.set(indices[i], s.charAt(i));
        }
        return rs.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
