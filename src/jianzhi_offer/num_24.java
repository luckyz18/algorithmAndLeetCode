package jianzhi_offer;

/**
 * 反转链表
 */
public class num_24 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        pre.next = null;
        while (cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    //递归
    public static ListNode ReverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList3(next);
        next.next = head;
        return newHead;
    }

    //头插  迭代
    public static ListNode ReverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode headPre = new ListNode(0);
        ListNode next =null;
        while (head!= null){
            next = head.next;
            head.next = headPre.next;
            headPre.next = head;
            head = next;
        }
        return headPre.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode node = ReverseList3(head);
        System.out.println();
    }
}
