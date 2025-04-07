package com.kylexu.bean;

import java.util.*;

/**
 * 深度优先遍历 前序遍历（递归法，迭代法） 中序遍历（递归法，迭代法） 后序遍历（递归法，迭代法）
 * ⼴度优先遍历 层次遍历（迭代法）
 * <p>
 * 之前我们讲栈与队列的时候，就说过栈其实就是递归的⼀种实现结构，也就说前中后序遍历的逻辑其实都是可以借 助栈使⽤⾮递归的⽅式来实现的。
 * ⽽⼴度优先遍历的实现⼀般使⽤队列来实现，这也是队列先进先出的特点所决定的，因为需要先进先出的结构，才 能⼀层⼀层的来遍历⼆叉树。
 */
public class TreeNodeTools {
    // ********************************************************************************************************************************************
    //    递归
    //    1. 确定递归函数的参数和返回值：
    //         确定哪些参数是递归的过程中需要处理的，那么就在递归函数⾥加上这个参数， 并且还要明确每次递归的返回值是什么进⽽确定递归函数的返回类型。
    //    2. 确定终⽌条件：
    //      写完了递归算法, 运⾏的时候，经常会遇到栈溢出的错误，就是没写终⽌条件或者终⽌条件写的不对，操作系 统也是⽤⼀个栈的结构来保存每⼀层递归的信息，如果递归没有终⽌，操作系统的内存栈必然就会溢出。
    //    3. 确定单层递归的逻辑：
    //         确定每⼀层递归需要处理的信息。在这⾥也就会重复调⽤⾃⼰来实现递归的过程。

    // 测试
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode root = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        // 前序遍历
        System.out.println("前序遍历: ");
        System.out.println(TreeNodeTools.preorderTraversal(root));
        System.out.println(TreeNodeTools.preorderTraversalWithStack(root));
        System.out.println(TreeNodeTools.preorderTraversalWithStackV2(root));

        System.out.println("中序遍历: ");
        System.out.println(TreeNodeTools.inorderTraversal(root));
        System.out.println(TreeNodeTools.inorderTraversalWithStack(root));

        System.out.println("后序遍历: ");
        System.out.println(TreeNodeTools.postorderTraversal(root));
        System.out.println(TreeNodeTools.postorderTraversalWithStack(root));

        System.out.println("层级遍历: ");
        System.out.println(TreeNodeTools.widthTraverse(root));
        System.out.println(TreeNodeTools.widthTraverseWithQueueV2(root));
        System.out.println(TreeNodeTools.widthTraverseWithQueue(root));
    }


    public static TreeNode buildTree(List<Integer> nums) {
        List<TreeNode> treeNodes = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            Integer current = nums.get(i);
            if (current != null) {
                TreeNode treeNode = new TreeNode(current);
                treeNodes.add(treeNode);
                if (i != 0) {
                    if (i % 2 == 0) {
                        treeNodes.get((i - 2) / 2).right = treeNode;
                    } else {
                        treeNodes.get((i - 1) / 2).left = treeNode;
                    }
                }
            }
        }

        return treeNodes.get(0);
    }


    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        preorderTraversalHelper(root, rs);
        return rs;
    }

    private static void preorderTraversalHelper(TreeNode root, List<Integer> holder) {
        if (root == null) {
            return;
        }

        holder.add(root.val);
        preorderTraversalHelper(root.left, holder);
        preorderTraversalHelper(root.right, holder);
    }

    // 通过栈来实现 - 1
    public static List<Integer> preorderTraversalWithStack(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 外层循环：当节点非空或栈非空时继续处理（保证处理完所有节点）
        while (node != null || !stack.isEmpty()) {
            // 内层循环：一直向左深入，沿途记录节点（根 -> 左）
            while (node != null) {
                rs.add(node.val);   // 访问当前根节点
                stack.push(node);   // 将当前节点压栈，为后续处理右子树做准备
                node = node.left;   // 移动到左子节点
            }

            // 当左子树遍历完成（node == null），处理右子树
            if (!stack.isEmpty()) {
                node = stack.pop(); // 弹出最近访问的父节点（回溯）
                node = node.right;  // 转向右子树继续遍历
            }
        }

        return rs;
    }

    // 通过栈来实现 - 2
    public static List<Integer> preorderTraversalWithStackV2(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (node == null) {
            return rs;
        }
        stack.add(node);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current != null) {
                stack.pop();
                if (current.right != null) {
                    stack.add(current.right);
                }
                if (current.left != null) {
                    stack.add(current.left);
                }
                stack.add(current);
                stack.add(null);
            } else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                rs.add(node.val);
            }
        }

        return rs;
    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        inorderTraversalHelper(root, rs);
        return rs;
    }

    private static void inorderTraversalHelper(TreeNode root, List<Integer> holder) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(root.left, holder);
        holder.add(root.val);
        inorderTraversalHelper(root.right, holder);
    }

    // 通过栈来实现 v2
    public static List<Integer> inorderTraversalWithStack(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (node == null) {
            return rs;
        }
        stack.add(node);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current != null) {
                stack.pop();
                if (current.right != null) {
                    stack.add(current.right);
                }
                stack.add(current);
                stack.add(null);
                if (current.left != null) {
                    stack.add(current.left);
                }
            } else {
                stack.pop();
                node = stack.pop();
                rs.add(node.val);
            }
        }

        return rs;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param holder
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        postorderTraversalHelper(root, rs);
        return rs;
    }

    private static void postorderTraversalHelper(TreeNode root, List<Integer> holder) {
        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left, holder);
        postorderTraversalHelper(root.right, holder);
        holder.add(root.val);
    }

    /**
     * 后序 遍历，使用栈来实现
     *
     * @param node
     * @return
     */
    public static List<Integer> postorderTraversalWithStack(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (node == null) {
            return rs;
        }
        stack.add(node);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current != null) {
                stack.pop();

                stack.add(current);
                stack.add(null);
                if (current.right != null) {
                    stack.add(current.right);
                }
                if (current.left != null) {
                    stack.add(current.left);
                }
            } else {
                stack.pop();
                node = stack.pop();
                rs.add(node.val);
            }
        }

        return rs;
    }


    //  **************************   层序遍历的模板  **************************

    // 递归实现
    public static List<List<Integer>> widthTraverse(TreeNode node) {
        List<List<Integer>> rs = new ArrayList<>();
        widthTraverseHelper(rs, node, 0);
        return rs;
    }

    private static void widthTraverseHelper(List<List<Integer>> rs, TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;

        if (rs.size() < deep) {
            rs.add(new ArrayList<>());
        }

        rs.get(deep - 1).add(node.val);
        widthTraverseHelper(rs, node.left, deep);
        widthTraverseHelper(rs, node.right, deep);
    }

    // 队列实现
    public static List<Integer> widthTraverseWithQueue(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();

        if (node == null) {
            return rs;
        }

        helper.add(node);
        while (!helper.isEmpty()) {
            TreeNode treeNode = helper.removeFirst();
            rs.add(treeNode.val);

            if (treeNode.left != null) {
                helper.add(treeNode.left);
            }
            if (treeNode.right != null) {
                helper.add(treeNode.right);
            }
        }

        return rs;
    }

    public static List<List<Integer>> widthTraverseWithQueueV2(TreeNode node) {
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();

        if (node == null) {
            return rs;
        }

        helper.add(node);
        while (!helper.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = helper.size();

            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
                n--;
            }

            rs.add(temp);
        }

        return rs;
    }

}
