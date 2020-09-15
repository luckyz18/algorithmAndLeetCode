package kaoshi.jd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        if(!(T>=1 && T<=10)){
            return;
        }
        while(T-- > 0){
            boolean flag = true;
            int tmp =0;
            int[] l = new int[6];
            int[] r = new int[6];
            for (int i = 0; i < 6 ; i++) {
                l[i] = scanner.nextInt();
                r[i] = scanner.nextInt();
                if(l[i] < r[i]){
                    tmp = l[i];
                    l[i] = r[i];
                    r[i] = tmp;
                }
            }

            for (int i = 0; i <l.length; i++) {
                for (int j = 0; j < l.length-1 ; j++) {
                    if (l[j] < l[j+1]) {
                        tmp = l[j];
                        l[j] = l[j+1];
                        l[j+1] = tmp;
                        tmp = r[j];
                        r[j] = r[j+1];
                        r[j+1] = tmp;
                    }
                    if (l[j] == l[j+1] &&  r[j] < r[j+1]){
                        tmp = r[j];
                        r[j] = r[j+1];
                        r[j+1] = tmp;
                    }
                }
            }

            for (int i = 0; i < 5 ; i+=2) {
                if(l[i] != l[i+1] || r[i]!= r[i+1] ){
                    flag = false;
                }
            }
            if(l[0] != l[2] || r[0]!= l[4] || r[2]!= r[4]){
                flag = false;
            }
            if (flag){
                System.out.println("POSSIBLE");
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
