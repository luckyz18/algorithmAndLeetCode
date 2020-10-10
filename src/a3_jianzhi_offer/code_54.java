package a3_jianzhi_offer;

import java.util.Stack;

/**
 * BST 的第K大节点
 */
public class code_54 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int k = 0;
    public static TreeNode KthNode(TreeNode pRoot, int k1) {
        if (pRoot == null || k1 <= 0) {
            return null;
        }
        k = k1;
        return KthNodeCore(pRoot);
    }

    private static TreeNode KthNodeCore(TreeNode pRoot) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = KthNodeCore(pRoot.left);
        }
        //visit
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (target == null && pRoot.right != null) {
            target = KthNodeCore(pRoot.right);
        }
        return target;
    }

    //非递归。。。
    public static TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.add(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                count++;
                if (count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(10);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);

        TreeNode treeNode = KthNode2(head, 5);
        System.out.println(treeNode.val);
    }
}
