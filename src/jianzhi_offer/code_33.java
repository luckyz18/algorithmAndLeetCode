package jianzhi_offer;

/**
 * 二叉搜索树的后序遍历序列
 */
public class code_33 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                more = more == end ? i : more;
            } else {
                less = i;
            }
        }
        // !!!
        if (less != more - 1) {
            return false;
        }
        //只有左子树或者只有右子树的情况
        if (less == -1 ||more == end){
            return VerifySquenceOfBST(sequence,start,end-1);
        }
        boolean a = VerifySquenceOfBST(sequence,start,less);
        boolean b = VerifySquenceOfBST(sequence,more,end-1);
        return a && b;
    }

    public static void main(String[] args) {
        boolean p = VerifySquenceOfBST(new int[]{7,4,6,5});
        System.out.println(p);
    }

}
