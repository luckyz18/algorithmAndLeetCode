package kaoshi.mt;

import java.util.*;

public class Main22 {
    public static void main(String[] args) {
        double P = 3.1415926;
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        //int n = scanner.nextInt();
        String tt =  scanner.nextLine();
        int n = Integer.parseInt(tt);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i <split.length ; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        Collections.sort(list);
        //int cnt = n-1;
        double ret = 0;
        for(int i = n-1; i >= 0; i--){
            Integer num = list.get(i);
            double o = P * Math.pow(num, 2);
            double k = 0.0;
            if (i >0  ){
                Integer l = list.get(i - 1);
                k = P * l * l;
            }
            ret = ret + o -k;
            i--;
        }
        System.out.println(String.format("%.5f",ret));
    }
}
