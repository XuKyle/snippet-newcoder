package com.kylexu.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> memo = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            memo.merge(c, 1, Integer::sum);
        }

        for (char c : ransomNote.toCharArray()) {
            if (memo.containsKey(c)) {
                if (memo.get(c) >= 1) {
                    memo.put(c, memo.get(c) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new Solution383().canConstruct(ransomNote, magazine));
    }
}
/// *
//
/// /给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
/// /
/// / 如果可以，返回 true ；否则返回 false 。
/// /
/// / magazine 中的每个字符只能在 ransomNote 中使用一次。
/// /
/// /
/// /
/// / 示例 1：
/// /
/// /
/// /输入：ransomNote = "a", magazine = "b"
/// /输出：false
/// /
/// /
/// / 示例 2：
/// /
/// /
/// /输入：ransomNote = "aa", magazine = "ab"
/// /输出：false
/// /
/// /
/// / 示例 3：
/// /
/// /
/// /输入：ransomNote = "aa", magazine = "aab"
/// /输出：true
/// /
/// /
/// /
/// /
/// / 提示：
/// /
/// /
/// / 1 <= ransomNote.length, magazine.length <= 10⁵
/// / ransomNote 和 magazine 由小写英文字母组成
/// /
/// /
/// / Related Topics 哈希表 字符串 计数 👍 936 👎 0
//
//
/// /leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//
//    }
//}
/// /leetcode submit region end(Prohibit modification and deletion)
//*/

