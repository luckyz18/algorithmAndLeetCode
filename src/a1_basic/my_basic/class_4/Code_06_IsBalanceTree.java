package a1_basic.my_basic.class_4;

public class Code_06_IsBalanceTree {
	//判断一颗树是否是平衡二叉树
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class ReturnData{
		boolean isB;
		int h;
		public ReturnData(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	}
	public static boolean isBlanceTree(Node head) {
		return process(head).isB;
	}
	
	public static ReturnData process(Node head) {
		if (head == null) {
			return new ReturnData(true, 0);
		}
		ReturnData leftdata = process(head.left);
		if (!leftdata.isB) {
			return new ReturnData(false, 0);
		}
		ReturnData rightdata = process(head.right);
		if (!rightdata.isB) {
			return new ReturnData(false, 0);
		}
		if (Math.abs(leftdata.h - rightdata.h) > 1) {
			return new ReturnData(false, 0);
		}
		return new ReturnData(true, Math.max(leftdata.h, rightdata.h) + 1);
		
	}
	
	//for test
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
//		head.right.right = new Node(7);
		head.right.left.left = new Node(7);

		System.out.println(isBlanceTree(head));
	}
}
