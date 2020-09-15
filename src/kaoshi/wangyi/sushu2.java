package kaoshi.wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class sushu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        List<Long> list = new LinkedList<>();

        while (N-- > 0){
            list.add(scanner.nextLong());
        }

        long count = 0;
        for (int i = 0; i <list.size() ; i++) {
            long a = list.get(i);
            if (a == 1 || a==0){
                continue;
            }
            count += (a/2);
        }
        System.out.println(count);
    }

}
