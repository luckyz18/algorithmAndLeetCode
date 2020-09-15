package kaoshi.tengxun_mianshi;

import java.util.Scanner;
import java.util.Stack;

public class Main22 {

    public static void main(String[] args) {
        Stack<Long> stackData = new Stack<>();
        Stack<Long> stackHelp = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (s.startsWith("add")) {
                stackData.push(Long.parseLong(split[1]));
            }else if (s.startsWith("peek")){
                dao(stackData,stackHelp);
                Long peek = stackHelp.peek();
                System.out.println(peek);
            } else if (s.startsWith("poll")){
                dao(stackData,stackHelp);
                if (!stackHelp.isEmpty()) {
                    stackHelp.pop();
                }
            }
        }
    }

    public static void  dao(Stack<Long> stackData, Stack<Long> stackHelp){
        if (!stackData.isEmpty() && stackHelp.isEmpty()){
            while (!stackData.isEmpty()){
                stackHelp.push(stackData.pop());
            }
        }
    }
}
