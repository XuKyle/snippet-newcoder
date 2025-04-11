package com.kylexu.bean;

import java.util.*;

public class NTreeNodeTools {
    public static void main(String[] args) {
        NTreeNode nTreeNode = NTreeNodeTools.buildTree(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
        System.out.println("nTreeNode = " + nTreeNode);

        NTreeNode nTreeNodePro = NTreeNodeTools.buildTreePro(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
        System.out.println("nTreeNode = " + nTreeNodePro);
    }


    public static NTreeNode buildTree(Integer[] nums) {
        List<List<NTreeNode>> layer = new ArrayList<>();
        LinkedList<NTreeNode> helper = new LinkedList<>();

        NTreeNode root = new NTreeNode(nums[0]);
        helper.add(root);
        layer.add(List.of(root));

        int index = 2;
        List<NTreeNode> currentLayer = new ArrayList<>();
        // 是否结束标识
        boolean flag = false;

        while (!helper.isEmpty() && !flag) {
            int size = helper.size();

            while (size > 0 && !flag) {
                NTreeNode node = helper.removeFirst();
                size--;
                for (int i = index; i < nums.length; i++) {
                    if (nums[i] == null) {
                        if (size != 0) {
                            currentLayer.add(null);
                        }
                        index = i + 1;
                        break;
                    } else {
                        NTreeNode newNode = new NTreeNode(nums[i]);
                        currentLayer.add(newNode);
                        helper.add(newNode);
                    }

                    if (i == nums.length - 1) {
                        flag = true;
                    }
                }

                if (size == 0 || flag) {
                    layer.add(currentLayer);
                    currentLayer = new ArrayList<>();
                }
            }
        }


        for (int i = 1; i < layer.size(); i++) {
            List<NTreeNode> upperLayer = layer.get(i - 1);
            List<NTreeNode> filerNullUpperLayer = upperLayer.stream().filter(obj -> !Objects.isNull(obj)).toList();

            List<NTreeNode> curLayer = layer.get(i);
            int loopIndex = 0;
            for (NTreeNode currentTreeNode : curLayer) {
                if (currentTreeNode == null) {
                    loopIndex++;
                } else {
                    NTreeNode parentNode = filerNullUpperLayer.get(loopIndex);
                    if (parentNode.children == null) {
                        parentNode.children = new ArrayList<>();
                    }
                    parentNode.children.add(currentTreeNode);
                }
            }
        }

        return root;
    }

    public static NTreeNode buildTreePro(Integer[] nums) {
        // 数据结构初始化
        List<List<NTreeNode>> layer = new ArrayList<>();    // 存储各层节点列表（包含null占位）
        LinkedList<NTreeNode> helper = new LinkedList<>();  // 用于BFS层序构建的辅助队列

        // 根节点初始化
        NTreeNode root = new NTreeNode(nums[0]);            // 首元素作为根节点
        helper.add(root);                                   // 根节点入队
        layer.add(List.of(root));                           // 首层(第0层)初始化

        // 构建过程变量
        int index = 2;                   // 从数组第3个元素开始处理（索引0是根节点，索引1已被跳过）
        List<NTreeNode> currentLayer = new ArrayList<>();  // 当前构建层节点集合
        boolean flag = false;            // 数组遍历完成标志

        // ====================== 阶段1：层级节点构建 ======================
        // 外层循环：按层处理
        while (!helper.isEmpty() && !flag) {
            int size = helper.size();    // 当前层待处理节点数

            // 内层循环：处理当前层每个节点
            while (size > 0 && !flag) {
                NTreeNode node = helper.removeFirst();  // 取出当前层节点
                size--;  // 当前层剩余节点数递减

                // 遍历数组元素构建子节点
                for (int i = index; i < nums.length; i++) {
                    if (nums[i] == null) {
                        // 空节点处理：当同层仍有未处理节点时添加占位null
                        if (size != 0) {
                            currentLayer.add(null);
                        }
                        index = i + 1;   // 跳过当前null元素
                        break;           // 结束当前节点的子节点处理
                    } else {
                        // 非空节点处理：创建节点并记录
                        NTreeNode newNode = new NTreeNode(nums[i]);
                        currentLayer.add(newNode);    // 加入当前层
                        helper.add(newNode);           // 加入队列供下层处理
                    }

                    // 终止条件：处理到数组末尾元素
                    if (i == nums.length - 1) {
                        flag = true;
                    }
                }

                // 当前层处理完成或数组遍历完成时
                if (size == 0 || flag) {
                    layer.add(currentLayer);           // 当前层加入层级列表
                    currentLayer = new ArrayList<>();  // 重置为下一层准备
                }
            }
        }

        // ====================== 阶段2：父子关系绑定 ======================
        for (int i = 1; i < layer.size(); i++) {
            // 获取过滤空节点后的上层父节点列表
            List<NTreeNode> upperLayer = layer.get(i - 1);
            List<NTreeNode> filteredUpper = upperLayer.stream().filter(Objects::nonNull).toList();

            // 当前层节点遍历
            List<NTreeNode> curLayer = layer.get(i);
            int parentIndex = 0;  // 父节点指针（指向filteredUpper的有效父节点）

            for (NTreeNode currentNode : curLayer) {
                if (currentNode == null) {
                    parentIndex++;  // 跳过空节点占位（对应父节点指针移动）
                    continue;
                }

                // 绑定父子关系（重要逻辑）
                NTreeNode parent = filteredUpper.get(parentIndex);  // 获取对应父节点
                if (parent.children == null) {
                    parent.children = new ArrayList<>();  // 初始化子节点列表
                }
                parent.children.add(currentNode);         // 添加子节点
            }
        }

        return root;
    }

}
