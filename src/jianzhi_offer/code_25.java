package jianzhi_offer;

/**
 * 合并两个排序的链表
 */
public class code_25 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode newHeadPre = new ListNode(-1);
        ListNode cur = newHeadPre;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return newHeadPre.next;
    }

    //递归
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val< list2.val){
            list1.next = Merge2(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge2(list1,list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(9);
        head2.next.next.next.next = new ListNode(10);

        ListNode merge = Merge2(head1, head2);
        System.out.println(merge.val);
    }

}
