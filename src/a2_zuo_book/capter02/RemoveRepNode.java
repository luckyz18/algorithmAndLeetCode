package a2_zuo_book.capter02;

import java.util.HashSet;

/**
 * 删除无序单链表的值重复的节点
 */
public class RemoveRepNode {
    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeRepNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet();
        Node cur = head.next;
        Node pre = head;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //不借助哈希表 时间复杂度 O(n^2) 空间 O(1)
    public static Node removeRepNode2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (next.value == cur.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(1);

        removeRepNode2(head);
        System.out.println();
    }

}
