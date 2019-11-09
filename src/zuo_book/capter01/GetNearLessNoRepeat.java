package zuo_book.capter01;

import java.util.Stack;

/**
 * 单调栈结构模板
 * 数组中没有重复元素
 */
public class GetNearLessNoRepeat {
    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack();
        int leftIndex;
        int rightIndex;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer popIndex = stack.pop();
                leftIndex = stack.isEmpty() ? -1 : stack.peek();
                rightIndex = i;
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = rightIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer popIndex = stack.pop();
            leftIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nearLess = getNearLess(new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2});

    }
}
