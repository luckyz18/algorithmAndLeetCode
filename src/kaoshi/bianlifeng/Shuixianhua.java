package kaoshi.bianlifeng;

import java.util.Scanner;

public class Shuixianhua {
    public static void main(String[] args) {
        int n,m;
        int count=0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            n = scanner.nextInt();
            m = scanner.nextInt();
            count = 0;
            for (int i = n; i <=m ; i++) {
                int a = i%10;
                int b = (i/10)%10;
                int c = ((i/10)/10)%10;
                int d = (int) ((Math.pow(a,3) + Math.pow(b,3)+Math.pow(c,3)));
                if (d == i){
                    count++;
                    System.out.print(i+" ");
                }
            }
            if (count ==0){
                System.out.println("no");
            }else {
                System.out.println();
            }
        }
    }
}
