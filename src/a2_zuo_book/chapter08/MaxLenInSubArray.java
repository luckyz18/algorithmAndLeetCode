package a2_zuo_book.chapter08;

import java.util.HashMap;
import java.util.Map;

/**
 * 在未排序数组中累加和为给定值的最长子数组长度
 */
public class MaxLenInSubArray {
    /**
     * 数组为正数数组
     * 可以做到时间复杂度是 O(N) 空间O(1)
     */
    public static int getMaxLen(int[] arr, int k) {
        if (arr == null || arr.length <= 0 || k < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }


    /**
     * 数组为正负都有
     * 核心： sum(i) - sum(j) == k,那么 j+1 ~ i 之间的和就是sum
     */
    public static int getMaxLen2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);  // ！！！
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            //只有第一次的 才放入map,这样能最长
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;

    }

    /**
     * 补充问题 1. 无序数组arr, 可正 可负 可0， 求arr 的所有子数组中 正数与负数个数相等 的最长子数组长度
     */
    public static int getMaxLen4PositiveAndNegativeNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //正数变成1   负数变成-1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = 1;
            } else if (arr[i] < 0) {
                arr[i] = -1;
            }
        }
        map.put(0, -1);
        for (int i = 0; i <arr.length ; i++) {
            sum+= arr[i];
            if (map.containsKey(sum- 0)){
                len = Math.max(len,i- map.get(sum));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }

    /**
     * 无序数组 元素只有 0和 1  最长子数组 0和 1的个数相等
     * @param arr
     * @return
     */
    public static  int  getMaxLen4zeroAndOne(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len=0;
        int sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == 0){
                arr[i] = -1;
            }
        }
        map.put(sum,-1);
        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
            if (map.containsKey(sum-0)) {
                len = Math.max(len,i-map.get(sum -0));
            }
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return len;
    }


    public static void main(String[] args) {
        getMaxLen(new int[]{1, 2, 1, 1, 1}, 3);

        getMaxLen2(new int[]{1, 2, 3, 3}, 6);
        getMaxLen4PositiveAndNegativeNum(new int[] {1,2,3,-1,-5,6,0,0,2,-4,-1,0,0});

        getMaxLen4zeroAndOne(new int[] {0,1,1,1,0,1,1,1,1,0,0});
    }
}
