package basic.my_basic.class_3;

import java.util.Stack;

//是否是回文结构  121  1221，
public class Code_11_IsPalindromeList {
	public static class Node{
		int value;
		Node next;
		public Node(int value) {
			super();
			this.value = value;
		}
	}
	
	//need extra(n) space 栈辅助
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null && !stack.empty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		if (head==null) {
			System.out.println("head null");
		}
		return true;
	}
	
	//need n/2 extra space 栈辅助
	public static Boolean isPalindrome2(Node head) {
		Stack<Node> stack = new Stack<Node>();
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		if (cur.next!=null || cur.next.next !=null) {
			cur = cur.next.next;
			right = right.next;
		}
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while(!stack.empty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	//need O(1) extra space 反转半个链表
	public static Boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while (n2.next != null && n2.next.next!=null) {
			n1 = n1.next;  //mid
			n2 = n2.next.next; //last
		}
		n2 = n1.next;  //右边第一个节点
		n1.next = null;
		Node n3 = null;
		while (n2 != null) {   /*反转右半部分*/
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;  //n3->last node
		n2 = head;
		boolean res = true;
		while (n2 != null && n1 != null) {
			if (n2.value != n1.value) {
//				return false;   不能return  还要把链表反转回来
				res = false;
				break;
			}
			n2 = n2.next;
			n1 = n1.next;
		}
		
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
		
	}
	
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		Node head = null;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
//		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.print(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}
}
