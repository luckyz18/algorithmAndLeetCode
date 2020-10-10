package a2_zuo_book.chapter03.CBT;

/**
 * 完全二叉树节点的个数
 * 时间复杂度低于 O(N)
 */
public class NodeNum {
    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public int getNodeNum(Node head){
        if (head == null){
            return 0;
        }
        int h = mostLeftLevel(head, 1);
        return bs(head,1,h);
    }

    private int bs(Node head, int l, int h) {
        if (l == h){
            return 1;
        }
        if (mostLeftLevel(head.right,l+1) == h){
            return (1 << (h-l)) + bs(head.right,l+1,h);
        } else {
            return (1 << (h-l-1)) + bs(head.left,l+1,h);
        }
    }

    private int mostLeftLevel(Node head, int level) {
        while (head.left!= null){
            head = head.left;
            level++;
        }
        return level;
    }
}
