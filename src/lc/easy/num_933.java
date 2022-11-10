package lc.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最近的请求次数
 */
public class num_933 {
    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while(queue.peek() < t-3000 ){
                queue.poll();
            }
            return queue.size();
        }
    }

}
