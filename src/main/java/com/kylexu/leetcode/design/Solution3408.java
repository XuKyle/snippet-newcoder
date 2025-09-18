package com.kylexu.leetcode.design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3408 {
}


class TaskManager {
    private Map<Integer, int[]> taskInfo;
    private PriorityQueue<int[]> heap;

    public TaskManager(List<List<Integer>> tasks) {
        taskInfo = new HashMap<>();
        heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        for (List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            taskInfo.put(taskId, new int[]{priority, userId});
            heap.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskInfo.put(taskId, new int[]{priority, userId});
        heap.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        if (taskInfo.containsKey(taskId)) {
            taskInfo.get(taskId)[0] = newPriority;
            heap.offer(new int[]{newPriority, taskId});
        }
    }

    public void rmv(int taskId) {
        taskInfo.remove(taskId);
    }

    public int execTop() {
        while (!heap.isEmpty()) {
            int[] task = heap.poll();
            int priority = task[0], taskId = task[1];

            if (taskInfo.containsKey(taskId) && taskInfo.get(taskId)[0] == priority) {
                int userId = taskInfo.get(taskId)[1];
                taskInfo.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/design-task-manager/solutions/3775224/she-ji-ren-wu-guan-li-qi-by-leetcode-sol-wibx/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。