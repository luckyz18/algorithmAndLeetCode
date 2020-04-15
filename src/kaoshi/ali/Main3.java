package kaoshi.ali;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long nb = n * b;
            long ma = m * a;

            if (nb >= ma){
                System.out.println(m);
            }else{
                long sh = (ma-nb) /a;
                long yu = (ma-nb) %a;
                long res = sh + (yu > 0? 1:0);
                System.out.println(res);
            }

        }
    }
}
