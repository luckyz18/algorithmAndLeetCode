package a2_zuo_book.chapter03.BT;

/**
 * 遍历二叉树的神级方法
 * 实现时间复杂度是O(N)
 * 空间复杂度是O(1)
 */
public class Morris {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //1：获取morris 序列
    public static void morris(Node root) {
        if (root == null) {
            return;
        }
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //找到cur 左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果最右节点指向null  让她指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;  // cur节点第一次访问
                    System.out.println("||" + cur.value + "  ");
                    cur = cur.left;
                    continue;
                } else {
                    //如果最右节点指向cur  让其指向null
                    mostRight.right = null;  //第二次访问  cur
                    System.out.println("--" + cur.value + "  ");
                }
            } else {
                System.out.println(cur.value + " ");
            }
            //没有左子树  只访问一次
            //或者 最右节点的右子树指向cur  cur向右移动
            cur = cur.right;
        }
        System.out.println("-----");
    }

    // 2. 在morris 序列的基础上  先序遍历  中序遍历
    // 2.1 先序：访问两次的节点第一次访问时打印；访问一次的节点直接打印
    public static void mirrorByPre(Node root) {
        if (root == null) {
            return;
        }
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //找到cur 左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果最右节点指向null  让她指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;  //cur节点第一次访问
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    //如果最右节点指向cur  让其指向null
                    mostRight.right = null;  //第二次访问  cur
                }
            } else {
                //打印
                System.out.print(cur.value + " ");
            }
            //没有左子树  只访问一次
            //或者 最右节点的右子树指向cur  cur向右移动
            cur = cur.right;
        }
    }

    // 2.2 中序：访问两次的节点第 2 次访问时打印；访问一次的节点直接打印
    public static void mirrorByInorder(Node root) {
        if (root == null) {
            return;
        }
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //找到cur 左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果最右节点指向null  让她指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;  //cur节点第一次访问
                    cur = cur.left;
                    continue;
                } else {
                    //如果最右节点指向cur  让其指向null
                    mostRight.right = null;  //第二次访问  cur
                    System.out.print(cur.value + " ");
                }
            } else {
                //打印
                System.out.print(cur.value + " ");
            }
            //没有左子树  只访问一次
            //或者 最右节点的右子树指向cur  cur向右移动
            cur = cur.right;
        }
    }

    // morris 序列 改写判断 是否是BST
    // 时间O(N) 空间时 O(1)
    public static boolean morrisTestIsCBT(Node root) {
        if (root == null) {
            return false;
        }
        Node cur = root;
        Node mostRight = null;
        Node pre = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;  //1.
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;  //2.  有左子树 中序 是 第二次访问的时候打印（判断业务逻辑）
                }
            } else {
                //没左子树 只访问一次
                //1.
            }
            //只访问一次的节点和访问两次第二次访问的节点 统一在这里判断了
            if (pre != null && pre.value > cur.value) {
                return false;
            } else {
                pre = cur;
            }

            cur = cur.right;
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.println(morrisTestIsCBT(head));

        //mirrors(root);
        //System.out.println("-----------------------");
        //mirrorByPre(root);
        //System.out.println("-----------------------");
        //mirrorByInorder(root);
    }
}
