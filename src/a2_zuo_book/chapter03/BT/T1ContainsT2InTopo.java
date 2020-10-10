package a2_zuo_book.chapter03.BT;

/**
 * 二叉树 t1 是否包含 t2 的拓扑结构
 */
public class T1ContainsT2InTopo {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(N*M)
    public boolean contains(Node t1, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }
    private boolean check(Node t1, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null || t1.value != t2.value) {
            return false;
        }
       return check(t1.left,t2.left) && check(t1.right,t2.right);
    }
}
