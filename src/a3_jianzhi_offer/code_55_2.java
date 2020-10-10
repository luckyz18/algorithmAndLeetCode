package a3_jianzhi_offer;

/**
 * 判断一棵树是不是平衡二叉树
 */
public class code_55_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
     class ReturnType{
        boolean isBalanced;
        int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public  boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        return isBalanced(root).isBalanced;
    }

    private  ReturnType isBalanced(TreeNode root) {
        if (root == null){
            return new ReturnType(true,0);
        }
        //后序遍历来提升性能
        ReturnType lData = isBalanced(root.left);
        ReturnType rData = isBalanced(root.right);
        if (lData.isBalanced && rData.isBalanced
                && Math.abs(lData.height - rData.height) <= 1){
            return new ReturnType(true,Math.max(lData.height,rData.height)+1);
        }
        return new ReturnType(false, Math.max(lData.height,rData.height)+1);
    }

    //网上
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution2(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced) //!!!
            return 0;
        //后序遍历
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(3);
        //head.right.right = new TreeNode(6);
        head.left.left.right = new TreeNode(7);

        boolean b = new code_55_2().IsBalanced_Solution(head);
        System.out.println(b);

    }
}
