package mianshi.tengxun_mianshi;

import java.util.Scanner;

//翻转数列
public class ReverseShulie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        /*long sum = 0;
        int count = 0;
        boolean isF= true;
        for (int i = 1; i <= m; i++) {
            if (count < n && isF) {
                sum += (-i);
                count++;
                if (count == n){
                    isF = !isF;
                    count = 0;
                }
            } else {
                sum += i;
                count++;
                if (count == n){
                    isF = !isF;
                    count = 0;
                }
            }
        }
        System.out.println(sum);*/
        //2.
        long a = n/(2*m);
        long sum = a * m * m;
        System.out.println(sum );
    }
}
