package mianshiti.qlbaidu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T  = scanner.nextInt();
        while (T-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            Map<Integer,Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < m ; i++) {
                int num = scanner.nextInt();
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                int count = 0;
                int mubiao = a[i];
                Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
                for(Map.Entry<Integer,Integer> entry : entries){
                    if (entry.getKey() >= mubiao){
                        count += entry.getValue();
                    }
                }
                result.add(count);
            }
           for(int i : result){
               System.out.print( i + " ");
           }
            System.out.println();
        }
    }
}
