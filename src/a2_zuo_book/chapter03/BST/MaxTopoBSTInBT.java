package a2_zuo_book.chapter03.BST;

/**
 * 在二叉树中找到最大的二叉搜索树拓扑结构
 * O（N^2）
 */
public class MaxTopoBSTInBT {
     static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int bstTopoSize(Node head) {
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(max, bstTopoSize(head.left));
        max = Math.max(max, bstTopoSize(head.right));
        return max;
    }
    //队列
    private int maxTopo(Node head, Node node) {
        if (head != null && node != null && isBSTNode(head, node, node.value)) {
            return maxTopo(head,node.left) + maxTopo(head,node.right) + 1;
        }
        return 0;
    }

    private boolean isBSTNode(Node head, Node node, int value) {
        if (head == null) {
            return false;
        }
        if (head == node) {
            return true;
        }
        if (value < head.value) {
            return isBSTNode(head.left, node, value);
        } else {
            return isBSTNode(head.right, node, value);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.left = new Node(10);
        head.right = new Node(13);
        head.left.left = new Node(4);
        head.left.right = new Node(14);
        head.right.left = new Node(20);
        head.right.right = new Node(16);
        head.left.left.left = new Node(2);
        head.left.left.right = new Node(5);
        head.left.right.left = new Node(11);
        head.left.right.right = new Node(15);


        MaxTopoBSTInBT maxTopoBSTInBT = new MaxTopoBSTInBT();
        int i = maxTopoBSTInBT.bstTopoSize(head);
        System.out.println(i);
    }
}
