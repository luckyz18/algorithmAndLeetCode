package mianshi.ali;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long ret = 0;
            long all = b*n;
            ret = all /a;
            if (ret > m){
                ret = m;
            }
            System.out.println(ret);

        }
    }
}
