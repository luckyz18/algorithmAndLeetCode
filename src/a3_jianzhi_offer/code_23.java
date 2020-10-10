package a3_jianzhi_offer;

/**
 * 链表中环的入口节点
 */
public class code_23 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while ( fast!= slow){
            if (fast != null && fast.next!= null) {
                slow = slow.next;
                fast = fast.next.next;
            }else{
                return null;
            }
        }
        fast = pHead;
        while ( slow!= fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
