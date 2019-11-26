package zuo_book.chapter03.BST;

/**
 * 在二叉树中找最大的搜索二叉树
 * 树形 dp !!!
 */
public class MaxBSTInBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
        int min;
        int max;
        Node maxBSTHead;
        int maxBSTSize;

        public ReturnType(int min, int max, Node maxBSTNode, int maxBSTSize) {
            this.min = min;
            this.max = max;
            this.maxBSTHead = maxBSTNode;
            this.maxBSTSize = maxBSTSize;
        }
    }

    public static ReturnType getMaxBST(Node X) {
        if (X == null) {
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, null, 0);
        }
        ReturnType lData = getMaxBST(X.left);
        ReturnType rData = getMaxBST(X.right);
        int min = Math.min(Math.min(lData.min, rData.min), X.value);
        int max = Math.max(Math.max(lData.max, rData.max), X.value);
        int maxBSTSize = Math.max(lData.maxBSTSize,rData.maxBSTSize);
        Node maxBSTNode = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        if (lData.maxBSTHead == X.left && rData.maxBSTHead == X.right
                && lData.max < X.value && rData.min > X.value) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize;
            maxBSTNode = X;
        }
        return new ReturnType(min,max,maxBSTNode,maxBSTSize);
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
        ReturnType maxBST = getMaxBST(head);
        System.out.println(maxBST.maxBSTHead.value);
    }
}
