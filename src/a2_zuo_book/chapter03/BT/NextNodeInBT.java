package a2_zuo_book.chapter03.BT;

/**
 * 找二叉树中的后继节点
 */
public class NextNodeInBT {
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }
        //右子树的最左节点
        if (node.right != null) {
            return getMostLeft(node.right);
        }
        /**
         *  右子树为空  分两种情况
         *  1. 是父节点的左子树
         *  2. 是父节点的右子树： 找到时父节点的第一个左子树的 那个父节点
         *  这两种情况可以合并
         */
        Node parent = node.parent;
        while (parent != null && node != parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static Node getMostLeft(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.parent = null;
        root.left = new Node(2);
        root.left.parent = root;
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.parent =root;
        root.left.left = new Node(4);
        root.left.left.parent = root.left;
        root.right.left.parent = root.right;

        //
        System.out.println(getNextNode(root).value);
        System.out.println(getNextNode(root.left).value);
        //System.out.println(getNextNode(root.right).value);  //getNextNode(root.right) null 不取value
        System.out.println(getNextNode(root.left.left).value);
        System.out.println(getNextNode(root.right.left).value);
    }
}
