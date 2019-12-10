package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class code_32_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    //这种方法比较巧妙  size
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null){
            return ret;
        }
        Queue<TreeNode> queue  =new LinkedList();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (size-- > 0){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!= null){
                    queue.offer(poll.left);
                }
                if (poll.right!= null){
                    queue.offer(poll.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    //用指针来做
    public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null){
            return ret;
        }
        Queue<TreeNode> queue  =new LinkedList();
        TreeNode last = pRoot;
        TreeNode nLast = null;
        queue.offer(pRoot);
        ArrayList<Integer> list =  new ArrayList();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!= null){
                queue.offer(poll.left);
                nLast = poll.left;
            }
            if (poll.right!= null){
                queue.offer(poll.right);
                nLast = poll.right;
            }
            if (poll == last){
                //一层结束
                ret.add(list);
                list = new ArrayList<>();
                last = nLast;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> print = Print2(head);
        System.out.println();
    }
}
