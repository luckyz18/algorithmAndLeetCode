package jianzhi_offer;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class code_41 {
    /**
     * 左半边存放大根堆  右半边存放小根堆
     * 左边的所有数据都小于右边的数据
     */
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void Insert(Integer num) {
        //奇数就插入到小根堆
        //偶数就插入到大根堆
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.offer(num);
                Integer poll = minHeap.poll();
                maxHeap.offer(poll);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.offer(num);
                Integer poll = maxHeap.poll();
                minHeap.offer(poll);
            } else {
                minHeap.offer(num);
            }
        }
    }

    //不比较数据 直接插入
    static int size = 0;
    public static void Insert2(Integer num) {
        //奇数就插入到小根堆
        //偶数就插入到大根堆
        if ((size & 1) == 0) {
            minHeap.offer(num);
            Integer poll = minHeap.poll();
            maxHeap.offer(poll);
        } else {
            maxHeap.offer(num);
            Integer poll = maxHeap.poll();
            minHeap.offer(poll);
        }
        size++;
    }


    public static Double GetMedian() {
        int size = maxHeap.size() + minHeap.size();
        //奇数
        if ((size & 1) == 1) {
            return maxHeap.peek() * 1.0;
        } else {
            return ( (maxHeap.peek() + minHeap.peek() ) * 1.0) / 2;
        }
    }

    public static void main(String[] args) {
        Insert2(1);
        Insert2(2);
        Insert2(3);
        Insert2(4);
        Insert2(5);
        //Insert2(6);

        Double aDouble = GetMedian();
        System.out.println(aDouble);
    }
}
