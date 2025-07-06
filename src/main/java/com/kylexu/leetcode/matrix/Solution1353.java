package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 观察一：第一天（即开始时间 startDay
 * i
 * ​
 *   的最小值）一定要参加会议，若不参加，岂不是白白浪费机会？比如有个会议是 [1,1]，不参加就错过了。
 *
 * 或者说，对于任意最优解，如果第一天什么也没做，我们总是可以把其中某个会议的参加时间改成第一天。
 *
 * 如果有多个会议的 startDay
 * i
 * ​
 *   都相同呢？比如有三个会议 [1,1],[1,2],[1,3]，参加哪个会议更好？
 *
 * 观察二：参加结束时间 endDay
 * i
 * ​
 *   最小的会议。如果第一天不参加会议 [1,1]，而是参加会议 [1,2]，那么第二天就没法参加会议 [1,1] 了。
 *
 * 参加 endDay
 * i
 * ​
 *   最小的会议后，问题变成从第二天开始，解决剩余 n−1 个会议的子问题。
 *
 * 需要知道哪些信息？
 * 在第一天，可以参加哪些会议？
 *
 * 在第二天，可以参加哪些会议？
 *
 * 在第 i 天，可以参加哪些会议？
 *
 * 若按照开始时间分组，那么在第 i 天，开始时间为 i 的会议就是新增的可以参加的会议。
 *
 * 此外，还需要知道在剩余可以参加的会议中，结束时间最小的会议。根据观察二，参加这个会议。
 *
 * 算法
 * 把会议按照开始时间分组，用 groups[i] 表示所有开始时间为 i 的会议的结束时间。
 *
 * 我们需要一个数据结构维护结束时间。这个数据结构需要支持如下操作：
 *
 * 添加结束时间。
 * 查询结束时间的最小值。
 * 删除最小的结束时间，表示我们参加这个会议，或者这个会议已过期（结束时间小于当前时间）。
 * 最小堆完美符合要求。
 *
 * 在第 i 天：
 *
 * 删除最小堆中结束时间小于 i 的会议（已过期）。
 * 把开始时间为 i 的会议的结束时间，加到最小堆中。
 * 如果最小堆不为空，那么弹出堆顶（参加会议），把答案加一。
 *
 * 作者：灵茶山艾府
 * 链接：https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/solutions/3707151/liang-chong-fang-fa-zui-xiao-dui-bing-ch-ijbf/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1353 {
    public static void main(String[] args) {
//[[1,2],[2,3],[3,4]]
        int[][] events = {
                {1, 2},
                {2, 3},
                {3, 4},
        };
        int i = new Solution1353().maxEvents(events);
        System.out.println("i = " + i);
    }

    public int maxEvents(int[][] events) {
        int mx = 0;
        for (int[] event : events) {
            mx = Math.max(mx, event[1]);
        }

        // 按照开始时间分组
        List<Integer>[] groupByStart = new ArrayList[mx + 1];
        Arrays.setAll(groupByStart, k -> new ArrayList<>());
        for (int[] event : events) {
            groupByStart[event[0]].add(event[1]);
        }

        int an = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= mx; i++) {
            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }
            for (Integer integer : groupByStart[i]) {
                queue.offer(integer);
            }
            if (!queue.isEmpty()) {
                an++;
                queue.poll();
            }
        }

        return an;
    }
}
