package mianshiti.pdd;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int [] count = new int[N];
        Set<Integer> set  =new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <N ; i++) {
            count[i] = scanner.nextInt();
            set.add(count[i]);
            if (!map.containsKey(count[i])){
                map.put(count[i],i);
            }
            max = Math.max(max,count[i]);
        }
        int[] num = new int[max+1];
        for (int i = 0; i <count.length ; i++) {
            num[count[i]]++;
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i <count.length ; i++) {
            if (num[count[i]] + K >= (i-map.get(count[i]))){
                ret = Math.max(ret, num[count[i]]);
            }
        }
        System.out.println(ret);

    }
}
