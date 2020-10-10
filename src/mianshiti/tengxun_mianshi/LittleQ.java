package mianshiti.tengxun_mianshi;

import java.util.Scanner;

//二分查找的变形
public class LittleQ {
    //public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
    //    int N = scanner.nextInt();
    //    int M = scanner.nextInt();
    //    //long days = (long) (M * (Math.pow(2, N - 1) / (Math.pow(2, N) - 1)));
    //    int max = M - (N - 1);
    //    int pre;
    //    int sum;
    //    while (true) {
    //        pre = max;
    //        sum = max;
    //        for (int i = 1; i < N; i++) {
    //            pre = pre/2;
    //            sum += pre;
    //        }
    //        if (sum <=M) {
    //            break;
    //        }
    //        max--;
    //    }
    //    System.out.println(max);
    //}

    //2.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            if (N == 1) {
                System.out.println(M);
                return;
            }
            //二分
            int low = 1;
            int high = M - (N - 1);
            while (low < high) {
                int mid = (low + high +1 ) / 2;  //向上取整
                int totalEat = totalSum(mid, N);
                if (totalEat == M) {
                    System.out.println(mid);
                    return;
                } else if (totalEat < M) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(low);
        }
    }

    public static int totalSum(int firstEat, int days) {
        int sum = 0;
        for (int i = 0; i < days; i++) {
            sum += firstEat;
            firstEat = (firstEat + 1) >> 1;
        }
        return sum;
    }


}
