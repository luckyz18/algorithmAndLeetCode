package kaoshi.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sushu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String s = scanner.nextLine();

        long N  = Long.parseLong(number);
        String[] split = s.split(" ");
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            list.add(Long.parseLong(split[i]));
        }
        Long count = Long.valueOf(0);
        for (int i = 0; i <list.size() ; i++) {
            Long a = list.get(i);
            if (a == 1 || a==0){
                continue;
            }
            count += (a/2);
        }
        System.out.println(count);
    }
}
