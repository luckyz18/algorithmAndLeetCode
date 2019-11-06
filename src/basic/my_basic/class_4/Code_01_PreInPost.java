package basic.my_basic.class_4;

import java.util.Stack;

public class Code_01_PreInPost {
	// 先序 中序 后序遍历二叉树
	//递归 和非递归
	public static class Node {
		int value;
		Node parent;
		Node left;
		Node right;
		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void postOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		postOrderRecur(head.left);
		postOrderRecur(head.right);
		System.out.print(head.value + " ");
	}
	//中左右
	public static void preOrderUnRecur(Node head) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(head);
		while (!stack.isEmpty()) {
			head = stack.pop();
			System.out.print(head.value+" ");
			if (head.right!=null) {
				stack.add(head.right);
			}
			if (head.left!=null) {
				stack.add(head.left);
			}
		}
	}
	//左中右
	public static void inOrderUnRecur(Node head) {
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head!=null) {
			if (head != null) {
				stack.add(head);
				head = head.left;
			}else {
				head = stack.pop();
				System.out.print(head.value+" ");
				head = head.right;
			}
		}
	}
	//左右中  在先序 中左右 的基础上，改成中右左，然后不输出而是放到另一个栈中
	public static void postOrderUnRecur(Node head) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.add(head);
		while (!stack1.isEmpty()) {
			head = stack1.pop();
//			System.out.print(head.value+" ");
			stack2.add(head);
			if (head.left!=null) {
				stack1.add(head.left);
			}
			if (head.right!=null) {
				stack1.add(head.right);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().value+" ");
		}
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		postOrderRecur(head);
		System.out.println();
		System.out.println("==============unrecursive==============");
		System.out.print("pre-order: ");
		preOrderUnRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderUnRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		postOrderUnRecur(head);
		

	}

}
