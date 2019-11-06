package basic.my_basic.class_4;

import java.util.Stack;

public class Code_07_IsSBTAndCBT {
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
		}
	}

	/**判断是否是搜索二叉树
	 * 中序遍历 有序 
	 * @return
	 */
	public static Boolean isSBT(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			int pre = Integer.MIN_VALUE;
			while (!stack.isEmpty() || head!=null) {
				if (head!=null) {
					stack.add(head);
					head = head.left;
				}else {
					head = stack.pop();
//					System.out.print(head.value+" ");
					if (head.value < pre) {
						return false;
					}
					pre = head.value;
					head = head.right;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);

		System.out.println(isSBT(head));
	}
}
