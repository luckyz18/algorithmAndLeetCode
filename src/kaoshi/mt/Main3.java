package kaoshi.mt;

import java.util.*;

public class Main3{
    public static void main(String[] args) {
        int n,p,q;
        List<Integer> list = new ArrayList<>();
        int m;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        n = Integer.parseInt(split[0]);
        p = Integer.parseInt(split[1]);
        q = Integer.parseInt(split[2]);
        long sum = 0;
        for (int i = 0; i <n ; i++) {
            m = scanner.nextInt();
            list.add(m);
            sum+= m;

        }
        long fenzi = sum * p;
        long ret = mostCommon(fenzi,q);
        long res1 = fenzi / ret;
        long ret2 = q / ret;
        long g = res1 * ret2 % 998244351;
        System.out.println(g);

    }

    private static long mostCommon(long a, int b) {
        int t;
        while (b!= 0){
            t = (int) (a%b);
            a = b;
            b = t;
        }
        return a;
    }

}
