package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * <p>
 * 返回交换 任意 次之后 num 的 最大 可能值。
 * 示例 1：
 * <p>
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 * <p>
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 */
public class Solution2231 {
    public static void main(String[] args) {
//        System.out.println(new Solution2231().largestInteger(1234));
        System.out.println(new Solution2231().largestInteger(65875));
    }

    public int largestInteger(int num) {
        String strNumber = String.valueOf(num);
        int n = strNumber.length();

        List<Integer> oddIndex = new ArrayList<>();
        List<Integer> evenIndex = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int parsed = Integer.parseInt(strNumber.substring(i, i + 1));
            if (parsed % 2 == 0) {
                evenIndex.add(i);
            } else {
                oddIndex.add(i);
            }
        }

        int[] odd = new int[oddIndex.size()];
        int[] even = new int[evenIndex.size()];

        int oddI = 0;
        int evenI = 0;
        for (int i = 0; i < n; i++) {
            if (oddIndex.contains(i)) {
                odd[oddI] = Integer.parseInt(strNumber.substring(i, i + 1));
            } else {
                even[evenI] = Integer.parseInt(strNumber.substring(i, i + 1));
            }
        }

        Arrays.sort(odd);
        Arrays.sort(even);

        int[] rs = new int[n];
        for (int i = odd.length - 1; i >= 0; i--) {
            rs[oddIndex.get(odd.length - 1 - i)] = odd[i];
        }

        for (int i = even.length - 1; i >= 0; i--) {
            rs[evenIndex.get(even.length - 1 - i)] = even[i];
        }

        int rsNumber = 0;
        for (int r : rs) {
            rsNumber = rsNumber * 10 + r;
        }

        return rsNumber;
    }
}
