package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class num_35 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public static RandomListNode Clone(RandomListNode pHead)  {
        if (pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        while (cur != null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur!= null){
            RandomListNode cloneNode = map.get(cur);
            cloneNode.next = map.get(cur.next);
            cloneNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.random =  pHead.next.next;

        RandomListNode head = Clone(pHead);
        System.out.println();
    }
}
