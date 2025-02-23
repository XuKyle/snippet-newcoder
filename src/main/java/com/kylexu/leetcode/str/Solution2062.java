package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：word = "aeiouu"
 * 输出：2
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "aeiouu"
 * - "aeiouu"
 * 示例 2：
 * <p>
 * 输入：word = "unicornarihan"
 * 输出：0
 * 解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
 * 示例 3：
 * <p>
 * 输入：word = "cuaieuouac"
 * 输出：7
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * 示例 4：
 * <p>
 * 输入：word = "bbaeixoubb"
 * 输出：0
 * 解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
 */
public class Solution2062 {
    public static void main(String[] args) {
        String word = "cuaieuouac";
        System.out.println(new Solution2062().countVowelSubstrings(word));
    }

    public int countVowelSubstrings(String word) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        Set<Character> exists = new HashSet<>();

        int n = word.length();
        int rs = 0;

        for (int i = 0; i < n; i++) {
            if (vowels.contains(word.charAt(i))) {
                exists.add(word.charAt(i));
                for (int j = i + 1; j < n; j++) {
                    if (vowels.contains(word.charAt(j))) {
                        exists.add(word.charAt(j));
                        if (exists.size() >= 5) {
                            rs++;
                        }
                    } else {
                        exists.clear();
                        break;
                    }
                }
            }
            exists.clear();
        }

        return rs;
    }
}
