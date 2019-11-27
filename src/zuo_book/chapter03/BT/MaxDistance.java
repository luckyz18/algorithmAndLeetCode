package zuo_book.chapter03.BT;

/**
 * 二叉树节点间的最大距离
 * 树形dp
 */
public class MaxDistance {

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
        int height;
        int maxDistance;

        public ReturnType(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        //后序遍历
        //以 X 为头结点的子树
        ReturnType ldata = process(head.left);
        ReturnType rdata = process(head.right);
        int height = Math.max(ldata.maxDistance, rdata.maxDistance) + 1;
        int maxDistance = Math.max(ldata.height + rdata.height + 1,
                Math.max(ldata.maxDistance, rdata.maxDistance));
        return new ReturnType(height, maxDistance);
    }

    public static int getMaxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(getMaxDistance(head));
    }

}
