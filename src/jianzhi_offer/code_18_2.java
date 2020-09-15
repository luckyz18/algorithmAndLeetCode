package jianzhi_offer;

/**
 * 删除链表中的重复节点
 */
public class code_18_2 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = pHead;
        ListNode pre = preHead;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && cur.val == next.val) {
                while (next != null &&  cur.val == next.val) {
                    cur = next;
                    next = next.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return preHead.next;
    }

    /**
     *大佬的递归写法
     */
    public static ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication2(next);
        } else {
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(3);
        //head.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next.next = new ListNode(4);

        ListNode listNode = deleteDuplication(head);
        System.out.println();
    }

}
