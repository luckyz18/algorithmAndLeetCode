package jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树转换为 双向链表
 */
public class code_36 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //队列容器收集 中序遍历 结果  重连
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        inOrder(queue, pRootOfTree);
        TreeNode head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = pre;
            pre.right = cur;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private void inOrder(Queue<TreeNode> queue, TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        inOrder(queue, pRootOfTree.left);
        queue.offer(pRootOfTree);
        inOrder(queue, pRootOfTree.right);
    }

    // 递归的方式
    class ReturnType {
        TreeNode start;
        TreeNode end;
        public ReturnType(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        return process(pRootOfTree).start;
    }
    public ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(null, null);
        }
        ReturnType lData = process(head.left);
        ReturnType rData = process(head.right);
        head.left = lData.end;
        if (lData.end != null) {
            lData.end.right = head;
        }
        head.right = rData.start;
        if (rData.start != null) {
            rData.start.left = head;
        }
        return new ReturnType(
                lData.start != null ? lData.start : head,
                rData.end != null ? rData.end : head);
    }

    //3. 递归
    private TreeNode head = null;
    private TreeNode pre = null;
    public TreeNode Convert3(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrderTree(pRootOfTree);
        return head;
    }
    private void inOrderTree(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTree(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        head = head == null ? node : head;
        inOrderTree(node.right);
    }

}
