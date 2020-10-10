package mianshiti.pdd;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] a = new int[N];
        //if (!(N >= 1 && N <= 100000) || !(M >= 1 && M <= 100)) {
        //    System.out.println(0);
        //    return;
        //}
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(scanner.next());
        }
        int ret = subArrayDivByK(a, M);
        System.out.println(ret);

    }

    public static int subArrayDivByK(int[] a, int k) {
        int result = 0;
        int len = a.length;
        a[0] %= k;
        //int[] p = new int[len + 1];
        for (int i = 1; i < len; i++) {
            a[i] = (a[i] + a[i-1]) % k;
        }
        int[] cnt = new int[k];
        cnt[0]++;
        for (int tmp : a) {
            cnt[(tmp % k + k) % k]++;
        }

        for (int j : cnt) {
            result += j * (j - 1) / 2;
        }
        return result;
    }
}
