package basic.my_basic.class_4;

public class Code_08_CBTNode {
	// 完全二叉树的节点个数 复杂度低于O(N)

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		};
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	public static int bs(Node node, int level, int h) {
		if (level == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {  //左子树是一颗完全二叉树
//			System.out.println("递归中右 = h --："+(1 << (h - level) + bs(node.right, level + 1, h)));
			return (1 << (h - level)) + bs(node.right, level + 1, h);
			
		} else {   //右子树是一科完全二叉树
//			System.out.println("递归中右 != h："+(1 << (h - level - 1) + bs(node.left, level + 1, h)));
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}
	//树的高度
	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}
	
	//打印二叉树
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));
		
//		printTree(head);

	}
}
