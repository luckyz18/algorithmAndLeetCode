package jianzhi_offer;


import java.util.*;

/**
 * 按照之字形打印二叉树
 */
public class code_32_3 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 用双端队列实现
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        Deque<TreeNode> dq = new LinkedList();
        dq.offer(pRoot);
        boolean lr = true;
        TreeNode last = pRoot;
        TreeNode nLast = null;
        TreeNode head = null;
        ArrayList<Integer> list = new ArrayList();
        while (!dq.isEmpty()) {
            if (lr) {
                head = dq.pollFirst();
                if (head.left != null) {
                    dq.offerLast(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
                if (head.right != null) {
                    dq.offerLast(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
            } else {
                head = dq.pollLast();
                if (head.right != null) {
                    dq.offerFirst(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
                if (head.left != null) {
                    dq.offerFirst(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
            }
            list.add(head.val);
            if (head == last) {
                lr = !lr;
                ret.add(list);
                last = nLast;
                nLast = null;
                list = new ArrayList<>();
            }
        }
        return ret;
    }

    /**
     * 再有方法就是 把 list 取出来之后逆序
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse)
                Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }

    /**
     * 用两个栈实现
     */
    public static ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }

        Stack<TreeNode>[] stack = new Stack[2];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        int current = 0;
        int next = 1;
        stack[current].push(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack[0].isEmpty() || !stack[1].isEmpty()) {
            TreeNode pop = stack[current].pop();
            if (current == 0) {
                if (pop.left != null) {
                    stack[next].push(pop.left);
                }
                if (pop.right != null) {
                    stack[next].push(pop.right);
                }
            } else {
                if (pop.right != null) {
                    stack[next].push(pop.right);
                }
                if (pop.left != null) {
                    stack[next].push(pop.left);
                }
            }
            list.add(pop.val);
            if (stack[current].isEmpty()){
                ret.add(list);
                list = new ArrayList<>();
                current = 1-current;
                next = 1-next;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.left.left = new TreeNode(7);
        head.right.left.right = new TreeNode(8);
        head.right.right = new TreeNode(6);

        ArrayList<ArrayList<Integer>> print = Print3(head);
        System.out.println();
    }

}
