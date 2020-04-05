package jianzhi_offer;

//二叉树的深度
public class code_55 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(treeDepth(root.left),treeDepth(root.right)) +1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(10);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);

        int i = treeDepth(head);
        System.out.println(i);
    }
}
