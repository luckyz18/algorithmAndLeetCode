package book_2;

import java.util.LinkedList;

public class GetMaxWindow {

    /**
     * 生成窗口最大值数组
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w <= 0 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> queueMax = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while (!queueMax.isEmpty() && arr[queueMax.peekLast()]<= cur){
                queueMax.pollLast();
            }
            queueMax.addLast(i);
            //判断是否过期
            if (queueMax.peekFirst() == i-w){
                queueMax.pollFirst();
            }
            //输出 队头最大
            if (i >= w-1){
                res[index++] = arr[queueMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.println(maxWindow[i]);
        }
    }

}
