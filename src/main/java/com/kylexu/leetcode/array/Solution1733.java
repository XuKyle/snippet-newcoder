package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1733 {
    public static void main(String[] args) {

    }


    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cncon = new HashSet<>();
        for (int[] friendship : friendships) {
            Map<Integer, Integer> mp = new HashMap<>();
            boolean conm = false;
            for (int lan : languages[friendship[0] - 1]) {
                mp.put(lan, 1);
            }
            for (int lan : languages[friendship[1] - 1]) {
                if (mp.containsKey(lan)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                cncon.add(friendship[0] - 1);
                cncon.add(friendship[1] - 1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n + 1];
        for (int friendship : cncon) {
            for (int lan : languages[friendship]) {
                cnt[lan]++;
                max_cnt = Math.max(max_cnt, cnt[lan]);
            }
        }
        return cncon.size() - max_cnt;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/minimum-number-of-people-to-teach/solutions/3766885/xu-yao-jiao-yu-yan-de-zui-shao-ren-shu-b-jaf9/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
