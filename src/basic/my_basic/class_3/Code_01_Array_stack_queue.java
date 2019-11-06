package basic.my_basic.class_3;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class Code_01_Array_stack_queue {
	
	public static class ArrayStack{
		private Integer[] arr;
		private Integer size;  //表示栈顶位置
		
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size=0;
			
		}
		
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size-1];
			
		}
		public void push(int num) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("the stack is full");
			}
			arr[size++] = num;
		}
		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("the stack is empty");
			}
			size--;
			return arr[size];
		}
	
}

	public static class ArrayQueue{
		private Integer[] arr;
		private int size;
		private int first;
		private int last;
		
		public ArrayQueue(int initSize) {
			if (initSize < 0 ) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size=0;
			first=0;
			last=0;
		}
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("the queue is full");
			}
			size++;
			arr[last] = obj;
			last = (last == arr.length-1) ? 0 : last++;
		}
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("the queue is empty");
			}
			size--;
			int res = first;
			first = (first == arr.length-1)? 0 : first++;
			return arr[res];
		}
		
	}
	
	public static void main(String[] args) {
		
		
	}
		
	
}
