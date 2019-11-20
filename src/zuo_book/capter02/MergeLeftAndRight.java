package zuo_book.capter02;

/**
 * 按照左右分区的方式重新组合链表
 */
public class MergeLeftAndRight {
    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void reLocat(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        Node mid = head;
        Node right = head.next;
        while(right.next!=null && right.next.next!= null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head,right);
    }

    private static void mergeLR(Node left, Node right) {
        Node next = null;
        Node newHead = left;
        while (left.next != null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
        System.out.println("--");
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        reLocat(head1);
    }
}
