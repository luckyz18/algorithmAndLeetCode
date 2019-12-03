package jianzhi_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class code_06 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //使用栈
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode phead = listNode;
        Stack<Integer> stack = new Stack<>();

        while (phead != null) {
            stack.push(phead.val);
            phead = phead.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //使用递归
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList list = new ArrayList();
        if (listNode != null) {
            list.addAll(printListFromTailToHead2(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ArrayList<Integer> integers = printListFromTailToHead2(head);
        System.out.println();
    }

}
