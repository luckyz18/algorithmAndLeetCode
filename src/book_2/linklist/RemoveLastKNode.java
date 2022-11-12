package book_2.linklist;


/**
 * 删除倒数第K个节点
 */
public class RemoveLastKNode {
    //单链表

    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node removeLastKNode(Node head, int k){
        int len = getListLength(head);
        if (head == null || k < 1 || k > len){
            return head;
        }
        if (k == len){
            head = head.next;
            return head;
        }
        Node cur = head;
        int index = 0;
        while (++index != (len-k)){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;

    }

    private static int getListLength(Node head) {
        Node cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);


        Node node = removeLastKNode(head, 2);
        System.out.println(node);
    }


}
