package jianzhi_offer;

public class code_28 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left==null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.left.left = new TreeNode(3);
        head1.left.right = new TreeNode(4);
        head1.right = new TreeNode(2);
        head1.right.left = new TreeNode(4);
        head1.right.right = new TreeNode(3);

        boolean symmetrical = isSymmetrical(head1);
        System.out.println(symmetrical);
    }
}
