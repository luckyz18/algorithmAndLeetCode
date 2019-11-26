package zuo_book.chapter03;

import java.util.HashMap;

/**
 * 二叉树中累加和为指定值的最长路径长度
 */
public class MaxLen4kInBT {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static int getMaxLen(Node head, int sum){
        HashMap<Integer,Integer> sumMap = new HashMap();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }

    public static int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null){
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if (sumMap.containsKey(curSum - sum)){
            maxLen = Math.max(maxLen, level - sumMap.get(curSum - sum));
        }
        maxLen = preOrder(head.left, sum, curSum, level+1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level+1, maxLen, sumMap);

        //!!! 返回cur的父节点的时候  访问cur父节点的右子树，清除左子树的值map 否则就不是自顶向下的
        if (level  == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(1);
        int maxLen = getMaxLen(head, 4);
        System.out.println();
    }

}
