package a3_jianzhi_offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class code_52 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //----------------------------
    //一种比较新颖的思路如下 思路是 a+c+b = b+c+a
    public ListNode FindFirstCommonNode222(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
    //----------------------------

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode loop1 = getLoopNode(pHead1);
        ListNode loop2 = getLoopNode(pHead2);
        //都没有环
        if (loop1 == null && loop2 == null) {
            return noLoop(pHead1, pHead2);
        }
        //两个都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(pHead1, pHead2, loop1, loop2);
        }
        //一个有环一个没有事不可能有公共节点的
        return null;
    }

    /**
     * 无环 找第一个公共节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode noLoop(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int n = 0;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? pHead1 : pHead2;
        cur2 = cur1 == pHead1 ? pHead2 : pHead1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 有环 找第一个公共节点
     * @param pHead1
     * @param pHead2
     * @param loop1
     * @param loop2
     * @return
     */
    private ListNode bothLoop(ListNode pHead1, ListNode pHead2, ListNode loop1, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        //入环节点相同
        if (loop1 == loop2) {
            int n = 0;
            cur1 = pHead1;
            cur2 = pHead2;
            while (cur1.next != null) {
                cur1 = cur1.next;
                n++;
            }
            while (cur2.next != null) {
                cur2 = cur2.next;
                n--;
            }
            cur1 = n > 0 ? pHead1 : pHead2;
            cur2 = cur1 == pHead1 ? pHead2 : pHead1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            //入环节点不相同
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    /**
     * 获取入环节点
     * @param head
     * @return
     */
    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != slow && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(4);
        pHead1.next.next.next.next = pHead1.next;

    }
}
