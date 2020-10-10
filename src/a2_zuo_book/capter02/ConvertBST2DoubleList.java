package a2_zuo_book.capter02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树转换为双向链表
 * 未完成
 */
public class ConvertBST2DoubleList {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node convert(Node head){
        Queue<Node> queue = new LinkedList();
        inOrderToQueue(queue,head);
        if(queue.isEmpty()){
            return null;
        }
        head = queue.poll();
        Node pre = head;
        Node cur = null;
        pre.left = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public static void inOrderToQueue(Queue queue, Node head) {
        if (head == null){
            return;
        }
        inOrderToQueue(queue,head.left);
        queue.offer(head);
        inOrderToQueue(queue,head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(4);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(5);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        head.right.right = new Node(9);
        head.right.right.left = new Node(8);

        convert(head);
    }
}
