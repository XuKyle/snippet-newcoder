package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * 输出："c"
 * 解释：按键顺序和持续时间如下：
 * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 * 示例 2：
 * <p>
 * 输入：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * 输出："a"
 * 解释：按键顺序和持续时间如下：
 * 按下 's' ，持续时间 12
 * 按下 'p' ，持续时间 23 - 12 = 11
 * 按下 'u' ，持续时间 36 - 23 = 13
 * 按下 'd' ，持续时间 46 - 36 = 10
 * 按下 'a' ，持续时间 62 - 46 = 16
 * 按键持续时间最长的键是 'a' ，持续时间 16
 */
public class Solution1629 {
    public static void main(String[] args) {
        int[] releaseTimes = new int[]{12,23,36,46,62};
        String keysPressed = "spuda";
        System.out.println(new Solution1629().slowestKey(releaseTimes, keysPressed));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Integer, List<Character>> mark = new HashMap<>();

        int n = keysPressed.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = keysPressed.charAt(i);
            int cost;
            if (i == 0) {
                cost = releaseTimes[0];
            } else {
                cost = releaseTimes[i] - releaseTimes[i - 1];
            }
            max = Math.max(max, cost);
            mark.computeIfAbsent(cost, k -> new ArrayList<>()).add(c);
        }

        List<Character> characters = mark.get(max);
        char maxChar = 'a';
        for (Character character : characters) {
            maxChar = character > maxChar ? character : maxChar;
        }
        return maxChar;
    }
}
