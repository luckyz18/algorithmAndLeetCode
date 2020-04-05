package kaoshi.qianxin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String,Boolean> map = new HashMap<>();
    private static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] price = new int[] {1,2,2,5,2,3};
        int[] num = new int[] {5,3,3,4,2,1};
        goLoop(num,price,N,0,0);
        System.out.println(res);
       /* map.put("A",false);
        map.put("B",false);
        map.put("C",false);
        map.put("D",false);
        map.put("E",false);
        map.put("F",false);

        int ret =  0;

        while(N > 2 ){
            if (N >= 1 && map.get("D") == false ){
                ret += 5;
                N = N-1;
                map.put("D",true);
                continue;
            }
            if (N >=2  && map.get("B") == false ){
                ret += 3;
                N= N-2;
                map.put("B",true);
                continue;
            }
            if (N >=2 && map.get("F") == false ){
                ret += 3;
                N= N-2;
                map.put("F",true);
                continue;
            }
            if (N >= 5 && map.get("E") == false ){
                ret += 4;
                N = N-4;
                map.put("E",true);
                continue;
            }
            if (N >= 2 && map.get("A") == false ){
                ret += 2;
                N= N-2;
                map.put("A",true);
                continue;
            }
            if (N >= 3 && map.get("C") == false ){
                ret += 1;
                N = N -3;
                map.put("C",true);
                continue;
            }
        }*/
        //System.out.println(ret);
    }
    private static void goLoop(int[] num, int[] price, int sum, int start, int cur) {
        if(start >= num.length){
            res = Math.max(cur,res);
            return;
        }
        for (int i = start; i <num.length ; i++) {
            if (price[i]<=sum ){
                goLoop(num,price,sum - price[i],i+1,cur +num[i]);
            }
            goLoop(num,price,sum,i+1,cur);
        }
    }


}
