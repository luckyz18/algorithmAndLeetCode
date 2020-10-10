package a2_zuo_book.capter02;

/**
 * 在有序的环形链表中 插入一个num的节点
 */
public class InsertInSortCircleLinkedlist {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && num <= cur.value) {
                pre.next = node;
                node.next = cur;
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        if (cur == head){
            pre.next = node;
            node.next = cur;
        }
        return num<head.value ? node : head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = head;
        Node w = insertNum(head, 7);
        System.out.println();
    }
}
