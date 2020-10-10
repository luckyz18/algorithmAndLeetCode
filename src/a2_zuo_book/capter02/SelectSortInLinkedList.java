package a2_zuo_book.capter02;

/**
 * 单链表的选择排序
 * 选择排序： 找到链表得最小值index  删除最小值  最小值加到已经排好序的部分中
 */
public class SelectSortInLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node selectSortInLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = null;
        Node small = null;
        Node smallPre = null;
        Node tail = null;
        Node cur = head;
        while (cur != null) {
            small = cur;
            smallPre = getMinNodePre(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                newHead = small;
                tail = small;
            } else {
                tail.next = small;
                tail = small;
            }
        }
        return newHead;
    }

    private static Node getMinNodePre(Node head) {
        if (head == null || head.next == null){
            return null;
        }
        Node smallPre = null;
        Node pre = head;
        Node small = head;
        Node cur = head.next;
        while (cur != null){
            if (cur.value < small.value){
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(6);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(4);

        selectSortInLinkedList(head);
    }
}
