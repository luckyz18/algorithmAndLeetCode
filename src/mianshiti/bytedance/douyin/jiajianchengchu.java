package mianshiti.bytedance.douyin;

import java.util.Stack;

/**
 * 四则运算  实现字符串的加减乘除算法
 */
public class jiajianchengchu {
    public static int calculate(String s) {
        s = s.trim();
        return core(s.toCharArray());
    }
    private static int i = 0;
    private static int core(char[] chs){
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        for (; i < chs.length; i++) {
            if(chs[i]==' '){
                continue;
            }
            if (Character.isDigit(chs[i])) {
                num = num * 10 + (chs[i] - '0');
            }
            //碰到下一个符号  判断之前的符号是+-*/ 跟前面的num 组合到一起； i是最后一位的时候  也会跟之前的符号参与运算
            if (!Character.isDigit(chs[i]) || i >= chs.length - 1) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    int a = stack.pop();
                    stack.push(a * num);
                } else if (operation == '/') {
                    int a = stack.pop();
                    stack.push(a / num);
                }
                if(i>=chs.length-1){
                    break;
                }
                operation = chs[i];
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        int calculate = calculate("-13-2/2");
        System.out.println(calculate);
    }

}

