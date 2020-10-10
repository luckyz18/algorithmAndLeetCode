package a3_jianzhi_offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class code_09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        dao(stack1,stack2);
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }
    public void dao(Stack stack1,Stack stack2){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
}
