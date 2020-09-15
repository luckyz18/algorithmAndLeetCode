package kaoshi.dxm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;
        //List<Integer> list = new ArrayList<>();
        int[] poll = new int[(n-a+1)*(m-b+1)];
        Arrays.fill(poll,-1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = i * j % 10;
                for (int k = Math.max(i - a, 0); k <= Math.min(i - 1, n - a); k++) {
                    for (int l = Math.max(j - b, 0); l <= Math.min(j - 1, m - b); l++) {
                        int index = k * (m - b + 1) + l;
                        //list.set(index, Math.max(list.get(index), temp));
                        poll[index] = Math.max(poll[index],temp);
                    }
                }
            }
        }
        for (int i = 0; i < poll.length; i++) {
            sum += poll[i];
        }

        System.out.println(sum);
    }
}

