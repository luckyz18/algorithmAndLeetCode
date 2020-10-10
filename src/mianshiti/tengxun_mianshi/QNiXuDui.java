package mianshiti.tengxun_mianshi;

import java.util.Arrays;
import java.util.Scanner;

public class QNiXuDui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = (int) Math.pow(2, n);
        int[] arr = new int[count];
        int[] qi;
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        qi = new int[m];
        for (int i = 0; i < m; i++) {
            qi[i] = scanner.nextInt();
        }
        int tmp = 0;
        while (m-- > 0){
            int reverse = (int) Math.pow(2,qi[tmp]);
            reverseNValueInArray(arr,reverse);
            int ret =getReverseCount2(arr);
            System.out.println(ret);
            tmp++;
        }
    }

    public static void reverseNValueInArray(int[] arr, int n) {
        for (int i = 0; i < arr.length; i += n) {
            int low = i;
            int high = (low + n-1) < arr.length ? low + n-1 : arr.length - 1;
            while (low < high) {
                swap(arr, low++, high--);
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    //一个数组中的逆序对
    public static int getReverseCount(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        //归并的过程中 查逆序对 不改变原数组
        int[] b = Arrays.copyOf(arr, arr.length);
        return mergeSort(b, 0, b.length - 1);
    }
    public static int getReverseCount2(int[] arr) {
        int res = 0;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i] > arr[i]){
                    res++;
                }
            }
        }
        return res;
    }

    private static int mergeSort(int[] b, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeSort(b, 0, mid) + mergeSort(b, mid + 1, right) + merge(b, left, mid, right);
    }

    private static int merge(int[] b, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p = left;
        int q = mid + 1;
        int index = 0;
        int res = 0;
        while (p <= mid && q <= right) {
            if (b[p] > b[q]) {
                //产生了逆序对
                res += (mid - p + 1);
                help[index++] = b[q++];
            }else{
                help[index++] = b[p++];
            }
        }
        while (p <= mid) {
            help[index++] = b[p++];
        }
        while (q <= right) {
            help[index++] = b[q++];
        }
        for (int i = 0; i <help.length ; i++) {
            b[left+i] = help[i];
        }
        return res;
    }

    //public static void main(String[] args) {
    //    int[] arr = new int[] {1,2,3,4};
    //    int reverseCount = getReverseCount(arr);
    //    System.out.println(reverseCount);
    //}
}
