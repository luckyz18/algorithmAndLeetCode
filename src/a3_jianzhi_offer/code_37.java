package a3_jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 */
public class code_37 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //先序遍历 序列化和反序列化
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer res = new StringBuffer();
        res.append(root.val + "!");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split("!");
        Queue<String> queue = new LinkedList();
        for (String tmp : split) {
            queue.offer(tmp);
        }
        return DeserializeByPre(queue);
    }

    private TreeNode DeserializeByPre(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.equals("#")) {
                return null;
            }
            TreeNode head = new TreeNode(Integer.parseInt(poll));
            head.left = DeserializeByPre(queue);
            head.right = DeserializeByPre(queue);
            return head;
        }
        return null;
    }

    //层次遍历序列化和反序列化
    public static String Serialize2(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer ret = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        ret.append(root.val + "!");
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                ret.append(poll.left.val + "!");
                queue.offer(poll.left);
            } else {
                ret.append("#!");
            }
            if (poll.right != null) {
                ret.append(poll.right.val + "!");
                queue.offer(poll.right);
            } else {
                ret.append("#!");
            }
        }
        return ret.toString();
    }

    public static TreeNode Deserialize2(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int index = 0;
        String[] split = str.split("!");
        Queue<TreeNode> queue = new LinkedList();
        TreeNode head = generateNode(split[index++]);
        if (head == null) {
            return null;
        }
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            poll.left = generateNode(split[index++]);
            poll.right = generateNode(split[index++]);
            if (poll.left!= null){
                queue.offer(poll.left);
            }
            if (poll.right!= null){
                queue.offer(poll.right);
            }
        }
        return head;
    }

    private static TreeNode generateNode(String s) {
        if ("#".equals(s)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        String s = Serialize2(root);
        System.out.println(s);
        TreeNode treeNode = Deserialize2(s);
        System.out.println();
    }
}
