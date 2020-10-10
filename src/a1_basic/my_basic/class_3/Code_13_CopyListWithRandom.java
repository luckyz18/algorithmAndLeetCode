package a1_basic.my_basic.class_3;

import java.util.HashMap;
import java.util.Map;

public class Code_13_CopyListWithRandom {
	public static class Node {
		public int value;
		public Node next;
		public Node random;

		public Node(int value) {
			this.value = value;
		}
	}

	// 哈希表实现深度拷贝
	public static Node CopyListWithRandom(Node head) {
		if (head == null) {
			return null;
		}
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}

		return map.get(head);
	}

	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.random == null ? "- " : cur.random.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 1->拷贝1->2->拷贝2->3->拷贝3->null
	public static Node CopyListWithRandom2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;
		// 拷贝节点
		while (cur != null) {
			next = cur.next;
			Node curCopy = new Node(cur.value);
			cur.next = curCopy;
			curCopy.next = next;
			cur = next;
		}

		// random节点
		Node copy = null;
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			copy.random = cur.random == null? null:cur.random.next;
			cur = next;
		}

		// next节点
		cur = head;
		Node res = head.next;
		copy = null;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy.next = next == null ? null : next.next;
			cur = next;
		}

		return res;
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
//		printRandLinkedList(head);
//		res1 = CopyListWithRandom(head);
//		printRandLinkedList(res1);
//		res2 = CopyListWithRandom(head);
//		printRandLinkedList(res2);
//		printRandLinkedList(head);
//		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.random = head.next.next.next.next.next; // 1 -> 6
		head.next.random = head.next.next.next.next.next; // 2 -> 6
		head.next.next.random = head.next.next.next.next; // 3 -> 5
		head.next.next.next.random = head.next.next; // 4 -> 3
		head.next.next.next.next.random = null; // 5 -> null
		head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = CopyListWithRandom(head);
		printRandLinkedList(res1);
		System.out.println("=========================");

		res2 = CopyListWithRandom2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);

	}
}
