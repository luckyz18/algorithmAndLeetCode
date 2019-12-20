package jianzhi_offer;

/**
 * 报数 环形约瑟夫
 */
public class code_62 {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //数学 O(N)
    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    //2. 环形链表解决此问题 时间O(Nm)
    public static int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        Node last = cur;
        int count = 0;
        while (head != last) {
            if (++count == m) {
                count = 0;
                last.next = head.next;
            } else {
                last = last.next;
            }
            head = head.next;
        }
        return head.value;
    }


    public static void main(String[] args) {
        int i = LastRemaining_Solution2(6, 3);
        System.out.println(i);
    }
}
