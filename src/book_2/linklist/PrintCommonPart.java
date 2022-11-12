package book_2.linklist;

/**
 * 打印两个有序链表公共部分
 */
public class PrintCommonPart {

    public static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void printCommonPart(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return;
        }
        while (head1.value < head2.value){
            head1 = head1.next;
        }
        while (head2.value < head1.value){
            head2 = head2.next;
        }
        while (head1!= null && head2 != null ){
            System.out.println(head1.value);
            head1 = head1.next;
            head2 = head2.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, null);
        head1.next = new Node(3, null);
        head1.next.next = new Node(4, null);
        head1.next.next.next = new Node(5, null);

        Node head2 = new Node(4, null);
        head2.next = new Node(5, null);


        printCommonPart(head1, head2);
    }

}
