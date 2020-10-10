package a1_basic.class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	/*利用栈结构实现队列结构*/
	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
			daoData();   //倒数据这个行为可以发生在任何位置  原则约束着
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} 
			daoData();
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} 
			daoData();
			return stackPop.peek();
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
	public static class TwoQueuesStack {
		public Queue<Integer> queue;
		public Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		}
		
		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;    
			help = queue;    //换引用
			queue = tmp;
		}

	}
	
	public static void main(String[] args) {
		//for test queue2stack
		TwoQueuesStack qstack = new TwoQueuesStack();
		qstack.push(1);
		qstack.push(2);
		qstack.push(3);
		
		while (!qstack.queue.isEmpty()) {
			System.out.println(qstack.pop());
		}	
		
	}

}
