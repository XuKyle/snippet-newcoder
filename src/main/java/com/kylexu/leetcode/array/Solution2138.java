package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：s = "abcdefghi", k = 3, fill = "x"
 * 输出：["abc","def","ghi"]
 * 解释：
 * 前 3 个字符是 "abc" ，形成第一组。
 * 接下来 3 个字符是 "def" ，形成第二组。
 * 最后 3 个字符是 "ghi" ，形成第三组。
 * 由于所有组都可以由字符串中的字符完全填充，所以不需要使用填充字符。
 * 因此，形成 3 组，分别是 "abc"、"def" 和 "ghi" 。
 * 示例 2：
 * <p>
 * 输入：s = "abcdefghij", k = 3, fill = "x"
 * 输出：["abc","def","ghi","jxx"]
 * 解释：
 * 与前一个例子类似，形成前三组 "abc"、"def" 和 "ghi" 。
 * 对于最后一组，字符串中仅剩下字符 'j' 可以用。为了补全这一组，使用填充字符 'x' 两次。
 * 因此，形成 4 组，分别是 "abc"、"def"、"ghi" 和 "jxx" 。
 */
public class Solution2138 {
    public static void main(String[] args) {
        String s = "ctoyjrwtngqwt";
        int k = 8;
        char fill = 'n';

        String[] rs = new Solution2138().divideString(s, k, fill);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = n % k == 0 ? n : (n / k + 1) * k;

        StringBuilder sb = new StringBuilder(s);
        sb.append(String.valueOf(fill).repeat(Math.max(0, m - n)));

        List<String> rs = new ArrayList<>();
        for (int i = 0; i < m; i += k) {
            rs.add(sb.substring(i, i + k));
        }

        return rs.toArray(new String[0]);
    }
}
