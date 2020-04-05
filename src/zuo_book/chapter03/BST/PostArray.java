package zuo_book.chapter03.BST;

/**
 * 根据后序数组重建搜索二叉树
 */
public class PostArray {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 数组 是不是某搜索二叉树后序遍历的结果
     */
    public static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPostArray(arr, 0, arr.length - 1);
    }

    private static boolean isPostArray(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[end]) {
                more = more == end ? i : more;
            } else {
                less = i;
            }
        }
        // !!! 保证了二叉搜索树的有序
        if (less != more - 1) {
            return false;
        }
        if (less == -1 || more == end) {
            return isPostArray(arr, start, end - 1);
        }
        boolean a = isPostArray(arr, start, less);
        boolean b = isPostArray(arr, more, end - 1);
        return a && b;
    }

    /**
     * 后序数组是BST 的后序遍历序列
     * 根据后序数组重建搜索二叉树
     */
    public static Node createBSTByPostArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return createBSTByPostArr2(arr, 0, arr.length - 1);
    }
    private static Node createBSTByPostArr(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start]);
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[end]) {
                more = more == end ? i : more;
            } else {
                less = i;
            }
        }
        if (less == -1) {
            head.right = createBSTByPostArr(arr, start, end - 1);
        } else if (more == end) {
            head.left = createBSTByPostArr(arr, start, end - 1);
        } else {
            head.left = createBSTByPostArr(arr, start, less);
            head.right = createBSTByPostArr(arr, more, end - 1);
        }
        return head;
    }

    //shu
    private static Node createBSTByPostArr2(int[] arr, int start, int end) {
        if (start > end){
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[end]) {
                more = more == end ? i : more;
            } else {
                less = i;
            }
        }
        head.left = createBSTByPostArr(arr, start, less);
        head.right = createBSTByPostArr(arr, more, end - 1);
        return head;
    }


    public static void main(String[] args) {
        /*boolean postArray = isPostArray(new int[]{1, 3, 4, 2});
        System.out.println(postArray);*/

        Node bstByPostArr = createBSTByPostArr(new int[]{1, 3, 4, 2});
        System.out.println();
    }


}
