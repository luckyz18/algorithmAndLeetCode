package jianzhi_offer;

import java.util.*;

/**
 * 最小的 K 个数
 */
public class code_40 {
    /**
     * 时间复杂度是 O(N * logK)  适合处理海量数据  堆
     * 应该使用大根堆来维护最小堆  而不是直接创建一个小根堆并设置大小 试图让小根堆中的元素都是最小的
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int size = 0;
        for (int i = 0; i < input.length; i++) {
            if (size < k) {
                priorityQueue.offer(input[i]);
                size++;
            } else {
                int peek = priorityQueue.peek();
                if (input[i] < peek) {
                    priorityQueue.remove();
                    priorityQueue.offer(input[i]);
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add((Integer) priorityQueue.poll());
        }
        Collections.sort(list);
        return list;
    }

    /**
     * 快排
     * 时间复杂度是 O(N)  改变了原数组
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return list;
        }
        findMinK(input,k-1);
        for (int i = 0; i < k ; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static int findMinK(int[] input, int k) {
        int l  =0;
        int r = input.length-1;
        int index =0;
        while (l < r ){  //这里 有等于号  如果取所有的数组长度（8） index的值才可以是（7）
            index = partation(input,l,r);
            if (index == k){
                break;
            }
            if (index > k){
                r = index-1;
            }else {
                l = index+1;
            }
        }
        return index;
    }

    public static int partation(int[] nums, int l, int h) {
        int p = nums[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;

    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8}, 4);
        System.out.println();
    }


}
