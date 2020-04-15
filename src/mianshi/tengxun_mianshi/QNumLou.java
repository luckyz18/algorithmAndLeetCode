package mianshi.tengxun_mianshi;

import java.util.Scanner;
import java.util.Stack;

/**
 * 小Q能看到的楼的数量
 * 单调栈结构
 */
public class QNumLou {
    //public static void main(String[] args) {
    //
    //    Scanner sc = new Scanner(System.in);
    //    int len = sc.nextInt();
    //    int[] arr = new int[len];
    //    for(int i = 0 ; i < len ; i++){
    //        arr[i] = sc.nextInt();
    //    }
    //    // stack中要保存的是 能看见的楼的 index
    //    int[] rightLook = new int[len];
    //    Stack<Integer> stack = new Stack<>();
    //    for(int i = len - 1 ; i >= 0 ; i--){
    //        rightLook[i] = stack.size();
    //        while((!stack.isEmpty()) && (arr[i] >= arr[stack.peek()])){
    //            stack.pop();
    //        }
    //        stack.push(i);
    //    }
    //    stack.clear();
    //    for(int i = 0 ; i < len ; i++){
    //        int total = rightLook[i] + 1 + stack.size();
    //        while((!stack.isEmpty()) && (arr[i] >= arr[stack.peek()])){
    //            stack.pop();
    //        }
    //        System.out.print(total + " ");
    //        stack.push(i);
    //    }
    //}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] rightLook = new int[n];
        for (int i = array.length-1; i >=0 ; i--) {
            rightLook[i]= stack.size();
            //while (!stack.isEmpty() && array[stack.peek()] ){
            //
            //}
        }

    }
}
