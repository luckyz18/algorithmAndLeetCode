package jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 二叉树树中和为某一值的路径
 */
public class num_34 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        findPath(root, target, new ArrayList<>());
        Collections.sort(ret, (o1, o2) -> o2.size()-o1.size());
        return ret;
    }

    private static void findPath(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        target -= node.val;
        path.add(node.val);
        boolean isLeaf = node.left == null && node.right == null;
        if (0 == target && isLeaf) {
            ret.add(new ArrayList<>(path));
        } else {
            findPath(node.left, target, path);
            findPath(node.right, target, path);
        }
        //
        path.remove(path.size()-1);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(root, 15);
        System.out.println();
    }
}
