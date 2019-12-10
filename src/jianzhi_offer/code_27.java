package jianzhi_offer;

import java.util.Stack;

/**
 * 二叉树镜像
 */
public class code_27 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
        System.out.println();
    }
    private static void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    //非递归
    //树的遍历
    public static void Mirror2(TreeNode root) {
        if (root == null || (root.left==null && root.right == null)){
            return;
        }
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            //visit
            swap(pop);
            if (pop.left!= null){
                stack.push(pop.left);
            }
            if (pop.right!= null){
                stack.push(pop.right);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.left.left = new TreeNode(4);
        head1.left.right = new TreeNode(5);
        head1.right = new TreeNode(3);

        Mirror2(head1);
    }
}
