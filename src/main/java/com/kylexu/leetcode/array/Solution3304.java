package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
 * <p>
 * 给定一个正整数 k。
 * <p>
 * 现在 Bob 会要求 Alice 执行以下操作 无限次 :
 * <p>
 * 将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。
 * 例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
 * <p>
 * 在执行足够多的操作后， word 中 至少 存在 k 个字符，此时返回 word 中第 k 个字符的值。
 * <p>
 * 注意，在操作中字符 'z' 可以变成 'a'。
 */
public class Solution3304 {
    public static void main(String[] args) {
//        输入：k = 5
//
//        输出："b"
//        解释：
//
//        最初，word = "a"。需要进行三次操作:
//
//        生成的字符串是 "b"，word 变为 "ab"。
//        生成的字符串是 "bc"，word 变为 "abbc"。
//        生成的字符串是 "bccd"，word 变为 "abbcbccd"。
        System.out.println(new Solution3304().kthCharacter(5));
    }

    List<Character> characterList = new ArrayList<>();

    public char kthCharacter(int k) {
        characterList.add('a');

        int n = characterList.size();
        while (n < k) {
            List<Character> tmp = new ArrayList<>();
            for (int i = 0; i < characterList.size(); i++) {
                tmp.add((char) (characterList.get(i) + 1));
            }
            characterList.addAll(tmp);
            n = characterList.size();
        }

        return characterList.get(k - 1);
    }
}
