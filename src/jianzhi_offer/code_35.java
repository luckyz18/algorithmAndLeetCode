package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class code_35 {
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

    //不利用 O(N)的哈希表  直接在原始链表上添加一个节点  然后再拆分开来
    //不知名的小人物吧
    public static RandomListNode Clone2(RandomListNode pHead)  {
        if(pHead == null){
            return null;
        }

        //克隆节点
        RandomListNode next = null;
        RandomListNode cur = pHead;
        while (cur != null){
            next = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next= newNode;
            cur = next;
        }
        //设置random
        cur = pHead;
        while (cur!= null){
            if (cur.random!= null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //奇数位置 偶数位置 拆分开
        RandomListNode newHead = pHead.next;
        RandomListNode cur2 = newHead;
        cur = pHead;
        while (cur != null && cur2 != null){
            cur.next = cur2.next;
            //尾节点
            if (cur.next!= null) {
                cur2.next = cur.next.next;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        return newHead;
    }


    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.random =  pHead.next.next;

        RandomListNode head = Clone2(pHead);
        System.out.println();
    }
}
