package mianshiti.tengxun_mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序中序重建二叉树
 */
public class RebuildBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length || pre.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, 0, map);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> map) {
        //递归结束的条件 ///
        if (preStart > preEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = map.get(pre[preStart]);
        int leftLen = rootIndex - inStart;
        root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, map);
        root.right = buildTree(pre, preStart + leftLen + 1, preEnd, inStart + leftLen + 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        RebuildBT rebuildBT = new RebuildBT();
        TreeNode treeNode = rebuildBT.buildTree(pre, in);
        System.out.println();

    }
}
