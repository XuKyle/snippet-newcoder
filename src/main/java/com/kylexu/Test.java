package com.kylexu;


/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = , n = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output:
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */

public class Test {
    public static void main(String[] args) {

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        node1.next = node2;

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        Node node1 = null;

        Test test = new Test();
        Node node = test.removeTargetNode(node1, 1);

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    public Node removeTargetNode(Node node,int n){

        if((node == null || node.next ==null ) && n>=1){
            return null;
        }

        int fast = 0;

        Node fastNode = node;
        Node slowNode = node;

        //快指针先走
        while (fast < n) {
            fastNode = fastNode.next;
            if(fastNode == null){
                return null;
            }
            fast ++;
        }

        while(fastNode.next !=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return node;
    }
}


class Node{
    Integer data;
    Node next;
    public Node(Integer data){
        this.data = data;
    }
}