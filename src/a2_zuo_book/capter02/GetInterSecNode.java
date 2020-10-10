package a2_zuo_book.capter02;

/**
 * 两个单链表相交的一系列问题
 */
public class GetInterSecNode {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersecNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //找到第一个入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //另个无环节点  或者 两个有环节点 才可能相交
        if (loop1 == null && loop2 == null) {
            return getNoLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return getBothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private static Node getBothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        if (loop1 == loop2) {
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop1) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            Node next = loop1.next;
            while (next != loop1){
                if (next == loop2){
                    //return loop1 或者 loop2
                    return loop1;
                }
                next = next.next;
            }
            return null;
        }
    }

    private static Node getNoLoop(Node head1, Node head2) {
        Node n1 = head1;
        Node n2 = head2;
        int n = 0;
        //判断最后一个节点是否相同
        while (n1.next != null) {
            n++;
            n1 = n1.next;
        }
        while (n2.next != null) {
            n--;
            n2 = n2.next;
        }
        if (n1 != n2) {
            return null;
        }
        //相同的情况下  长的先走 X
        n1 = n > 0 ? head1 : head2;
        n2 = n1 == head1 ? head2 : head1;

        n = Math.abs(n);
        while (n > 0) {
            n--;
            n1 = n1.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /** 空间复杂度是 O(1)*/
    /**
     * 还可以用 map
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1.next;

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(7);
        head2.next.next.next = head2.next;


        Node intersecNode = getIntersecNode(head1, head2);
        System.out.println(intersecNode);
    }
}
