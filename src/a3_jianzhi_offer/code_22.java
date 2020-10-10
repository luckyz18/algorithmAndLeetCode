package a3_jianzhi_offer;

/**
 * 链表中倒数第 K 个节点
 */
public class code_22 {
    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (k <= 0 ){
            return null;
        }
        ListNode cur = null;
        int len= getLinkedListLen(head);
        if (k > len){
            return null;
        }
        //
        cur = head;
        int count = 0;
        while (count<= len-k-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //快慢指针
    //判断链表节点小于K 不遍历整个链表
    public static ListNode FindKthToTail2(ListNode head,int k) {
        if (k <= 0 || head == null ){
            return null;
        }
        //int len = getLinkedListLen(head);
        //if (k > len){
        //    return null;
        //}
        ListNode slow = head;
        ListNode fast = head;
        int step = 0;
        while ( step < k){
            if (fast == null){
                return null;
            }
            step++;
            fast = fast.next;
        }
        while (fast!= null){
            slow= slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static int getLinkedListLen(ListNode head) {
        if (head == null){
            return 0;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = FindKthToTail2(head, 1);
        System.out.println();
    }
}
