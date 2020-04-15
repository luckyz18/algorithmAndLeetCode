package mianshi.tengxun_mianshi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序数组
 * 第一种方法： 优先级队列 N * logK
 * 2: 归并
 * 3: 线性合并： O(2n+3n +4n+5n+..) = O（n*n） 每次合并两个  （合并K个有序链表啊。。）
 */
public class MergeKSortedArray {
    static class Element{
        int row;
        int col;
        int value;

        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static int[] mergeKArray(int[][] arr){
        if (arr == null ) return new int[0];
        int k = arr.length;
        PriorityQueue<Element> queue = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.value - o2.value;
            }
        });
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].length>0) {
                Element element = new Element(i,0,arr[i][0]);   //把每行第一个元素放到队列中
                queue.add(element);
                sum += arr[i].length;
            }
        }
        int[] res = new int[sum];
        int index = 0;
        while (!queue.isEmpty()){
            Element poll = queue.poll();
            res[index++] = poll.value;
            if (poll.col +1 < arr[poll.row].length){
                //把该行第二个元素放到队列中
                queue.add(new Element(poll.row,poll.col+1,arr[poll.row][poll.col+1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr= new int[][] {
                {1, 3, 5, 7},
                {2, 4, 6},
                {0, 8, 9, 10, 11}
        };
        int[] ints = mergeKArray(arr);
        System.out.println();
    }
}
