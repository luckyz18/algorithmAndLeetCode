package zuo_book.capter01;

import java.util.LinkedList;
import java.util.List;

/**
 * 生成窗口最大的值数组
 */
public class GetMaxWIndow {

    private int length;

    /**
     * 时间复杂度是  O(N*M)
     *
     * @param arr
     * @param windowSize
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int windowSize) {
        int len = arr.length;
        int[] res = new int[len - windowSize + 1];
        int index = 0;
        List list = new LinkedList();
        if (windowSize >= len) {
            return null;
        }
        for (int i = windowSize - 1; i < len; i++) {
            list.clear();
            list.add(arr[i]);
            list.add(arr[i - 1]);
            list.add(arr[i - 2]);
            int maxInList = getMaxInList(list);
            res[index++] = maxInList;
        }
        return res;
    }

    public static int getMaxInList(List<Integer> list) {
        int size = list.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }

    /**
     * 改进 时间复杂度是 O（N）
     * 基于双端队列实现
     * linkedList 实现了 deque 双端队列接口
     */
    public static int[] getMaxWindow2(int[] arr, int w) {
        LinkedList<Integer> linkedList = new LinkedList();
        int len = arr.length;
        int[] res = new int[len - w + 1];
        int index = 0;
        if (len < w) {
            return null;
        }

        for (int i = 0; i < len; i++) {
            while (!linkedList.isEmpty() && arr[linkedList.getLast()] <= arr[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            /*  过期移除*/
            if (linkedList.peekFirst() == i - w) {
                linkedList.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[linkedList.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] maxWindow = getMaxWindow2(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3);
        System.out.println(maxWindow);
    }
}
