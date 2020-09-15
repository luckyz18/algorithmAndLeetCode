package zzz_dachang_mianshiti.WXG;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            int tmp = scanner.nextInt();
            list1.add(tmp);
            list2.add(tmp);
        }
        Collections.sort(list1);
        for (int i = 0; i < n; i++) {
            if (list2.get(i) > list1.get(n / 2 - 1)) {
                System.out.println(list1.get(n / 2 - 1));
            } else if (list2.get(i) < list1.get(n / 2)) {
                System.out.println(list1.get(n / 2));
            }
        }
    }
}
