package a1_basic.my_basic.class_3;

public class Code_14_FindFirstIntersectNode {
	public static class Node{
		int value;
		Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * 找到相交节点
	 * @return
	 */
	public static Node getIntersectNode(Node head1,Node head2) {
		if (head1 == null || head2==null) {
			return null;
		}
		//环节点
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		
		if (loop1 == null && loop2 == null) {
			return getNoLoop(head1,head2);
		}
		if (loop1!=null && loop2!=null) {
			return bothLoop(head1,loop1,head2,loop2);
		}
		return null;
		
	}
	
	//判断有没有环 如果有环 返回第一个入环节点
	//第1种：hashset实现 
	//第2种：一个快指针 一个慢指针 ； 如果相遇了， 快指针从头开始 每次一步走，首次相遇的节点就是第一个入环节点
	public static Node getLoopNode(Node head) {
		//2. 
		if (head == null || head.next == null || head.next.next == null ) {
			return null;
		}
		Node n1;  //slow
		Node n2;  //fast
		n1 = head.next;
		n2 = head.next.next;
		while(n1 != n2) {
			if (n2.next == null || n2.next.next == null ) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n2 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
		
		//1. 需要额外的哈希表做辅助空间
		/*HashSet<Object> set = new HashSet<>();
		Node n1 = head;  
		while (n1 != null) {
			if (set.contains(n1)) {
				return n1;
			}
			set.add(n1);
			n1 = n1.next;
		}
		return null;*/
	}
	
	//都没有环: 也可以借助hashset
	public static Node getNoLoop(Node head1, Node head2) {
		if (head1==null || head2 == null) {
			return null;
		}
		Node cur1 = head1;  //long list
		Node cur2 = head2;  //short  list
		int n=0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		} 
		cur1 = n>0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	//都有环: 也可以借助hashset
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2 ) {
			Node cur1 = head1;  //long
			Node cur2 = head2;  //short
			int n=0;
			while (cur1.next != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2.next != loop2) {
				n--;
				cur2 = cur2.next;
			}
			if (cur1 != cur2) {
				return null;
			} 
			cur1 = n>0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			
			n = Math.abs(n);
			while (n > 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else{
			Node n = loop1.next;
			while(n != loop1) {
				if (n == loop2) {
					return loop1;
				}
				n = n.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
//		head1.next = new Node(2);
//		head1.next.next = new Node(3);
//		head1.next.next.next = new Node(4);
//		head1.next.next.next.next = new Node(5);
//		head1.next.next.next.next.next = new Node(6);
//		head1.next.next.next.next.next.next = new Node(7);
//
//		// 0->9->8->6->7->null
		Node head2 = new Node(0);
//		head2.next = new Node(9);
//		head2.next.next = new Node(8);
//		head2.next.next.next = head1.next.next.next.next.next; // 8->6
//		System.out.println(getIntersectNode(head1, head2).value);
//
		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next.next = head1.next.next.next; // 7->4

//		// 0->9->8->2...
//		head2 = new Node(0);
//		head2.next = new Node(9);
//		head2.next.next = new Node(8);
//		head2.next.next.next = head1.next; // 8->2
//		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}
}
