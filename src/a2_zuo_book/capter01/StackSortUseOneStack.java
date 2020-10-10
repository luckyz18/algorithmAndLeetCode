package a2_zuo_book.capter01;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈顶的排序
 */
public class StackSortUseOneStack {
    public static Stack<Integer> sort(Stack stack) {
        Stack<Integer> help = new Stack();
        if (stack.isEmpty()) {
            return stack;
        }

        while (!stack.isEmpty()){
            int current = (int) stack.pop();
            addWithSorted(current,help);
        }
        return help;

    }

    public static void addWithSorted(int value, Stack<Integer> help) {
        if (help.isEmpty()) {
            help.push(value);
            return;
        } else {
            if (help.peek() < value) {
                help.push(value);
                return;
            }
            int result = help.pop();
            addWithSorted(value, help);
            help.push(result);
        }
    }

    public static void main(String[] args) {
        Stack a = new Stack();
        a.push(7);
        a.push(4);
        a.push(9);
        a.push(5);
        sort(a);
    }

}
