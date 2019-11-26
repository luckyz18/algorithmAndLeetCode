package zuo_book.chapter03.BT;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Stack;

/**
 * 最基本的二叉树遍历
 */
public class TraverseBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println("递归先序----" + head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println("非递归先序----" + node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println("递归中序---" + head.value);
        inOrderRecur(head.right);
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;  //先装左子树
            } else {
                head = stack.pop();  //访问节点
                System.out.println("中序非递归---"+ head.value);
                head = head.right;
            }
        }
    }

    public static void postOrderRecur(Node head){
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println("后序递归"+head.value);
    }

    /**
     * 后序遍历的非递归方式用两个栈
     * @param head
     */
    public static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            Node pop = stack2.pop();
            System.out.println("后序非递归"+pop.value);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right= new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        //preOrderRecur(head);
        //preOrder(head);
        //inOrderRecur(head);
        //inOrder(head);
        //postOrderRecur(head);
        postOrder(head);

    }


}
