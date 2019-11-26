package zuo_book.chapter03.BT;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 按层打印和 zigzag 打印
 */
public class PrintByLevelAndZigzag {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 这个按层打印 同一层的节点必须在同一行上 打印层数
     *
     * @param head
     */
    public static void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Node last = head;
        Node nLast = null;
        Deque<Node> queue = new LinkedList();
        queue.offer(head);
        int level = 1;
        System.out.print("level " + level + ":");
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.value + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
                nLast = queue.getLast();
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nLast = queue.getLast();
            }
            if (poll == last && !queue.isEmpty()) {
                level += 1;
                System.out.print("\nlevel " + level + ":");
                last = nLast;
            }
        }
    }

    //双端队列
    public static void printByZigZag(Node head) {
        if (head == null) {
            return;
        }
        int level = 1;
        Deque<Node> deque = new LinkedList();
        deque.offer(head);
        Node last = head;
        Node nLast = null;
        boolean fromL2R = true;
        Node poll = null;
        printLevelInfo(level++, fromL2R);
        while (!deque.isEmpty()) {
            if (fromL2R) {
                poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.addLast(poll.left);
                    nLast = nLast == null ? poll.left : nLast;
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                    nLast = nLast == null ? poll.right : nLast;
                }
            } else {
                poll = deque.pollLast();
                if (poll.right != null) {
                    deque.addFirst(poll.right);
                    nLast = nLast == null ? poll.right : nLast;
                }
                if (poll.left != null) {
                    deque.addFirst(poll.left);
                    nLast = nLast == null ? poll.left : nLast;
                }
            }
            System.out.print(poll.value + " ");

            if (poll == last && !deque.isEmpty()) {
                fromL2R = !fromL2R;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelInfo(level++, fromL2R);
            }
        }
        System.out.println();
    }

    private static void printLevelInfo(int level, boolean fromL2R) {
        System.out.print("level " + level + " from ");
        System.out.print(fromL2R ? "left to right: " : "right to left: ");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(7);
        head.right.left.right = new Node(8);
        head.right.right = new Node(6);

        //printByLevel(head);
        printByZigZag(head);
    }
}
