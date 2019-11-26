package zuo_book.chapter03.BBT;

/**
 * 判断一颗树是否是平衡二叉树
 * 树形 dp ！！！
 */
public class BalancedTree {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
        int height;
        boolean isBalanced;

        public ReturnType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static ReturnType isBalancedTree(Node head) {
        if (head == null) {
            return new ReturnType(0, true);
        }
        ReturnType lData = isBalancedTree(head.left);
        ReturnType rdata = isBalancedTree(head.right);
        int height = Math.max(lData.height, rdata.height) + 1;
        boolean isBalanced = (lData.isBalanced &&
                rdata.isBalanced &&
                Math.abs(lData.height - rdata.height) < 2);
        return new ReturnType(height, isBalanced);
    }

    public static boolean isisBalanced(Node head) {
        return isBalancedTree(head).isBalanced;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.right.left = new Node(4);
        //head.right.left.right = new Node(5);
        System.out.println(isisBalanced(head));
    }

}
