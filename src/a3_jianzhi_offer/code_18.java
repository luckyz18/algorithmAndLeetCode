package a3_jianzhi_offer;

/**
 * O(1) 删除链表节点
 */
public class code_18 {
    static class ListNode {
        int value;
        ListNode next;
        public ListNode(int data){
            this.value = data;
        }
    }
    public static ListNode deleteNode(ListNode head,ListNode toBeDelete){
        if (head == null || toBeDelete== null){
            return null;
        }
        //不是尾节点
        if (toBeDelete.next!= null){
            ListNode next = toBeDelete.next;
            toBeDelete.value = next.value;
            toBeDelete.next= next.next;
        } else if (head.next == null){
            //只有一个节点
            head= null;
        } else{
            ListNode cur = head;
            while (cur.next != toBeDelete){
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = deleteNode(head, head.next.next);
        System.out.println(listNode);
    }
}
