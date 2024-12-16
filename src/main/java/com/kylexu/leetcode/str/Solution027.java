package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * 示例 2：
 * <p>
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 * 示例 3：
 * <p>
 * 输入：s = "OOOO"
 * 输出：0
 * 解释：s 中不存在需要转换的 'X' 。
 */
public class Solution027 {
    public static void main(String[] args) {
        String s = "OXOX";
        System.out.println(new Solution027().minimumMoves(s));

    }

    public int minimumMoves(String s) {
        int rs = 0;

        int start = 0;
        int n = s.length();

        while (start < n) {
            while (start < n && s.charAt(start) == 'O') {
                start++;
            }
            int end = Math.min(start + 3, n);

            String substring = s.substring(start, end);
            if (!zero(substring)) {
                rs++;
            }
            start += 3;
        }
        return rs;
    }


    private boolean zero(String str) {
        boolean flag = true;
        for (char c : str.toCharArray()) {
            if ('O' != c) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
