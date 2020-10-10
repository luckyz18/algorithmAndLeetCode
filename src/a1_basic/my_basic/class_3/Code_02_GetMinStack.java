package a1_basic.my_basic.class_3;

import java.util.Stack;

public class Code_02_GetMinStack {
	Stack<Integer> stackData = new Stack<Integer>();
	Stack<Integer> stackMin = new Stack<Integer>();
	
	public void push(int pushInt) {
		if (stackMin.empty()) {
			stackMin.push(pushInt);
		}else if (pushInt < stackMin.peek()) {
			stackMin.push(pushInt);
		}else {
			stackMin.push(stackMin.peek());
		}
		stackData.push(pushInt);
	}
	
	public int pop() {
		if (stackData.empty()) {
			throw new RuntimeException("stack is empty!");
		}
		stackMin.pop();
		return stackData.pop();
	}
	
	public int getMin() {
		if (stackData.empty()) {
			throw new RuntimeException("stack is empty!");
		}
		return stackMin.peek();
	}
	
	public static void main(String[] args) {
		Code_02_GetMinStack s = new Code_02_GetMinStack();
		s.push(6);
		s.push(5);
		s.push(2);
		
		int res = s.getMin();
		System.out.println(res);
		
		s.push(7);
		
		res =  s.getMin();
		System.out.println(res);
		
		s.pop();
		s.pop();
		
		res =  s.getMin();
		System.out.println(res);
	}
	
}
