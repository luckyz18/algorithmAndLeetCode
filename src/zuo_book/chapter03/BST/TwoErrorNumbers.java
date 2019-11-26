package zuo_book.chapter03.BST;

import java.util.Stack;

/**
 * 调整搜索二叉树中的两个错误节点
 */
public class TwoErrorNumbers {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node[] getTwoErrorNumbers(Node head) {
        if (head == null) {
            return null;
        }
        //中序遍历
        Stack<Node> stack = new Stack();
        Node pre = null;
        Node[] errors = new Node[2];
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errors;
    }

    public static void main(String[] args) {
        //Node head = new Node(3);
        //head.left = new Node(2);
        //head.left.left = new Node(1);
        //head.right = new Node(4);
        //head.right.left = new Node(5);

        Node head = new Node(2);
        head.left = new Node(3);
        head.right = new Node(1);

        Node[] twoErrorNumbers = getTwoErrorNumbers(head);
        System.out.println();
    }
}
