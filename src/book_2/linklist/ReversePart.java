package book_2.linklist;

/**
 * 反转部分单向链表
 */
public class ReversePart {

    public static class Node{
        private int  value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reversePart(Node head, int from, int to){
        if (head == null || head.next == null){
            return head;
        }
        //找到fromPre, toPost节点
        Node fromPre = null;
        Node toPost = null;
        int len = 0;
        Node cur = head;
        while (cur != null){
            len++;
            fromPre = len == from-1 ? cur : fromPre;
            toPost = len == to+1 ? cur : toPost;
            cur = cur.next;
        }
        if (from < 1 || to > len || from > to){
            return head;
        }
        //先反转中间部分 再链接fromPre toPost
        //fromPre == null ? 头节点是反转过来第一个节点 ： 头节点不变;
        Node pre = fromPre != null ? fromPre.next : head;
        Node h = pre.next;
        pre.next = toPost;
        Node next = null;
        while (h != toPost){
            next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }
        if (fromPre != null){
            fromPre.next = pre;
            return head;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);


        Node node = reversePart(head, 1, 4);
        System.out.println(node);
    }

}
