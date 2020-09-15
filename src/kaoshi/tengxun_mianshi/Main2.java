package kaoshi.tengxun_mianshi;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    static Stack<Integer> stackData = new Stack<>();
    static Stack<Integer> stackHelp = new Stack<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (s.startsWith("add")) {
                stackData.push(Integer.parseInt(split[1]));
            }else if (s.startsWith("peek")){
                dao();
                Integer peek = stackHelp.peek();
                System.out.println(peek);
            } else if (s.startsWith("poll")){
                dao();
                stackHelp.pop();
            }
        }
    }

    public static void  dao(){
        if (!stackData.isEmpty() && stackHelp.isEmpty()){
            while (!stackData.isEmpty()){
                stackHelp.push(stackData.pop());
            }
        }
    }


}
