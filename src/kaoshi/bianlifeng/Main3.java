package kaoshi.bianlifeng;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (i % 2 == 1) {
                list.add(tmp + 30);
            } else {
                list.add(tmp - 30);
            }
        }
        boolean[] f = new boolean[list.size()];
        for (int i = 1; i < list.size() - 1; i += 2) {
            if (f[i] == false && f[i + 1] == false) {
                Integer a = list.get(i);
                Integer b = list.get(i + 1);
                if (b - a > 0) {
                    f[i] = true;
                    f[i + 1] = true;
                }
            }
        }


    }
}
