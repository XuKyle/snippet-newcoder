package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：number = "123", digit = "3"
 * 输出："12"
 * 解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
 * 示例 2：
 * <p>
 * 输入：number = "1231", digit = "1"
 * 输出："231"
 * 解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
 * 由于 231 > 123 ，返回 "231" 。
 * 示例 3：
 * <p>
 * 输入：number = "551", digit = "5"
 * 输出："51"
 * 解释：可以从 "551" 中移除第一个或者第二个 '5' 。
 * 两种方案的结果都是 "51" 。
 */
public class Solution2259 {
    public static void main(String[] args) {
        String number = "3619552534";
        char digit = '5';
        System.out.println(new Solution2259().removeDigit(number, digit));

//        "619552534"
//        预期结果
//        "361955234"
    }

    public String removeDigit(String number, char digit) {
        int firstIndex = number.indexOf(digit);
        int lastIndex = number.lastIndexOf(digit);

        if (firstIndex == lastIndex) {
            return number.substring(0, firstIndex) + number.substring(lastIndex + 1);
        }

        int n = number.length();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                index.add(i);
            }
        }

        int removeIndex = -1;
        for (int i = 0; i < index.size(); i++) {
            Integer integer = index.get(i);
            if (integer == n - 1) {
                removeIndex = integer;
                break;
            }
            if (number.charAt(integer) < number.charAt(integer + 1)) {
                removeIndex = integer;
                break;
            }
            if (i == index.size() - 1 && removeIndex == -1) {
                removeIndex = integer;
            }
        }

        return number.substring(0, removeIndex) + number.substring(removeIndex + 1);
    }
}
