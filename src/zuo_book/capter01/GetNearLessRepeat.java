package zuo_book.capter01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构模板
 * 数组中有重复元素
 */
public class GetNearLessRepeat {
    public int[][] getNearLessRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack();
        int leftIndex;
        int rightIndex;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> popList = stack.pop();
                leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                rightIndex = i;
                for (int popIndex : popList) {
                    res[popIndex][0] = leftIndex;
                    res[popIndex][1] = rightIndex;
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                List<Integer> peekList = stack.peek();
                peekList.add(i);
            } else {
                List<Integer> arrList = new ArrayList();
                arrList.add(i);
                stack.push(arrList);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> popList = stack.pop();
            leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (int popIndex : popList) {
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = -1;
            }
        }
        return res;
    }
}
