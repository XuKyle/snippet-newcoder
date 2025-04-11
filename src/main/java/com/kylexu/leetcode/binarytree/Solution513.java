package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class Solution513 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{1, 2, 3, null, null, null, 5});
        System.out.println(new Solution513().findBottomLeftValue(treeNode));
        System.out.println(new Solution513().findBottomLeftValueV1(treeNode));
        System.out.println(new Solution513().findBottomLeftValuePro(treeNode));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public int findBottomLeftValueV1(TreeNode root) {
        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);
        int rs = 0;

        while (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = helper.removeFirst();
                if (i == 0) {
                    rs = treeNode.val;
                }
                if (treeNode.left != null) {
                    helper.add(treeNode.left);

                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
            }
        }
        return rs;
    }

    public int findBottomLeftValuePro(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int rs = 0;

        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            boolean leftFlag = false;
            int currentLeft = -1;
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                    if (!leftFlag) {
                        leftFlag = true;
                        currentLeft = treeNode.left.val;
                    }
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }

                n--;
            }

            if (leftFlag) {
                rs = currentLeft;
            }
        }

        return rs;
    }

}
