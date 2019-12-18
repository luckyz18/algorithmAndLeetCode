package jianzhi_offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 抓不住
 */
public class code_59_1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if( num == null || num.length==0 || size<=0 || size > num.length){
            return new ArrayList<>();
        }
        Deque<Integer> deque = new LinkedList();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <num.length ; i++) {
            while (!deque.isEmpty()  && num[deque.peekLast()] <= num[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if ( deque.peekFirst() == i-size ){
                deque.pollFirst();
            }
            if (i>= size-1){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new code_59_1().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(integers);
    }
}
