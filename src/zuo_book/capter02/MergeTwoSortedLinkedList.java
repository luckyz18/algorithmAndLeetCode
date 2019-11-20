package zuo_book.capter02;

public class MergeTwoSortedLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        Node newHead = head1.value < head2.value ? head1 : head2;
        Node cur = null;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                if (cur != null) {
                    cur.next = head1;
                }
                cur = head1;
                head1 = head1.next;
            } else {
                if (cur != null) {
                    cur.next = head2;
                }
                cur = head2;
                head2 = head2.next;
            }
        }
        cur.next = head1 == null ? head2 : head1;
        return newHead;
    }

    public static void main(String[] args) {
        //Node head1 = new Node(1);
        //head1.next = new Node(5);
        //head1.next.next = new Node(6);

        Node head1 = new Node(9);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(7);

        Node merge = merge(head1, head2);
        System.out.println();


    }
}
