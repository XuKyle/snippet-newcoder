package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入：nums1 = [2,3,2], nums2 = [1,2]
 * 输出：[2,1]
 */
public class Solution2956 {
    public static void main(String[] args) {
        int[] num1 = new int[]{4, 3, 2, 3, 1};
        int[] num2 = new int[]{2, 2, 5, 2, 3, 6};

//        输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
//        输出：[3,4]
        int[] intersectionValues = new Solution2956().findIntersectionValues(num1, num2);
        System.out.println("intersectionValues = " + Arrays.toString(intersectionValues));
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();

        for (int i : nums1) {
            num1Set.add(i);
        }

        for (int i : nums2) {
            num2Set.add(i);
        }

        int right = 0;
        for (int i : nums1) {
            if (num2Set.contains(i)) {
                right++;
            }
        }
        int left = 0;
        for (int i : nums2) {
            if (num1Set.contains(i)) {
                left++;
            }
        }

        return new int[]{right, left};
    }
}
