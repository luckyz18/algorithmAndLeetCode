package a2_zuo_book.chapter03.BT;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 找到最近的公共祖先
 */
public class LowestAncestor {
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getLowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        //后序遍历
        Node left = getLowestAncestor(head.left, o1, o2);
        Node right = getLowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    /**
     * 进阶： 单条查询的时间变短（1）
     */
    private HashMap<Node,Node>  map;
    class Record1{
        public Record1(Node head) {
            map = new HashMap<Node,Node>();
            if (head != null){
                map.put(head,null);
            }
            setMap(head);
        }
    }

    private void setMap(Node head) {
        if (head == null){
            return;
        }
        if (head.left != null ){
            map.put(head.left,head);
        }
        if (head.right != null){
            map.put(head.right,head);
        }
        setMap(head.left);
        setMap(head.right);
    }
    public Node query(Node o1,Node o2){
        HashSet<Node> path = new HashSet();
        while (map.containsKey(o1)){
            path.add(o1);
            o1 = map.get(o1);
        }
        while (!path.contains(o2)){
            o2 = map.get(o2);
        }
        return o2;
    }
}
