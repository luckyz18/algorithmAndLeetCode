package jianzhi_offer;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * 使用一个栈来模拟压入弹出操作。
 */
public class num_31 {
    Stack<Integer> stack = new Stack();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA== null || popA== null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int len = pushA.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex< len; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty() && popIndex < len && stack.peek() == popA[popIndex] ){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new num_31().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        System.out.println(b);
    }

}
