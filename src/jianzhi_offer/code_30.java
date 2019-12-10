package jianzhi_offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class code_30 {
    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            Integer peek = minStack.peek();
            minStack.push(Math.min(peek, node));
        }
    }

    public static void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public static int top() {
        return dataStack.peek();
    }

    public static int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {

        push(7);
        System.out.println(min());
        push(3);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(8);
        System.out.println(min());
        push(1);
        System.out.println(min());
        push(6);
        System.out.println(min());


    }
}
