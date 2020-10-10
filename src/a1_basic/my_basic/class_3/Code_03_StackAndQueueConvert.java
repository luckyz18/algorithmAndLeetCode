package a1_basic.my_basic.class_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	/*利用栈结构实现队列结构*/
	public static class Stack2Queue{
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		
		public Stack2Queue() {
			this.stackPush = new Stack<Integer>();
			this.stackPop = new Stack<Integer>();
		}
		
		public void push(int num) {
			stackPush.push(num);
		}
		public int peek() {
			if (stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			daoData();
			return stackPop.peek();
		}
		public int poll() {
			if (stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			daoData();
			return stackPop.pop();
		}
		
		public void daoData() {
			if (!stackPop.isEmpty()) {  //原则1： 一定要pop栈 空 才可以倒数据
				return;
			}
			while (!stackPush.isEmpty()) {  //原则2：倒数据一定要倒完
				stackPop.push(stackPush.pop());
			}
		}
	}
	
	/*利用队列结构实现栈结构*/
	public static class Queue2Stack{
		public Queue<Integer> data;
		public Queue<Integer> help;
		
		public Queue2Stack() {
			data = new LinkedList<>();
			help = new LinkedList<>();
		}
		
		public void push(int num) {
			data.add(num);
		}
		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("stack is empty!");
			}
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			swap();
			return res;
		}
		

		public int poll() {
			if (data.isEmpty()) {
				throw new RuntimeException("stack is empty!");
			}
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}
		
		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}
		
	}
	
	public static void main(String[] args) {
		Queue2Stack qStack = new Queue2Stack();
		qStack.push(1);
		qStack.push(2);
		qStack.push(3);
		
		while (!qStack.data.isEmpty()) {
			System.out.println(qStack.poll());
		}	
		
		//stack2queue
		Stack2Queue squeue = new Stack2Queue();
		squeue.push(1);
		squeue.push(2);
		squeue.push(3);
		int res = squeue.poll();
		System.out.println(res);
		squeue.push(4);
		res = squeue.poll();
		System.out.println(res);
	}

}
	
