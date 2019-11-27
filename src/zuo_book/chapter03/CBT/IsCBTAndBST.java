package zuo_book.chapter03.CBT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsCBTAndBST {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 是否是完全二叉树
     * 层次遍历，不是二叉树的情况：
     * 1. 有右子树 没左子树
     * 2. 左右不全 但是后面不全是叶子节点
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Node l = null;
        Node r = null;
        boolean leaf = false;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (l == null && r != null) {
                return false;
            }
            //如果要求其是叶子节点 但是该节点有左右孩子
            if (leaf && (l != null || r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                //该节点左右孩子不全，那么它后面的节点都应该是叶子
                //都没有  或者只有左
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 判断一棵树是否是搜索二叉树
     * 看其中序遍历的顺序是否有序即可
     * 时间 O(N)
     * 空间 O(N)
     * 也可以用 morris 序列 时间复杂度是 O(1)
     */
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }

    /**
     * morris序列的解法
     *
     * @param head
     * @return
     */
    public static boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node pre = null;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur; //cur 第一次访问
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; //cur 第二次访问
                    if (pre != null && pre.value > cur.value) {
                        return false;
                    }
                    pre = cur;
                }
            } else {
                //只访问一次的节点也要比较！！！
                //或者抽离出来
                if (pre != null && pre.value > cur.value) {
                    return false;
                }
                pre = cur;
            }

            cur = cur.right;
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(3);
        head.left = new Node(2);
        head.right = new Node(5);
        head.left.left = new Node(6);

        head.right.left = new Node(4);

        //boolean cbt = isCBT(head);
        boolean a = isBST2(head);
        System.out.println(a);
    }


}
