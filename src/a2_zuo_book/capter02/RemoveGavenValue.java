package a2_zuo_book.capter02;

public class RemoveGavenValue {

    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeGivenValue(Node head, int k){
        if (head == null ){
            return null;
        }
        Node pre = new Node(0);
        pre.next = head;
        Node newHead = pre;
        Node cur = head;
        while(cur != null){
            if (cur.value  ==  k){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(1);
        //head.next.next.next = new Node(2);
        removeGivenValue(head,1);
    }


}
