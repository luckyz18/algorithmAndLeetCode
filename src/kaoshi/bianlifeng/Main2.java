package kaoshi.bianlifeng;

import java.util.*;

public class Main2 {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int[] getNum(String[] arr, int i) {
        String s = arr[i];
        int left = s.indexOf("[");
        int[] res = new int[2];
        res[0] = Integer.parseInt(String.valueOf(s.charAt(left + 1)));
        res[1] = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
        return res;
    }

    static Node head = null;
    static Node tail = head;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split("]");
        int[] num1 = getNum(split, 0);
        head = new Node(num1[0]);
        tail = head;
        set.add(num1[0]);
        for (int i = 0; i < split.length; i++) {
            int[] num = getNum(split, i);
            int value = num[1];
            if (!set.contains(value)) {
                set.add(value);
                Node node = new Node(value);
                tail.next = node;
                tail = node;
            } else {
                Node node2 = getNodeWithValue(value);
                Node node1 = getNodeWithValue(num[0]);
                node1.next = node2;
            }
        }
        int ret = cycleLen(head.next);
        System.out.println(ret);

    }

    public static int cycleLen(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return 0;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        if (fast == null) {
            return 0;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node cur = slow.next;
        int len = 1;
        while (cur != null) {
            if (cur == slow) {
                break;
            } else {
                cur = cur.next;
                len++;
            }
        }
        return len;
    }

    private static Node getNodeWithValue(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
