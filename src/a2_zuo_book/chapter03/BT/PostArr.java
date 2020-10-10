package a2_zuo_book.chapter03.BT;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过先序 中序数组生成后序数组
 根据先序和中序重建二叉树
 */
public class PostArr {

    //网上 根据先序和中序重建二叉树
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //借助哈希表来储存二叉树的节点，优化时间复杂度
        Map<Integer, Integer> inPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inPosMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inPosMap);
    }

    public static TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> inPosMap) {
        //递归停止条件
        if (preStart > preEnd)
            return null;
        //前序中左起第一位肯定是根结点
        TreeNode root = new TreeNode(pre[preStart]);
        //根结点的位置直接通过中序获取
        int rootIndex = inPosMap.get(pre[preStart]);
        //左子树结点个数可以通过中序中根节点的位置与中序中起始位置确定
        int leftLen = rootIndex - inStart;
        //递归调用
        root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, inPosMap);
        root.right = buildTree(pre, preStart + leftLen + 1, preEnd, rootIndex + 1, inPosMap);
        return root;
    }

    /**
     * 根据先序中序数组在不重建二叉树的基础上  直接生成后序数组
     */
    public static int index;  //这里用全局的index  每次递归的时候不会往回退
    public static int[] getPosArr(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] post = new int[len];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        index = len-1;
        setPost(pre, 0, len - 1, in, 0, len - 1, post, map);
        return post;
    }

    private static void setPost(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, int[] post,  HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            //return index;  //应该插入的下一个位置
            return;
        }
        post[index--] = pre[preStart];
        int i = map.get(pre[preStart]);
        setPost(pre, preEnd - inEnd + i + 1, preEnd, in, i + 1, inEnd, post, map);
        setPost(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1, post, map);

    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        //TreeNode treeNode = buildTree(pre, in);
        //System.out.println();
        int[] posArr = getPosArr(pre, in);
        System.out.println();

    }

}
