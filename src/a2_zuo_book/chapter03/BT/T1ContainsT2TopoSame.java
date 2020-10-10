package a2_zuo_book.chapter03.BT;

/**
 * t1树中是否有与t2树拓扑结构 完全相同 的子树
 */
public class T1ContainsT2TopoSame {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(N+M)
    //这里米有用 KMP 算法
    public static boolean isSubTree(Node t1, Node t2) {
        //序列化
        String t1Str = serialByPre(t1);
        String t2Str = serialByPre(t2);
        //看是否是子串
        return isSubString(t1Str, t2Str);
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        StringBuffer res = new StringBuffer();
        res.append(head.value + "!");
        res.append(serialByPre(head.left));
        res.append(serialByPre(head.right));
        return res.toString();
    }

    public static boolean isSubString(String t1Str, String t2Str) {
        if (t1Str.indexOf(t2Str) != -1 ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.left.left = new Node(4);
        head1.left.left.right = new Node(8);
        head1.left.right = new Node(5);
        head1.left.right.left = new Node(9);
        head1.right = new Node(3);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);

        //
        Node head2 = new Node(2);
        head2.left = new Node(4);
        head2.right = new Node(5);
        head2.right.left= new Node(9);
        head2.left.right = new Node(8);

        boolean subTree = isSubTree(head1, head2);
        System.out.println(subTree);
    }
}
