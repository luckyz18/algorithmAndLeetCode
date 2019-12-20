package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 树中两个节点的最近公共祖先
 * 树有可能是 BST 或者 BT
 */
public class code_68 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //树节点
    public static class Node {
        int val;
        ArrayList<Node> children;
        Node(int x) {
            val = x;
        }
    }

    //普通二叉树
    //在左右子树中查找  如果 p q 分别在两个子树中，说明根节点就是其最低公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    //搜索二叉树
    //两个节点 p q 的公共祖先满足 p.val <= root.val <= q.val
    public static TreeNode lowestCommonAncestor2( TreeNode head, TreeNode p,TreeNode q){
        if (head == null){
            return null;
        }
        if (head.val < p.val && head.val < q.val){
            return lowestCommonAncestor(head.right,p,q);
        }
        if (head.val > p.val && head.val > q.val){
            return lowestCommonAncestor(head.left,p,q);
        }
        return head;
    }

    //不是二叉树就是一颗树  节点也没有指向父节点的指针
    //path1
    public static void getNodePath(Node pRoot, Node pNode, ArrayList<Node> tmpList, ArrayList<Node> path){
        if (pRoot == null){
            return;
        }
        if(pRoot == pNode ){
            tmpList.add(pRoot);
            path.addAll(tmpList);
            return;
        }
        tmpList.add(pRoot);
        ArrayList<Node> childs = pRoot.children;
        if (childs!= null) {
            for (Node node : childs) {
                if (node == pNode) {
                    tmpList.add(node);
                    path.addAll(tmpList);
                    break;
                }
                getNodePath(node, pNode, tmpList, path);
            }
        }
        tmpList.remove(tmpList.size()-1);
    }
    ////path2
    public static void getNodePath2(Node pRoot, Node pNode, ArrayList<Node> path){
        if (pRoot == null){
            return;
        }
        if(pRoot == pNode ){
            path.add(pRoot);
            return;
        }
        path.add(pRoot);
        ArrayList<Node> childs = pRoot.children;
        if (childs != null) {
            for (Node node : childs) {
                if (node == pNode) {
                    path.add(node);
                    break;
                }
                getNodePath2(node, pNode, path);
            }
        }
        path.remove(path.size()-1);
    }
    //
    public static Node getLowAncestor(Node root,Node node1,Node node2){
        if (root == null || node1 == null || node2 == null){
            return null;
        }
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getNodePath(root,node1,new ArrayList<>(),path1);
        getNodePath(root,node2,new ArrayList<>(),path2);
        return getCommonNode(path1,path2);
    }

    private static Node getCommonNode(ArrayList<Node> path1, ArrayList<Node> path2) {
        if (path1 == null || path2 == null){
            return null;
        }
        Node ret = null;
        for (int i = 0,j=0; i <path1.size() && j<path2.size() ; i++,j++) {
            if (path1.get(i) == path2.get(i)){
                ret = path1.get(i);
            }else{
                break;
            }
        }
        return ret;
    }

    ////path3
    public static boolean getPath(Node root,Node node,List<Node> curPath){
        if(root == node) {
            curPath.add(root);
            return true;
        }
        curPath.add(root);
        if (root.children != null) {
            for (Node child : root.children) {
                if (getPath(child, node, curPath))
                    return true;
            }
        }
        curPath.remove(curPath.size()-1);
        return false;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        ArrayList list1 = new ArrayList();
        list1.add(node_2);
        list1.add(node_3);
        list1.add(node_4);
        root.children = list1;

        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        ArrayList list2 = new ArrayList();
        list2.add(node_5);
        list2.add(node_6);
        node_2.children = list2;

        Node node_7 = new Node(7);
        ArrayList list3 = new ArrayList();
        list3.add(node_7);
        node_3.children = list3;
        //
        ArrayList<Node> tmp = new ArrayList<>();
        ArrayList<Node> ret = new ArrayList<>();
        //getNodePath(root,node_2, tmp ,ret);
        //System.out.println();
        //getPath(root,node_7, ret);
        Node ancestor = getLowAncestor(root, node_4, node_6);
        System.out.println(ancestor.val);



        //TreeNode head = new TreeNode(4);
        //head.left = new TreeNode(2);
        //head.left.left = new TreeNode(1);
        //head.left.right = new TreeNode(3);
        //head.right = new TreeNode(6);
        //head.right.left = new TreeNode(5);
        //head.right.right = new TreeNode(7);
        //
        //TreeNode p =  head.left;
        //TreeNode q = head.left.right;
        //TreeNode t = lowestCommonAncestor(head, p, q);
        //System.out.println(t.val);
    }

}
