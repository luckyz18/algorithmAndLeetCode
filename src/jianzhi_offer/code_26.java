package jianzhi_offer;

/**
 * 判断一个树是不是另一个树的子结构
 */
public class code_26 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2==null){
            return false;
        }
        boolean res= false;
        if (root1.val == root2.val){
            res = isSubtreeWithRoot(root1,root2);
        }
        if (!res){
            res = HasSubtree(root1.left,root2);
        }
        if (!res){
            res = HasSubtree(root1.right,root2);
        }
        return res;
    }

    private static boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        //二者的顺序不能反 先验root2
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right,root2.right);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
       TreeNode head1 = new TreeNode(8);
       head1.left = new TreeNode(8);
       head1.left.left = new TreeNode(9);
       head1.left.right = new TreeNode(2);
       head1.left.right.left = new TreeNode(4);
       head1.left.right.right = new TreeNode(7);
       head1.right = new TreeNode(7);

       TreeNode head2 = new TreeNode(8);
       head2.left = new TreeNode(9);
       head2.right = new TreeNode(1);


        boolean b = HasSubtree(head1, head2);
        System.out.println(b);
    }
}
