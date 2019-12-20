package jianzhi_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列的最大值
 * 时间o(n) 空间O(1) 常数大小
 */
public class code_59_2 {
     class IntegerData {
        int number;
        int index;

        public IntegerData(int num, int index) {
            this.number = num;
            this.index = index;
        }
    }
    private Deque<IntegerData> dataQueue = new LinkedList();
    private Deque<IntegerData> maxQueue = new LinkedList();
    private int index = 0;

    public void push_back(int num) {
        while (!maxQueue.isEmpty() && num >= maxQueue.peekLast().number) {
            maxQueue.pollLast();
        }
        IntegerData pushData = new IntegerData(num, index++);
        dataQueue.offerLast(pushData);
        maxQueue.offerLast(pushData);
    }

    public void pop_front() throws Exception {
        if (maxQueue.isEmpty() || dataQueue.isEmpty()) {
            throw new Exception(" queue is empty!");
        }
        if (maxQueue.peekFirst().index == dataQueue.peekFirst().index) {  //如果弹出的元素是最大值
            maxQueue.pollFirst();
        }
        dataQueue.pollFirst();
    }

    public int max() throws Exception{
        if (maxQueue.isEmpty()){
            throw new Exception(" queue is empty!");
        }
        return maxQueue.peekFirst().number;
    }

    public static void main(String[] args) throws Exception {
        code_59_2 A = new code_59_2();

        A.push_back(2);
        A.push_back(6);
        A.pop_front();
        A.pop_front();
        A.push_back(2);
        System.out.println(A.max()+"----------");
        A.push_back(5);
        A.push_back(1);
        System.out.println(A.max()+"----------");

    }
}
