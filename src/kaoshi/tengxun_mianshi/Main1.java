package kaoshi.tengxun_mianshi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new LinkedList();
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            queue.clear();
            int Q = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Q; i++) {
                String cz = scanner.nextLine();
                String[] split = cz.split(" ");
                if (split[0].startsWith("PUSH")) {
                    int num = Integer.parseInt(split[1]);
                    queue.add(num);
                } else if (split[0].startsWith("TOP")) {   //取出对首
                    if (queue.size() > 0) {
                        System.out.println(queue.peekFirst());
                    } else {
                        System.out.println("-1");
                    }
                } else if (split[0].startsWith("POP")) {  //删除队首
                    if (queue.size() > 0) {
                        queue.removeFirst();
                    }else{
                        System.out.println(-1);
                    }

                } else if (split[0].startsWith("SIZE")) {
                    System.out.println(queue.size());
                } else if (split[0].startsWith("CLEAR")) {
                    queue.clear();
                }
            }
        }
    }
}
