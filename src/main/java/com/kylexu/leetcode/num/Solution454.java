package leetcode.num;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 */
public class Solution454 {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {-2, -1};
        int[] num3 = {-1, 2};
        int[] num4 = {0, 2};
        int i = new Solution454().fourSumCount(num1, num2, num3, num4);
        System.out.println("i = " + i);
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int rs = 0;

        Map<Integer, Integer> memo = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                var temp = i + j;
                memo.merge(temp, 1, Integer::sum);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                if (memo.containsKey(0 - i - j)) {
                    rs += memo.get(0 - i - j);
                }
            }
        }

        return rs;
    }
}
