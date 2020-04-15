package mianshi.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N<=0){
            System.out.println(0);
            return;
        }
        Integer[] cost = new Integer[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(cost, (Comparator<Object>) (o1, o2) -> (Integer) o2 - (Integer) o1);
        int sum = 0;
        int count = 1;
        for (int i = 0; i < cost.length; i++) {
            if (count % 3 == 0) {
                count = 1;
                continue;
            } else {
                sum += cost[i];
                count++;
            }
        }
        System.out.println(sum);
    }
}
