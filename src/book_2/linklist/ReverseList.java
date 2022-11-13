package book_2.linklist;

/**
 * 翻转链表
 */
public class ReverseList {

    public class Node{
        private int  value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public class DoubleNode{
        private int  value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public Node reverseList(Node  head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public DoubleNode reverseList(DoubleNode  head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


}
