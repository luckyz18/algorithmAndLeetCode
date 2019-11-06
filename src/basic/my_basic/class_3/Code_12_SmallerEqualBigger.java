package basic.my_basic.class_3;

public class Code_12_SmallerEqualBigger {
	public static class Node{
		int value;
		Node next;
		public Node(int value) {
			super();
			this.value = value;
		}
	}
	//1. 如果考虑用荷兰国旗，它的辅助空间是数组,三向快排
	public static Node listPartition1(Node head,int num) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i=0;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		int[] arr = new int[i];
		cur = head;
		i = 0;
		while (cur != null) {
			arr[i++] = cur.value;
			cur = cur.next;
		}
		//调整在数组中的顺序
		partition(arr,0,arr.length-1,num);
		cur = head;
		for (int j = 0; j < arr.length; j++) {
			cur.value = arr[j];
			cur = cur.next;
		}
		return head;
	}
	public static void partition(int[] arr,int l, int r, int num) {
		int less= l-1;
		int more = r+1;
		while (l < more) {
			if (arr[l] < num) {
				swap(arr, l++, ++less);
			}else if (arr[l] > num) {
				swap(arr, l, --more);
			}else {
				l++;
			}
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;		
	}
	
	//2. 分成 > = < 三个链表 ，再串起来
	public static Node listPartition2(Node head,int num) {
		Node lessH = null;
		Node lessT = null;
		Node moreH = null;
		Node moreT = null;
		Node equalH = null;
		Node equalT = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if (head.value < num) {
				if (lessH == null) {
					lessH = head;
					lessT = head;
				}else {
					lessT.next = head;
					lessT = head;
				}
			} 
			if (head.value == num) {
				if (equalH == null) {
					equalH = head;
					equalT = head;
				}else {
					equalT.next = head;
					equalT = head;
				}
			}
			if (head.value > num) {
				if (moreH == null) {
					moreH = head;
					moreT = head;
				}else {
					moreT.next = head;
					moreT = head;
				}
			}
			head = next;
		}
		// merge three part 
		if (lessT != null) {
			lessT.next = equalH;
			equalT = equalT == null ? lessT : equalT;
		}
		if (equalT != null) {
			equalT.next = moreH;
		}
		if (lessH != null) {
			return lessH;
		}
		if (equalH != null) {
			return equalH;
		}
		if (moreH != null) {
			return moreH;
		}
		return null;
	}
	
	
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
//		cur = head;
//		System.out.print("rand:  ");
//		while (cur != null) {
//			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
//			cur = cur.next;
//		}
//		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);
		printRandLinkedList(head);
//		System.out.println("==============");
//		copyListWithRand1(head,3);
//		printRandLinkedList(head);
		System.out.println("===============");
		head =listPartition2(head, 3);
		printRandLinkedList(head);
	}

}
