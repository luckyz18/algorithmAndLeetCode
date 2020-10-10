package a2_zuo_book.chapter03.BST;

/**
 * 通过有序数组 生成平衡搜索二叉树
 */
public class BalancedBST {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node sortedArr2BalancedBST(int[] arr){
        if (arr == null || arr.length ==0){
            return null;
        }
        return sortedArr2BalancedBST(arr,0,arr.length-1);
    }
    public static Node sortedArr2BalancedBST(int[] arr, int left, int right){
        if (arr == null || arr.length ==0 || left>right){
            return null;
        }
        int mid = (left+right) / 2;
        Node head = new Node(arr[mid]);
        head.left = sortedArr2BalancedBST(arr,left,mid-1);
        head.right = sortedArr2BalancedBST(arr,mid+1,right);
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        Node node = sortedArr2BalancedBST(arr);
        System.out.println(node.value);
    }
}
