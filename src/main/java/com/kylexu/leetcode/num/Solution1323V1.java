package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 * <p>
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 * <p>
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 */
public class Solution1323V1 {
    public static void main(String[] args) {
        int num = 9969;
        int i = new Solution1323V1().maximum69Number(num);
        System.out.println("i = " + i);
    }

    public int maximum69Number(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        boolean flag = true;
        for (int i = 0; i < charArray.length; i++) {
            if (flag && charArray[i] == '6') {
                charArray[i] = '9';
                flag = false;
            }

            if (!flag) {
                break;
            }
        }

        return Integer.parseInt(new String(charArray));
    }
}
