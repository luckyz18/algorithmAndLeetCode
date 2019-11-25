package zuo_book.chapter03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 * 先序
 * 层次
 */
public class SerialAndDeserialBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序序列化和反序列化二叉树
     *
     * @param root
     * @return
     */
    public static String serialByPre(Node root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer str = new StringBuffer();
        str.append(root.value + "!");
        str.append(serialByPre(root.left));
        str.append(serialByPre(root.right));
        return str.toString();
    }

    public static Node deSerialByPreString(String str) {
        if (str == null || !(str.length() > 0)) {
            return null;
        }
        String[] split = str.split("!");
        Queue<String> queue = new LinkedList();
        for (int i = 0; i < split.length; i++) {
            queue.offer(split[i]);
        }
        return deSerialByPre(queue);

    }

    private static Node deSerialByPre(Queue<String> queue) {
        String stringValue = queue.poll();
        if (stringValue.equals("#")) {
            return null;
        }
        Node root = new Node(Integer.valueOf(stringValue));
        root.left = deSerialByPre(queue);
        root.right = deSerialByPre(queue);
        return root;
    }

    /**
     * 层次遍历序列化和反序列化
     *
     * @param root
     */
    public String serialByLevel(Node root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer str = new StringBuffer();
        Queue<Node> queue = new LinkedList();  // 宽度遍历  队列里不能放string 所以不能放#
        queue.offer(root);
        str.append(root.value + "!");
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                str.append(poll.left.value + "!");
                queue.offer(poll.left);
            } else {
                str.append("#!");
            }
            if (poll.right != null) {
                str.append(poll.right.value + "!");
                queue.offer(poll.right);
            } else {
                str.append("#!");
            }
        }
        return str.toString();
    }

    //反序列化
    public static Node deSerialByLevel(String str){
        if (str == null || !(str.length() > 0)){
            return null;
        }
        String[] s = str.split("!");
        int index = 0;
        Queue<Node> queue = new LinkedList();
        Node root = generateNode(s[index++]);
        if (root != null){
            queue.offer(root);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(s[index++]);
            node.right = generateNode(s[index++]);
            if (node.left!= null){
                queue.offer(node.left);
            }
            if (node.right!= null){
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static Node generateNode(String s){
        if (s.equals("#")){
            return null;
        }else{
            return new Node(Integer.valueOf(s));
        }
    }


    public static void main(String[] args) {
        //Node root = new Node(12);
        //root.left = new Node(3);
        //String serialByPre = serialByPre(root);
        //System.out.println(serialByPre);
        //
        //String serial = "12!3!#!#!#!";
        //Node node = deSerialByPreString(serial);
        //System.out.println(node);

        //
        deSerialByLevel("1!2!3!4!#!#!5!#!#!#!#!");

    }


}
