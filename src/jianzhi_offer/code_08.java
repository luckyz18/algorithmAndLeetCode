package jianzhi_offer;

/**
 * 二叉树的下一个节点
 */
public class code_08 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null ){
            return pNode;
        }
        if (pNode.right!= null){
            return getMostLeft(pNode.right);
        }
        TreeLinkNode parent = null;
        parent = pNode.next;
        while (parent!= null){
            if (parent.left == pNode){
                return parent;
            }
            pNode= parent;
            parent = parent.next;
        }
        return parent;
    }

    public static TreeLinkNode getMostLeft(TreeLinkNode node) {
        if (node == null){
            return node;
        }
        while ( node.left!= null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
    }
}
