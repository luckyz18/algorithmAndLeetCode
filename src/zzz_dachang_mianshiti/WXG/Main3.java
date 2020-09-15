package zzz_dachang_mianshiti.WXG;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N  = scanner.nextInt();
        int K  = scanner.nextInt();
        Map<String,Integer> map = new HashMap<>();
        String str = null;
        for (int i = 0; i < N; i++) {
            str= scanner.next();
            if (map.containsKey(str)){
                map.put(str,map.get(str) +1);
            }else{
                map.put(str,1);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o2.getValue() == o1.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        for (int i = 0; i < K ; i++) {
            System.out.println(list.get(i).getKey() +  " " + list.get(i).getValue());
        }
        Collections.sort(list, (o1, o2) -> {
            if (o2.getValue() == o1.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        });
        for (int i = 0; i < K ; i++) {
            System.out.println(list.get(i).getKey() +  " " + list.get(i).getValue());
        }


    }
}

