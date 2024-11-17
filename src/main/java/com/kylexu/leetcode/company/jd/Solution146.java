package com.kylexu.leetcode.company.jd;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    class DLinkNode {
        int key;
        int value;

        DLinkNode pre;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private DLinkNode head;
    private DLinkNode tail;


    public Solution146(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        this.head = new DLinkNode();
        this.tail = new DLinkNode();

        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            DLinkNode linkNode = new DLinkNode(key, value);
            cache.put(key, linkNode);

            addToHead(linkNode);
            size++;

            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private DLinkNode removeTail() {
        DLinkNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    private void addToHead(DLinkNode node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }


    public static void main(String[] args) {
        Solution146 lRUCache = new Solution146(2);
//        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
