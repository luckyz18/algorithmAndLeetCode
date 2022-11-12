package book_2.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈
 * 获取左右两边离得最近的比他小（大）的元素
 */
public class GetNearLessNoRepeat {

    //不包含重复元素
    public static int[][] getNearLessNoRepeat(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                Integer x = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;
                res[x][0] = leftIndex;
                res[x][1] = rightIndex;
            }
            stack.push(i);
        }
        //此时栈内都是单调的，清退所有元素
        while (!stack.isEmpty()){
            Integer x = stack.pop();
            int leftIndex = stack.isEmpty()? -1 : stack.peek();
            int rightIndex = -1;
            res[x][0] = leftIndex;
            res[x][1] = rightIndex;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nearLessNoRepeat = getNearLessNoRepeat(new int[]{3, 4, 1, 5, 6, 2, 7});
        System.out.println(Arrays.deepToString(nearLessNoRepeat));

    }

}
