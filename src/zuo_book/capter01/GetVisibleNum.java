package zuo_book.capter01;

import java.util.Stack;

/**
 * 可见山峰的数量
 * 当数组中存在重复的变量
 */
public class GetVisibleNum {


    static class Record {
        int value;
        int time;

        public Record(int value) {
            this.value = value;
            this.time = 1;
        }
    }

    public static int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            maxIndex = arr[maxIndex] > arr[i] ? maxIndex : i;
        }
        int res = 0;
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex]));
        int stackSize = arr.length;
        int index = getNextIndex(maxIndex, stackSize);
        while (index != maxIndex) {
            // 如果不满足单调栈的性质  就弹出栈
            while (arr[index] > stack.peek().value) {
                Record pop = stack.pop();
                int popTime = pop.time;
                res += 2 * popTime + getInternelTime(popTime);
            }
            //入栈
            if (arr[index] == stack.peek().value) {
                stack.peek().time++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = getNextIndex(index, stackSize);
        }

        //清算栈中剩余
        while (stack.size() > 2) {
            Record pop = stack.pop();
            int popTime = pop.time;
            res += 2 * popTime + getInternelTime(popTime);
        }
        if (stack.size() == 2) {
            Record pop = stack.pop();
            int popTime = pop.time;
            int tmp = stack.peek().time == 1 ? 1 : 2;
            res += getInternelTime(popTime) + popTime * tmp;
        }
        int time = stack.pop().time;
        if (time > 1) {
            res += getInternelTime(time);
        }
        return res;
    }

    private static int getInternelTime(int k) {
        return k == 1 ? 0 : k * (k - 1) / 2;
    }

    private static int getNextIndex(int index, int length) {
        return index < length - 1 ? index + 1 : 0;
    }

    public static void main(String[] args) {
        int visibleNum = getVisibleNum(new int[]{5, 4, 3, 5, 4, 2, 4, 4, 5, 3, 2});
        System.out.println(visibleNum);
    }
}
