package mianshiti.yuanfudao;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N  = scanner.nextInt();
        int M = scanner.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N ; i++) {
            list.add(scanner.nextInt());
        }
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        int half = N / 2;
        int leave = N - half;
        for (int i = 0; i <N ; i++) {
            if (i < half){
                left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }

        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < half ; j++) {
                list.set(2 * j, right.get(j));
                list.set(2 * j +1 , left.get(j));
            }
            if (leave > half){
                list.set(2 * half, right.get(half));
            }
            int cnt = half;
            left = list.subList(0,cnt);
            right = list.subList(cnt,list.size());

            for (int j = 0; j < N ; j++) {
                System.out.println(list.get(j));
            }
        }

        for (int i = 0; i < N  ; i++) {
            System.out.print(list.get(i) + " ");
        }
        //int half = N / 2;
        //int p= 0;
        //int q = half;
        //int index = 0;
        //int time = 1;
        //for (int i = 0; i < N ; i++) {
        //    if (time % 2 == 0){
        //        list.set();
        //    }else{
        //        list.set(p++,);
        //    }
        //}

    }


}
