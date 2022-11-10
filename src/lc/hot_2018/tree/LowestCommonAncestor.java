package lc.hot_2018.tree;

/**
 * 最近公共祖先
 */
public class LowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode ldata = lowestCommonAncestor(root.left, p, q);
        TreeNode rdata = lowestCommonAncestor(root.right, p, q);
        if (ldata != null && rdata != null) {
            return root;
        }
        return ldata != null ? ldata : rdata;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode node = lowestCommonAncestor(root, root.left, root.right.right);
        System.out.println(node.val);
    }

}
