package mianshi.ali;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] arr = new int[m];
            Arrays.fill(arr, a);
            if (n == 0) {
                System.out.println(0);
                continue;
            } else {
                for (int i = 0; i <n ; i++) {
                    int everyCount = b;
                    for (int j = 0; j <m ; j++) {
                        if (arr[i] == 0){
                            continue;
                        }else{
                            arr[i]--;
                            everyCount--;
                            if (everyCount == 0){
                                break;
                            }
                        }
                    }
                }
            }
            int ret = getKillNums(arr);
            System.out.println(ret);
        }
    }

    private static int getKillNums(int[] arr) {
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == 0){
                count++;
            }
        }
        return count;
    }
}
