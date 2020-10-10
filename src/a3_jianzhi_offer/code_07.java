package a3_jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 根据先序 中序 数组
 */
public class code_07 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; ++i) {
            map.put(in[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, 0, map);
    }

    private static TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        Integer rootIndex = map.get(pre[preStart]);
        int leftLen = rootIndex - inStart;
        head.left = buildTree(pre, preStart + 1, leftLen + preStart, inStart, map);
        head.right = buildTree(pre, leftLen + preStart + 1, preEnd, rootIndex + 1, map);
        return head;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println();
    }
}
