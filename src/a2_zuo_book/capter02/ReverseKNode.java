package a2_zuo_book.capter02;

import java.util.Stack;

/**
 * 将单链表的没K个节点之间逆序
 */
public class ReverseKNode {
    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverseKNode(Node head, int k){
        if (k < 2){
            return head;
        }
        Node cur=head;
        Node pre = null;
        Node next;
        Node newHead = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null){
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k){
                pre= regionStack(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private static Node regionStack(Stack<Node> stack, Node pre, Node next) {
        Node cur = stack.pop();
        if (pre!=null){
            pre.next = cur;
        }
        Node p;
        while (!stack.isEmpty()){
            p = stack.pop();
            cur.next  =p;
            cur = p;
        }
        // next 的目的是 对于那些最后长度小于k的 没反转 连起来
        cur.next = next;
        //尾节点
        return cur;
    }

    /**
     * 不借助栈 在元链表中直接调整
     */
    public static Node reversekNode2(Node head, int k){
        if (k < 2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        Node newHead = head;
        while (cur != null){
            next = cur.next;
            if (count == k){
                start = pre == null ? head : pre.next;
                resign2(pre,start,cur,next);
                //要返回的头结点
                newHead = pre == null ? cur : newHead;

                pre = start;
                count = 0;
            }
            cur = next;
            count++;
        }
        return newHead;
    }

    private static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = pre.next;
        Node next = null;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = right;
        if (left != null){
            left.next = end;
        }
    }

    public static void main(String[] args) {
        Node head= new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        head.next.next.next.next.next= new Node(6);
        head.next.next.next.next.next.next= new Node(7);
        head.next.next.next.next.next.next.next= new Node(8);
        //Node node = reverseKNode(head, 3);
        Node node = reversekNode2(head,3);
        System.out.println(node);
    }


}
