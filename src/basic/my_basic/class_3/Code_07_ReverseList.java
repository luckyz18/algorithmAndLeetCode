package basic.my_basic.class_3;

public class Code_07_ReverseList {
	public static class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			super();
			this.value = value;
		}
	}
	
	/*反转单向链表*/
	public static Node reverseList(Node head) {
		Node next = null;
		Node pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static class DoubleNode{
		private int value;
		private DoubleNode next;
		private DoubleNode last;
		public DoubleNode(int value) {
			super();
			this.value = value;
		}
	}
	
	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode next = null;
		DoubleNode pre = null;
		while (head != null) {
			next =head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void printLinkedList(Node head) {
		System.out.println("单链表：");
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.println("双向单链表：");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.println("|");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));

	}

}
