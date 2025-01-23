package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class Solution599 {
    public static void main(String[] args) {
        String[] list1 = new String[]{"happy", "sad", "good"};
        String[] list2 = new String[]{"sad", "happy", "good"};
        String[] restaurant = new Solution599().findRestaurant(list1, list2);
        System.out.println("restaurant = " + Arrays.toString(restaurant));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            index.put(list2[i], i);
        }

        int minGap = Integer.MAX_VALUE;
        Map<Integer, List<String>> gap = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            String currentRestaurant = list1[i];
            if (index.containsKey(currentRestaurant)) {
                Integer anotherIndex = index.get(currentRestaurant);
                int allGap = anotherIndex + i;
                minGap = Math.min(minGap, allGap);
                gap.computeIfAbsent(allGap, k -> new ArrayList<>()).add(currentRestaurant);
            }
        }

        return gap.get(minGap).toArray(String[]::new);
    }
}
