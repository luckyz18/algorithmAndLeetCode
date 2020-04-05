package kaoshi.qianxin;

import java.util.Scanner;

public class Main2 {
    static  int res=  0;
    public static void main(String[] args) {
        int[] num = new int[9];
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        for (int i = 0; i <split.length ; i++) {
            num[i] = Integer.parseInt(split[i]);
        }
        /*for (int i = 0; i <9 ; i++) {
            num[i] = scanner.nextInt();
        }*/
        int s1 = num[0] + num[1]+ num[2]+ num[3];
        int s2 = num[3] + num[4]+ num[5]+ num[6];
        int s3 = num[6] + num[7]+ num[8]+ num[0];
        if (s1 == s2 && s2 == s3){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
